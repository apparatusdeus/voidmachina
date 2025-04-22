// package uk.isohex.voidmachina.block;

// import javax.annotation.Nonnull;
// import javax.annotation.Nullable;

// import net.minecraft.core.BlockPos;
// import net.minecraft.world.level.BlockGetter;
// import net.minecraft.world.level.Level;
// import net.minecraft.world.level.block.BaseEntityBlock;
// import net.minecraft.world.level.block.Block;
// import net.minecraft.world.level.block.EntityBlock;
// import net.minecraft.world.level.block.state.BlockState;
// import net.minecraft.world.level.block.state.properties.BlockStateProperties;
// import net.minecraft.world.level.block.state.BlockBehaviour;
// import net.minecraft.world.level.block.entity.BlockEntity;
// import net.minecraft.world.level.block.RenderShape;
// import net.minecraft.world.level.block.state.StateDefinition;
// import net.minecraft.world.level.block.state.properties.BooleanProperty;
// import net.minecraft.world.entity.player.Player;
// import net.minecraft.world.InteractionHand;
// import net.minecraft.world.InteractionResult;
// import net.minecraft.world.phys.BlockHitResult;
// import net.minecraft.world.MenuProvider;
// import net.minecraft.server.level.ServerPlayer;
// import net.minecraft.network.chat.Component;

// public class VoidEnergyExtractorBlock extends BaseEntityBlock {
// public VoidEnergyExtractorBlock(Properties properties) {
// super(properties);
// }

// @Override
// public RenderShape getRenderShape(@Nonnull BlockState state) {
// return RenderShape.MODEL;
// }

// @Nullable
// @Override
// public BlockEntity newBlockEntity(@Nonnull BlockPos pos, @Nonnull BlockState
// state) {
// return new VoidEnergyExtractorBlockEntity(pos, state);
// }
// }
