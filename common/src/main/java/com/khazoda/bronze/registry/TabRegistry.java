package com.khazoda.bronze.registry;

import com.khazoda.bronze.BronzeCommon;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;

import java.util.function.Supplier;

@SuppressWarnings("unused")
public class TabRegistry {
  public static final Supplier<CreativeModeTab> PLUSHABLES_TAB = BronzeCommon.REGISTRARS
      .get(Registries.CREATIVE_MODE_TAB)
      .register("main", () -> CreativeModeTab.builder(CreativeModeTab.Row.TOP, 0)
          .title(Component.translatable("itemGroup.plushables.main"))
          .icon(() -> MainRegistry.BRONZE_BLOCK_ITEM.get().getDefaultInstance())
          .displayItems((parameters, output) -> {
            output.accept(MainRegistry.TIN_BLOCK_ITEM.get());
            output.accept(MainRegistry.BRONZE_BLOCK_ITEM.get());
          })
          .build());

  public static void init() {
  }
}