package uk.isohex.voidmachina.datagen;

import java.util.OptionalLong;

import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.dimension.DimensionType;
import uk.isohex.voidmachina.registry.DimensionTypeRegistry;

public class ModDimensionTypeProvider {
  public static void bootstrap(BootstrapContext<DimensionType> context) {
    context.register(DimensionTypeRegistry.VOID, createVoidDimensionType());
  }

  private static DimensionType createVoidDimensionType() {
    return new DimensionType(
        OptionalLong.empty(), // fixedTime
        true, // hasSkyLight
        false, // hasCeiling
        false, // ultraWarm
        true, // natural
        1.0, // coordinateScale
        true, // bedWorks
        false, // respawnAnchorWorks
        -64, // minY
        384, // height
        384, // logicalHeight
        BlockTags.INFINIBURN_OVERWORLD, // infiniburn
        BuiltinDimensionTypes.OVERWORLD_EFFECTS, // effectsLocation
        0.0F, // ambientLight
        new DimensionType.MonsterSettings(false, true, UniformInt.of(0, 7), 0) // monsterSettings
    );
  }
}