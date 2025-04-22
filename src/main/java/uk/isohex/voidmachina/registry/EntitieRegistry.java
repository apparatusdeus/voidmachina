package uk.isohex.voidmachina.registry;

//import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
//import net.minecraftforge.registries.RegistryObject;
import uk.isohex.voidmachina.VoidMachina;

public class EntitieRegistry {
  public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister
      .create(ForgeRegistries.BLOCK_ENTITY_TYPES, VoidMachina.MODID);

  // public static final RegistryObject<BlockEntityType</*
  // VoidEnergyExtractorBlockEntity */ BlockEntity>> VOID_ENERGY_EXTRACTOR_ENTITY
  // = BLOCK_ENTITIES
  // .register("void_energy_extractor",
  // () -> BlockEntityType.Builder.of(
  // /* VoidEnergyExtractorBlockEntity::new */ BlockEntity::new,
  // BlockRegistry.VOID_ENERGY_EXTRACTOR.get()).build(null));

  public static void register(IEventBus eventBus) {
    BLOCK_ENTITIES.register(eventBus);
  }
}
