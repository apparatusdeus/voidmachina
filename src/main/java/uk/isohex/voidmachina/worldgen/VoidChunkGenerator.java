package uk.isohex.voidmachina.worldgen;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeManager;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.*;
import net.minecraft.world.level.levelgen.blending.Blender;
import uk.isohex.voidmachina.registry.BiomeRegistry;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.NoiseColumn;
import net.minecraft.world.level.LevelHeightAccessor;
import net.minecraft.server.level.WorldGenRegion;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.resources.RegistryOps;

public class VoidChunkGenerator extends ChunkGenerator {

  public static final MapCodec<VoidChunkGenerator> CODEC = RecordCodecBuilder.mapCodec(builder -> builder
      .group(RegistryOps.retrieveElement(BiomeRegistry.VOID_BIOME_ID))
      .apply(builder, builder.stable(VoidChunkGenerator::new)));

  protected static final BlockState AIR;
  protected static final BlockState BARRIER;
  public static final int HEIGHT = 70;
  public static final int BARRIER_HEIGHT = 60;

  public VoidChunkGenerator(Holder.Reference<Biome> biome) {
    super(new VoidBiomeSource(biome));
  }

  @Override
  protected MapCodec<? extends ChunkGenerator> codec() {
    return CODEC;
  }

  @Override
  public void buildSurface(@Nonnull WorldGenRegion region, @Nonnull StructureManager structureManager,
      @Nonnull RandomState random, @Nonnull ChunkAccess chunk) {
  }

  @Override
  public void applyBiomeDecoration(@Nonnull WorldGenLevel level, @Nonnull ChunkAccess chunk,
      @Nonnull StructureManager structureManager) {
  }

  @Override
  public CompletableFuture<ChunkAccess> fillFromNoise(@Nonnull Blender blender, @Nonnull RandomState random,
      @Nonnull StructureManager structureManager, @Nonnull ChunkAccess chunk) {
    return CompletableFuture.completedFuture(chunk);
  }

  @Override
  public int getBaseHeight(int x, int z, @Nonnull Heightmap.Types heightmapType, @Nonnull LevelHeightAccessor level,
      @Nonnull RandomState random) {
    return 0;
  }

  @Override
  public NoiseColumn getBaseColumn(int x, int z, @Nonnull LevelHeightAccessor level, @Nonnull RandomState random) {
    return new NoiseColumn(0, new BlockState[0]);
  }

  @Override
  public void addDebugScreenInfo(@Nonnull List<String> info, @Nonnull RandomState random, @Nonnull BlockPos pos) {
  }

  @Override
  public void applyCarvers(@Nonnull WorldGenRegion region, long seed, @Nonnull RandomState random,
      @Nonnull BiomeManager biomeManager,
      @Nonnull StructureManager structureManager, @Nonnull ChunkAccess chunk, @Nonnull GenerationStep.Carving step) {
  }

  @Override
  public void spawnOriginalMobs(@Nonnull WorldGenRegion level) {
  }

  @Override
  public int getMinY() {
    return -64;
  }

  @Override
  public int getGenDepth() {
    return 384;
  }

  @Override
  public int getSeaLevel() {
    return 64;
  }

  static {
    AIR = Blocks.AIR.defaultBlockState();
    BARRIER = Blocks.BARRIER.defaultBlockState();
  }
}
