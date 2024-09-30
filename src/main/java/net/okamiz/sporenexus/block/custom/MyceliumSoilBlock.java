package net.okamiz.sporenexus.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class MyceliumSoilBlock extends Block {
    public MyceliumSoilBlock(Properties properties) {
        super(properties);
    }


    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        super.animateTick(state, level, pos, random);
        if (random.nextInt(10) == 0) {
            level.addParticle(
                    ParticleTypes.MYCELIUM,
                    (double)pos.getX() + random.nextDouble(),
                    (double)pos.getY() + 1.1,
                    (double)pos.getZ() + random.nextDouble(),
                    0.0,
                    0.0,
                    0.0
            );
        }
    }
}
