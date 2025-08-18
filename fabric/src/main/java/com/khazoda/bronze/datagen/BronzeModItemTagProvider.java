package com.khazoda.bronze.datagen;

import com.khazoda.bronze.registry.MainRegistry;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.ItemTags;

import java.util.concurrent.CompletableFuture;

public class BronzeModItemTagProvider extends FabricTagProvider.ItemTagProvider {
  public BronzeModItemTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registryLookup) {
    super(output, registryLookup);
  }

  @Override
  protected void addTags(HolderLookup.Provider provider) {
    valueLookupBuilder(ItemTags.TRIMMABLE_ARMOR)
        .add(MainRegistry.BRONZE_HELMET.get())
        .add(MainRegistry.BRONZE_CHESTPLATE.get())
        .add(MainRegistry.BRONZE_LEGGINGS.get())
        .add(MainRegistry.BRONZE_BOOTS.get());
  }
}