package net.okamiz.sporenexus.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
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


        //FERTILIZED MYCELIUM

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, SNBlocks.FERTILIZED_MYCELIUM, 1)
                .pattern("SSS")
                .pattern("SMS")
                .pattern("SSS")
                .define('S', SNItems.MUSHROOM_SPORES)
                .define('M', Blocks.MYCELIUM)
                .unlockedBy("has_mushroom_spores", has(SNItems.MUSHROOM_SPORES))
                .unlockedBy("has_mycelium", has(Blocks.MYCELIUM))
                .save(recipeOutput);

        //RESOURCES MUSHROOMS

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, SNBlocks.COAL_MUSHROOM, 1)
                .pattern("XXX")
                .pattern("XOX")
                .pattern("XXX")
                .define('X', Items.COAL)
                .define('O', SNItems.NEXUS_FUNGUS)
                .unlockedBy("has_nexus_fungus", has(SNItems.NEXUS_FUNGUS))
                .unlockedBy("has_coal", has(Items.COAL))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, SNBlocks.LAPIS_LAZULI_MUSHROOM, 1)
                .pattern("XXX")
                .pattern("XOX")
                .pattern("XXX")
                .define('X', Items.LAPIS_LAZULI)
                .define('O', SNItems.NEXUS_FUNGUS)
                .unlockedBy("has_nexus_fungus", has(SNItems.NEXUS_FUNGUS))
                .unlockedBy("has_lapis_lazuli", has(Items.LAPIS_LAZULI))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, SNBlocks.QUARTZ_MUSHROOM, 1)
                .pattern("XXX")
                .pattern("XOX")
                .pattern("XXX")
                .define('X', Items.QUARTZ)
                .define('O', SNItems.NEXUS_FUNGUS)
                .unlockedBy("has_nexus_fungus", has(SNItems.NEXUS_FUNGUS))
                .unlockedBy("has_quartz", has(Items.QUARTZ))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, SNBlocks.REDSTONE_MUSHROOM, 1)
                .pattern("XXX")
                .pattern("XOX")
                .pattern("XXX")
                .define('X', Items.REDSTONE)
                .define('O', SNItems.NEXUS_FUNGUS)
                .unlockedBy("has_nexus_fungus", has(SNItems.NEXUS_FUNGUS))
                .unlockedBy("has_redstone", has(Items.REDSTONE))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, SNBlocks.IRON_MUSHROOM, 1)
                .pattern("XXX")
                .pattern("XOX")
                .pattern("XXX")
                .define('X', Items.IRON_INGOT)
                .define('O', SNItems.NEXUS_FUNGUS)
                .unlockedBy("has_nexus_fungus", has(SNItems.NEXUS_FUNGUS))
                .unlockedBy("has_iron", has(Items.IRON_INGOT))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, SNBlocks.COPPER_MUSHROOM, 1)
                .pattern("XXX")
                .pattern("XOX")
                .pattern("XXX")
                .define('X', Items.COPPER_INGOT)
                .define('O', SNItems.NEXUS_FUNGUS)
                .unlockedBy("has_nexus_fungus", has(SNItems.NEXUS_FUNGUS))
                .unlockedBy("has_copper", has(Items.COPPER_INGOT))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, SNBlocks.GOLD_MUSHROOM, 1)
                .pattern("XXX")
                .pattern("XOX")
                .pattern("XXX")
                .define('X', Items.GOLD_INGOT)
                .define('O', SNItems.NEXUS_FUNGUS)
                .unlockedBy("has_nexus_fungus", has(SNItems.NEXUS_FUNGUS))
                .unlockedBy("has_gold", has(Items.GOLD_INGOT))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, SNBlocks.DIAMOND_MUSHROOM, 1)
                .pattern("XXX")
                .pattern("XOX")
                .pattern("XXX")
                .define('X', Items.DIAMOND)
                .define('O', SNItems.NEXUS_FUNGUS)
                .unlockedBy("has_nexus_fungus", has(SNItems.NEXUS_FUNGUS))
                .unlockedBy("has_diamond", has(Items.DIAMOND))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, SNBlocks.EMERALD_MUSHROOM, 1)
                .pattern("XXX")
                .pattern("XOX")
                .pattern("XXX")
                .define('X', Items.EMERALD)
                .define('O', SNItems.NEXUS_FUNGUS)
                .unlockedBy("has_nexus_fungus", has(SNItems.NEXUS_FUNGUS))
                .unlockedBy("has_emerald", has(Items.EMERALD))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, SNBlocks.NETHERITE_MUSHROOM, 1)
                .pattern("XXX")
                .pattern("XOX")
                .pattern("XXX")
                .define('X', Items.NETHERITE_SCRAP)
                .define('O', SNItems.NEXUS_FUNGUS)
                .unlockedBy("has_nexus_fungus", has(SNItems.NEXUS_FUNGUS))
                .unlockedBy("has_netherite", has(Items.NETHERITE_SCRAP))
                .save(recipeOutput);



        // FRAGMENTS TO ORES

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
}
