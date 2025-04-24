package uk.isohex.voidmachina.worldgen;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Random;

public class ShardTestSpawner {

  public static void generateTestShard(ServerLevel level, BlockPos playerPos) {
    final int buildMin = -64;
    final int buildMax = 320;
    final int totalBuildHeight = buildMax - buildMin;
    final int shardHeight = Mth.floor(totalBuildHeight * (0.80 + Math.random() * 0.10)); // 80–90%
    final int rhombusHeight = shardHeight / 2 - 12; // leave space for a 24-block sphere
    final int sphereRadius = 12;
    final int radius = 22;

    Random rand = new Random();

    // Calculate center of the current chunk the player is in, with ±5 block
    // variation
    int chunkX = (playerPos.getX() >> 4) << 4;
    int chunkZ = (playerPos.getZ() >> 4) << 4;

    int offsetX = chunkX + 8 + rand.nextInt(11) - 5;
    int offsetZ = chunkZ + 8 + rand.nextInt(11) - 5;
    int offsetY = buildMin + shardHeight / 2 + rand.nextInt(11) - 5;

    BlockPos center = new BlockPos(offsetX, offsetY, offsetZ);

    BlockState core = Blocks.STONE.defaultBlockState();
    BlockState terrain = Blocks.GRASS_BLOCK.defaultBlockState();

    // Bottom rhombus
    for (int y = 0; y < rhombusHeight; y++) {
      double progress = 1.0 - ((double) y / rhombusHeight);
      int r = (int) (radius * progress);
      fillCircle(level, center.offset(0, y - rhombusHeight, 0), r, terrain);
    }

    // Sphere
    for (int y = -sphereRadius; y <= sphereRadius; y++) {
      double yRatio = y / (double) sphereRadius;
      int r = (int) (Math.sqrt(1 - yRatio * yRatio) * sphereRadius);
      fillCircle(level, center.offset(0, y, 0), r, core);
    }

    // Top rhombus
    for (int y = 1; y <= rhombusHeight; y++) {
      double progress = 1.0 - ((double) y / rhombusHeight);
      int r = (int) (radius * progress);
      fillCircle(level, center.offset(0, y + sphereRadius, 0), r, terrain);
    }
  }

  private static void fillCircle(ServerLevel level, BlockPos center, int radius, BlockState state) {
    for (int x = -radius; x <= radius; x++) {
      for (int z = -radius; z <= radius; z++) {
        if (x * x + z * z <= radius * radius) {
          level.setBlock(center.offset(x, 0, z), state, 2);
        }
      }
    }
  }
}
