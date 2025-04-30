package uk.isohex.voidmachina.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.dimension.DimensionType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import uk.isohex.voidmachina.core.Common;

public class DimensionTypeRegistry {
  public static final DeferredRegister<DimensionType> DIMENSION_TYPE = DeferredRegister
      .create(Registries.DIMENSION_TYPE, Common.MODID);

  public static final ResourceKey<DimensionType> VOID = Common.modResourceKey(
      Registries.DIMENSION_TYPE,
      "void_dimension_type");

  public static final void register(IEventBus eventBus) {
    DIMENSION_TYPE.register(eventBus);
  }
}
