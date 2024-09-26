package net.okamiz.sporenexus.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.okamiz.sporenexus.SporeNexusMod;

public class SNItemModelProvider extends ItemModelProvider {
    public SNItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, SporeNexusMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {



    }


    public void flowerItem(DeferredBlock<Block> block){
        this.withExistingParent(block.getId().getPath(), mcLoc("item/generated"))
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(SporeNexusMod.MOD_ID,
                        "block/" + block.getId().getPath()));
    }
}
