package uk.isohex.voidmachina.data;

import java.util.Map;

import javax.annotation.Nonnull;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimpleJsonResourceReloadListener;
import net.minecraft.util.GsonHelper;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraftforge.event.AddReloadListenerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import uk.isohex.voidmachina.VoidMachina;
import uk.isohex.voidmachina.api.energy.VoidEnergyRegistry;

@Mod.EventBusSubscriber(modid = VoidMachina.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class VoidEnergyValueLoader extends SimpleJsonResourceReloadListener {
  private static final String DIRECTORY = "voidenergy_values";

  public VoidEnergyValueLoader() {
    super(VoidMachina.GSON, DIRECTORY);
  }

  @Override
  protected void apply(@Nonnull Map<ResourceLocation, JsonElement> data, @Nonnull ResourceManager manager,
      @Nonnull ProfilerFiller profiler) {
    VoidEnergyRegistry.clear();

    data.entrySet().forEach(entry -> {
      JsonObject json = GsonHelper.convertToJsonObject(entry.getValue(), "voidenergy_values");

      if (json.has("items")) {
        JsonObject items = json.getAsJsonObject("items");
        items.entrySet().forEach(itemEntry -> {
          try {
            ResourceLocation itemId = ResourceLocation.parse(itemEntry.getKey());
            int value = itemEntry.getValue().getAsInt();
            VoidEnergyRegistry.registerItemVoidEnergy(itemId, value);
          } catch (Exception e) {
            VoidMachina.LOGGER.error("Failed to load VoidEnergy value for item {}", itemEntry.getKey(), e);
          }
        });
      }

      if (json.has("tags")) {
        JsonObject items = json.getAsJsonObject("tags");
        items.entrySet().forEach(itemEntry -> {
          try {
            ResourceLocation itemId = ResourceLocation.parse(itemEntry.getKey());
            int value = itemEntry.getValue().getAsInt();
            VoidEnergyRegistry.registerItemVoidEnergy(itemId, value);
          } catch (Exception e) {
            VoidMachina.LOGGER.error("Failed to load VoidEnergy value for tag {}", itemEntry.getKey(), e);
          }
        });
      }
    });
  }

  @SubscribeEvent
  public static void onAddReloadListeners(AddReloadListenerEvent event) {
    event.addListener(new VoidEnergyValueLoader());
  }
}