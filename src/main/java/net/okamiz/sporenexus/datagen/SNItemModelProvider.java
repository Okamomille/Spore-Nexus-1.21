package net.okamiz.sporenexus.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.okamiz.sporenexus.SporeNexusMod;
import net.okamiz.sporenexus.item.SNItems;

public class SNItemModelProvider extends ItemModelProvider {
    public SNItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, SporeNexusMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

        basicItem(SNItems.NEXUS_FUNGUS.get());
        basicItem(SNItems.GREAT_FUNGUS.get());
        basicItem(SNItems.INFERNAL_FUNGUS.get());
        basicItem(SNItems.ETHEREAL_FUNGUS.get());

        basicItem(SNItems.FUNGAL_ESSENCE.get());
        basicItem(SNItems.INFERNAL_ESSENCE.get());
        basicItem(SNItems.ETHEREAL_ESSENCE.get());

        basicItem(SNItems.SPORE_RELIC.get());
        basicItem(SNItems.MUSHROOM_SPORES.get());
        basicItem(SNItems.MUSHROOM_CAP.get());

        basicItem(SNItems.FUNGAL_POWDER.get());
        basicItem(SNItems.FUNGALSTEEL_INGOT.get());

        basicItem(SNItems.FUNGAL_DIAMOND.get());
        basicItem(SNItems.INFERNAL_DIAMOND.get());
        basicItem(SNItems.ETHEREAL_DIAMOND.get());

        // ---------------------------------------- FUNGAL TOOLS --------------------------------------------------------

        handheldItem(SNItems.FUNGAL_DIAMOND_SWORD);
        handheldItem(SNItems.FUNGAL_DIAMOND_PICKAXE);
        handheldItem(SNItems.FUNGAL_DIAMOND_AXE);
        handheldItem(SNItems.FUNGAL_DIAMOND_SHOVEL);
        handheldItem(SNItems.FUNGAL_DIAMOND_HOE);

        // ---------------------------------------- INFERNAL TOOLS --------------------------------------------------------

        handheldItem(SNItems.INFERNAL_DIAMOND_SWORD);
        handheldItem(SNItems.INFERNAL_DIAMOND_PICKAXE);
        handheldItem(SNItems.INFERNAL_DIAMOND_AXE);
        handheldItem(SNItems.INFERNAL_DIAMOND_SHOVEL);
        handheldItem(SNItems.INFERNAL_DIAMOND_HOE);

        // ---------------------------------------- ETHEREAL TOOLS --------------------------------------------------------

        handheldItem(SNItems.ETHEREAL_DIAMOND_SWORD);
        handheldItem(SNItems.ETHEREAL_DIAMOND_PICKAXE);
        handheldItem(SNItems.ETHEREAL_DIAMOND_AXE);
        handheldItem(SNItems.ETHEREAL_DIAMOND_SHOVEL);
        handheldItem(SNItems.ETHEREAL_DIAMOND_HOE);



        // ---------------------------------------- ---------------------------------------------------------------------

        basicItem(SNItems.DIRT_FRAGMENTS.get());
        basicItem(SNItems.GRAVEL_FRAGMENTS.get());
        basicItem(SNItems.SAND_FRAGMENTS.get());
        basicItem(SNItems.CLAY_FRAGMENTS.get());
        basicItem(SNItems.STONE_FRAGMENTS.get());
        basicItem(SNItems.MOSSY_COBBLESTONE_FRAGMENTS.get());

        basicItem(SNItems.COAL_FRAGMENTS.get());
        basicItem(SNItems.IRON_FRAGMENTS.get());
        basicItem(SNItems.COPPER_FRAGMENTS.get());


        basicItem(SNItems.ICE_FRAGMENTS.get());

        basicItem(SNItems.REDSTONE_FRAGMENTS.get());
        basicItem(SNItems.LAPIS_LAZULI_FRAGMENTS.get());
        basicItem(SNItems.GOLD_FRAGMENTS.get());
        basicItem(SNItems.FUNGALSTEEL_FRAGMENTS.get());


        basicItem(SNItems.BLACKSTONE_FRAGMENTS.get());
        basicItem(SNItems.GLOWSTONE_FRAGMENTS.get());
        basicItem(SNItems.NETHERRACK_FRAGMENTS.get());
        basicItem(SNItems.SOUL_SAND_FRAGMENTS.get());

        basicItem(SNItems.QUARTZ_FRAGMENTS.get());
        basicItem(SNItems.DIAMOND_FRAGMENTS.get());


        basicItem(SNItems.EMERALD_FRAGMENTS.get());
        basicItem(SNItems.NETHERITE_FRAGMENTS.get());

    }


    public void flowerItem(DeferredBlock<Block> block){
        this.withExistingParent(block.getId().getPath(), mcLoc("item/generated"))
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(SporeNexusMod.MOD_ID,
                        "block/" + block.getId().getPath()));
    }

    private ItemModelBuilder handheldItem(DeferredItem<Item> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/handheld")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(SporeNexusMod.MOD_ID,"item/" + item.getId().getPath()));
    }
}
