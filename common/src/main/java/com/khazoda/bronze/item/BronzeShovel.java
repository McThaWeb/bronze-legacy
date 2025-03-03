package com.khazoda.bronze.item;

import com.khazoda.bronze.material.BronzeToolMaterial;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.Tier;

public class BronzeShovel extends ShovelItem {
  public BronzeShovel(Tier tier) {
    super(tier, getItemSettings());
  }

  private static Properties getItemSettings() {
    return (new Properties()).attributes(ShovelItem.createAttributes(BronzeToolMaterial.INSTANCE, 1.5F, -3.0F));
  }
}
