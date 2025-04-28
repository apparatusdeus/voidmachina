package uk.isohex.voidmachina.worldgen;

import com.mojang.serialization.MapCodec;
import java.util.stream.Stream;

import javax.annotation.Nonnull;
import net.minecraft.core.Holder;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.biome.Climate;

public class VoidBiomeSource extends BiomeSource {
  public static final MapCodec<VoidBiomeSource> CODEC;
  private final Holder<Biome> biome;

  public VoidBiomeSource(Holder<Biome> biome) {
    this.biome = biome;
  }

  @Override
  protected Stream<Holder<Biome>> collectPossibleBiomes() {
    return Stream.of(this.biome);
  }

  @Override
  protected MapCodec<? extends BiomeSource> codec() {
    return CODEC;
  }

  @Override
  public Holder<Biome> getNoiseBiome(int x, int y, int z, @Nonnull Climate.Sampler sampler) {
    return this.biome;
  }

  static {
    CODEC = Biome.CODEC.fieldOf("biome").xmap(VoidBiomeSource::new, (builder) -> {
      return builder.biome;
    }).stable();
  }
}
