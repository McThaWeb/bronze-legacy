package com.khazoda.bronze;

import net.fabricmc.api.ModInitializer;

public class BronzeFabric implements ModInitializer {

    @Override
    public void onInitialize() {

        BronzeCommon.init();
        BronzeCommon.postInit();
        BronzeCommon.REGISTRARS.registerAll();
    }
}
