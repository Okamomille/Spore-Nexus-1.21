package net.okamiz.sporenexus.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.okamiz.sporenexus.SporeNexusMod;
import net.okamiz.sporenexus.block.SNBlocks;

public class SNBlockStateProvider extends BlockStateProvider {
    public SNBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, SporeNexusMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

        blockWithItem(SNBlocks.FERTILIZED_MYCELIUM);
        blockWithItem(SNBlocks.ENRICHED_MYCELIUM);
        blockWithItem(SNBlocks.FUNGALSTEEL_BLOCK);

        blockWithItem(SNBlocks.FUNGAL_DIAMOND_BLOCK);

        blockWithItem(SNBlocks.FUNGAL_LANTERN);

    }

    private void blockWithItem(DeferredBlock<Block> deferredBlock){
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private void blockItem(DeferredBlock<Block> deferredBlock){
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("sporenexus:block/" + deferredBlock.getId().getPath()));
    }


}
