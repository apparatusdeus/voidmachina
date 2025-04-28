package uk.isohex.voidmachina.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.presets.WorldPreset;
import uk.isohex.voidmachina.core.Common;

public class TagRegistry {
  // public static class Blocks {
  // private static TagKey<Block> register(String name) {
  // return BlockTags.create(modResourceLocation(name));
  // }
  // }

  // public static class Items {
  // private static TagKey<Item> register(String name) {
  // return ItemTags.create(modResourceLocation(name));
  // }
  // }

  public static class WorldPresets {
    public static class Ids {
      public static final ResourceKey<WorldPreset> VOID = register("void_world");

      private static ResourceKey<WorldPreset> register(String name) {
        return Common.modResourceKey(Registries.WORLD_PRESET, name);
      }
    }
  }
}