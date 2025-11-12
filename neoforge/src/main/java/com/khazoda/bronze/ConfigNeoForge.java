package com.khazoda.bronze;

import com.google.common.collect.ImmutableMap;
import net.neoforged.neoforge.common.ModConfigSpec;

import java.util.Map;

import static com.khazoda.bronze.ConfigCommon.ALL_CONFIGS;

public final class ConfigNeoForge {
  public static final ModConfigSpec SPEC;
  private static final Map<ConfigCommon.Config, ModConfigSpec.ConfigValue<?>> HANDLES;

  static {
    ModConfigSpec.Builder b = new ModConfigSpec.Builder();
    ImmutableMap.Builder<ConfigCommon.Config, ModConfigSpec.ConfigValue<?>> map = ImmutableMap.builder();

    for (ConfigCommon.Config k : ALL_CONFIGS) {
      ModConfigSpec.ConfigValue<?> handle = switch (k.type()) {
        case BOOL -> b.define(k.key(), (Boolean) k.def());
        case NUM -> b.defineInRange(k.key(), ((Number) k.def()).intValue(),
            0, Integer.MAX_VALUE);
        case STR -> b.define(k.key(), (String) k.def());
      };
      map.put(k, handle);
    }

    HANDLES = map.build();
    SPEC = b.build();
  }

  @SuppressWarnings("unchecked")
  public static <T> T get(ConfigCommon.Config key) {
    ModConfigSpec.ConfigValue<?> h = HANDLES.get(key);
    return h != null ? (T) h.get() : (T) key.def();
  }
}