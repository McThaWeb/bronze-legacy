package com.khazoda.bronze.item;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;

public class BronzeNugget extends Item {
  public BronzeNugget(ResourceKey<Item> id) {
    super(new Properties().setId(id));
  }
}
