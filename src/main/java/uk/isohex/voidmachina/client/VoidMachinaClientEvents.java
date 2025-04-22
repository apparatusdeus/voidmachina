package uk.isohex.voidmachina.client;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import uk.isohex.voidmachina.VoidMachina;
import uk.isohex.voidmachina.api.energy.VoidEnergyRegistry;

@Mod.EventBusSubscriber(modid = VoidMachina.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class VoidMachinaClientEvents {

  @SubscribeEvent
  public static void onItemTooltip(ItemTooltipEvent event) {
    ItemStack stack = event.getItemStack();
    int value = VoidEnergyRegistry.getVoidEnergy(stack);

    if (value > 0) {
      Component tooltip = Component.literal("Void Energy: " + value)
          .withStyle(ChatFormatting.DARK_PURPLE);
      event.getToolTip().add(tooltip);
    }
  }
}
