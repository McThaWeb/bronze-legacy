package com.khazoda.bronze.registry;

import com.khazoda.bronze.BronzeCommon;
import com.khazoda.bronze.Constants;
import com.khazoda.bronze.block.*;
import com.khazoda.bronze.item.BronzeKnifeFarmersDelight;
import com.khazoda.bronze.item.Sickle;
import com.khazoda.bronze.material.BronzeMaterial;
import com.khazoda.bronze.registry.helper.Reggie;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.*;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.material.MapColor;

import java.util.function.Function;
import java.util.function.Supplier;

import static com.khazoda.bronze.BronzeCommon.mod_loaded_farmersdelight;
import static com.khazoda.bronze.Constants.*;


public class MainRegistry {
  private static final Reggie<Block> BLOCK_REGISTRAR = BronzeCommon.REGISTRARS.get(Registries.BLOCK);
  private static final Reggie<Item> ITEM_REGISTRAR = BronzeCommon.REGISTRARS.get(Registries.ITEM);

  /* =========[ TagKey Registration ]==========*/
  private static final TagKey<Block> SICKLE_MINEABLE_TAG = TagKey.create(Registries.BLOCK, Constants.ID("mineable/sickle"));

  /* ==========[ Item Registration ]========== */
  public static final Supplier<Item> RAW_TIN = registerItem("raw_tin");
  public static final Supplier<Item> TIN_INGOT = registerItem("tin_ingot");
  public static final Supplier<Item> BRONZE_BLEND = registerItem("bronze_blend");
  public static final Supplier<Item> BRONZE_NUGGET = registerItem("bronze_nugget");
  public static final Supplier<Item> BRONZE_INGOT = registerItem("bronze_ingot");

  public static final Supplier<Item> BRONZE_HORSE_ARMOR = registerItem("bronze_horse_armor", id -> new Item(new Item.Properties().horseArmor(BronzeMaterial.BRONZE_ARMOR_MATERIAL).setId(id)));

  public static final Supplier<Item> BRONZE_SWORD = registerItem("bronze_sword", id -> new Item(new Item.Properties().sword(BronzeMaterial.BRONZE_TOOL_MATERIAL, 3.0F, -2.4F).setId(id)));
  public static final Supplier<Item> BRONZE_AXE = registerItem("bronze_axe", id -> new AxeItem(BronzeMaterial.BRONZE_TOOL_MATERIAL, 5.5F, -3.1F, new Item.Properties().setId(id)));
  public static final Supplier<Item> BRONZE_PICKAXE = registerItem("bronze_pickaxe", id -> new Item(new Item.Properties().pickaxe(BronzeMaterial.BRONZE_TOOL_MATERIAL, 1.0F, -2.8F).setId(id)));
  public static final Supplier<Item> BRONZE_SHOVEL = registerItem("bronze_shovel", id -> new ShovelItem(BronzeMaterial.BRONZE_TOOL_MATERIAL, 1.5F, -3.0F, new Item.Properties().setId(id)));
  public static final Supplier<Item> BRONZE_HOE = registerItem("bronze_hoe", id -> new HoeItem(BronzeMaterial.BRONZE_TOOL_MATERIAL, -2.0F, 0.0F, new Item.Properties().setId(id)));
  public static final Supplier<Item> SICKLE = registerItem("bronze_sickle", id -> new Sickle(new Item.Properties().tool(BronzeMaterial.BRONZE_TOOL_MATERIAL, SICKLE_MINEABLE_TAG, 1.5f, -3.0f, 0.0f).setId(id)));

  public static final Supplier<Item> BRONZE_HELMET = registerItem("bronze_helmet", id -> new Item(new Item.Properties().humanoidArmor(BronzeMaterial.BRONZE_ARMOR_MATERIAL, ArmorType.HELMET).setId(id)));
  public static final Supplier<Item> BRONZE_CHESTPLATE = registerItem("bronze_chestplate", id -> new Item(new Item.Properties().humanoidArmor(BronzeMaterial.BRONZE_ARMOR_MATERIAL, ArmorType.CHESTPLATE).setId(id)));
  public static final Supplier<Item> BRONZE_LEGGINGS = registerItem("bronze_leggings", id -> new Item(new Item.Properties().humanoidArmor(BronzeMaterial.BRONZE_ARMOR_MATERIAL, ArmorType.LEGGINGS).setId(id)));
  public static final Supplier<Item> BRONZE_BOOTS = registerItem("bronze_boots", id -> new Item(new Item.Properties().humanoidArmor(BronzeMaterial.BRONZE_ARMOR_MATERIAL, ArmorType.BOOTS).setId(id)));

  /* Farmers Delight Knife Compatibility - add the conditional registration code from init() here when using datagen*/
  public static Supplier<Item> BRONZE_KNIFE = registerItem("bronze_knife", id -> new BronzeKnifeFarmersDelight(BronzeKnifeFarmersDelight.createProperties(id)));


  /* ==========[ Block Registration ]========== */
  public static final Supplier<Block> TIN_ORE = registerBlock("tin_ore_block", 2.5f, 0, MapColor.STONE, NoteBlockInstrument.BASEDRUM, SoundType.STONE);
  public static final Supplier<Block> DEEPSLATE_TIN_ORE = registerBlock("deepslate_tin_ore_block", 3.5f, 0, MapColor.DEEPSLATE, NoteBlockInstrument.BASEDRUM, SoundType.DEEPSLATE);
  public static final Supplier<Block> RAW_TIN_BLOCK = registerBlock("raw_tin_block", 2.5F, 6.0F, MapColor.TERRACOTTA_WHITE, NoteBlockInstrument.BASEDRUM, SoundType.COPPER);
  public static final Supplier<Block> TIN_BLOCK = registerBlock("tin_block", 2.5F, 6.0F, MapColor.TERRACOTTA_WHITE, NoteBlockInstrument.IRON_XYLOPHONE, SoundType.COPPER);
  public static final Supplier<Block> CHISELED_TIN = registerBlock("chiseled_tin", 2.5F, 6.0F, MapColor.TERRACOTTA_WHITE, NoteBlockInstrument.IRON_XYLOPHONE, SoundType.COPPER);
  public static final Supplier<Block> CUT_TIN = registerBlock("cut_tin", 2.5F, 6.0F, MapColor.TERRACOTTA_WHITE, NoteBlockInstrument.IRON_XYLOPHONE, SoundType.COPPER);
  public static final Supplier<Block> TIN_TILES = registerBlock("tin_tiles", 2.5F, 6.0F, MapColor.TERRACOTTA_WHITE, NoteBlockInstrument.IRON_XYLOPHONE, SoundType.COPPER);
  public static final Supplier<Block> BRONZE_BLEND_BLOCK = registerBlock("bronze_blend_block", 2.5f, 0, MapColor.DIRT, NoteBlockInstrument.BASEDRUM, SoundType.STONE);
  public static final Supplier<Block> BRONZE_BLOCK = registerBlock("bronze_block", 3.5f, 0, MapColor.GOLD, NoteBlockInstrument.IRON_XYLOPHONE, SoundType.METAL);

  public static final Supplier<Block> TIN_FRAMED_GLASS = registerBlock("tin_framed_glass", () -> new TinFramedGlass(blockKey("tin_framed_glass")));
  public static final Supplier<Block> CUT_TIN_SLAB = registerBlock("cut_tin_slab", () -> new CutTinSlab(BlockBehaviour.Properties.ofFullCopy(CUT_TIN.get()).setId(blockKey("cut_tin_slab"))));
  public static final Supplier<Block> CUT_TIN_STAIRS = registerBlock("cut_tin_stairs", () -> new CutTinStairs(CUT_TIN.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(CUT_TIN.get()).setId(blockKey("cut_tin_stairs"))));
  public static final Supplier<Block> BRONZE_TRAPDOOR = registerBlock("bronze_trapdoor_block", () -> new BronzeTrapdoor(blockKey("bronze_trapdoor_block")));
  public static final Supplier<Block> BRONZE_DOOR = registerBlock("bronze_door_block", () -> new BronzeDoor(blockKey("bronze_door_block")));

  /* ==========[ BlockItem Registration ]========== */
  public static final Supplier<BlockItem> TIN_BLOCK_ITEM = registerBlockItem("tin_block", TIN_BLOCK);
  public static final Supplier<BlockItem> BRONZE_BLOCK_ITEM = registerBlockItem("bronze_block", BRONZE_BLOCK);
  public static final Supplier<BlockItem> TIN_ORE_ITEM = registerBlockItem("tin_ore_block", TIN_ORE);
  public static final Supplier<BlockItem> DEEPSLATE_TIN_ORE_ITEM = registerBlockItem("deepslate_tin_ore_block", DEEPSLATE_TIN_ORE);
  public static final Supplier<BlockItem> TIN_FRAMED_GLASS_ITEM = registerBlockItem("tin_framed_glass", TIN_FRAMED_GLASS);
  public static final Supplier<BlockItem> BRONZE_TRAPDOOR_ITEM = registerBlockItem("bronze_trapdoor_block", BRONZE_TRAPDOOR);
  public static final Supplier<BlockItem> BRONZE_DOOR_ITEM = registerBlockItem("bronze_door_block", BRONZE_DOOR);
  public static final Supplier<BlockItem> TIN_TILES_ITEM = registerBlockItem("tin_tiles", TIN_TILES);
  public static final Supplier<BlockItem> BRONZE_BLEND_BLOCK_ITEM = registerBlockItem("bronze_blend_block", BRONZE_BLEND_BLOCK);
  public static final Supplier<BlockItem> CHISELED_TIN_ITEM = registerBlockItem("chiseled_tin", CHISELED_TIN);
  public static final Supplier<BlockItem> CUT_TIN_ITEM = registerBlockItem("cut_tin", CUT_TIN);
  public static final Supplier<BlockItem> RAW_TIN_BLOCK_ITEM = registerBlockItem("raw_tin_block", RAW_TIN_BLOCK);
  public static final Supplier<BlockItem> CUT_TIN_STAIRS_ITEM = registerBlockItem("cut_tin_stairs", CUT_TIN_STAIRS);
  public static final Supplier<BlockItem> CUT_TIN_SLAB_ITEM = registerBlockItem("cut_tin_slab", CUT_TIN_SLAB);

  /* ===========[ World Generation ]============== */
  public static final ResourceKey<PlacedFeature> TIN_ORE_PLACED_KEY = ResourceKey.create(Registries.PLACED_FEATURE, ID("ore_tin"));
  public static final ResourceKey<PlacedFeature> TIN_ORE_SMALL_PLACED_KEY = ResourceKey.create(Registries.PLACED_FEATURE, ID("ore_tin_small"));

  public static void init() {
//    if (mod_loaded_farmersdelight) {
//      BRONZE_KNIFE = registerItem("bronze_knife", id -> new BronzeKnifeFarmersDelight(BronzeKnifeFarmersDelight.createProperties(id)));
//    }
  }


  /* =============[ Helper Methods ]============== */
  /* Register default BlockItem from Block */
  private static Supplier<BlockItem> registerBlockItem(String name, Supplier<Block> block) {
    return ITEM_REGISTRAR.register(name, () -> new BlockItem(block.get(), new Item.Properties().useBlockDescriptionPrefix().setId(itemKey(name))));
  }

  /* Register default Item */
  private static Supplier<Item> registerItem(String name) {
    return ITEM_REGISTRAR.register(name, () -> new Item(new Item.Properties().setId(itemKey(name))));
  }
  /* Register Item with dedicated Item class from factory */
  private static <T extends Item> Supplier<Item> registerItem(String name, Function<ResourceKey<Item>, T> factory) {
    return ITEM_REGISTRAR.register(name, () -> factory.apply(itemKey(name)));
  }

  /* Register Block with properties */
  private static Supplier<Block> registerBlock(String name, Function<ResourceKey<Block>, BlockBehaviour.Properties> props) {
    return BLOCK_REGISTRAR.register(name, () -> new Block(props.apply(blockKey(name))));
  }
  /* Register Block with dedicated Block supplier */
  private static Supplier<Block> registerBlock(String name, Supplier<Block> supplier) {
    return BLOCK_REGISTRAR.register(name, supplier);
  }
  /* Register Block with a bunch of predefined property parameters */
  private static Supplier<Block> registerBlock(String name, float destroyTime, float explosionResistance, MapColor mapColor, NoteBlockInstrument instrument, SoundType soundType) {
    return registerBlock(name, id -> BlockBehaviour.Properties.of().strength(destroyTime, explosionResistance).mapColor(mapColor).instrument(instrument).sound(soundType).requiresCorrectToolForDrops().setId(id));
  }
}