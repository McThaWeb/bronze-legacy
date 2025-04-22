package com.khazoda.bronze.material;

import com.khazoda.bronze.Constants;
import net.minecraft.Util;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAsset;

import java.util.EnumMap;

public class BronzeMaterial {

  public static final ResourceKey<? extends Registry<EquipmentAsset>> ROOT_ID = ResourceKey.createRegistryKey(ResourceLocation.withDefaultNamespace("equipment_asset"));
  public static final ResourceKey<EquipmentAsset> BRONZE_ARMOR_MATERIAL_KEY = ResourceKey.create(ROOT_ID, Constants.ID("bronze"));

  public static final TagKey<Item> BRONZE_INGOT_TAG = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("c", "ingots/bronze"));
  
  public static final ArmorMaterial BRONZE_ARMOR_MATERIAL = new ArmorMaterial(350,
    Util.make(new EnumMap<>(ArmorType.class), map -> {
      map.put(ArmorType.BOOTS, 2);
      map.put(ArmorType.LEGGINGS, 5);
      map.put(ArmorType.CHESTPLATE, 7);
      map.put(ArmorType.HELMET, 2);
      map.put(ArmorType.BODY, 6);
    }), 12, SoundEvents.ARMOR_EQUIP_IRON, 1.0F, 0.0F, BRONZE_INGOT_TAG, BRONZE_ARMOR_MATERIAL_KEY);
  
  public static final ToolMaterial BRONZE_TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_IRON_TOOL, 350, 7.0F, 2.5F, 15, BRONZE_INGOT_TAG);
}
