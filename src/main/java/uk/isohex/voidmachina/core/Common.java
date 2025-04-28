package uk.isohex.voidmachina.core;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;

public class Common {
  public static final String MODID = "voidmachina";

  public static final Logger LOGGER = LogUtils.getLogger();

  public static ResourceLocation modResourceLocation(String name) {
    return ResourceLocation.fromNamespaceAndPath(MODID, name);
  }

  public static <T> ResourceKey<T> modResourceKey(ResourceKey<? extends Registry<T>> registryKey, String name) {
    return ResourceKey.create(registryKey, modResourceLocation(name));
  }
}
