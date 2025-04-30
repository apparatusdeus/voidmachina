package uk.isohex.voidmachina.worldgen;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import uk.isohex.voidmachina.core.Common;

public class SpawnStructurePlacer {

  public static void placeSpawnStructure(ServerLevel level) {
    ResourceLocation structureLocation = Common.modResourceLocation("spawn_shrine");
    StructureTemplate template = level.getStructureManager().get(structureLocation).orElse(null);

    if (template == null) {
      Common.LOGGER.error("Failed to load structure: {}", structureLocation);
      return;
    }

    int midPoint = (level.getMaxBuildHeight() + level.getMinBuildHeight()) / 2;

    Vec3i size = template.getSize();

    BlockPos structurePos = new BlockPos(
        (16 / 2) - (size.getX() / 2),
        midPoint - (size.getY() / 2),
        (16 / 2) - (size.getZ() / 2));

    Common.LOGGER.info("Minimum build height {} {}", midPoint);
    Common.LOGGER.info("Placing structure '{}' at {}", structureLocation, structurePos);
    Common.LOGGER.info("Template size {}", template.getSize());

    boolean success = template.placeInWorld(
        level,
        structurePos,
        structurePos,
        new StructurePlaceSettings(),
        level.getRandom(),
        2);

    if (!success) {
      Common.LOGGER.error("Failed to place structure at {}", structurePos);
    } else {
      Common.LOGGER.info("Successfully placed structure!");
    }

    BlockPos spawnPos = structurePos.offset(size.getX() / 2, size.getY() / 2, 1);
    Common.LOGGER.info("Spawn position {}", spawnPos);
    level.setDefaultSpawnPos(spawnPos, 0.0F);
    level.getGameRules().getRule(GameRules.RULE_SPAWN_RADIUS).set(0, level.getServer());
  }
}
