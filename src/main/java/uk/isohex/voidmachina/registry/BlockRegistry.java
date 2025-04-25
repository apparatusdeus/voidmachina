package uk.isohex.voidmachina.registry;

import java.util.function.Supplier;

import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import uk.isohex.voidmachina.VoidMachina;

public class BlockRegistry {
        public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(VoidMachina.MODID);

        public static final DeferredBlock<Block> VOID_NODE = registerBlock(
                        "void_node",
                        () -> new Block(BlockBehaviour.Properties.of()));

        public static final DeferredBlock<Block> VOID_STEEL_ORE = registerBlock(
                        "void_steel_ore",
                        () -> new Block(BlockBehaviour.Properties.of()
                                        .mapColor(MapColor.STONE)
                                        .strength(3.5f)
                                        .requiresCorrectToolForDrops()
                                        .destroyTime(3.0f) // Higher value means harder to break
                                        .explosionResistance(3.0f)
                                        .instrument(NoteBlockInstrument.BASEDRUM) // Optional: for noteblock sound
                                        .sound(SoundType.STONE)));

        public static final DeferredBlock<Block> RAW_VOID_STEEL_BLOCK = registerBlock(
                        "raw_void_steel_block",
                        () -> new Block(BlockBehaviour.Properties.of()
                                        .mapColor(MapColor.STONE)
                                        .strength(3.5f)
                                        .requiresCorrectToolForDrops()
                                        .destroyTime(3.0f) // Higher value means harder to break
                                        .explosionResistance(3.0f)
                                        .instrument(NoteBlockInstrument.BASEDRUM) // Optional: for noteblock sound
                                        .sound(SoundType.STONE)));

        public static final DeferredBlock<Block> VOID_STEEL_BLOCK = registerBlock(
                        "void_steel_block",
                        () -> new Block(BlockBehaviour.Properties.of()
                                        .mapColor(MapColor.METAL)
                                        .strength(5.0f)
                                        .requiresCorrectToolForDrops()
                                        .destroyTime(5.0f) // Higher value means harder to break
                                        .explosionResistance(5.0f)
                                        .instrument(NoteBlockInstrument.BASEDRUM) // Optional: for noteblock sound
                                        .sound(SoundType.METAL)));

        public static <B extends Block> DeferredBlock<B> registerBlock(String name, Supplier<B> blockSupplier) {
                DeferredBlock<B> blockDeferred = BLOCKS.register(name, blockSupplier);
                ItemRegistry.registerBlockItem(name, blockDeferred);
                return blockDeferred;
        }

        public static final void register(IEventBus eventBus) {
                BLOCKS.register(eventBus);
        }
}
