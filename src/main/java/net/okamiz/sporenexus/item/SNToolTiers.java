package net.okamiz.sporenexus.item;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;
import net.okamiz.sporenexus.util.SNTags;

public class SNToolTiers {
    public static final Tier FUNGAL_DIAMOND = new SimpleTier(SNTags.Blocks.INCORRECT_FOR_FUNGAL_DIAMOND_TOOL,
            1653, 8.3f, 3.3f, 12,
            () -> Ingredient.of(SNItems.FUNGAL_DIAMOND.get()));
}
