package net.okamiz.sporenexus.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import java.util.concurrent.CompletableFuture;

public class SNRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public SNRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {

        /*
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, SNBlocks.BLOCK, 8)
                .pattern("QQQ")
                .pattern("QEQ")
                .pattern("QQQ")
                .define('Q', Blocks.QUARTZ_BLOCK)
                .define('E', Items.HONEYCOMB)
                .unlockedBy("has_honeycomb", has(Items.HONEYCOMB))
                .unlockedBy("has_quartz_block", has(Blocks.QUARTZ_BLOCK))
                .save(recipeOutput);
        */

    }
}
