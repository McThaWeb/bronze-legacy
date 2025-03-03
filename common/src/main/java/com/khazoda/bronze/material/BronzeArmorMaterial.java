package com.khazoda.bronze.material;

import com.khazoda.bronze.registry.MainRegistry;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public class BronzeArmorMaterial {
  public static final Holder<ArmorMaterial> INSTANCE;

  private BronzeArmorMaterial() {
  }

  private static Holder<ArmorMaterial> register(String name, EnumMap<ArmorItem.Type, Integer> defense, int enchantmentValue, Holder<SoundEvent> equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
    List<ArmorMaterial.Layer> list = List.of(new ArmorMaterial.Layer(ResourceLocation.withDefaultNamespace(name)));
    return register(name, defense, enchantmentValue, equipSound, toughness, knockbackResistance, repairIngredient, list);
  }

  private static Holder<ArmorMaterial> register(String name, EnumMap<ArmorItem.Type, Integer> defense, int enchantmentValue, Holder<SoundEvent> equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient, List<ArmorMaterial.Layer> layers) {
    EnumMap<ArmorItem.Type, Integer> enumMap = new EnumMap<>(ArmorItem.Type.class);
    for (ArmorItem.Type type : ArmorItem.Type.values()) {
      enumMap.put(type, defense.get(type));
    }
    return Registry.registerForHolder(BuiltInRegistries.ARMOR_MATERIAL, ResourceLocation.withDefaultNamespace(name), new ArmorMaterial(enumMap, enchantmentValue, equipSound, repairIngredient, layers, toughness, knockbackResistance));
  }

  static {
    INSTANCE = register("bronze", Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> {
      map.put(ArmorItem.Type.BOOTS, 2);
      map.put(ArmorItem.Type.LEGGINGS, 5);
      map.put(ArmorItem.Type.CHESTPLATE, 7);
      map.put(ArmorItem.Type.HELMET, 2);
      map.put(ArmorItem.Type.BODY, 6);
    }), 12, SoundEvents.ARMOR_EQUIP_IRON, 1.0F, 0.0F, () -> Ingredient.of(MainRegistry.BRONZE_INGOT.get()));
  }
}
