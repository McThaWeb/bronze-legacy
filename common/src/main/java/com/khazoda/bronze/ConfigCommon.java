package com.khazoda.bronze;

public final class ConfigCommon {
  public enum Type {BOOL, NUM, STR}

  public record Config(String key, Type type, Object def) {
  }

  /* Define each config here */
  public static class Configs {
    public static final Config GENERATE_TIN_ORE = new Config("generate_tin_ore", Type.BOOL, true);
    public static final Config ENABLE_TIN_GEAR = new Config("enable_tin_gear", Type.BOOL, true);
  }

  /* And add a reference to it here */
  public static final java.util.List<Config> ALL_CONFIGS = java.util.List.of(
      Configs.GENERATE_TIN_ORE,
      Configs.ENABLE_TIN_GEAR
  );
}