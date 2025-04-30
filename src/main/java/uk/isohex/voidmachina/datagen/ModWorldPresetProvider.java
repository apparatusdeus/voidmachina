package uk.isohex.voidmachina.datagen;

import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.level.levelgen.presets.WorldPreset;

public class ModWorldPresetProvider {
  public static void bootstrap(BootstrapContext<WorldPreset> context) {
    // context.register(WorldPresetRegistry.VOID, createVoidWorldPreset());
  }

  @SuppressWarnings("unused")
  private static void createVoidWorldPreset() {
    // Not sure how to implement this
  }
}
