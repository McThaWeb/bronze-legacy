package com.khazoda.bronze.block;

import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;

public class BronzeTrapdoor extends TrapDoorBlock {
  public BronzeTrapdoor() {
    super(BlockSetType.IRON, BlockBehaviour.Properties.of().strength(3.5f).instrument(NoteBlockInstrument.IRON_XYLOPHONE).sound(SoundType.METAL).requiresCorrectToolForDrops().noOcclusion());
  }
}
