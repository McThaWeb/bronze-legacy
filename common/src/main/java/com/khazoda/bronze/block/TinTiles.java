package com.khazoda.bronze.block;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;

public class TinTiles extends Block {
  public TinTiles(ResourceKey<Block> id) {
    super(BlockBehaviour.Properties.of().strength(2.5F, 6.0F).mapColor(MapColor.TERRACOTTA_WHITE).instrument(NoteBlockInstrument.IRON_XYLOPHONE).sound(SoundType.COPPER).requiresCorrectToolForDrops().setId(id));
  }
}
