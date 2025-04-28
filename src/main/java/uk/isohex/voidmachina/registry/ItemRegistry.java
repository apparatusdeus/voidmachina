package uk.isohex.voidmachina.registry;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import uk.isohex.voidmachina.core.Common;

public class ItemRegistry {
  public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Common.MODID);

  public static final DeferredItem<Item> VOID_CRYSTAL = ITEMS.registerSimpleItem("void_crystal");

  public static final DeferredItem<Item> CRACKED_VOID_CRYSTAL = ITEMS.registerSimpleItem("cracked_void_crystal");

  public static final DeferredItem<Item> RAW_VOID_STEEL = ITEMS.registerSimpleItem("raw_void_steel");

  public static final DeferredItem<Item> VOID_STEEL_NUGGET = ITEMS.registerSimpleItem("void_steel_nugget");

  public static final DeferredItem<Item> VOID_STEEL_INGOT = ITEMS.registerSimpleItem("void_steel_ingot");

  public static final DeferredItem<Item> VOID_STEEL_PLATE = ITEMS.registerSimpleItem("void_steel_plate");

  public static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
    ITEMS.registerSimpleBlockItem(name, block);
  }

  public static final void register(IEventBus eventBus) {
    ITEMS.register(eventBus);
  }
}
