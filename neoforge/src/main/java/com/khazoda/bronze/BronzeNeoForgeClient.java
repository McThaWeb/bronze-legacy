package com.khazoda.bronze;

import com.khazoda.bronze.registry.MainRegistry;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod(value = Constants.MOD_ID, dist = Dist.CLIENT)
public class BronzeNeoForgeClient {

    public BronzeNeoForgeClient(IEventBus eventBus) {
        eventBus.addListener(this::onClientSetup);
    }

    public void onClientSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            /* Needed until fabric datagen can create the "render_type": "minecraft:translucent/cutout" fields that neoforge needs */
            ItemBlockRenderTypes.setRenderLayer(MainRegistry.BRONZE_DOOR.get(), ChunkSectionLayer.CUTOUT);
            ItemBlockRenderTypes.setRenderLayer(MainRegistry.BRONZE_TRAPDOOR.get(), ChunkSectionLayer.CUTOUT);
            ItemBlockRenderTypes.setRenderLayer(MainRegistry.TIN_FRAMED_GLASS.get(), ChunkSectionLayer.TRANSLUCENT);
        });
    }
}