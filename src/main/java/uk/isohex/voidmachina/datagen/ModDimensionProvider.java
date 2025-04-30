package uk.isohex.voidmachina.datagen;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import uk.isohex.voidmachina.registry.BiomeRegistry;
import uk.isohex.voidmachina.registry.DimensionRegistry;
import uk.isohex.voidmachina.registry.DimensionTypeRegistry;
import uk.isohex.voidmachina.worldgen.VoidChunkGenerator;

// A "Dimension" for the purposes of code is actually a "LevelStem"
public class ModDimensionProvider {
  public static void bootstrap(BootstrapContext<LevelStem> context) {
    context.register(DimensionRegistry.VOID, createVoidDimensionType(context));
  }

  private static LevelStem createVoidDimensionType(BootstrapContext<LevelStem> context) {
    HolderGetter<DimensionType> holdergetter = context.lookup(Registries.DIMENSION_TYPE);
    Holder<DimensionType> holder = holdergetter.getOrThrow(DimensionTypeRegistry.VOID);
    Holder.Reference<Biome> biome = context.lookup(Registries.BIOME).getOrThrow(BiomeRegistry.VOID);

    return new LevelStem(holder, new VoidChunkGenerator(biome));
  }
}
