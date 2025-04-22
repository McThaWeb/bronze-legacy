package com.khazoda.bronze;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Recipe;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Constants {

	public static final String MOD_ID = "bronze";
	public static final String MOD_NAME = "Bronze";
	public static final Logger LOG = LoggerFactory.getLogger(MOD_NAME);

	public static ResourceLocation ID(String path) {
		return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
	}

	public static ResourceKey<Item> BLOCKKEY(String name) {
		return ResourceKey.create(Registries.ITEM, ID(name));
	}

	public static ResourceKey<Item> ITEMKEY(String name) {
		return ResourceKey.create(Registries.ITEM, ID(name));
	}

	public static ResourceKey<Recipe<?>> RECIPEKEY(String name) {
    	return ResourceKey.create(Registries.RECIPE, ID(name));
  	}
}