package com.khazoda.bronze.item;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;

public class BronzeIngot extends Item {
  public BronzeIngot(ResourceKey<Item> id) {
    super(new Properties().setId(id));
  }
}
