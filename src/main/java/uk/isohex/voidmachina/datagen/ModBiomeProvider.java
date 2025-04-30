package uk.isohex.voidmachina.datagen;

import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;
import uk.isohex.voidmachina.registry.BiomeRegistry;

public class ModBiomeProvider {
  public static void bootstrap(BootstrapContext<Biome> context) {
    context.register(BiomeRegistry.VOID, createVoidBiome());
  }

  private static Biome createVoidBiome() {
    BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder()
        .waterColor(0x3F76E4)
        .waterFogColor(0x050533)
        .fogColor(0xC0D8FF)
        .skyColor(0x77ADFF)
        .build();

    return new Biome.BiomeBuilder()
        .temperature(0.5f)
        .downfall(0f)
        .hasPrecipitation(false)
        .specialEffects(effects)
        .mobSpawnSettings(MobSpawnSettings.EMPTY)
        .generationSettings(BiomeGenerationSettings.EMPTY)
        .build();
  }
}