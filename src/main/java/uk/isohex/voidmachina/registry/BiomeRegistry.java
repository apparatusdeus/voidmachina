package uk.isohex.voidmachina.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import uk.isohex.voidmachina.core.Common;

public class BiomeRegistry {
  public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(Registries.BIOME, Common.MODID);

  public static final ResourceKey<Biome> VOID = Common.modResourceKey(Registries.BIOME, "void_diome");

  public static final void register(IEventBus eventBus) {
    BIOMES.register(eventBus);
  }
}
