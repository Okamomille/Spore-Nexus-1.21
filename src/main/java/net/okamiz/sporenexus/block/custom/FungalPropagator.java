package net.okamiz.sporenexus.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;

public class FungalPropagator extends Block {
    public FungalPropagator(Properties properties) {
        super(properties);
    }



    @Override
    protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {

        if(!level.isClientSide()){
            for (int i = -1; i < 1; i++) {
                for (int j = -1; j < 1; j++) {
                    if(level.getBlockState(pos.offset(i, 0, j)).is(Blocks.DIRT))
                    {
                        level.setBlock(pos.offset(i, 0, j), Blocks.MYCELIUM.defaultBlockState(), 2);
                    }
                }
            }
        }
        super.randomTick(state, level, pos, random);
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos blockPos, RandomSource random) {
        int blockPosX = blockPos.getX();
        int blockPosY = blockPos.getY();
        int blockPosZ = blockPos.getZ();
        BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

        for (int l = 0; l < 14; l++) {
            blockpos$mutableblockpos.set(blockPosX + Mth.nextInt(random, -1, 1),
                    blockPosY, blockPosZ + Mth.nextInt(random, -1, 1));
            BlockState blockstate = level.getBlockState(blockpos$mutableblockpos);
            if (!blockstate.isCollisionShapeFullBlock(level, blockpos$mutableblockpos)) {
                level.addParticle(
                        ParticleTypes.MYCELIUM,
                        (double)blockpos$mutableblockpos.getX() + random.nextDouble(),
                        (double)blockpos$mutableblockpos.getY() + random.nextDouble(),
                        (double)blockpos$mutableblockpos.getZ() + random.nextDouble(),
                        0.00,
                        0.1,
                        0.00
                );
            }
        }
    }


    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable("tooltip.sporenexus.spore_spreader"));
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
