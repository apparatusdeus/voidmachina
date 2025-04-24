package uk.isohex.voidmachina.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import uk.isohex.voidmachina.VoidMachina;

public class CreativeTabRegistry {
  public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister
      .create(Registries.CREATIVE_MODE_TAB, VoidMachina.MODID);

  public static final DeferredHolder<CreativeModeTab, CreativeModeTab> VOID_MACHINA_TAB = TABS.register(
      "void_machina",
      () -> CreativeModeTab.builder()
          .title(Component.translatable("creative_tab.void_machina"))
          .icon(() -> new ItemStack(ItemRegistry.VOID_CRYSTAL.get()))
          .displayItems((parameters, output) -> {
            output.accept(ItemRegistry.VOID_CRYSTAL.get());
            output.accept(ItemRegistry.CRACKED_VOID_CRYSTAL.get());
            output.accept(BlockRegistry.VOID_NODE.get());

            output.accept(BlockRegistry.VOID_STEEL_ORE.get());
            output.accept(BlockRegistry.VOID_STEEL_BLOCK.get());

            output.accept(ItemRegistry.VOID_STEEL_NUGGET.get());
            output.accept(ItemRegistry.VOID_STEEL_INGOT.get());
            output.accept(ItemRegistry.VOID_STEEL_PLATE.get());

            output.accept(ItemRegistry.RAW_VOID_STEEL.get());
            output.accept(BlockRegistry.RAW_VOID_STEEL_BLOCK.get());
          })
          .build());

  public static void register(IEventBus eventBus) {
    TABS.register(eventBus);
  }
}
