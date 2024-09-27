package net.okamiz.sporenexus.block.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class EnrichedMycelium extends FertilizedMycelium {
    public EnrichedMycelium(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {

        tooltipComponents.add(Component.translatable("tooltip.sporenexus.enriched_mycelium"));

        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
