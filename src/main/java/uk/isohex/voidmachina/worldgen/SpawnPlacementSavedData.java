package uk.isohex.voidmachina.worldgen;

import javax.annotation.Nonnull;

import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.saveddata.SavedData;
import net.minecraft.server.level.ServerLevel;

public class SpawnPlacementSavedData extends SavedData {
  private static final String KEY = "voidmachina_spawn_placed";

  private boolean placed;

  private SpawnPlacementSavedData() {
    this.placed = false;
  }

  public static SpawnPlacementSavedData create() {
    return new SpawnPlacementSavedData();
  }

  public static SpawnPlacementSavedData get(ServerLevel level) {
    return level.getDataStorage()
        .computeIfAbsent(new Factory<>(
            SpawnPlacementSavedData::create,
            SpawnPlacementSavedData::load),
            KEY);
  }

  public static SpawnPlacementSavedData load(CompoundTag tag, HolderLookup.Provider lookupProvider) {
    SpawnPlacementSavedData data = SpawnPlacementSavedData.create();
    data.placed = tag.getBoolean("Placed");
    return data;
  }

  @Override
  public CompoundTag save(@Nonnull CompoundTag tag, @Nonnull HolderLookup.Provider registries) {
    tag.putBoolean("Placed", placed);
    return tag;
  }

  public boolean isPlaced() {
    return placed;
  }

  public void markPlaced() {
    this.placed = true;
    setDirty();
  }
}
