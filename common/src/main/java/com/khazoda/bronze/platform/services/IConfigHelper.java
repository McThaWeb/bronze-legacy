package com.khazoda.bronze.platform.services;

import com.khazoda.bronze.ConfigCommon;

public interface IConfigHelper {
  <T> T get(ConfigCommon.Config key);
}