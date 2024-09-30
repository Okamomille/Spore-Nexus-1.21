package net.okamiz.sporenexus.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TotemBlock extends Block {
    protected static final VoxelShape SHAPE = Block.box(5.0, 0.0, 5.0, 11.0, 16.0, 11.0);
    private double effectRadius = 5.0;
    private final Set<Player> playersInRadius = new HashSet<>();
    private Holder<MobEffect> mobEffect;
    private ParticleOptions particles;
    public TotemBlock(Properties properties, Holder<MobEffect> mobEffect, ParticleOptions particles) {
        super(properties);
        this.mobEffect = mobEffect;
        this.particles = particles;
    }
    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        // Get the center position of the block
        Vec3 blockCenter = Vec3.atCenterOf(pos);
        // Get all players within the radius
        List<Player> players = level.getEntitiesOfClass(Player.class,
                new AABB(blockCenter.subtract(effectRadius, effectRadius, effectRadius),
                        blockCenter.add(effectRadius, effectRadius, effectRadius)));

        // Check for players who have entered the radius
        for (Player player : players) {
            if (!playersInRadius.contains(player)) {
                // Player has entered the radius
                playersInRadius.add(player);
                // Apply regeneration effect when they enter
                player.addEffect(new MobEffectInstance(mobEffect, 100, 0, true, true));
            } else {
                // Player is still within the radius, refresh the effect
                player.addEffect(new MobEffectInstance(mobEffect, 100, 0, true, true));
            }
        }
        // Check for players who have left the radius
        playersInRadius.removeIf(player -> !players.contains(player));

        level.scheduleTick(pos, this, 20);
        super.tick(state, level, pos, random);
    }


    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        for (int i = 0; i < 5; i++) {  // Spawn 10 particles per tick, adjust as needed
            double offsetX = random.nextDouble() * 2 * effectRadius - effectRadius;
            double offsetZ = random.nextDouble() * 2 * effectRadius - effectRadius;

            // Spawn particles around the block within the radius
            level.addParticle(particles, // You can change the particle type here
                    pos.getX() + offsetX,
                    pos.getY() + random.nextDouble() * 2, // Randomize the Y position a little
                    pos.getZ() + offsetZ,
                    0, 0.1, 0); // Motion of particles (set to almost still)
        }
        super.animateTick(state, level, pos, random);
    }

    @Override
    public void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean isMoving) {
        if (!level.isClientSide) {
            // Schedule a tick for the block every second (20 ticks)
            level.scheduleTick(pos, this, 20);
        }
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable("tooltip.sporenexus.totems"));
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
