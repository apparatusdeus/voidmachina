package uk.isohex.voidmachina.api.energy;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public class VoidEnergyRegistry {

  private static final Map<ResourceLocation, Integer> itemVoidEnergyValues = new HashMap<>();
  private static final Map<ResourceLocation, Integer> tagVoidEnergyValues = new HashMap<>();
  private static final int DEFAULT_VE_VALUE = 0;

  // Query VE value for a given stack
  public static int getVoidEnergy(ItemStack stack) {
    // Item item = stack.getItem();
    // int itemId = Item.getId(item);

    // if (itemId == null) {
    // return DEFAULT_VE_VALUE;
    // }

    // // Check item-specific override
    // if (itemVoidEnergyValues.containsKey(itemId)) {
    // return itemVoidEnergyValues.get(itemId);
    // }

    // Future: Check tags here (for now we ignore them)
    return DEFAULT_VE_VALUE;
  }

  // Register a VoidEnergy value override for a speific item
  public static void registerItemVoidEnergy(ResourceLocation itemId, int value) {
    itemVoidEnergyValues.put(itemId, value);
  }

  // Placeholder for tag support
  public static void registerTagVoidEnergy(ResourceLocation tagId, int value) {
    tagVoidEnergyValues.put(tagId, value);
  }

  public static void clear() {
    itemVoidEnergyValues.clear();
    tagVoidEnergyValues.clear();
  }

}
