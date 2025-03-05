package com.khazoda.bronze.item;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

import static com.khazoda.bronze.Constants.ID;

public class Sickle extends DiggerItem {
  public static final TagKey<Block> SICKLE_EFFECTIVE_BLOCKS = TagKey.create(Registries.BLOCK, ID("mineable/sickle"));

  public Sickle(Tier tier, Properties properties) {
    super(tier, SICKLE_EFFECTIVE_BLOCKS, properties);
  }

  @Override
  public boolean canAttackBlock(BlockState state, Level level, BlockPos pos, Player player) {
    return !(state.getBlock() instanceof CropBlock) && !(state.getBlock() instanceof NetherWartBlock);
  }

  @Override
  public boolean mineBlock(ItemStack stack, Level level, BlockState state, BlockPos pos, LivingEntity miningEntity) {
    if (state.getBlock() instanceof TallGrassBlock || state.getBlock() instanceof DoublePlantBlock) {
      aoeMow(level, miningEntity, state, state, pos, 0);
    }
    return true;
  }

  @Override
  public InteractionResult useOn(UseOnContext context) {
    Level level = context.getLevel();
    Player player = context.getPlayer();
    if (level.isClientSide() || player == null) return InteractionResult.PASS;
    ItemStack stack = context.getItemInHand();
    BlockPos pos = context.getClickedPos();
    BlockState state = level.getBlockState(pos);

    if ((state.getBlock() instanceof CropBlock || state.getBlock() instanceof NetherWartBlock) && isMature(state)) {
      // Play break sound
      level.playSound(null, pos, state.getSoundType().getBreakSound(), SoundSource.BLOCKS, 1.0F, 1.0F);
      // Do swipe animation
      player.swing(context.getHand());
      // Add sweep particles
      ((ServerLevel) level).sendParticles(ParticleTypes.SWEEP_ATTACK,
          pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5,
          1, 0, 0, 0, 0);

      stack.hurtAndBreak(1, player, player.getEquipmentSlotForItem(stack));
      aoeHarvest(level, player, state, state, pos, 0);
      return InteractionResult.SUCCESS;
    }
    return InteractionResult.PASS;
  }

  @Override
  public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
    stack.hurtAndBreak(1, attacker, EquipmentSlot.MAINHAND);
    return true;
  }

  private static void aoeMow(Level level, LivingEntity entity, BlockState initialBlockState, BlockState currentBlockState, BlockPos pos, int iteration) {
    if (level.isClientSide()) return;
    /* Cut Grass */
    if (initialBlockState.getBlock() instanceof TallGrassBlock || initialBlockState.getBlock() instanceof DoublePlantBlock) {
      Block currentBlock = currentBlockState.getBlock();
      if (currentBlock instanceof TallGrassBlock || currentBlock instanceof DoublePlantBlock) {
        if (entity instanceof Player player) {
          if (level.getBlockState(pos).getBlock() == currentBlockState.getBlock()) {
            currentBlockState.getBlock().playerDestroy(level, player, pos, currentBlockState, null, player.getMainHandItem());
            level.setBlock(pos, Blocks.AIR.defaultBlockState(), 3);
          }
        } else {
          Block.dropResources(currentBlockState, level, pos, null, entity, ItemStack.EMPTY);
          level.setBlock(pos, Blocks.AIR.defaultBlockState(), 3);
        }
      }
      if (iteration < 4) {
        aoeMow(level, entity, initialBlockState, level.getBlockState(pos.east()), pos.east(), iteration + 1);
        aoeMow(level, entity, initialBlockState, level.getBlockState(pos.north()), pos.north(), iteration + 1);
        aoeMow(level, entity, initialBlockState, level.getBlockState(pos.west()), pos.west(), iteration + 1);
        aoeMow(level, entity, initialBlockState, level.getBlockState(pos.south()), pos.south(), iteration + 1);
      }
    }
  }

  private static void aoeHarvest(Level level, LivingEntity entity, BlockState initialBlockState, BlockState currentBlockState, BlockPos pos, int iteration) {
    if (level.isClientSide()) return;
    /* Harvest Crops */
    if ((initialBlockState.getBlock() instanceof CropBlock || initialBlockState.getBlock() instanceof NetherWartBlock) && isMature(initialBlockState)) {
      /* Break block, drop drops */
      if (entity instanceof Player player) {
        if (level.getBlockState(pos).getBlock() == currentBlockState.getBlock()) {
          currentBlockState.getBlock().playerDestroy(level, player, pos, currentBlockState, null, player.getMainHandItem());
          // Add block breaking particles
          ((ServerLevel) level).sendParticles(new BlockParticleOption(
                  ParticleTypes.BLOCK, currentBlockState),
              pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5,
              5, 0.2, 0.2, 0.2, 0.1);
        }
      } else {
        Block.dropResources(currentBlockState, level, pos, null, entity, ItemStack.EMPTY);
      }
      /* Reset crop to lowest growth stage */
      replantCrop(level, initialBlockState, pos);
      if (iteration < 2) {
        aoeHarvest(level, entity, level.getBlockState(pos.east()), level.getBlockState(pos.east()), pos.east(), iteration + 1);
        aoeHarvest(level, entity, level.getBlockState(pos.north()), level.getBlockState(pos.north()), pos.north(), iteration + 1);
        aoeHarvest(level, entity, level.getBlockState(pos.west()), level.getBlockState(pos.west()), pos.west(), iteration + 1);
        aoeHarvest(level, entity, level.getBlockState(pos.south()), level.getBlockState(pos.south()), pos.south(), iteration + 1);
      }
    }
  }

  private static boolean isMature(BlockState state) {
    if (state.getBlock() instanceof CropBlock cropBlock) {
      return cropBlock.isMaxAge(state);
    } else if (state.getBlock() instanceof NetherWartBlock) {
      return state.getValue(NetherWartBlock.AGE) >= NetherWartBlock.MAX_AGE;
    }
    return false;
  }

  /* 'state' must reference the blockstate before the crop is destroyed */
  private static void replantCrop(Level level, BlockState state, BlockPos pos) {
    if (state.getBlock() instanceof BeetrootBlock) {
      level.setBlock(pos, state.setValue(BlockStateProperties.AGE_3, 0), 3);
    } else if (state.getBlock() instanceof NetherWartBlock) {
      level.setBlock(pos, state.setValue(BlockStateProperties.AGE_3, 0), 3);
    } else if (state.getBlock() instanceof CropBlock) {
      level.setBlock(pos, state.setValue(BlockStateProperties.AGE_7, 0), 3);
    }
  }
}


