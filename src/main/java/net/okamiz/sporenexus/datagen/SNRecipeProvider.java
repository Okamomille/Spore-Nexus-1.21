package net.okamiz.sporenexus.datagen;

import net.minecraft.advancements.Criterion;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.okamiz.sporenexus.block.SNBlocks;
import net.okamiz.sporenexus.item.SNItems;

import java.util.concurrent.CompletableFuture;

public class SNRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public SNRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {


        // MUSHROOM SPORES

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,SNItems.MUSHROOM_SPORES, 1)
                        .requires(Items.BROWN_MUSHROOM)
                        .unlockedBy("has_brown_mushroom", has(Items.BROWN_MUSHROOM))
                        .save(recipeOutput, "spores_from_brown_mushroom");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,SNItems.MUSHROOM_SPORES, 1)
                .requires(Items.RED_MUSHROOM)
                .unlockedBy("has_red_mushroom", has(Items.RED_MUSHROOM))
                .save(recipeOutput, "spores_from_red_mushroom");

        // NEXUS FUNGUS

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,SNItems.NEXUS_FUNGUS, 1)
                .requires(Items.BROWN_MUSHROOM, 9)
                .unlockedBy("has_brown_mushroom", has(Items.BROWN_MUSHROOM))
                .save(recipeOutput, "nexus_fungus_from_brown_mushroom");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,SNItems.NEXUS_FUNGUS, 1)
                .requires(Items.RED_MUSHROOM, 9)
                .unlockedBy("has_red_mushroom", has(Items.RED_MUSHROOM))
                .save(recipeOutput, "nexus_fungus_from_red_mushroom");


        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, SNItems.GREAT_FUNGUS, 1)
                .pattern("XXX")
                .pattern("XOX")
                .pattern("XXX")
                .define('O', SNItems.NEXUS_FUNGUS)
                .define('X', SNItems.FUNGAL_ESSENCE)
                .unlockedBy("has_nexus_fungus", has(SNItems.NEXUS_FUNGUS))
                .unlockedBy("has_fungal_essence", has(SNItems.FUNGAL_ESSENCE))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, SNItems.INFERNAL_FUNGUS, 1)
                .pattern("XXX")
                .pattern("XOX")
                .pattern("XXX")
                .define('O', SNItems.GREAT_FUNGUS)
                .define('X', SNItems.INFERNAL_ESSENCE)
                .unlockedBy("has_great_fungus", has(SNItems.GREAT_FUNGUS))
                .unlockedBy("has_infernal_essence", has(SNItems.INFERNAL_ESSENCE))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, SNItems.ETHEREAL_FUNGUS, 1)
                .pattern("XXX")
                .pattern("XOX")
                .pattern("XXX")
                .define('O', SNItems.INFERNAL_FUNGUS)
                .define('X', SNItems.ETHEREAL_ESSENCE)
                .unlockedBy("has_infernal_fungus", has(SNItems.INFERNAL_FUNGUS))
                .unlockedBy("has_ethereal_essence", has(SNItems.ETHEREAL_ESSENCE))
                .save(recipeOutput);

        // ESSENCES- --------------------------


        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, SNItems.INFERNAL_ESSENCE, 1)
                .pattern(" X ")
                .pattern("XOX")
                .pattern(" X ")
                .define('O', Items.BLAZE_POWDER)
                .define('X', SNItems.FUNGAL_ESSENCE)
                .unlockedBy("has_blaze_powder", has(Items.BLAZE_POWDER))
                .unlockedBy("has_fungal_essence", has(SNItems.FUNGAL_ESSENCE))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, SNItems.ETHEREAL_ESSENCE, 1)
                .pattern(" X ")
                .pattern("XOX")
                .pattern(" X ")
                .define('O', Items.CHORUS_FRUIT)
                .define('X', SNItems.INFERNAL_ESSENCE)
                .unlockedBy("has_chorus_fruit", has(Items.CHORUS_FRUIT))
                .unlockedBy("has_infernal_essence", has(SNItems.INFERNAL_ESSENCE))
                .save(recipeOutput);


        // ------------------------------------

        // FUNGAL DIAMOND

        craft9x9BlockRecipes(recipeOutput, "fungal_diamond", SNItems.FUNGAL_DIAMOND.get(), SNBlocks.FUNGAL_DIAMOND_BLOCK.get(),
                "has_fungal_diamond", has(SNItems.FUNGAL_DIAMOND));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, SNItems.FUNGAL_DIAMOND, 1)
                .pattern(" X ")
                .pattern("XOX")
                .pattern(" X ")
                .define('O', Items.DIAMOND)
                .define('X', SNItems.FUNGAL_ESSENCE)
                .unlockedBy("has_diamond", has(Items.DIAMOND))
                .unlockedBy("has_fungal_essence", has(SNItems.FUNGAL_ESSENCE))
                .save(recipeOutput);

        craftCustomToolSet(recipeOutput, "fungal_diamond", SNItems.FUNGAL_DIAMOND_SWORD.get(),
                SNItems.FUNGAL_DIAMOND_PICKAXE.get(), SNItems.FUNGAL_DIAMOND_AXE.get(), SNItems.FUNGAL_DIAMOND_SHOVEL.get(), SNItems.FUNGAL_DIAMOND_HOE.get(),
                SNItems.FUNGAL_DIAMOND.get(), "has_fungal_diamond", has(SNItems.FUNGAL_DIAMOND));

        // ------------------------------------

        // INFERNAL DIAMOND

        craft9x9BlockRecipes(recipeOutput, "infernal_diamond", SNItems.INFERNAL_DIAMOND.get(), SNBlocks.INFERNAL_DIAMOND_BLOCK.get(),
                "has_infernal_diamond", has(SNItems.INFERNAL_DIAMOND));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, SNItems.INFERNAL_DIAMOND, 1)
                .pattern(" X ")
                .pattern("XOX")
                .pattern(" X ")
                .define('O', SNItems.FUNGAL_DIAMOND)
                .define('X', SNItems.INFERNAL_ESSENCE)
                .unlockedBy("has_fungal_diamond", has(SNItems.FUNGAL_DIAMOND))
                .unlockedBy("has_infernal_essence", has(SNItems.INFERNAL_ESSENCE))
                .save(recipeOutput);

        craftCustomToolSet(recipeOutput, "infernal_diamond", SNItems.INFERNAL_DIAMOND_SWORD.get(),
                SNItems.INFERNAL_DIAMOND_PICKAXE.get(), SNItems.INFERNAL_DIAMOND_AXE.get(), SNItems.INFERNAL_DIAMOND_SHOVEL.get(), SNItems.INFERNAL_DIAMOND_HOE.get(),
                SNItems.INFERNAL_DIAMOND.get(), "has_infernal_diamond", has(SNItems.INFERNAL_DIAMOND));

        // ------------------------------------

        // ETHEREAL DIAMOND

        craft9x9BlockRecipes(recipeOutput, "ethereal_diamond", SNItems.ETHEREAL_DIAMOND.get(), SNBlocks.ETHEREAL_DIAMOND_BLOCK.get(),
                "has_ethereal_diamond", has(SNItems.ETHEREAL_DIAMOND));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, SNItems.ETHEREAL_DIAMOND, 1)
                .pattern(" X ")
                .pattern("XOX")
                .pattern(" X ")
                .define('O', SNItems.INFERNAL_DIAMOND)
                .define('X', SNItems.ETHEREAL_ESSENCE)
                .unlockedBy("has_infernal_diamond", has(SNItems.INFERNAL_DIAMOND))
                .unlockedBy("has_ethereal_essence", has(SNItems.ETHEREAL_ESSENCE))
                .save(recipeOutput);

        craftCustomToolSet(recipeOutput, "ethereal_diamond", SNItems.ETHEREAL_DIAMOND_SWORD.get(),
                SNItems.ETHEREAL_DIAMOND_PICKAXE.get(), SNItems.ETHEREAL_DIAMOND_AXE.get(), SNItems.ETHEREAL_DIAMOND_SHOVEL.get(), SNItems.ETHEREAL_DIAMOND_HOE.get(),
                SNItems.ETHEREAL_DIAMOND.get(), "has_ethereal_diamond", has(SNItems.ETHEREAL_DIAMOND));


        // ------------------------------------

        // FUNGALSTEEL

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,SNItems.FUNGALSTEEL_INGOT, 9)
                .requires(SNBlocks.FUNGALSTEEL_BLOCK, 1)
                .unlockedBy("has_fungalsteel_block", has(SNBlocks.FUNGALSTEEL_BLOCK))
                .save(recipeOutput, "fungalsteel_ingot_from_block");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,SNBlocks.FUNGALSTEEL_BLOCK, 1)
                .requires(SNItems.FUNGALSTEEL_INGOT, 9)
                .unlockedBy("has_fungalsteel_ingot", has(SNItems.FUNGALSTEEL_INGOT))
                .save(recipeOutput, "fungalsteel_block_from_ingot");



        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, SNItems.FUNGAL_POWDER, 1)
                .pattern(" X ")
                .pattern("XOX")
                .pattern(" X ")
                .define('O', Blocks.MOSS_BLOCK)
                .define('X', SNItems.FUNGAL_ESSENCE)
                .unlockedBy("has_moss_block", has(Blocks.MOSS_BLOCK))
                .unlockedBy("has_fungal_essence", has(SNItems.FUNGAL_ESSENCE))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, SNItems.FUNGALSTEEL_INGOT, 1)
                .pattern(" X ")
                .pattern("XOX")
                .pattern(" X ")
                .define('O', Items.IRON_INGOT)
                .define('X', SNItems.FUNGAL_POWDER)
                .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
                .unlockedBy("has_fungal_powder", has(SNItems.FUNGAL_POWDER))
                .save(recipeOutput);



        // FUNGAL ORGANIC THINGS

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, SNBlocks.FUNGAL_LANTERN, 1)
                .pattern(" X ")
                .pattern("XOX")
                .pattern(" X ")
                .define('O', Blocks.GLOWSTONE)
                .define('X', SNItems.FUNGAL_POWDER)
                .unlockedBy("has_glowstone", has(Blocks.GLOWSTONE))
                .unlockedBy("has_fungal_powder", has(SNItems.FUNGAL_POWDER))
                .save(recipeOutput);



        //MACHINES

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, SNBlocks.SPORE_SPREADER, 1)
                .pattern("SXS")
                .pattern("BMB")
                .pattern("SXS")
                .define('S', SNItems.FUNGALSTEEL_INGOT)
                .define('M', SNBlocks.ENRICHED_MYCELIUM)
                .define('X', SNBlocks.FUNGALSTEEL_BLOCK)
                .define('B', Blocks.IRON_BARS)
                .unlockedBy("has_fungalsteel_ingot", has(SNItems.FUNGALSTEEL_INGOT))
                .unlockedBy("has_iron_bars", has(Blocks.IRON_BARS))
                .unlockedBy("has_fungalsteel_block", has(SNBlocks.FUNGALSTEEL_BLOCK))
                .unlockedBy("has_enriched_mycelium", has(SNBlocks.ENRICHED_MYCELIUM))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, SNBlocks.FUNGAL_PROPAGATOR, 1)
                .pattern("SXS")
                .pattern("BMB")
                .pattern("SXS")
                .define('S', SNItems.FUNGALSTEEL_INGOT)
                .define('M', SNItems.MUSHROOM_SPORES)
                .define('X', SNBlocks.FUNGALSTEEL_BLOCK)
                .define('B', Items.IRON_NUGGET)
                .unlockedBy("has_fungalsteel_ingot", has(SNItems.FUNGALSTEEL_INGOT))
                .unlockedBy("has_iron_nugget", has(Items.IRON_NUGGET))
                .unlockedBy("has_fungalsteel_block", has(SNBlocks.FUNGALSTEEL_BLOCK))
                .unlockedBy("has_mushroom_spores", has(SNItems.MUSHROOM_SPORES))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, SNBlocks.MUSHROOM_COLLECTOR, 1)
                .pattern("SXS")
                .pattern("BMB")
                .pattern("SBS")
                .define('S', SNItems.FUNGALSTEEL_INGOT)
                .define('M', Blocks.CHEST)
                .define('X', SNBlocks.FUNGALSTEEL_BLOCK)
                .define('B', Blocks.HOPPER)
                .unlockedBy("has_fungalsteel_ingot", has(SNItems.FUNGALSTEEL_INGOT))
                .unlockedBy("has_hopper", has(Blocks.HOPPER))
                .unlockedBy("has_fungalsteel_block", has(SNBlocks.FUNGALSTEEL_BLOCK))
                .unlockedBy("has_chest", has(Blocks.CHEST))
                .save(recipeOutput);


        // TOTEMS

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, SNBlocks.REGENERATION_TOTEM, 1)
                .pattern(" X ")
                .pattern("ABA")
                .pattern("CDC")
                .define('X', SNItems.NEXUS_FUNGUS)
                .define('A', Blocks.ANDESITE_WALL)
                .define('B', SNItems.SPORE_RELIC)
                .define('C', Blocks.POLISHED_ANDESITE)
                .define('D', Items.GLISTERING_MELON_SLICE)
                .unlockedBy("has_nexus_fungus", has(SNItems.NEXUS_FUNGUS))
                .unlockedBy("has_andesite_wall", has(Blocks.ANDESITE_WALL))
                .unlockedBy("has_spore_relic", has(SNItems.SPORE_RELIC))
                .unlockedBy("has_polished_andesite", has(Blocks.POLISHED_ANDESITE))
                .unlockedBy("has_glistering_melon_slice", has(Items.GLISTERING_MELON_SLICE))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, SNBlocks.NIGHT_VISION_TOTEM, 1)
                .pattern(" X ")
                .pattern("ABA")
                .pattern("CDC")
                .define('X', SNItems.GREAT_FUNGUS)
                .define('A', Blocks.ANDESITE_WALL)
                .define('B', SNItems.SPORE_RELIC)
                .define('C', Blocks.POLISHED_ANDESITE)
                .define('D', Items.ENDER_EYE)
                .unlockedBy("has_great_fungus", has(SNItems.GREAT_FUNGUS))
                .unlockedBy("has_andesite_wall", has(Blocks.ANDESITE_WALL))
                .unlockedBy("has_spore_relic", has(SNItems.SPORE_RELIC))
                .unlockedBy("has_polished_andesite", has(Blocks.POLISHED_ANDESITE))
                .unlockedBy("has_ender_eye", has(Items.ENDER_EYE))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, SNBlocks.HASTE_TOTEM, 1)
                .pattern(" X ")
                .pattern("ABA")
                .pattern("CDC")
                .define('X', SNItems.GREAT_FUNGUS)
                .define('A', Blocks.ANDESITE_WALL)
                .define('B', SNItems.SPORE_RELIC)
                .define('C', Blocks.POLISHED_ANDESITE)
                .define('D', Items.GOLDEN_PICKAXE)
                .unlockedBy("has_great_fungus", has(SNItems.GREAT_FUNGUS))
                .unlockedBy("has_andesite_wall", has(Blocks.ANDESITE_WALL))
                .unlockedBy("has_spore_relic", has(SNItems.SPORE_RELIC))
                .unlockedBy("has_polished_andesite", has(Blocks.POLISHED_ANDESITE))
                .unlockedBy("has_golden_pickaxe", has(Items.GOLDEN_PICKAXE))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, SNBlocks.FIRE_RESISTANCE_TOTEM, 1)
                .pattern(" X ")
                .pattern("ABA")
                .pattern("CDC")
                .define('X', SNItems.INFERNAL_FUNGUS)
                .define('A', Blocks.ANDESITE_WALL)
                .define('B', SNItems.SPORE_RELIC)
                .define('C', Blocks.POLISHED_ANDESITE)
                .define('D', Items.BLAZE_POWDER)
                .unlockedBy("has_infernal_fungus", has(SNItems.INFERNAL_FUNGUS))
                .unlockedBy("has_andesite_wall", has(Blocks.ANDESITE_WALL))
                .unlockedBy("has_spore_relic", has(SNItems.SPORE_RELIC))
                .unlockedBy("has_polished_andesite", has(Blocks.POLISHED_ANDESITE))
                .unlockedBy("has_blaze_powder", has(Items.BLAZE_POWDER))
                .save(recipeOutput);



        //MYCELIUMS

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Blocks.MYCELIUM, 1)
                .pattern("SSS")
                .pattern("SDS")
                .pattern("SSS")
                .define('S', SNItems.MUSHROOM_SPORES)
                .define('D', Blocks.DIRT)
                .unlockedBy("has_mushroom_spores", has(SNItems.MUSHROOM_SPORES))
                .unlockedBy("has_dirt", has(Blocks.DIRT))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, SNBlocks.FERTILIZED_MYCELIUM, 1)
                .pattern("SSS")
                .pattern("SMS")
                .pattern("SSS")
                .define('S', SNItems.MUSHROOM_SPORES)
                .define('M', Blocks.MYCELIUM)
                .unlockedBy("has_mushroom_spores", has(SNItems.MUSHROOM_SPORES))
                .unlockedBy("has_mycelium", has(Blocks.MYCELIUM))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, SNBlocks.ENRICHED_MYCELIUM, 1)
                .pattern("SSS")
                .pattern("SMS")
                .pattern("SSS")
                .define('S', SNItems.FUNGAL_ESSENCE)
                .define('M', SNBlocks.FERTILIZED_MYCELIUM)
                .unlockedBy("has_fertilized_mycelium", has(SNBlocks.FERTILIZED_MYCELIUM))
                .unlockedBy("has_fungal_essence", has(SNItems.FUNGAL_ESSENCE))
                .save(recipeOutput);




        //RESOURCES MUSHROOMS --------------------------------------------------------------------

            // --- LEVEL 1 ---

        craftResourceMushroom(recipeOutput, SNBlocks.COAL_MUSHROOM.get(), Items.COAL, "has_coal", has(Items.COAL));
        craftResourceMushroom(recipeOutput, SNBlocks.COPPER_MUSHROOM.get(), Items.COPPER_INGOT, "has_copper_ingot", has(Items.COPPER_INGOT));
        craftResourceMushroom(recipeOutput, SNBlocks.IRON_MUSHROOM.get(), Items.IRON_INGOT, "has_iron", has(Items.IRON_INGOT));
        craftResourceMushroom(recipeOutput, SNBlocks.CLAY_MUSHROOM.get(), Items.CLAY, "has_clay", has(Items.CLAY));
        craftResourceMushroom(recipeOutput, SNBlocks.SAND_MUSHROOM.get(), Items.SAND, "has_sand", has(Items.SAND));
        craftResourceMushroom(recipeOutput, SNBlocks.STONE_MUSHROOM.get(), Items.STONE, "has_stone", has(Items.STONE));
        craftResourceMushroom(recipeOutput, SNBlocks.DIRT_MUSHROOM.get(), Items.DIRT, "has_dirt", has(Items.DIRT));
        craftResourceMushroom(recipeOutput, SNBlocks.GRAVEL_MUSHROOM.get(), Items.GRAVEL, "has_gravel", has(Items.GRAVEL));


            // --- LEVEL 2 ---

        craftGreatResourceMushroom(recipeOutput, SNBlocks.ICE_MUSHROOM.get(), Items.ICE, "has_ice", has(Items.ICE));
        craftGreatResourceMushroom(recipeOutput, SNBlocks.REDSTONE_MUSHROOM.get(), Items.REDSTONE, "has_redstone", has(Items.REDSTONE));
        craftGreatResourceMushroom(recipeOutput, SNBlocks.FUNGALSTEEL_MUSHROOM.get(), SNItems.FUNGALSTEEL_INGOT.get(), "has_fungalsteel_ingot", has(SNItems.FUNGALSTEEL_INGOT));
        craftGreatResourceMushroom(recipeOutput, SNBlocks.LAPIS_LAZULI_MUSHROOM.get(), Items.LAPIS_LAZULI, "has_lapis", has(Items.LAPIS_LAZULI));
        craftGreatResourceMushroom(recipeOutput, SNBlocks.GOLD_MUSHROOM.get(), Items.GOLD_INGOT, "has_gold", has(Items.GOLD_INGOT));


            // --- LEVEL 3 ---

        craftInfernalResourceMushroom(recipeOutput, SNBlocks.BLACKSTONE_MUSHROOM.get(), Items.BLACKSTONE, "has_blackstone", has(Items.BLACKSTONE));
        craftInfernalResourceMushroom(recipeOutput, SNBlocks.GLOWSTONE_MUSHROOM.get(), Items.GLOWSTONE, "has_glowstone", has(Items.GLOWSTONE));
        craftInfernalResourceMushroom(recipeOutput, SNBlocks.NETHERRACK_MUSHROOM.get(), Items.NETHERRACK, "has_netherrack", has(Items.NETHERRACK));
        craftInfernalResourceMushroom(recipeOutput, SNBlocks.SOUL_SAND_MUSHROOM.get(), Items.SOUL_SAND, "has_soul_sand", has(Items.SOUL_SAND));
        craftInfernalResourceMushroom(recipeOutput, SNBlocks.QUARTZ_MUSHROOM.get(), Items.QUARTZ, "has_quartz", has(Items.QUARTZ));
        craftInfernalResourceMushroom(recipeOutput, SNBlocks.DIAMOND_MUSHROOM.get(), Items.DIAMOND, "has_diamond", has(Items.DIAMOND));



            // --- LEVEL 4 ---

        craftEtherealResourceMushroom(recipeOutput, SNBlocks.EMERALD_MUSHROOM.get(), Items.EMERALD, "has_emerald", has(Items.EMERALD));
        craftEtherealResourceMushroom(recipeOutput, SNBlocks.NETHERITE_MUSHROOM.get(), Items.NETHERITE_INGOT, "has_netherite", has(Items.NETHERITE_INGOT));

        //------------------- --------------------------------------------------------------------


        // --------------------------------------- FRAGMENTS TO BLOCKS ---------------------------------------------------

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Blocks.DIRT, 4)
                .pattern("FF")
                .pattern("FF")
                .define('F', SNItems.DIRT_FRAGMENTS)
                .unlockedBy("has_dirt_fragments", has(SNItems.DIRT_FRAGMENTS))
                .save(recipeOutput, "dirt_from_fragments");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Blocks.GRAVEL, 4)
                .pattern("FF")
                .pattern("FF")
                .define('F', SNItems.GRAVEL_FRAGMENTS)
                .unlockedBy("has_gravel_fragments", has(SNItems.GRAVEL_FRAGMENTS))
                .save(recipeOutput, "gravel_from_fragments");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Blocks.SAND, 4)
                .pattern("FF")
                .pattern("FF")
                .define('F', SNItems.SAND_FRAGMENTS)
                .unlockedBy("has_sand_fragments", has(SNItems.SAND_FRAGMENTS))
                .save(recipeOutput, "sand_from_fragments");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Blocks.GRAY_CONCRETE_POWDER, 4)
                .pattern("XFX")
                .pattern("FXF")
                .pattern("XFX")
                .define('F', SNItems.SAND_FRAGMENTS)
                .define('X', SNItems.GRAVEL_FRAGMENTS)
                .unlockedBy("has_sand_fragments", has(SNItems.SAND_FRAGMENTS))
                .unlockedBy("has_gravel_fragments", has(SNItems.GRAVEL_FRAGMENTS))
                .save(recipeOutput, "gray_concrete_powder_from_fragments");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Blocks.SANDSTONE, 4)
                .pattern(" F ")
                .pattern("FXF")
                .pattern(" F ")
                .define('F', SNItems.SAND_FRAGMENTS)
                .define('X', SNItems.STONE_FRAGMENTS)
                .unlockedBy("has_sand_fragments", has(SNItems.SAND_FRAGMENTS))
                .unlockedBy("has_stone_fragments", has(SNItems.STONE_FRAGMENTS))
                .save(recipeOutput, "sandstone_from_fragments");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Blocks.CLAY, 4)
                .pattern("FF")
                .pattern("FF")
                .define('F', SNItems.CLAY_FRAGMENTS)
                .unlockedBy("has_clay_fragments", has(SNItems.CLAY_FRAGMENTS))
                .save(recipeOutput, "clay_from_fragments");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Blocks.STONE, 4)
                .pattern("FF")
                .pattern("FF")
                .define('F', SNItems.STONE_FRAGMENTS)
                .unlockedBy("has_stone_fragments", has(SNItems.STONE_FRAGMENTS))
                .save(recipeOutput, "stone_from_fragments");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Blocks.COBBLESTONE, 4)
                .pattern(" F ")
                .pattern("F F")
                .pattern(" F ")
                .define('F', SNItems.STONE_FRAGMENTS)
                .unlockedBy("has_stone_fragments", has(SNItems.STONE_FRAGMENTS))
                .save(recipeOutput, "cobblestone_from_fragments");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Blocks.ANDESITE, 8)
                .pattern("XFX")
                .pattern("F F")
                .pattern("XFX")
                .define('F', SNItems.STONE_FRAGMENTS)
                .define('X', SNItems.GRAVEL_FRAGMENTS)
                .unlockedBy("has_stone_fragments", has(SNItems.STONE_FRAGMENTS))
                .unlockedBy("has_gravel_fragments", has(SNItems.GRAVEL_FRAGMENTS))
                .save(recipeOutput, "andesite_from_fragments");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Blocks.GRANITE, 8)
                .pattern("FXF")
                .pattern("X X")
                .pattern("FXF")
                .define('F', SNItems.STONE_FRAGMENTS)
                .define('X', SNItems.GRAVEL_FRAGMENTS)
                .unlockedBy("has_stone_fragments", has(SNItems.STONE_FRAGMENTS))
                .unlockedBy("has_gravel_fragments", has(SNItems.GRAVEL_FRAGMENTS))
                .save(recipeOutput, "granite_from_fragments");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Blocks.DIORITE, 9)
                .pattern("FXF")
                .pattern("XFX")
                .pattern("FXF")
                .define('F', SNItems.STONE_FRAGMENTS)
                .define('X', SNItems.GRAVEL_FRAGMENTS)
                .unlockedBy("has_stone_fragments", has(SNItems.STONE_FRAGMENTS))
                .unlockedBy("has_gravel_fragments", has(SNItems.GRAVEL_FRAGMENTS))
                .save(recipeOutput, "diorite_from_fragments");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Blocks.DEEPSLATE, 4)
                .pattern("FFF")
                .pattern("FFF")
                .pattern("FFF")
                .define('F', SNItems.STONE_FRAGMENTS)
                .unlockedBy("has_stone_fragments", has(SNItems.STONE_FRAGMENTS))
                .save(recipeOutput, "deepslate_from_fragments");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Blocks.MOSSY_COBBLESTONE, 4)
                .pattern("FF")
                .pattern("FF")
                .define('F', SNItems.MOSSY_COBBLESTONE_FRAGMENTS)
                .unlockedBy("has_mossy_cobblestone_fragments", has(SNItems.MOSSY_COBBLESTONE_FRAGMENTS))
                .save(recipeOutput, "mossy_cobblestone_from_fragments");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Blocks.MOSSY_STONE_BRICKS, 8)
                .pattern("FFF")
                .pattern("FXF")
                .pattern("FFF")
                .define('F', SNItems.STONE_FRAGMENTS)
                .define('X', SNItems.MOSSY_COBBLESTONE_FRAGMENTS)
                .unlockedBy("has_stone_fragments", has(SNItems.STONE_FRAGMENTS))
                .unlockedBy("has_mossy_cobblestone_fragments", has(SNItems.MOSSY_COBBLESTONE_FRAGMENTS))
                .save(recipeOutput, "mossy_stonebricks_from_fragments");


        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Blocks.BLACKSTONE, 4)
                .pattern("FF")
                .pattern("FF")
                .define('F', SNItems.BLACKSTONE_FRAGMENTS)
                .unlockedBy("has_blackstone_fragments", has(SNItems.BLACKSTONE_FRAGMENTS))
                .save(recipeOutput, "blackstone_from_fragments");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Blocks.GLOWSTONE, 4)
                .pattern("FF")
                .pattern("FF")
                .define('F', SNItems.GLOWSTONE_FRAGMENTS)
                .unlockedBy("has_glowstone_fragments", has(SNItems.GLOWSTONE_FRAGMENTS))
                .save(recipeOutput, "glowstone_from_fragments");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Blocks.NETHERRACK, 4)
                .pattern("FF")
                .pattern("FF")
                .define('F', SNItems.NETHERRACK_FRAGMENTS)
                .unlockedBy("has_netherrack_fragments", has(SNItems.NETHERRACK_FRAGMENTS))
                .save(recipeOutput, "netherrack_from_fragments");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Blocks.SOUL_SAND, 4)
                .pattern("FF")
                .pattern("FF")
                .define('F', SNItems.SOUL_SAND_FRAGMENTS)
                .unlockedBy("has_soul_sand_fragments", has(SNItems.SOUL_SAND_FRAGMENTS))
                .save(recipeOutput, "soul_sand_from_fragments");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Blocks.ICE, 4)
                .pattern("FF")
                .pattern("FF")
                .define('F', SNItems.ICE_FRAGMENTS)
                .unlockedBy("has_ice_fragments", has(SNItems.ICE_FRAGMENTS))
                .save(recipeOutput, "ice_from_fragments");


        // --------------------------------------- FRAGMENTS TO ORES ---------------------------------------------------

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.COAL, 1)
                .pattern("FF")
                .pattern("FF")
                .define('F', SNItems.COAL_FRAGMENTS)
                .unlockedBy("has_coal_fragments", has(SNItems.COAL_FRAGMENTS))
                .save(recipeOutput, "coal_from_fragments");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.COPPER_INGOT, 1)
                .pattern("FF")
                .pattern("FF")
                .define('F', SNItems.COPPER_FRAGMENTS)
                .unlockedBy("has_copper_fragments", has(SNItems.COPPER_FRAGMENTS))
                .save(recipeOutput, "copper_from_fragments");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.QUARTZ, 1)
                .pattern("FF")
                .pattern("FF")
                .define('F', SNItems.QUARTZ_FRAGMENTS)
                .unlockedBy("has_quartz_fragments", has(SNItems.QUARTZ_FRAGMENTS))
                .save(recipeOutput, "quartz_from_fragments");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.REDSTONE, 1)
                .pattern("FF")
                .pattern("FF")
                .define('F', SNItems.REDSTONE_FRAGMENTS)
                .unlockedBy("has_redstone_fragments", has(SNItems.REDSTONE_FRAGMENTS))
                .save(recipeOutput, "redstone_from_fragments");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.LAPIS_LAZULI, 1)
                .pattern("FF")
                .pattern("FF")
                .define('F', SNItems.LAPIS_LAZULI_FRAGMENTS)
                .unlockedBy("has_lapis_lazuli_fragments", has(SNItems.LAPIS_LAZULI_FRAGMENTS))
                .save(recipeOutput, "lapis_lazuli_from_fragments");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.IRON_INGOT, 1)
                .pattern("FF")
                .pattern("FF")
                .define('F', SNItems.IRON_FRAGMENTS)
                .unlockedBy("has_iron_fragments", has(SNItems.IRON_FRAGMENTS))
                .save(recipeOutput, "iron_from_fragments");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.GOLD_INGOT, 1)
                .pattern("FF")
                .pattern("FF")
                .define('F', SNItems.GOLD_FRAGMENTS)
                .unlockedBy("has_gold_fragments", has(SNItems.GOLD_FRAGMENTS))
                .save(recipeOutput, "gold_from_fragments");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, SNItems.FUNGALSTEEL_INGOT, 1)
                .pattern("FF")
                .pattern("FF")
                .define('F', SNItems.FUNGALSTEEL_FRAGMENTS)
                .unlockedBy("has_fungalsteel_fragments", has(SNItems.FUNGALSTEEL_FRAGMENTS))
                .save(recipeOutput, "fungalsteel_from_fragments");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.DIAMOND, 1)
                .pattern("FF")
                .pattern("FF")
                .define('F', SNItems.DIAMOND_FRAGMENTS)
                .unlockedBy("has_diamond_fragments", has(SNItems.DIAMOND_FRAGMENTS))
                .save(recipeOutput, "diamond_from_fragments");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.EMERALD, 1)
                .pattern("FF")
                .pattern("FF")
                .define('F', SNItems.EMERALD_FRAGMENTS)
                .unlockedBy("has_emerald_fragments", has(SNItems.EMERALD_FRAGMENTS))
                .save(recipeOutput, "emerald_from_fragments");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.NETHERITE_SCRAP, 1)
                .pattern("FF")
                .pattern("FF")
                .define('F', SNItems.NETHERITE_FRAGMENTS)
                .unlockedBy("has_netherite_fragments", has(SNItems.NETHERITE_FRAGMENTS))
                .save(recipeOutput, "netherite_from_fragments");


    }



    private void craftCustomToolSet(RecipeOutput recipeOutput, String saveID, Item resultSword, Item resultPickaxe, Item resultAxe
            , Item resultShovel, Item resultHoe, Item ingredient, String criterionString, Criterion<?> criterion){


        craftCustomSword(recipeOutput, saveID + "_sword", resultSword, ingredient, criterionString, criterion);
        craftCustomPickaxe(recipeOutput, saveID + "_pickaxe", resultPickaxe, ingredient, criterionString, criterion);
        craftCustomAxe(recipeOutput, saveID + "_axe", resultAxe, ingredient, criterionString, criterion);
        craftCustomShovel(recipeOutput, saveID + "_shovel", resultShovel, ingredient, criterionString, criterion);
        craftCustomHoe(recipeOutput, saveID + "_hoe", resultHoe, ingredient, criterionString, criterion);
    }

    private void craftCustomArmorSet(RecipeOutput recipeOutput, String saveID, Item resultHelmet, Item resultChestplate, Item resultLeggings
            , Item resultBoots, Item resultHoe, Item ingredient, String criterionString, Criterion<?> criterion){


        craftCustomHelmet(recipeOutput, saveID + "_helmet", resultHelmet, ingredient, criterionString, criterion);
        craftCustomChestplate(recipeOutput, saveID + "_chestplate", resultChestplate, ingredient, criterionString, criterion);
        craftCustomLeggings(recipeOutput, saveID + "_leggings", resultLeggings, ingredient, criterionString, criterion);
        craftCustomBoots(recipeOutput, saveID + "_boots", resultBoots, ingredient, criterionString, criterion);
    }


// - ------------------------------------------TOOLS CRAFT VOIDS-----------------------------------------------------
    private void craftCustomSword(RecipeOutput recipeOutput, String saveID, Item result, Item ingredient, String criterionString, Criterion<?> criterion){
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, result, 1)
                .pattern("X")
                .pattern("X")
                .pattern("I")
                .define('X', ingredient)
                .define('I', Items.STICK)
                .unlockedBy(criterionString, criterion)
                .unlockedBy("has_stick", has(Items.STICK))
                .save(recipeOutput, saveID);
    }

    private void craftCustomPickaxe(RecipeOutput recipeOutput, String saveID, Item result, Item ingredient, String criterionString, Criterion<?> criterion){
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, result, 1)
                .pattern("XXX")
                .pattern(" I ")
                .pattern(" I ")
                .define('X', ingredient)
                .define('I', Items.STICK)
                .unlockedBy(criterionString, criterion)
                .unlockedBy("has_stick", has(Items.STICK))
                .save(recipeOutput, saveID);
    }

    private void craftCustomAxe(RecipeOutput recipeOutput, String saveID, Item result, Item ingredient, String criterionString, Criterion<?> criterion){
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, result, 1)
                .pattern("XX")
                .pattern("XI")
                .pattern(" I")
                .define('X', ingredient)
                .define('I', Items.STICK)
                .unlockedBy(criterionString, criterion)
                .unlockedBy("has_stick", has(Items.STICK))
                .save(recipeOutput, saveID);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, result, 1)
                .pattern(" XX")
                .pattern(" IX")
                .pattern(" I ")
                .define('X', ingredient)
                .define('I', Items.STICK)
                .unlockedBy(criterionString, criterion)
                .unlockedBy("has_stick", has(Items.STICK))
                .save(recipeOutput, saveID + "_reversed");
    }

    private void craftCustomShovel(RecipeOutput recipeOutput, String saveID, Item result, Item ingredient, String criterionString, Criterion<?> criterion){
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, result, 1)
                .pattern("X")
                .pattern("I")
                .pattern("I")
                .define('X', ingredient)
                .define('I', Items.STICK)
                .unlockedBy(criterionString, criterion)
                .unlockedBy("has_stick", has(Items.STICK))
                .save(recipeOutput, saveID);
    }

    private void craftCustomHoe(RecipeOutput recipeOutput, String saveID, Item result, Item ingredient, String criterionString, Criterion<?> criterion){
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, result, 1)
                .pattern("XX")
                .pattern(" I")
                .pattern(" I")
                .define('X', ingredient)
                .define('I', Items.STICK)
                .unlockedBy(criterionString, criterion)
                .unlockedBy("has_stick", has(Items.STICK))
                .save(recipeOutput, saveID);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, result, 1)
                .pattern("XX")
                .pattern("I ")
                .pattern("I ")
                .define('X', ingredient)
                .define('I', Items.STICK)
                .unlockedBy(criterionString, criterion)
                .unlockedBy("has_stick", has(Items.STICK))
                .save(recipeOutput, saveID + "_reversed");
    }

// - --------------------------------------------------------------------------------------------------------------------

// - ------------------------------------------ARMOR CRAFT VOIDS-----------------------------------------------------

    private void craftCustomHelmet(RecipeOutput recipeOutput, String saveID, Item result, Item ingredient, String criterionString, Criterion<?> criterion){
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, result, 1)
                .pattern("XXX")
                .pattern("X X")
                .define('X', ingredient)
                .unlockedBy(criterionString, criterion)
                .save(recipeOutput, saveID);
    }

    private void craftCustomChestplate(RecipeOutput recipeOutput, String saveID, Item result, Item ingredient, String criterionString, Criterion<?> criterion){
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, result, 1)
                .pattern("X X")
                .pattern("XXX")
                .pattern("XXX")
                .define('X', ingredient)
                .unlockedBy(criterionString, criterion)
                .save(recipeOutput, saveID);
    }

    private void craftCustomLeggings(RecipeOutput recipeOutput, String saveID, Item result, Item ingredient, String criterionString, Criterion<?> criterion){
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, result, 1)
                .pattern("XXX")
                .pattern("X X")
                .pattern("X X")
                .define('X', ingredient)
                .unlockedBy(criterionString, criterion)
                .save(recipeOutput, saveID);
    }

    private void craftCustomBoots(RecipeOutput recipeOutput, String saveID, Item result, Item ingredient, String criterionString, Criterion<?> criterion){
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, result, 1)
                .pattern("X X")
                .pattern("X X")
                .define('X', ingredient)
                .unlockedBy(criterionString, criterion)
                .save(recipeOutput, saveID);
    }


    private void craft9x9BlockRecipes(RecipeOutput recipeOutput, String saveID, Item item, Block block, String criterionString, Criterion<?> criterion){
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,item, 9)
                .requires(block, 1)
                .unlockedBy(criterionString, criterion)
                .save(recipeOutput, saveID + "from_block");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,block, 1)
                .requires(item, 9)
                .unlockedBy(criterionString, criterion)
                .save(recipeOutput, saveID + "block_from_items");
    }

    private void craftResourceMushroom(RecipeOutput recipeOutput, Block result, Item ingredient, String criterionString, Criterion<?> criterion){
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, result, 1)
                .pattern("XXX")
                .pattern("XOX")
                .pattern("XXX")
                .define('X', ingredient)
                .define('O', SNItems.NEXUS_FUNGUS)
                .unlockedBy("has_nexus_fungus", has(SNItems.NEXUS_FUNGUS))
                .unlockedBy(criterionString, criterion)
                .save(recipeOutput);
    }
    private void craftGreatResourceMushroom(RecipeOutput recipeOutput, Block result, Item ingredient, String criterionString, Criterion<?> criterion){
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, result, 1)
                .pattern("XXX")
                .pattern("XOX")
                .pattern("XXX")
                .define('X', ingredient)
                .define('O', SNItems.GREAT_FUNGUS)
                .unlockedBy("has_great_fungus", has(SNItems.GREAT_FUNGUS))
                .unlockedBy(criterionString, criterion)
                .save(recipeOutput);
    }
    private void craftInfernalResourceMushroom(RecipeOutput recipeOutput, Block result, Item ingredient, String criterionString, Criterion<?> criterion){
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, result, 1)
                .pattern("XXX")
                .pattern("XOX")
                .pattern("XXX")
                .define('X', ingredient)
                .define('O', SNItems.INFERNAL_FUNGUS)
                .unlockedBy("has_infernal_fungus", has(SNItems.INFERNAL_FUNGUS))
                .unlockedBy(criterionString, criterion)
                .save(recipeOutput);
    }
    private void craftEtherealResourceMushroom(RecipeOutput recipeOutput, Block result, Item ingredient, String criterionString, Criterion<?> criterion){
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, result, 1)
                .pattern("XXX")
                .pattern("XOX")
                .pattern("XXX")
                .define('X', ingredient)
                .define('O', SNItems.ETHEREAL_FUNGUS)
                .unlockedBy("has_ethereal_fungus", has(SNItems.ETHEREAL_FUNGUS))
                .unlockedBy(criterionString, criterion)
                .save(recipeOutput);
    }



}
