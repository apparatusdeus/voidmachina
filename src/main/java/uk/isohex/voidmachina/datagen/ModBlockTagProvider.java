package uk.isohex.voidmachina.datagen;

import java.util.concurrent.CompletableFuture;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import uk.isohex.voidmachina.core.Common;
import uk.isohex.voidmachina.registry.BlockRegistry;

public class ModBlockTagProvider extends BlockTagsProvider {

  public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
      @Nullable ExistingFileHelper existingFileHelper) {
    super(output, lookupProvider, Common.MODID, existingFileHelper);
  }

  @Override
  protected void addTags(@Nonnull HolderLookup.Provider provider) {
    tag(BlockTags.MINEABLE_WITH_PICKAXE)
        .add(BlockRegistry.VOID_STEEL_ORE.get())
        .add(BlockRegistry.RAW_VOID_STEEL_BLOCK.get())
        .add(BlockRegistry.VOID_STEEL_BLOCK.get());

    tag(BlockTags.NEEDS_DIAMOND_TOOL)
        .add(BlockRegistry.VOID_STEEL_ORE.get())
        .add(BlockRegistry.RAW_VOID_STEEL_BLOCK.get())
        .add(BlockRegistry.VOID_STEEL_BLOCK.get());
  }

}
