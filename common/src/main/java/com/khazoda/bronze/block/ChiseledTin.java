package com.khazoda.bronze.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;

public class ChiseledTin extends Block {
  public ChiseledTin() {
    super(BlockBehaviour.Properties.of().strength(2.5F, 6.0F).mapColor(MapColor.TERRACOTTA_WHITE)
        .instrument(NoteBlockInstrument.IRON_XYLOPHONE).sound(SoundType.COPPER).requiresCorrectToolForDrops());
  }
}
