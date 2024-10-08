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
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;

public class SporeSpreader extends Block {
    public SporeSpreader(Properties properties) {
        super(properties);
    }




    @Override
    public void animateTick(BlockState state, Level level, BlockPos blockPos, RandomSource random) {
        int blockPosX = blockPos.getX();
        int blockPosY = blockPos.getY();
        int blockPosZ = blockPos.getZ();
        BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

        for (int l = 0; l < 14; l++) {
            blockpos$mutableblockpos.set(blockPosX + Mth.nextInt(random, -3, 3),
                    blockPosY, blockPosZ + Mth.nextInt(random, -3, 3));
            BlockState blockstate = level.getBlockState(blockpos$mutableblockpos);
            if (!blockstate.isCollisionShapeFullBlock(level, blockpos$mutableblockpos)) {
                level.addParticle(
                        ParticleTypes.MYCELIUM,
                        (double)blockpos$mutableblockpos.getX() + random.nextDouble(),
                        (double)blockpos$mutableblockpos.getY() + random.nextDouble(),
                        (double)blockpos$mutableblockpos.getZ() + random.nextDouble(),
                        0.01,
                        0.01,
                        0.01
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
