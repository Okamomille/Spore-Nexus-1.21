package net.okamiz.sporenexus.datagen;


import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.okamiz.sporenexus.SporeNexusMod;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = SporeNexusMod.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class DataGenerator {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event){
        net.minecraft.data.DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(event.includeServer(), new SNRecipeProvider(packOutput, lookupProvider));
        generator.addProvider(event.includeServer(), new LootTableProvider(packOutput, Collections.emptySet(),
                List.of(new LootTableProvider.SubProviderEntry(SNBlockLootTableProvider::new, LootContextParamSets.BLOCK)), lookupProvider));

        BlockTagsProvider blockTagsProvider = new SNBlockTagProvider(packOutput, lookupProvider, existingFileHelper);
        generator.addProvider(event.includeServer(), blockTagsProvider);
        generator.addProvider(event.includeServer(), new SNItemTagProvider(packOutput, lookupProvider, blockTagsProvider.contentsGetter(), existingFileHelper));

        generator.addProvider(event.includeClient(), new SNItemModelProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeClient(), new SNBlockStateProvider(packOutput, existingFileHelper));

        generator.addProvider(event.includeServer(), new SNDataRegistryProvider(packOutput, lookupProvider));
    }
}
