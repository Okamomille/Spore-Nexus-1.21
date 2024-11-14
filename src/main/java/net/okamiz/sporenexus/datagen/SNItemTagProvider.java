package net.okamiz.sporenexus.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.okamiz.sporenexus.SporeNexusMod;
import net.okamiz.sporenexus.item.SNItems;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class SNItemTagProvider extends ItemTagsProvider {


    public SNItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, SporeNexusMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        this.tag(ItemTags.SWORDS)
            .add(SNItems.FUNGAL_DIAMOND_SWORD.get())
            .add(SNItems.INFERNAL_DIAMOND_SWORD.get())
            .add(SNItems.ETHEREAL_DIAMOND_SWORD.get());

        this.tag(ItemTags.PICKAXES)
                .add(SNItems.FUNGAL_DIAMOND_PICKAXE.get())
                .add(SNItems.INFERNAL_DIAMOND_PICKAXE.get())
                .add(SNItems.ETHEREAL_DIAMOND_PICKAXE.get());

        this.tag(ItemTags.AXES)
                .add(SNItems.FUNGAL_DIAMOND_AXE.get())
                .add(SNItems.INFERNAL_DIAMOND_AXE.get())
                .add(SNItems.ETHEREAL_DIAMOND_AXE.get());

        this.tag(ItemTags.SHOVELS)
                .add(SNItems.FUNGAL_DIAMOND_SHOVEL.get())
                .add(SNItems.INFERNAL_DIAMOND_SHOVEL.get())
                .add(SNItems.ETHEREAL_DIAMOND_SHOVEL.get());

        this.tag(ItemTags.HOES)
                .add(SNItems.FUNGAL_DIAMOND_HOE.get())
                .add(SNItems.INFERNAL_DIAMOND_HOE.get())
                .add(SNItems.ETHEREAL_DIAMOND_HOE.get());

    }
}
