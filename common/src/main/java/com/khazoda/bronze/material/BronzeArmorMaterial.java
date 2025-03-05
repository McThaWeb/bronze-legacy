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
  private static Holder<ArmorMaterial> register(String name, EnumMap<ArmorItem.Type, Integer> defense, int enchantmentValue, Holder<SoundEvent> equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
    List<ArmorMaterial.Layer> list = List.of(new ArmorMaterial.Layer(ResourceLocation.withDefaultNamespace(name)));
    return register(name, defense, enchantmentValue, equipSound, toughness, knockbackResistance, repairIngredient, list);
  }

  private static Holder<ArmorMaterial> register(String name, EnumMap<ArmorItem.Type, Integer> defense, int enchantmentValue, Holder<SoundEvent> equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngridient, List<ArmorMaterial.Layer> layers) {
    EnumMap<ArmorItem.Type, Integer> enummap = new EnumMap<>(ArmorItem.Type.class);
    ArmorItem.Type[] var9 = ArmorItem.Type.values();

    for (ArmorItem.Type armoritem$type : var9) {
      enummap.put(armoritem$type, defense.get(armoritem$type));
    }


    return Registry.registerForHolder(BuiltInRegistries.ARMOR_MATERIAL, ResourceLocation.withDefaultNamespace(name), new ArmorMaterial(enummap, enchantmentValue, equipSound, repairIngridient, layers, toughness, knockbackResistance));
  }

  public static final Holder<ArmorMaterial> HOLDER = register("bronze", Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
    map.put(ArmorItem.Type.BOOTS, 2);
    map.put(ArmorItem.Type.LEGGINGS, 5);
    map.put(ArmorItem.Type.CHESTPLATE, 7);
    map.put(ArmorItem.Type.HELMET, 2);
    map.put(ArmorItem.Type.BODY, 6);
    }), 12, SoundEvents.ARMOR_EQUIP_IRON, 1.0F, 0.0F, () -> Ingredient.of(MainRegistry.BRONZE_INGOT.get()));

}
