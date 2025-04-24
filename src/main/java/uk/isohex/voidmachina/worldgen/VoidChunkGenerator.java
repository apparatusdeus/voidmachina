// package uk.isohex.voidmachina.worldgen;

// import java.util.List;
// import java.util.concurrent.CompletableFuture;
// import java.util.function.Function;

// import com.mojang.serialization.MapCodec;

// import net.minecraft.core.BlockPos;
// import net.minecraft.core.Holder;
// import net.minecraft.resources.ResourceKey;
// import net.minecraft.server.level.WorldGenRegion;
// import net.minecraft.world.level.LevelHeightAccessor;
// import net.minecraft.world.level.NoiseColumn;
// import net.minecraft.world.level.StructureManager;
// import net.minecraft.world.level.biome.Biome;
// import net.minecraft.world.level.biome.BiomeGenerationSettings;
// import net.minecraft.world.level.biome.BiomeManager;
// import net.minecraft.world.level.biome.BiomeSource;
// import net.minecraft.world.level.chunk.*;
// import net.minecraft.world.level.levelgen.*;
// import net.minecraft.world.level.levelgen.GenerationStep.Carving;
// import net.minecraft.world.level.levelgen.Heightmap.Types;
// import net.minecraft.world.level.levelgen.blending.Blender;
// import net.minecraft.world.level.levelgen.structure.StructureSet;

// public class VoidChunkGenerator extends ChunkGenerator {

// public VoidChunkGenerator(BiomeSource pBiomeSource,
// Function<Holder<Biome>, BiomeGenerationSettings> pGenerationSettingsGetter) {
// super(pBiomeSource, pGenerationSettingsGetter);
// }

// @Override
// protected MapCodec<? extends ChunkGenerator> codec() {
// // TODO Auto-generated method stub
// throw new UnsupportedOperationException("Unimplemented method 'codec'");
// }

// @Override
// public void applyCarvers(WorldGenRegion pLevel, long pSeed, RandomState
// pRandom, BiomeManager pBiomeManager,
// StructureManager pStructureManager, ChunkAccess pChunk, Carving pStep) {
// // Empty on purpose
// }

// @Override
// public void buildSurface(WorldGenRegion pLevel, StructureManager
// pStructureManager, RandomState pRandom,
// ChunkAccess pChunk) {
// // Empty on purpose
// }

// @Override
// public void spawnOriginalMobs(WorldGenRegion pLevel) {
// // Empty on purpose
// }

// @Override
// public int getGenDepth() {
// // TODO Auto-generated method stub
// throw new UnsupportedOperationException("Unimplemented method
// 'getGenDepth'");
// }

// @Override
// public CompletableFuture<ChunkAccess> fillFromNoise(Blender pBlender,
// RandomState pRandomState,
// StructureManager pStructureManager, ChunkAccess pChunk) {
// // TODO Auto-generated method stub
// throw new UnsupportedOperationException("Unimplemented method
// 'fillFromNoise'");
// }

// @Override
// public int getSeaLevel() {
// // TODO Auto-generated method stub
// throw new UnsupportedOperationException("Unimplemented method
// 'getSeaLevel'");
// }

// @Override
// public int getMinY() {
// // TODO Auto-generated method stub
// throw new UnsupportedOperationException("Unimplemented method 'getMinY'");
// }

// @Override
// public int getBaseHeight(int pX, int pZ, Types pType, LevelHeightAccessor
// pLevel, RandomState pRandom) {
// // TODO Auto-generated method stub
// throw new UnsupportedOperationException("Unimplemented method
// 'getBaseHeight'");
// }

// @Override
// public NoiseColumn getBaseColumn(int pX, int pZ, LevelHeightAccessor pHeight,
// RandomState pRandom) {
// // TODO Auto-generated method stub
// throw new UnsupportedOperationException("Unimplemented method
// 'getBaseColumn'");
// }

// @Override
// public void addDebugScreenInfo(List<String> pInfo, RandomState pRandom,
// BlockPos pPos) {
// // TODO Auto-generated method stub
// throw new UnsupportedOperationException("Unimplemented method
// 'addDebugScreenInfo'");
// }
// }
