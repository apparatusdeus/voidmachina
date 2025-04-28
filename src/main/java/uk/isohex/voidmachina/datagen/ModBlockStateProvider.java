package uk.isohex.voidmachina.datagen;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import uk.isohex.voidmachina.core.Common;
import uk.isohex.voidmachina.registry.BlockRegistry;

public class ModBlockStateProvider extends BlockStateProvider {

  public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
    super(output, Common.MODID, exFileHelper);
  }

  @Override
  protected void registerStatesAndModels() {
    blockWithItem(BlockRegistry.VOID_NODE);

    blockWithItem(BlockRegistry.RAW_VOID_STEEL_BLOCK);
    blockWithItem(BlockRegistry.VOID_STEEL_BLOCK);
    blockWithItem(BlockRegistry.VOID_STEEL_ORE);
  }

  private void blockWithItem(DeferredBlock<?> deferredBlock) {
    simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
  }
}
