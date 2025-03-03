package com.khazoda.bronze.material;

import com.khazoda.bronze.registry.MainRegistry;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

public class BronzeToolMaterial implements Tier {

  public static final BronzeToolMaterial INSTANCE = new BronzeToolMaterial();

  @Override
  public int getUses() {
    return 350;
  }

  @Override
  public float getSpeed() {
    return 7.0F;
  }

  @Override
  public float getAttackDamageBonus() {
    return 2.5F;
  }

  @Override
  public @NotNull TagKey<Block> getIncorrectBlocksForDrops() {
    return BlockTags.INCORRECT_FOR_IRON_TOOL;
  }

  @Override
  public int getEnchantmentValue() {
    return 15;
  }

  @Override
  public @NotNull Ingredient getRepairIngredient() {
    return Ingredient.of(MainRegistry.BRONZE_INGOT.get());
  }
}
