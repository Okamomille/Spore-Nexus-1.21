package net.okamiz.sporenexus.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.okamiz.sporenexus.block.entity.SNBlockEntities;
import net.okamiz.sporenexus.block.entity.custom.MushroomCollectorBlockEntity;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class MushroomCollectorBlock extends BaseEntityBlock {
    public static final MapCodec<MushroomCollectorBlock> CODEC = simpleCodec(MushroomCollectorBlock::new);
    public MushroomCollectorBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new MushroomCollectorBlockEntity(pos, state);
    }

    @Override
    protected RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    protected void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean movedByPiston) {
        if(state.getBlock() != newState.getBlock()){
            if(level.getBlockEntity(pos) instanceof MushroomCollectorBlockEntity mushroomCollectorBlockEntity){
                mushroomCollectorBlockEntity.dropContent();
                level.updateNeighbourForOutputSignal(pos, this);
            }
        }

        super.onRemove(state, level, pos, newState, movedByPiston);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if(level.getBlockEntity(pos) instanceof MushroomCollectorBlockEntity mushroomCollectorBlockEntity){
            if (level.isClientSide) {
                return InteractionResult.SUCCESS;
            } else {
                ((ServerPlayer) player).openMenu(new SimpleMenuProvider(mushroomCollectorBlockEntity, Component.literal("Mushroom Collector")), pos);
                return InteractionResult.CONSUME;
            }
        }
            return InteractionResult.CONSUME;

    }

    @Override
    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        return level.isClientSide ? null : createTickerHelper(type, SNBlockEntities.MUSHROOM_COLLECTOR_BE.get(), MushroomCollectorBlockEntity::tick);
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable("tooltip.sporenexus.mushroom_collector_line1"));
        tooltipComponents.add(Component.translatable("tooltip.sporenexus.mushroom_collector_line2"));
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
