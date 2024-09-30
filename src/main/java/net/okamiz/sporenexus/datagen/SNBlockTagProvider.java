package net.okamiz.sporenexus.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.okamiz.sporenexus.SporeNexusMod;
import net.okamiz.sporenexus.block.SNBlocks;
import net.okamiz.sporenexus.util.SNTags;
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
                .add(SNBlocks.LAPIS_LAZULI_MUSHROOM.get())
                .add(SNBlocks.QUARTZ_MUSHROOM.get())
                .add(SNBlocks.REDSTONE_MUSHROOM.get())
                .add(SNBlocks.IRON_MUSHROOM.get())
                .add(SNBlocks.COPPER_MUSHROOM.get())
                .add(SNBlocks.GOLD_MUSHROOM.get())
                .add(SNBlocks.FUNGALSTEEL_MUSHROOM.get())
                .add(SNBlocks.DIAMOND_MUSHROOM.get())
                .add(SNBlocks.EMERALD_MUSHROOM.get())
                .add(SNBlocks.NETHERITE_MUSHROOM.get());

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(SNBlocks.REGENERATION_TOTEM.get())
                .add(SNBlocks.NIGHT_VISION_TOTEM.get())
                .add(SNBlocks.HASTE_TOTEM.get())
                .add(SNBlocks.FIRE_RESISTANCE_TOTEM.get())
                .add(SNBlocks.FUNGALSTEEL_BLOCK.get())
                .add(SNBlocks.SPORE_SPREADER.get())
                .add(SNBlocks.FUNGAL_PROPAGATOR.get());

        this.tag(BlockTags.MINEABLE_WITH_HOE)
                .add(SNBlocks.FUNGAL_LANTERN.get())
                .add(SNBlocks.FERTILIZED_MYCELIUM.get())
                .add(SNBlocks.ENRICHED_MYCELIUM.get());

        this.tag(SNTags.Blocks.RESOURCES_MUSHROOMS)
                .add(SNBlocks.COAL_MUSHROOM.get())
                .add(SNBlocks.LAPIS_LAZULI_MUSHROOM.get())
                .add(SNBlocks.QUARTZ_MUSHROOM.get())
                .add(SNBlocks.REDSTONE_MUSHROOM.get())
                .add(SNBlocks.IRON_MUSHROOM.get())
                .add(SNBlocks.COPPER_MUSHROOM.get())
                .add(SNBlocks.GOLD_MUSHROOM.get())
                .add(SNBlocks.FUNGALSTEEL_MUSHROOM.get())
                .add(SNBlocks.DIAMOND_MUSHROOM.get())
                .add(SNBlocks.EMERALD_MUSHROOM.get())
                .add(SNBlocks.NETHERITE_MUSHROOM.get());

        this.tag(SNTags.Blocks.MYCELIUM_SOILS)
                .add(Blocks.MYCELIUM)
                .add(SNBlocks.FERTILIZED_MYCELIUM.get())
                .add(SNBlocks.ENRICHED_MYCELIUM.get());

        this.tag(BlockTags.MUSHROOM_GROW_BLOCK)
                .add(SNBlocks.FERTILIZED_MYCELIUM.get())
                .add(SNBlocks.ENRICHED_MYCELIUM.get());
    }
}
