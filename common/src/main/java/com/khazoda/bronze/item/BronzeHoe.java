package com.khazoda.bronze.item;

import com.khazoda.bronze.material.BronzeToolMaterial;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Tier;

public class BronzeHoe extends HoeItem {
  public BronzeHoe(Tier tier) {
    super(tier, getItemSettings());
  }

  private static Properties getItemSettings() {
    return (new Properties()).attributes(HoeItem.createAttributes(BronzeToolMaterial.INSTANCE, -2.0F, 0.0F));
  }
}
