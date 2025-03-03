package com.khazoda.bronze;

import com.khazoda.bronze.registry.MainRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.RenderType;

public class BronzeFabricClient implements ClientModInitializer {
  @Override
  public void onInitializeClient() {

    BlockRenderLayerMap.INSTANCE.putBlock(MainRegistry.BRONZE_DOOR.get(), RenderType.cutout());
    BlockRenderLayerMap.INSTANCE.putBlock(MainRegistry.BRONZE_TRAPDOOR.get(), RenderType.cutout());
    BlockRenderLayerMap.INSTANCE.putBlock(MainRegistry.TIN_FRAMED_GLASS.get(), RenderType.translucent());
  }
}
