package uk.isohex.voidmachina.event;

import net.minecraft.server.level.ServerLevel;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.EventBusSubscriber.Bus;
import net.neoforged.neoforge.event.server.ServerStartedEvent;
import uk.isohex.voidmachina.core.Common;
import uk.isohex.voidmachina.worldgen.SpawnPlacementSavedData;
import uk.isohex.voidmachina.worldgen.SpawnStructurePlacer;

@EventBusSubscriber(modid = Common.MODID, bus = Bus.GAME)
public class ModServerStartedEvent {

  @SubscribeEvent
  public static void onServerStarted(ServerStartedEvent event) {
    ServerLevel overworld = event.getServer().overworld();

    if (overworld == null)
      return;

    var spawnData = SpawnPlacementSavedData.get(overworld);

    // if (!spawnData.isPlaced()) {
    Common.LOGGER.info("Placing spawn structure...");
    SpawnStructurePlacer.placeSpawnStructure(overworld);
    spawnData.markPlaced();
    spawnData.setDirty();
    // }
  }
}
