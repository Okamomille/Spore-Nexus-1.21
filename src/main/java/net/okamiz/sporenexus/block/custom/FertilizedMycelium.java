package net.okamiz.sporenexus.block.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.block.Block;

import java.util.List;

public class FertilizedMycelium extends MyceliumSoilBlock {

    public FertilizedMycelium(Properties properties) {
        super(properties);
    }




    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable("tooltip.sporenexus.fertilized_mycelium"));
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
