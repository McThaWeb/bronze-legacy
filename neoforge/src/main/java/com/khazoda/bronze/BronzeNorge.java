package com.khazoda.bronze;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.registries.RegisterEvent;

@Mod(Constants.MOD_ID)
public class BronzeNorge {

  public BronzeNorge(IEventBus eventBus) {
    BronzeCommon.init();
    eventBus.addListener(this::onInit);
    eventBus.addListener(this::onRegister);

  }

  private void onInit(FMLCommonSetupEvent event) {
    event.enqueueWork(BronzeCommon::postInit);
  }

  private void onRegister(RegisterEvent event) {
    BronzeCommon.REGISTRARS.register(event.getRegistry());
  }
}