package com.khazoda.bronze.item;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.component.Tool;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

import java.util.List;

import static com.khazoda.bronze.Constants.ID;

public class Sickle extends DiggerItem {

  public static final TagKey<Block> EFFECTIVE_BLOCKS = TagKey.create(Registries.BLOCK, ID("mineable/sickle"));

  public Sickle(Tier tier, Properties properties) {
    super(tier, EFFECTIVE_BLOCKS, properties);
  }

  public static Tool createToolComponent() {
    return new Tool(List.of(Tool.Rule.minesAndDrops(List.of(Blocks.COBWEB), 15.0F), Tool.Rule.minesAndDrops(BlockTags.LEAVES, 15.0F), Tool.Rule.minesAndDrops(BlockTags.WOOL, 5.0F), Tool.Rule.minesAndDrops(List.of(Blocks.VINE, Blocks.GLOW_LICHEN), 2.0F)), 1.0F, 1);
  }

  @Override
  public boolean canAttackBlock(BlockState state, Level level, BlockPos pos, Player player) {
    if (state.getBlock() instanceof CropBlock || state.getBlock() instanceof NetherWartBlock) {
      return isMature(state);
    }
    return true;
  }

  @Override
  public boolean mineBlock(ItemStack stack, Level level, BlockState state, BlockPos pos, LivingEntity miningEntity) {
    stack.hurtAndBreak(1, miningEntity, EquipmentSlot.MAINHAND);
    aoeHarvest(miningEntity.level(), state, state, pos, 0);
    return true;
  }

  public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
    stack.hurtAndBreak(1, attacker, EquipmentSlot.MAINHAND);
    return true;
  }

  private static void aoeHarvest(Level level, BlockState initialBlockState, BlockState currentBlockState, BlockPos pos, int time) {
    if (level.isClientSide()) return;

    /* True when block mined is a crop*/
    if (initialBlockState.getBlock() instanceof CropBlock || initialBlockState.getBlock() instanceof NetherWartBlock) {
      if (isMature(initialBlockState) && !level.isClientSide()) {
        level.destroyBlock(pos, true);
        if (initialBlockState.getBlock() instanceof BeetrootBlock) {
          level.setBlock(pos, initialBlockState.setValue(BlockStateProperties.AGE_3, 0), 3);
        } else if (initialBlockState.getBlock() instanceof NetherWartBlock) {
          level.setBlock(pos, initialBlockState.setValue(BlockStateProperties.AGE_3, 0), 3);
        } else if (initialBlockState.getBlock() instanceof CropBlock) {
          level.setBlock(pos, initialBlockState.setValue(BlockStateProperties.AGE_7, 0), 3);
        }

        if (time < 2) {
          aoeHarvest(level, level.getBlockState(pos.east()), level.getBlockState(pos.east()), pos.east(), time + 1);
          aoeHarvest(level, level.getBlockState(pos.north()), level.getBlockState(pos.north()), pos.north(), time + 1);
          aoeHarvest(level, level.getBlockState(pos.west()), level.getBlockState(pos.west()), pos.west(), time + 1);
          aoeHarvest(level, level.getBlockState(pos.south()), level.getBlockState(pos.south()), pos.south(), time + 1);
        }
      }
    }
    /* True when block mined is grass*/
    if (initialBlockState.getBlock() instanceof TallGrassBlock || initialBlockState.getBlock() instanceof DoublePlantBlock) {
      Block currentBlock = currentBlockState.getBlock();
      if (currentBlock instanceof TallGrassBlock || currentBlock instanceof DoublePlantBlock) {
        level.destroyBlock(pos, true);
      }
      if (time < 4) {
        aoeHarvest(level, initialBlockState, level.getBlockState(pos.east()), pos.east(), time + 1);
        aoeHarvest(level, initialBlockState, level.getBlockState(pos.north()), pos.north(), time + 1);
        aoeHarvest(level, initialBlockState, level.getBlockState(pos.west()), pos.west(), time + 1);
        aoeHarvest(level, initialBlockState, level.getBlockState(pos.south()), pos.south(), time + 1);
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
}


