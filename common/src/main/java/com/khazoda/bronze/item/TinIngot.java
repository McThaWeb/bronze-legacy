package com.khazoda.bronze.item;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;

public class TinIngot extends Item {
  public TinIngot(ResourceKey<Item> id) {
    super(new Properties().setId(id));
  }
}
