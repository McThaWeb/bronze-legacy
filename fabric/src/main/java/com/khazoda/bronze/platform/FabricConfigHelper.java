package com.khazoda.bronze.platform;

import com.khazoda.bronze.ConfigCommon;
import com.khazoda.bronze.ConfigFabric;
import com.khazoda.bronze.platform.services.IConfigHelper;

public class FabricConfigHelper implements IConfigHelper {
  @Override
  public <T> T get(ConfigCommon.Config key) {
    return ConfigFabric.get(key);
  }
}