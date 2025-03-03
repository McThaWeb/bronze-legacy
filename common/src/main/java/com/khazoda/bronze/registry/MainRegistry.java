package com.khazoda.bronze.registry;

import com.khazoda.bronze.BronzeCommon;
import com.khazoda.bronze.block.BronzeBlock;
import com.khazoda.bronze.block.TinBlock;
import com.khazoda.bronze.registry.helper.Reggie;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;


public class MainRegistry {
  private static final Reggie<Block> BLOCK_REGISTRAR = BronzeCommon.REGISTRARS.get(Registries.BLOCK);
  private static final Reggie<Item> ITEM_REGISTRAR = BronzeCommon.REGISTRARS.get(Registries.ITEM);

  /* ==========[ Block Registration ]========== */
  public static final Supplier<Block> TIN_BLOCK = BLOCK_REGISTRAR.register("tin_block", TinBlock::new);
  public static final Supplier<Block> BRONZE_BLOCK = BLOCK_REGISTRAR.register("bronze_block", BronzeBlock::new);


  /* ==========[ BlockItem Registration ]========== */
  public static final Supplier<BlockItem> TIN_BLOCK_ITEM = register("tin_block", TIN_BLOCK);
  public static final Supplier<BlockItem> BRONZE_BLOCK_ITEM = register("bronze_block", BRONZE_BLOCK);


  public static void init() {
  }

  private static Supplier<BlockItem> register(String name, Supplier<Block> block) {
    Supplier<BlockItem> blockItemSupplier = ITEM_REGISTRAR.register(name, () -> new BlockItem(block.get(), new Item.Properties().stacksTo(1)));
    return blockItemSupplier;
  }
}