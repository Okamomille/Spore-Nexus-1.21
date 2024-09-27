package net.okamiz.sporenexus.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
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

    public static final DeferredBlock<Block> COAL_MUSHROOM = registerBlock("coal_mushroom",
            () -> new ResourcesMushroomBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MUSHROOM_STEM)
                    .noOcclusion().randomTicks().pushReaction(PushReaction.DESTROY), Items.COAL));
    public static final DeferredBlock<Block> LAPIS_LAZULI_MUSHROOM = registerBlock("lapis_lazuli_mushroom",
            () -> new ResourcesMushroomBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MUSHROOM_STEM)
                    .noOcclusion().randomTicks().pushReaction(PushReaction.DESTROY), Items.LAPIS_LAZULI));
    public static final DeferredBlock<Block> QUARTZ_MUSHROOM = registerBlock("quartz_mushroom",
            () -> new ResourcesMushroomBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MUSHROOM_STEM)
                    .noOcclusion().randomTicks().pushReaction(PushReaction.DESTROY), Items.QUARTZ));
    public static final DeferredBlock<Block> REDSTONE_MUSHROOM = registerBlock("redstone_mushroom",
            () -> new ResourcesMushroomBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MUSHROOM_STEM)
                    .noOcclusion().randomTicks().pushReaction(PushReaction.DESTROY), Items.REDSTONE));
    public static final DeferredBlock<Block> IRON_MUSHROOM = registerBlock("iron_mushroom",
            () -> new ResourcesMushroomBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MUSHROOM_STEM)
                    .noOcclusion().randomTicks().pushReaction(PushReaction.DESTROY), Items.RAW_IRON));
    public static final DeferredBlock<Block> COPPER_MUSHROOM = registerBlock("copper_mushroom",
            () -> new ResourcesMushroomBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MUSHROOM_STEM)
                    .noOcclusion().randomTicks().pushReaction(PushReaction.DESTROY), Items.RAW_COPPER));
    public static final DeferredBlock<Block> GOLD_MUSHROOM = registerBlock("gold_mushroom",
            () -> new ResourcesMushroomBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MUSHROOM_STEM)
                    .noOcclusion().randomTicks().pushReaction(PushReaction.DESTROY), Items.RAW_GOLD));
    public static final DeferredBlock<Block> DIAMOND_MUSHROOM = registerBlock("diamond_mushroom",
            () -> new ResourcesMushroomBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MUSHROOM_STEM)
                    .noOcclusion().randomTicks().pushReaction(PushReaction.DESTROY), Items.DIAMOND));
    public static final DeferredBlock<Block> EMERALD_MUSHROOM = registerBlock("emerald_mushroom",
            () -> new ResourcesMushroomBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MUSHROOM_STEM)
                    .noOcclusion().randomTicks().pushReaction(PushReaction.DESTROY), Items.EMERALD));
    public static final DeferredBlock<Block> NETHERITE_MUSHROOM = registerBlock("netherite_mushroom",
            () -> new ResourcesMushroomBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MUSHROOM_STEM)
                    .noOcclusion().randomTicks().pushReaction(PushReaction.DESTROY), Items.NETHERITE_SCRAP));




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
