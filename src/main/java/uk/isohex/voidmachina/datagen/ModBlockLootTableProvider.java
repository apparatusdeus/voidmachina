package uk.isohex.voidmachina.datagen;

import java.util.Set;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import uk.isohex.voidmachina.registry.BlockRegistry;
import uk.isohex.voidmachina.registry.ItemRegistry;

public class ModBlockLootTableProvider extends BlockLootSubProvider {

  protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
    super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
  }

  @Override
  protected void generate() {
    dropSelf(BlockRegistry.VOID_STEEL_BLOCK.get());
    dropSelf(BlockRegistry.RAW_VOID_STEEL_BLOCK.get());

    add(BlockRegistry.VOID_STEEL_ORE.get(),
        block -> createOreDrop(BlockRegistry.VOID_STEEL_ORE.get(), ItemRegistry.RAW_VOID_STEEL.get()));
  }

  /**
   * Creates a loot table builder for ore drops with fortune enchantment applied.
   *
   * @param block    The block being dropped from.
   * @param item     The item being dropped.
   * @param minDrops The minimum number of items dropped.
   * @param maxDrops The maximum number of items dropped.
   * @return The loot table builder.
   */
  protected LootTable.Builder createMultipleOreDrops(Block block, Item item, float minDrops, float maxDrops) {
    HolderLookup.RegistryLookup<Enchantment> registryLookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
    return this.createSilkTouchDispatchTable(block,
        this.applyExplosionDecay(item, LootItem.lootTableItem(item))
            .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
            .apply(ApplyBonusCount.addOreBonusCount(registryLookup.getOrThrow(Enchantments.FORTUNE))));
  }

  @Override
  protected Iterable<Block> getKnownBlocks() {
    return BlockRegistry.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
  }
}
