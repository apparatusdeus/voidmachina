package uk.isohex.voidmachina.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.presets.WorldPreset;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import uk.isohex.voidmachina.core.Common;

public class WorldPresetRegistry {
  public static final DeferredRegister<WorldPreset> WORLD_PRESET = DeferredRegister
      .create(Registries.WORLD_PRESET, Common.MODID);

  public static final ResourceKey<WorldPreset> VOID = Common.modResourceKey(
      Registries.WORLD_PRESET,
      "void_world_preset");

  public static final void register(IEventBus eventBus) {
    WORLD_PRESET.register(eventBus);
  }
}
