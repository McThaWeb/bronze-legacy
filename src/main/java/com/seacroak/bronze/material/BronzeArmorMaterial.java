package com.seacroak.bronze.material;

import com.seacroak.bronze.registry.MainRegistry;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public class BronzeArmorMaterial {
  public static final RegistryEntry<ArmorMaterial> INSTANCE;

  public BronzeArmorMaterial() {
  }
  private static RegistryEntry<ArmorMaterial> register(EnumMap<ArmorItem.Type, Integer> defense, Supplier<Ingredient> repairIngredient) {
    List<ArmorMaterial.Layer> list = List.of(new ArmorMaterial.Layer(Identifier.of("bronze")));
    return register("bronze", defense, repairIngredient, list);
  }

  private static RegistryEntry<ArmorMaterial> register(String id, EnumMap<ArmorItem.Type, Integer> defense, Supplier<Ingredient> repairIngredient, List<ArmorMaterial.Layer> layers) {
    EnumMap<ArmorItem.Type, Integer> enumMap = new EnumMap<>(ArmorItem.Type.class);
    ArmorItem.Type[] var9 = ArmorItem.Type.values();
    int var10 = var9.length;

    for (ArmorItem.Type type : var9) {
      enumMap.put(type, (Integer) defense.get(type));
    }

    return Registry.registerReference(Registries.ARMOR_MATERIAL, Identifier.of(id), new ArmorMaterial(enumMap, 12, SoundEvents.ITEM_ARMOR_EQUIP_IRON, repairIngredient, layers, (float) 1.0, (float) 0.0));
  }
  static {

    INSTANCE = register(Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> {
      map.put(ArmorItem.Type.BOOTS, 2);
      map.put(ArmorItem.Type.LEGGINGS, 5);
      map.put(ArmorItem.Type.CHESTPLATE, 7);
      map.put(ArmorItem.Type.HELMET, 2);
      map.put(ArmorItem.Type.BODY, 6);
    }), () -> {
      return Ingredient.ofItems(new ItemConvertible[]{MainRegistry.BRONZE_INGOT});
    });
  }
}
