package uk.isohex.voidmachina.datagen;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.data.loot.LootTableProvider.SubProviderEntry;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.EventBusSubscriber.Bus;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import uk.isohex.voidmachina.core.Common;

@EventBusSubscriber(modid = Common.MODID, bus = Bus.MOD)
public class DataGenerators {

  @SubscribeEvent
  public static void gatherData(GatherDataEvent event) {
    DataGenerator generator = event.getGenerator();
    PackOutput packOutput = generator.getPackOutput();
    ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
    CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

    SubProviderEntry subProviderEntry = new LootTableProvider.SubProviderEntry(
        ModBlockLootTableProvider::new,
        LootContextParamSets.BLOCK);

    generator.addProvider(
        event.includeServer(),
        new LootTableProvider(packOutput, Collections.emptySet(), List.of(subProviderEntry),
            lookupProvider));

    generator.addProvider(event.includeServer(), new ModRecipeProvider(packOutput, lookupProvider));

    BlockTagsProvider blockTagsProvider = new ModBlockTagProvider(packOutput, lookupProvider,
        existingFileHelper);

    generator.addProvider(
        event.includeServer(),
        blockTagsProvider);

    generator.addProvider(
        event.includeServer(),
        new ModItemTagProvider(packOutput, lookupProvider, blockTagsProvider.contentsGetter(),
            existingFileHelper));

    generator.addProvider(
        event.includeClient(),
        new ModItemModelProvider(packOutput, existingFileHelper));

    generator.addProvider(
        event.includeClient(),
        new ModBlockStateProvider(packOutput, existingFileHelper));

    generator.addProvider(
        event.includeServer(),
        new ModWorldPresetTagsProvider(packOutput, lookupProvider, existingFileHelper));

    RegistrySetBuilder builder = new RegistrySetBuilder()
        .add(Registries.BIOME, ModBiomeProvider::bootstrap)
        .add(Registries.DIMENSION_TYPE, ModDimensionTypeProvider::bootstrap)
        .add(Registries.LEVEL_STEM, ModDimensionProvider::bootstrap)
        .add(Registries.WORLD_PRESET, ModWorldPresetProvider::bootstrap);

    generator.addProvider(
        event.includeServer(),
        new DatapackBuiltinEntriesProvider(packOutput, lookupProvider, builder,
            Set.of(Common.MODID)));
  }
}
