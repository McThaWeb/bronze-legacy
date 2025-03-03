package com.khazoda.bronze.item;

import com.khazoda.bronze.material.BronzeToolMaterial;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;

public class BronzeAxe extends AxeItem {
  public BronzeAxe(Tier tier) {
    super(tier, getItemSettings());
  }

  private static Properties getItemSettings() {
    return (new Properties()).attributes(PickaxeItem.createAttributes(BronzeToolMaterial.INSTANCE, 5.5F, -3.1F));
  }
}
