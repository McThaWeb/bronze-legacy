package com.khazoda.bronze.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;

public class BronzeBlendBlock extends Block {
  public BronzeBlendBlock() {
    super(BlockBehaviour.Properties.of().strength(2.5f).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops());
  }
}
