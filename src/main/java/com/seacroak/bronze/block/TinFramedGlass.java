package com.seacroak.bronze.block;

import net.minecraft.block.AbstractGlassBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.TransparentBlock;
import net.minecraft.block.enums.Instrument;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;

public class TinFramedGlass extends AbstractGlassBlock {
  public TinFramedGlass() {
    super(Settings.create()
        .instrument(Instrument.HAT)
        .strength(0.7F)
        .sounds(BlockSoundGroup.GLASS)
        .nonOpaque()
        .allowsSpawning(Blocks::never)
        .solidBlock(Blocks::never)
        .suffocates(Blocks::never)
        .blockVision(Blocks::never));
  }

}