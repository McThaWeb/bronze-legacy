package com.khazoda.bronze.block;

import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

public class BronzeDoor extends DoorBlock {
  public BronzeDoor() {
    super(BlockSetType.IRON, BlockBehaviour.Properties.of().strength(5.5f).noOcclusion()
        .instrument(NoteBlockInstrument.IRON_XYLOPHONE)
        .pushReaction(PushReaction.DESTROY)
        .mapColor(MapColor.GOLD)
        .sound(SoundType.METAL)
        .requiresCorrectToolForDrops());
  }
}
