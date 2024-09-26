package net.okamiz.sporenexus.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.okamiz.sporenexus.SporeNexusMod;
import net.okamiz.sporenexus.block.SNBlocks;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class SNBlockTagProvider extends BlockTagsProvider {
    public SNBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, SporeNexusMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        this.tag(BlockTags.MINEABLE_WITH_AXE)
                .add(SNBlocks.COAL_MUSHROOM.get())
                .add(SNBlocks.IRON_MUSHROOM.get())
                .add(SNBlocks.GOLD_MUSHROOM.get())
                .add(SNBlocks.DIAMOND_MUSHROOM.get());
    }
}
