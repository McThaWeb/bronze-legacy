package com.khazoda.bronze.datagen;

import com.khazoda.bronze.registry.MainRegistry;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.world.item.ArmorItem;

public class BronzeModModelProvider extends FabricModelProvider {

  public BronzeModModelProvider(FabricDataOutput output) {
    super(output);
  }

  @Override
  public void generateBlockStateModels(BlockModelGenerators blockModelGenerators) {
  }

  @Override
  public void generateItemModels(ItemModelGenerators itemModelGenerators) {
    itemModelGenerators.generateArmorTrims((ArmorItem) MainRegistry.BRONZE_HELMET.get());
    itemModelGenerators.generateArmorTrims((ArmorItem) MainRegistry.BRONZE_CHESTPLATE.get());
    itemModelGenerators.generateArmorTrims((ArmorItem) MainRegistry.BRONZE_LEGGINGS.get());
    itemModelGenerators.generateArmorTrims((ArmorItem) MainRegistry.BRONZE_BOOTS.get());
  }
}
