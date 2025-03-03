package com.khazoda.bronze.item;

import com.khazoda.bronze.material.BronzeToolMaterial;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;

public class BronzePickaxe extends PickaxeItem {
  public BronzePickaxe(Tier tier) {
    super(tier, getItemSettings());
  }

  private static Properties getItemSettings() {
    return (new Properties()).attributes(PickaxeItem.createAttributes(BronzeToolMaterial.INSTANCE, 1.0F, -2.8F));
  }
}
