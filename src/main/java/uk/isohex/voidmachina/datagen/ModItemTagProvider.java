package uk.isohex.voidmachina.datagen;

import java.util.concurrent.CompletableFuture;

import javax.annotation.Nonnull;

import org.jetbrains.annotations.Nullable;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import uk.isohex.voidmachina.core.Common;

public class ModItemTagProvider extends ItemTagsProvider {

  public ModItemTagProvider(PackOutput output, CompletableFuture<Provider> lookupProvider,
      CompletableFuture<TagLookup<Block>> blockTags,
      @Nullable ExistingFileHelper existingFileHelper) {
    super(output, lookupProvider, blockTags, Common.MODID, existingFileHelper);
  }

  @Override
  protected void addTags(@Nonnull Provider provider) {
    // Add tags here!
  }

}
