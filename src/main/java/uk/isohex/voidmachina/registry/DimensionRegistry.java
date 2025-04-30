package uk.isohex.voidmachina.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.dimension.LevelStem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import uk.isohex.voidmachina.core.Common;

public class DimensionRegistry {
  public static final DeferredRegister<LevelStem> DIMENSION = DeferredRegister
      .create(Registries.LEVEL_STEM, Common.MODID);

  public static final ResourceKey<LevelStem> VOID = Common.modResourceKey(
      Registries.LEVEL_STEM,
      "void_dimension");

  public static final void register(IEventBus eventBus) {
    DIMENSION.register(eventBus);
  }
}
