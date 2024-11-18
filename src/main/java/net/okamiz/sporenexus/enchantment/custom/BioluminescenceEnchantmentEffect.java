package net.okamiz.sporenexus.enchantment.custom;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.EnchantedItemInUse;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

public record BioluminescenceEnchantmentEffect(int level) implements EnchantmentEntityEffect {
    public static MapCodec<BioluminescenceEnchantmentEffect> CODEC = RecordCodecBuilder.mapCodec(instance ->
            instance.group(Codec.INT.fieldOf("level").forGetter(BioluminescenceEnchantmentEffect::level))
                    .apply(instance, BioluminescenceEnchantmentEffect::new));


    @Override
    public void apply(ServerLevel level, int enchantmentLevel, EnchantedItemInUse item, Entity entity, Vec3 origin) {

            if(entity instanceof Player player){
                player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 60, 0), player);
                player.addEffect(new MobEffectInstance(MobEffects.GLOWING, 60, 0), player);
            }
    }

    @Override
    public void onDeactivated(EnchantedItemInUse item, Entity entity, Vec3 pos, int enchantmentLevel) {
        if(entity instanceof Player player){
            player.removeEffect(MobEffects.NIGHT_VISION);
        }
    }

    @Override
    public MapCodec<? extends EnchantmentEntityEffect> codec() {
        return CODEC;
    }
}
