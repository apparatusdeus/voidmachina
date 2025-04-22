package uk.isohex.voidmachina.registry;

import java.util.function.Supplier;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import uk.isohex.voidmachina.VoidMachina;

public class BlockRegistry {
  public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
      VoidMachina.MODID);

  public static final RegistryObject<Block> VOID_NODE = registerBlock(
      "void_node",
      () -> new Block(BlockBehaviour.Properties.of()));

  public static final RegistryObject<Block> VOID_STEEL_ORE = registerBlock("void_steel_ore",
      () -> new Block(BlockBehaviour.Properties.of()
          .mapColor(MapColor.STONE)
          .strength(3.5f)
          .requiresCorrectToolForDrops()
          .destroyTime(3.0f) // Higher value means harder to break
          .explosionResistance(3.0f)
          .instrument(NoteBlockInstrument.BASEDRUM) // Optional: for noteblock sound
          .sound(SoundType.STONE))); // Optional: for block sounds

  public static final RegistryObject<Block> RAW_VOID_STEEL_BLOCK = registerBlock("raw_void_steel_block",
      () -> new Block(BlockBehaviour.Properties.of()
          .mapColor(MapColor.STONE)
          .strength(3.5f)
          .requiresCorrectToolForDrops()
          .destroyTime(3.0f) // Higher value means harder to break
          .explosionResistance(3.0f)
          .instrument(NoteBlockInstrument.BASEDRUM) // Optional: for noteblock sound
          .sound(SoundType.STONE))); // Optional: for block sounds

  public static final RegistryObject<Block> VOID_STEEL_BLOCK = registerBlock("void_steel_block",
      () -> new Block(BlockBehaviour.Properties.of()
          .mapColor(MapColor.METAL)
          .strength(5.0f)
          .requiresCorrectToolForDrops()
          .destroyTime(5.0f) // Higher value means harder to break
          .explosionResistance(5.0f)
          .instrument(NoteBlockInstrument.BASEDRUM) // Optional: for noteblock sound
          .sound(SoundType.METAL))); // Optional: for block sounds

  // public static final RegistryObject<Block> VOID_ENERGY_EXTRACTOR =
  // BLOCKS.register(
  // "void_energy_extractor",
  // () -> new Block(
  // BlockBehaviour.Properties.of(Material.METAL).strength(3.5f).requiresCorrectToolForDrops()));

  public static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> blockSupplier) {
    RegistryObject<T> block = BLOCKS.register(name, blockSupplier);
    ItemRegistry.registerBlockItem(name, block);
    return block;
  }

  public static final void register(IEventBus eventBus) {
    BLOCKS.register(eventBus);
  }
}
