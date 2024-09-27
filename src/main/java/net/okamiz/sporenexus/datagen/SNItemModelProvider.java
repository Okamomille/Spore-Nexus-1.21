package net.okamiz.sporenexus.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.okamiz.sporenexus.SporeNexusMod;
import net.okamiz.sporenexus.item.SNItems;

public class SNItemModelProvider extends ItemModelProvider {
    public SNItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, SporeNexusMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

        basicItem(SNItems.MUSHROOM_CAP.get());
        basicItem(SNItems.COAL_FRAGMENTS.get());
        basicItem(SNItems.LAPIS_LAZULI_FRAGMENTS.get());
        basicItem(SNItems.QUARTZ_FRAGMENTS.get());
        basicItem(SNItems.IRON_FRAGMENTS.get());
        basicItem(SNItems.COPPER_FRAGMENTS.get());
        basicItem(SNItems.GOLD_FRAGMENTS.get());
        basicItem(SNItems.DIAMOND_FRAGMENTS.get());
        basicItem(SNItems.EMERALD_FRAGMENTS.get());
        basicItem(SNItems.NETHERITE_FRAGMENTS.get());

    }


    public void flowerItem(DeferredBlock<Block> block){
        this.withExistingParent(block.getId().getPath(), mcLoc("item/generated"))
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(SporeNexusMod.MOD_ID,
                        "block/" + block.getId().getPath()));
    }
}
