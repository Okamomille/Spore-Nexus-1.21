package net.okamiz.sporenexus.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.okamiz.sporenexus.SporeNexusMod;
import net.okamiz.sporenexus.enchantment.SNEnchantments;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class SNDataRegistryProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.ENCHANTMENT, SNEnchantments::bootstrap);


    public SNDataRegistryProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(SporeNexusMod.MOD_ID));
    }
}
