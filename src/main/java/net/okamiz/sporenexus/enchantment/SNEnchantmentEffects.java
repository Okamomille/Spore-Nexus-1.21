package net.okamiz.sporenexus.enchantment;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.okamiz.sporenexus.SporeNexusMod;
import net.okamiz.sporenexus.enchantment.custom.BioluminescenceEnchantmentEffect;
import net.okamiz.sporenexus.enchantment.custom.LightningStrikerEnchantmentEffect;
import net.okamiz.sporenexus.enchantment.custom.ToxicSporesEnchantmentEffect;

import java.util.function.Supplier;

public class SNEnchantmentEffects {
    public static final DeferredRegister<MapCodec<? extends EnchantmentEntityEffect>> ENTITY_ENCHANTMENT_EFFECTS =
            DeferredRegister.create(Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE, SporeNexusMod.MOD_ID);


    public static final Supplier<MapCodec<? extends EnchantmentEntityEffect>> LIGHTNING_STRIKER_ =
            registerEnchantmentEffect("lightning_striker", LightningStrikerEnchantmentEffect.CODEC);

    public static final Supplier<MapCodec<? extends EnchantmentEntityEffect>> TOXIC_SPORES =
            registerEnchantmentEffect("toxic_spores", ToxicSporesEnchantmentEffect.CODEC);

    public static final Supplier<MapCodec<? extends EnchantmentEntityEffect>> BIOLUMINESCENCE =
            registerEnchantmentEffect("bioluminescence", BioluminescenceEnchantmentEffect.CODEC);



    private static Supplier<MapCodec<? extends EnchantmentEntityEffect>> registerEnchantmentEffect(String name, MapCodec<? extends EnchantmentEntityEffect> codec){
        return ENTITY_ENCHANTMENT_EFFECTS.register(name, () -> codec);
    }

    public static void register(IEventBus eventBus){
        ENTITY_ENCHANTMENT_EFFECTS.register(eventBus);
    }

}
