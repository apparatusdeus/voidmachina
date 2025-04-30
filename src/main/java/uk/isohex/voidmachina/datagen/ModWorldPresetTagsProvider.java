package uk.isohex.voidmachina.datagen;

import java.util.concurrent.CompletableFuture;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.WorldPresetTags;
import net.minecraft.world.level.levelgen.presets.WorldPreset;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import uk.isohex.voidmachina.core.Common;
import uk.isohex.voidmachina.registry.WorldPresetRegistry;

public class ModWorldPresetTagsProvider extends TagsProvider<WorldPreset> {
  public ModWorldPresetTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider,
      @Nullable ExistingFileHelper existingFileHelper) {
    super(output, Registries.WORLD_PRESET, provider, Common.MODID, existingFileHelper);
  }

  protected void addTags(@Nonnull HolderLookup.Provider provider) {
    this.tag(WorldPresetTags.NORMAL)
        .add(WorldPresetRegistry.VOID);
  }
}
