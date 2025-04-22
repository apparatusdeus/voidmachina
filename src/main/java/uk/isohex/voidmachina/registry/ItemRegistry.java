package uk.isohex.voidmachina.registry;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import uk.isohex.voidmachina.VoidMachina;

public class ItemRegistry {
  public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, VoidMachina.MODID);

  public static final RegistryObject<Item> VOID_CRYSTAL = ITEMS.register("void_crystal",
      () -> new Item(new Item.Properties()));

  public static final RegistryObject<Item> CRACKED_VOID_CRYSTAL = ITEMS.register("cracked_void_crystal",
      () -> new Item(new Item.Properties()));

  public static final RegistryObject<Item> RAW_VOID_STEEL = ITEMS.register("raw_void_steel",
      () -> new Item(new Item.Properties()));

  public static final RegistryObject<Item> VOID_STEEL_NUGGET = ITEMS.register("void_steel_nugget",
      () -> new Item(new Item.Properties()));

  public static final RegistryObject<Item> VOID_STEEL_INGOT = ITEMS.register("void_steel_ingot",
      () -> new Item(new Item.Properties()));

  public static final RegistryObject<Item> VOID_STEEL_PLATE = ITEMS.register("void_steel_plate",
      () -> new Item(new Item.Properties()));

  // public static final RegistryObject<Item> VOID_ENERGY_EXTRACTOR_ITEM =
  // ITEMS.register(
  // "void_energy_extractor",
  // () -> new BlockItem(BlockRegistry.VOID_ENERGY_EXTRACTOR.get(), new
  // Item.Properties()));

  public static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
    ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
  }

  public static final void register(IEventBus eventBus) {
    ITEMS.register(eventBus);
  }
}
