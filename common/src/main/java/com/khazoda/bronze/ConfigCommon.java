package com.khazoda.bronze;

public final class ConfigCommon {
  public enum Type {BOOL, NUM, STR}

  public record Config(String key, Type type, Object def) {
  }

  /* Define each config here */
  public static class Configs {
    public static final Config GENERATE_TIN_ORE = new Config("generate_tin_ore", Type.BOOL, true);
    public static final Config SICKLE_HARVEST_RANGE = new Config("sickle_harvest_range", Type.NUM, 4);
  }

  /* And add a reference to it here */
  public static final java.util.List<Config> ALL_CONFIGS = java.util.List.of(
      Configs.GENERATE_TIN_ORE,
      Configs.SICKLE_HARVEST_RANGE
  );
}