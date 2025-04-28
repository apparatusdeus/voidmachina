package uk.isohex.voidmachina.event;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.EventBusSubscriber.Bus;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;
import uk.isohex.voidmachina.api.energy.VoidEnergyRegistry;
import uk.isohex.voidmachina.core.Common;

@EventBusSubscriber(modid = Common.MODID, value = Dist.CLIENT, bus = Bus.GAME)
public class ModItemTooltipEvent {

  @SubscribeEvent
  public static void onItemTooltip(ItemTooltipEvent event) {
    ItemStack stack = event.getItemStack();
    int value = VoidEnergyRegistry.getVoidEnergy(stack);

    if (value > 0) {
      Component tooltip = Component
          .literal("Void Energy: " + value)
          .withStyle(ChatFormatting.DARK_PURPLE);
      event.getToolTip().add(tooltip);
    }
  }
}
