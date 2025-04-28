package uk.isohex.voidmachina;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import uk.isohex.voidmachina.core.Common;
import uk.isohex.voidmachina.registry.BiomeRegistry;
import uk.isohex.voidmachina.registry.BlockRegistry;
import uk.isohex.voidmachina.registry.ChunkGeneratorRegistery;
import uk.isohex.voidmachina.registry.CreativeTabRegistry;
import uk.isohex.voidmachina.registry.ItemRegistry;

@Mod(Common.MODID)
public class VoidMachina {

  public VoidMachina(IEventBus modEventBus, ModContainer modContainer) {
    BiomeRegistry.register(modEventBus);
    ChunkGeneratorRegistery.register(modEventBus);
    BlockRegistry.register(modEventBus);
    ItemRegistry.register(modEventBus);
    CreativeTabRegistry.register(modEventBus);

    modEventBus.addListener(this::commonSetup);

    // Register our mod's ForgeConfigSpec so that Forge can create and load the
    // config file for us
    modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
  }

  private void commonSetup(final FMLCommonSetupEvent event) {
    // Some common setup code
    Common.LOGGER.info("HELLO FROM COMMON SETUP");

    if (Config.logDirtBlock)
      Common.LOGGER.info("DIRT BLOCK >> {}", BuiltInRegistries.BLOCK.getKey(Blocks.DIRT));

    Common.LOGGER.info(Config.magicNumberIntroduction + Config.magicNumber);
  }
}
