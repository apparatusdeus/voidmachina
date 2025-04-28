package uk.isohex.voidmachina.datagen;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import uk.isohex.voidmachina.core.Common;
import uk.isohex.voidmachina.registry.ItemRegistry;

public class ModItemModelProvider extends ItemModelProvider {

  public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
    super(output, Common.MODID, existingFileHelper);
  }

  @Override
  protected void registerModels() {
    basicItem(ItemRegistry.CRACKED_VOID_CRYSTAL.get());
    basicItem(ItemRegistry.VOID_CRYSTAL.get());
    basicItem(ItemRegistry.RAW_VOID_STEEL.get());
    basicItem(ItemRegistry.VOID_STEEL_NUGGET.get());
    basicItem(ItemRegistry.VOID_STEEL_INGOT.get());
    basicItem(ItemRegistry.VOID_STEEL_PLATE.get());
  }

}
