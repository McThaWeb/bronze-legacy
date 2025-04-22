package com.khazoda.bronze.registry;

import com.khazoda.bronze.BronzeCommon;
import com.khazoda.bronze.Constants;
import com.khazoda.bronze.block.*;
import com.khazoda.bronze.item.*;
import com.khazoda.bronze.material.BronzeMaterial;
import com.khazoda.bronze.registry.helper.Reggie;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.*;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.util.function.Supplier;

import static com.khazoda.bronze.Constants.ID;


public class MainRegistry {
  private static final Reggie<Block> BLOCK_REGISTRAR = BronzeCommon.REGISTRARS.get(Registries.BLOCK);
  private static final Reggie<Item> ITEM_REGISTRAR = BronzeCommon.REGISTRARS.get(Registries.ITEM);

  /* ==========[ Item Registration ]========== */
  public static final Supplier<Item> RAW_TIN = ITEM_REGISTRAR.register("raw_tin", () -> new RawTin(itemKey("raw_tin")));
  public static final Supplier<Item> TIN_INGOT = ITEM_REGISTRAR.register("tin_ingot", () -> new TinIngot(itemKey("tin_ingot")));
  public static final Supplier<Item> BRONZE_BLEND = ITEM_REGISTRAR.register("bronze_blend", () -> new BronzeBlend(itemKey("bronze_blend")));
  public static final Supplier<Item> BRONZE_NUGGET = ITEM_REGISTRAR.register("bronze_nugget", () -> new BronzeNugget(itemKey("bronze_nugget")));
  public static final Supplier<Item> BRONZE_INGOT = ITEM_REGISTRAR.register("bronze_ingot", () -> new BronzeIngot(itemKey("bronze_ingot")));
  public static final Supplier<Item> BRONZE_HORSE_ARMOR = ITEM_REGISTRAR.register("bronze_horse_armor",
      () -> new Item(new Item.Properties().horseArmor(BronzeMaterial.BRONZE_ARMOR_MATERIAL).setId(itemKey("bronze_horse_armor"))));

  public static final Supplier<Item> BRONZE_SWORD = ITEM_REGISTRAR.register("bronze_sword", () -> new Item(new Item.Properties().sword(BronzeMaterial.BRONZE_TOOL_MATERIAL, 3.0F, -2.4F).setId(itemKey("bronze_sword"))));
  public static final Supplier<Item> BRONZE_AXE = ITEM_REGISTRAR.register("bronze_axe", () -> new AxeItem(BronzeMaterial.BRONZE_TOOL_MATERIAL, 5.5F, -3.1F, new Item.Properties().setId(itemKey("bronze_axe"))));
  public static final Supplier<Item> BRONZE_PICKAXE = ITEM_REGISTRAR.register("bronze_pickaxe", () -> new Item(new Item.Properties().pickaxe(BronzeMaterial.BRONZE_TOOL_MATERIAL, 1.0F, -2.8F).setId(itemKey("bronze_pickaxe"))));
  public static final Supplier<Item> BRONZE_SHOVEL = ITEM_REGISTRAR.register("bronze_shovel", () -> new ShovelItem(BronzeMaterial.BRONZE_TOOL_MATERIAL, 1.5F, -3.0F, new Item.Properties().setId(itemKey("bronze_shovel"))));
  public static final Supplier<Item> BRONZE_HOE = ITEM_REGISTRAR.register("bronze_hoe", () -> new HoeItem(BronzeMaterial.BRONZE_TOOL_MATERIAL, -2.0F, 0.0F, new Item.Properties().setId(itemKey("bronze_hoe"))));
  private static final TagKey<Block> SICKLE_MINEABLE_TAG = TagKey.create(Registries.BLOCK, Constants.ID("mineable/sickle"));
  public static final Supplier<Sickle> SICKLE = ITEM_REGISTRAR.register("bronze_sickle", () -> new Sickle(new Item.Properties().tool(BronzeMaterial.BRONZE_TOOL_MATERIAL, SICKLE_MINEABLE_TAG, 1.5f, -3.0f, 0.0f).setId(itemKey("bronze_sickle"))));

  public static final Supplier<Item> BRONZE_HELMET = ITEM_REGISTRAR.register("bronze_helmet",
      () -> new Item(new Item.Properties().humanoidArmor(BronzeMaterial.BRONZE_ARMOR_MATERIAL, ArmorType.HELMET).setId(itemKey("bronze_helmet"))));
  public static final Supplier<Item> BRONZE_CHESTPLATE = ITEM_REGISTRAR.register("bronze_chestplate",
      () -> new Item(new Item.Properties().humanoidArmor(BronzeMaterial.BRONZE_ARMOR_MATERIAL, ArmorType.CHESTPLATE).setId(itemKey("bronze_chestplate"))));
  public static final Supplier<Item> BRONZE_LEGGINGS = ITEM_REGISTRAR.register("bronze_leggings",
      () -> new Item(new Item.Properties().humanoidArmor(BronzeMaterial.BRONZE_ARMOR_MATERIAL, ArmorType.LEGGINGS).setId(itemKey("bronze_leggings"))));
  public static final Supplier<Item> BRONZE_BOOTS = ITEM_REGISTRAR.register("bronze_boots",
      () -> new Item(new Item.Properties().humanoidArmor(BronzeMaterial.BRONZE_ARMOR_MATERIAL, ArmorType.BOOTS).setId(itemKey("bronze_boots"))));

  /* ==========[ Block Registration ]========== */
  public static final Supplier<Block> TIN_BLOCK = BLOCK_REGISTRAR.register("tin_block", () -> new TinBlock(blockKey("tin_block")));
  public static final Supplier<Block> BRONZE_BLOCK = BLOCK_REGISTRAR.register("bronze_block", () -> new BronzeBlock(blockKey("bronze_block")));
  public static final Supplier<Block> TIN_ORE = BLOCK_REGISTRAR.register("tin_ore_block", () -> new TinOre(blockKey("tin_ore_block")));
  public static final Supplier<Block> DEEPSLATE_TIN_ORE = BLOCK_REGISTRAR.register("deepslate_tin_ore_block", () -> new DeepslateTinOre(blockKey("deepslate_tin_ore_block")));
  public static final Supplier<Block> TIN_FRAMED_GLASS = BLOCK_REGISTRAR.register("tin_framed_glass", () -> new TinFramedGlass(blockKey("tin_framed_glass")));
  public static final Supplier<Block> BRONZE_TRAPDOOR = BLOCK_REGISTRAR.register("bronze_trapdoor_block", () -> new BronzeTrapdoor(blockKey("bronze_trapdoor_block")));
  public static final Supplier<Block> BRONZE_DOOR = BLOCK_REGISTRAR.register("bronze_door_block", () -> new BronzeDoor(blockKey("bronze_door_block")));
  public static final Supplier<Block> TIN_TILES = BLOCK_REGISTRAR.register("tin_tiles", () -> new TinTiles(blockKey("tin_tiles")));
  public static final Supplier<Block> BRONZE_BLEND_BLOCK = BLOCK_REGISTRAR.register("bronze_blend_block", () -> new BronzeBlendBlock(blockKey("bronze_blend_block")));
  public static final Supplier<Block> CHISELED_TIN = BLOCK_REGISTRAR.register("chiseled_tin", () -> new ChiseledTin(blockKey("chiseled_tin")));
  public static final Supplier<Block> CUT_TIN = BLOCK_REGISTRAR.register("cut_tin", () -> new CutTin(blockKey("cut_tin")));
  public static final Supplier<Block> RAW_TIN_BLOCK = BLOCK_REGISTRAR.register("raw_tin_block", () -> new TinRawBlock(blockKey("raw_tin_block")));
  public static final Supplier<Block> CUT_TIN_STAIRS = BLOCK_REGISTRAR.register("cut_tin_stairs", () -> new CutTinStairs(CUT_TIN.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(CUT_TIN.get()).setId(blockKey("cut_tin_stairs"))));
  public static final Supplier<Block> CUT_TIN_SLAB = BLOCK_REGISTRAR.register("cut_tin_slab", () -> new CutTinSlab(BlockBehaviour.Properties.ofFullCopy(CUT_TIN.get()).setId(blockKey("cut_tin_slab"))));

  /* ==========[ BlockItem Registration ]========== */
  public static final Supplier<BlockItem> TIN_BLOCK_ITEM = register("tin_block", TIN_BLOCK);
  public static final Supplier<BlockItem> BRONZE_BLOCK_ITEM = register("bronze_block", BRONZE_BLOCK);
  public static final Supplier<BlockItem> TIN_ORE_ITEM = register("tin_ore_block", TIN_ORE);
  public static final Supplier<BlockItem> DEEPSLATE_TIN_ORE_ITEM = register("deepslate_tin_ore_block", DEEPSLATE_TIN_ORE);
  public static final Supplier<BlockItem> TIN_FRAMED_GLASS_ITEM = register("tin_framed_glass", TIN_FRAMED_GLASS);
  public static final Supplier<BlockItem> BRONZE_TRAPDOOR_ITEM = register("bronze_trapdoor_block", BRONZE_TRAPDOOR);
  public static final Supplier<BlockItem> BRONZE_DOOR_ITEM = register("bronze_door_block", BRONZE_DOOR);
  public static final Supplier<BlockItem> TIN_TILES_ITEM = register("tin_tiles", TIN_TILES);
  public static final Supplier<BlockItem> BRONZE_BLEND_BLOCK_ITEM = register("bronze_blend_block", BRONZE_BLEND_BLOCK);
  public static final Supplier<BlockItem> CHISELED_TIN_ITEM = register("chiseled_tin", CHISELED_TIN);
  public static final Supplier<BlockItem> CUT_TIN_ITEM = register("cut_tin", CUT_TIN);
  public static final Supplier<BlockItem> RAW_TIN_BLOCK_ITEM = register("raw_tin_block", RAW_TIN_BLOCK);
  public static final Supplier<BlockItem> CUT_TIN_STAIRS_ITEM = register("cut_tin_stairs", CUT_TIN_STAIRS);
  public static final Supplier<BlockItem> CUT_TIN_SLAB_ITEM = register("cut_tin_slab", CUT_TIN_SLAB);

  /* WorldGen */
  public static final ResourceKey<PlacedFeature> TIN_ORE_PLACED_KEY = ResourceKey.create(Registries.PLACED_FEATURE, ID("ore_tin"));
  public static final ResourceKey<PlacedFeature> TIN_ORE_SMALL_PLACED_KEY = ResourceKey.create(Registries.PLACED_FEATURE, ID("ore_tin_small"));

  public static void init() {

  }

  private static Supplier<BlockItem> register(String name, Supplier<Block> block) {
    Supplier<BlockItem> blockItemSupplier = ITEM_REGISTRAR.register(name, () -> new BlockItem(block.get(), new Item.Properties().useBlockDescriptionPrefix().setId(itemKey(name))));
    return blockItemSupplier;
  }

  private static ResourceKey<Block> blockKey(String name) {
    return ResourceKey.create(Registries.BLOCK, Constants.ID(name));
  }

  private static ResourceKey<Item> itemKey(String name) {
    return ResourceKey.create(Registries.ITEM, Constants.ID(name));
  }
}