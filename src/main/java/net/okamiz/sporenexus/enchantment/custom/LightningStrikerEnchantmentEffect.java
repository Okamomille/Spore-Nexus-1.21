package net.okamiz.sporenexus.enchantment.custom;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.item.enchantment.EnchantedItemInUse;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.minecraft.world.phys.Vec3;

public record LightningStrikerEnchantmentEffect(int level) implements EnchantmentEntityEffect {
    public static MapCodec<LightningStrikerEnchantmentEffect> CODEC = RecordCodecBuilder.mapCodec(instance ->
            instance.group(Codec.INT.fieldOf("level").forGetter(LightningStrikerEnchantmentEffect::level))
                    .apply(instance, LightningStrikerEnchantmentEffect::new));


    @Override
    public void apply(ServerLevel level, int enchantmentLevel, EnchantedItemInUse item, Entity entity, Vec3 origin) {
        if(enchantmentLevel == 1){
            EntityType.LIGHTNING_BOLT.spawn(level, entity.getOnPos(), MobSpawnType.TRIGGERED);
        }
        if(enchantmentLevel == 2){
            EntityType.LIGHTNING_BOLT.spawn(level, entity.getOnPos(), MobSpawnType.TRIGGERED);
            EntityType.LIGHTNING_BOLT.spawn(level, entity.getOnPos(), MobSpawnType.TRIGGERED);
        }
    }

    @Override
    public MapCodec<? extends EnchantmentEntityEffect> codec() {
        return CODEC;
    }
}
