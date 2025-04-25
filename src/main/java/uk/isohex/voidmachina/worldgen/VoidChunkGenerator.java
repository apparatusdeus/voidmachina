// package com.voidmachina.worldgen;

// import net.minecraft.core.Holder;
// import net.minecraft.core.RegistryAccess;
// import net.minecraft.core.registries.Registries;
// import net.minecraft.resources.ResourceLocation;
// import net.minecraft.server.level.WorldGenRegion;
// import net.minecraft.world.level.StructureManager;
// import net.minecraft.world.level.biome.BiomeManager;
// import net.minecraft.world.level.biome.BiomeSource;
// import net.minecraft.world.level.chunk.*;
// import net.minecraft.world.level.levelgen.*;
// import net.minecraft.world.level.levelgen.structure.StructureSet;
// import
// net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplateManager;

// public class VoidChunkGenerator extends ChunkGenerator {

// public VEVoidChunkGenerator(Holder<StructureSet> structureSet, BiomeSource
// biomeSource) {
// super(structureSet, biomeSource);
// }

// @Override
// public void buildSurface(WorldGenRegion region, StructureManager
// structureManager, RandomState randomState,
// ChunkAccess chunk) {
// // Intentionally left blank to create a void world
// }

// @Override
// public void applyCarvers(WorldGenRegion region, long seed, RandomState
// randomState, BiomeManager biomeManager,
// StructureManager structureManager, ChunkAccess chunk, GenerationStep.Carving
// step) {
// // No carvers applied in a void world
// }

// @Override
// public void fillFromNoise(WorldGenRegion region, StructureManager
// structureManager, RandomState randomState,
// ChunkAccess chunk) {
// // No terrain noise to fill in a void world
// }

// @Override
// public int getBaseHeight(int x, int z, Heightmap.Types heightmapType,
// LevelHeightAccessor level) {
// return level.getMinBuildHeight();
// }

// @Override
// public NoiseColumn getBaseColumn(int x, int z, LevelHeightAccessor level) {
// return new NoiseColumn(level.getMinBuildHeight(), new BlockState[0]);
// }
// }
