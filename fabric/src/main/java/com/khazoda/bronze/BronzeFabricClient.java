package com.khazoda.bronze;

import com.khazoda.bronze.registry.MainRegistry;
import net.fabricmc.api.ClientModInitializer;
 import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;

public class BronzeFabricClient implements ClientModInitializer {
  @Override
  public void onInitializeClient() {
    BlockRenderLayerMap.putBlock(MainRegistry.BRONZE_DOOR.get(), ChunkSectionLayer.CUTOUT);
    BlockRenderLayerMap.putBlock(MainRegistry.BRONZE_TRAPDOOR.get(), ChunkSectionLayer.CUTOUT);
    BlockRenderLayerMap.putBlock(MainRegistry.TIN_FRAMED_GLASS.get(), ChunkSectionLayer.TRANSLUCENT);
  }
}
