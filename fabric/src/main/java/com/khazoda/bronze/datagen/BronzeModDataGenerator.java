package com.khazoda.bronze.datagen;

import com.khazoda.bronze.datagen.advancements.BronzeModAdvancementsProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class BronzeModDataGenerator implements DataGeneratorEntrypoint {
  @Override
  public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
    FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

    pack.addProvider(BronzeModItemTagProvider::new);
    pack.addProvider(BronzeModModelProvider::new);
    pack.addProvider(BronzeModAdvancementsProvider::new);
  }
}
