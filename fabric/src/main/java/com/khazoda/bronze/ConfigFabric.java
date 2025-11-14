package com.khazoda.bronze;

import com.google.gson.*;
import net.fabricmc.loader.api.FabricLoader;

import java.nio.file.Files;
import java.nio.file.Path;

public final class ConfigFabric {
  private static final Path FILE = FabricLoader.getInstance().getConfigDir().resolve("bronze.json");
  private static JsonObject root;

  static {
    load();
  }

  @SuppressWarnings("unchecked")
  public static <T> T get(ConfigCommon.Config config) {
    if (!root.has(config.key())) return (T) config.def();

    JsonElement e = root.get(config.key());
    return switch (config.type()) {
      case BOOL -> (T) Boolean.valueOf(e.getAsBoolean());
      case NUM -> (T) Integer.valueOf(e.getAsInt());
      case STR -> (T) e.getAsString();
    };
  }

  private static void load() {
    try {
      if (Files.notExists(FILE)) {
        root = new JsonObject();
        for (ConfigCommon.Config k : ConfigCommon.ALL_CONFIGS) {
          root.add(k.key(), switch (k.type()) {
            case BOOL -> new JsonPrimitive((Boolean) k.def());
            case NUM -> new JsonPrimitive((Number) k.def());
            case STR -> new JsonPrimitive((String) k.def());
          });
        }
        Files.writeString(FILE, new GsonBuilder().setPrettyPrinting().create().toJson(root));
      } else {
        root = JsonParser.parseString(Files.readString(FILE)).getAsJsonObject();
      }
    } catch (Exception ex) {
      throw new RuntimeException(ex);
    }
  }
}