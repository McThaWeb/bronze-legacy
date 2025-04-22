package com.khazoda.bronze.item;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;

public class RawTin extends Item {
  public RawTin(ResourceKey<Item> id) {
    super(new Item.Properties().setId(id));
  }
}
