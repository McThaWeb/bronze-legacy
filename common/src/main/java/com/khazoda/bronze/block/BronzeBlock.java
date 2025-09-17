package com.khazoda.bronze.block;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;

public class BronzeBlock extends Block {
  public BronzeBlock(ResourceKey<Block> id) {
    super(BlockBehaviour.Properties.of().strength(3.5f).instrument(NoteBlockInstrument.IRON_XYLOPHONE).sound(SoundType.METAL).requiresCorrectToolForDrops().setId(id));
  }
}
