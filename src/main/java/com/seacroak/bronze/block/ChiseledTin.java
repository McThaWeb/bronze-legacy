package com.seacroak.bronze.block;

import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.Instrument;
import net.minecraft.sound.BlockSoundGroup;

public class ChiseledTin extends Block {
  public ChiseledTin() {
    super(Settings.create().strength(2.5F, 6.0F).mapColor(MapColor.WHITE).instrument(Instrument.IRON_XYLOPHONE).sounds(BlockSoundGroup.COPPER).requiresTool());  }
}
