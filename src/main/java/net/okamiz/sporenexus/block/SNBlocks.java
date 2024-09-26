package net.okamiz.sporenexus.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.okamiz.sporenexus.SporeNexusMod;
import net.okamiz.sporenexus.block.custom.ResourcesMushroomBlock;
import net.okamiz.sporenexus.item.SNItems;

import java.util.function.Supplier;

public class SNBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(SporeNexusMod.MOD_ID);


    public static final DeferredBlock<Block> IRON_MUSHROOM = registerBlock("iron_mushroom",
            () -> new ResourcesMushroomBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MUSHROOM_STEM)
                    .noOcclusion()
                    .randomTicks()
                    .pushReaction(PushReaction.DESTROY), Items.RAW_IRON));

    public static final DeferredBlock<Block> FERTILIZED_MYCELIUM = registerBlock("fertilized_mycelium",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MYCELIUM)));


    private static <T extends Block>DeferredBlock<T> registerBlock(String name, Supplier<T> block){
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        SNItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
