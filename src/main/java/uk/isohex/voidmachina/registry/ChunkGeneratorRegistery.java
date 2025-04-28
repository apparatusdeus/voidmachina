package uk.isohex.voidmachina.registry;

import com.mojang.serialization.MapCodec;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import uk.isohex.voidmachina.core.Common;
import uk.isohex.voidmachina.worldgen.VoidChunkGenerator;

public class ChunkGeneratorRegistery {
  public static final DeferredRegister<MapCodec<? extends ChunkGenerator>> CHUNK_GENERATORS = DeferredRegister
      .create(Registries.CHUNK_GENERATOR, Common.MODID);

  public static final DeferredHolder<MapCodec<? extends ChunkGenerator>, MapCodec<VoidChunkGenerator>> VOID_CHUNK_GENERATOR = CHUNK_GENERATORS
      .register("void_chunk_generator", () -> VoidChunkGenerator.CODEC);

  public static final void register(IEventBus eventBus) {
    CHUNK_GENERATORS.register(eventBus);
  }
}
