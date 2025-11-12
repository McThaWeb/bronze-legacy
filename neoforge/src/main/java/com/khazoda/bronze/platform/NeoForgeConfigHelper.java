package com.khazoda.bronze.platform;

import com.khazoda.bronze.ConfigCommon;
import com.khazoda.bronze.ConfigNeoForge;
import com.khazoda.bronze.platform.services.IConfigHelper;

public class NeoForgeConfigHelper implements IConfigHelper {
  @Override
  public <T> T get(ConfigCommon.Config key) {
    return ConfigNeoForge.get(key);
  }
}