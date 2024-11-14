package net.okamiz.sporenexus.block;

import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.okamiz.sporenexus.SporeNexusMod;
import net.okamiz.sporenexus.block.custom.*;
import net.okamiz.sporenexus.item.SNItems;
import net.okamiz.sporenexus.util.SNDustParticleOptions;

import java.util.function.Supplier;

public class SNBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(SporeNexusMod.MOD_ID);



    // ------------------------------------------- LEVEL 1 MUSHROOMS ---------------------------------------------------

    // -- BLOCKS MUSHROOMS
    public static final DeferredBlock<Block> DIRT_MUSHROOM = registerBlock("dirt_mushroom",
            () -> new ResourcesMushroomBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MUSHROOM_STEM)
                    .noOcclusion().randomTicks().pushReaction(PushReaction.DESTROY), SNItems.DIRT_FRAGMENTS, null));
    public static final DeferredBlock<Block> GRAVEL_MUSHROOM = registerBlock("gravel_mushroom",
            () -> new ResourcesMushroomBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MUSHROOM_STEM)
                    .noOcclusion().randomTicks().pushReaction(PushReaction.DESTROY), SNItems.GRAVEL_FRAGMENTS, null));
    public static final DeferredBlock<Block> SAND_MUSHROOM = registerBlock("sand_mushroom",
            () -> new ResourcesMushroomBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MUSHROOM_STEM)
                    .noOcclusion().randomTicks().pushReaction(PushReaction.DESTROY), SNItems.SAND_FRAGMENTS, null));
    public static final DeferredBlock<Block> CLAY_MUSHROOM = registerBlock("clay_mushroom",
            () -> new ResourcesMushroomBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MUSHROOM_STEM)
                    .noOcclusion().randomTicks().pushReaction(PushReaction.DESTROY), SNItems.CLAY_FRAGMENTS, null));
    public static final DeferredBlock<Block> STONE_MUSHROOM = registerBlock("stone_mushroom",
            () -> new ResourcesMushroomBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MUSHROOM_STEM)
                    .noOcclusion().randomTicks().pushReaction(PushReaction.DESTROY), SNItems.STONE_FRAGMENTS, SNItems.MOSSY_COBBLESTONE_FRAGMENTS));

    // -- ORES MUSHROOMS
    public static final DeferredBlock<Block> COAL_MUSHROOM = registerBlock("coal_mushroom",
            () -> new ResourcesMushroomBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MUSHROOM_STEM)
                    .noOcclusion().randomTicks().pushReaction(PushReaction.DESTROY), SNItems.COAL_FRAGMENTS, null));
    public static final DeferredBlock<Block> IRON_MUSHROOM = registerBlock("iron_mushroom",
            () -> new ResourcesMushroomBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MUSHROOM_STEM)
                    .noOcclusion().randomTicks().pushReaction(PushReaction.DESTROY), SNItems.IRON_FRAGMENTS, null));
    public static final DeferredBlock<Block> COPPER_MUSHROOM = registerBlock("copper_mushroom",
            () -> new ResourcesMushroomBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MUSHROOM_STEM)
                    .noOcclusion().randomTicks().pushReaction(PushReaction.DESTROY), SNItems.COPPER_FRAGMENTS, null));



    // ------------------------------------------- LEVEL 2 MUSHROOMS ---------------------------------------------------

    // -- BLOCKS MUSHROOMS
    public static final DeferredBlock<Block> ICE_MUSHROOM = registerBlock("ice_mushroom",
            () -> new ResourcesMushroomBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MUSHROOM_STEM)
                    .noOcclusion().randomTicks().pushReaction(PushReaction.DESTROY), SNItems.ICE_FRAGMENTS, null));


    // -- ORES MUSHROOMS
    public static final DeferredBlock<Block> REDSTONE_MUSHROOM = registerBlock("redstone_mushroom",
            () -> new ResourcesMushroomBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MUSHROOM_STEM)
                    .noOcclusion().randomTicks().pushReaction(PushReaction.DESTROY), SNItems.REDSTONE_FRAGMENTS, null));
    public static final DeferredBlock<Block> LAPIS_LAZULI_MUSHROOM = registerBlock("lapis_lazuli_mushroom",
            () -> new ResourcesMushroomBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MUSHROOM_STEM)
                    .noOcclusion().randomTicks().pushReaction(PushReaction.DESTROY), SNItems.LAPIS_LAZULI_FRAGMENTS, null));
    public static final DeferredBlock<Block> GOLD_MUSHROOM = registerBlock("gold_mushroom",
            () -> new ResourcesMushroomBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MUSHROOM_STEM)
                    .noOcclusion().randomTicks().pushReaction(PushReaction.DESTROY), SNItems.GOLD_FRAGMENTS, null));
    public static final DeferredBlock<Block> FUNGALSTEEL_MUSHROOM = registerBlock("fungalsteel_mushroom",
            () -> new ResourcesMushroomBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MUSHROOM_STEM)
                    .noOcclusion().randomTicks().pushReaction(PushReaction.DESTROY), SNItems.FUNGALSTEEL_FRAGMENTS, null));

    // ------------------------------------------- LEVEL 3 MUSHROOMS ---------------------------------------------------

    // -- BLOCKS MUSHROOMS
    public static final DeferredBlock<Block> BLACKSTONE_MUSHROOM = registerBlock("blackstone_mushroom",
            () -> new ResourcesMushroomBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MUSHROOM_STEM)
                    .noOcclusion().randomTicks().pushReaction(PushReaction.DESTROY), SNItems.BLACKSTONE_FRAGMENTS, null));
    public static final DeferredBlock<Block> GLOWSTONE_MUSHROOM = registerBlock("glowstone_mushroom",
            () -> new ResourcesMushroomBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MUSHROOM_STEM)
                    .noOcclusion().randomTicks().pushReaction(PushReaction.DESTROY), SNItems.GLOWSTONE_FRAGMENTS, null));
    public static final DeferredBlock<Block> NETHERRACK_MUSHROOM = registerBlock("netherrack_mushroom",
            () -> new ResourcesMushroomBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MUSHROOM_STEM)
                    .noOcclusion().randomTicks().pushReaction(PushReaction.DESTROY), SNItems.NETHERRACK_FRAGMENTS, null));
    public static final DeferredBlock<Block> SOUL_SAND_MUSHROOM = registerBlock("soul_sand_mushroom",
            () -> new ResourcesMushroomBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MUSHROOM_STEM)
                    .noOcclusion().randomTicks().pushReaction(PushReaction.DESTROY), SNItems.SOUL_SAND_FRAGMENTS, null));

    // -- ORES MUSHROOMS
    public static final DeferredBlock<Block> QUARTZ_MUSHROOM = registerBlock("quartz_mushroom",
            () -> new ResourcesMushroomBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MUSHROOM_STEM)
                    .noOcclusion().randomTicks().pushReaction(PushReaction.DESTROY), SNItems.QUARTZ_FRAGMENTS, null));
    public static final DeferredBlock<Block> DIAMOND_MUSHROOM = registerBlock("diamond_mushroom",
            () -> new ResourcesMushroomBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MUSHROOM_STEM)
                    .noOcclusion().randomTicks().pushReaction(PushReaction.DESTROY), SNItems.DIAMOND_FRAGMENTS, null));



    // ------------------------------------------- LEVEL 4 MUSHROOMS ---------------------------------------------------



    // -- ORES MUSHROOMS
    public static final DeferredBlock<Block> EMERALD_MUSHROOM = registerBlock("emerald_mushroom",
            () -> new ResourcesMushroomBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MUSHROOM_STEM)
                    .noOcclusion().randomTicks().pushReaction(PushReaction.DESTROY), SNItems.EMERALD_FRAGMENTS, null));
    public static final DeferredBlock<Block> NETHERITE_MUSHROOM = registerBlock("netherite_mushroom",
            () -> new ResourcesMushroomBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MUSHROOM_STEM)
                    .noOcclusion().randomTicks().pushReaction(PushReaction.DESTROY), SNItems.NETHERITE_FRAGMENTS, null));

    // ------------------------------------------- ///////////////// ---------------------------------------------------

    public static final DeferredBlock<Block> FUNGAL_DIAMOND_BLOCK = registerBlock("fungal_diamond_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_BLOCK)));



    public static final DeferredBlock<Block> FUNGALSTEEL_BLOCK = registerBlock("fungalsteel_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)));

    public static final DeferredBlock<Block> MUSHROOM_COLLECTOR = registerBlock("mushroom_collector",
            () -> new MushroomCollectorBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)));

    public static final DeferredBlock<Block> FUNGAL_LANTERN = registerBlock("fungal_lantern",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SHROOMLIGHT)));


    //MACHINES
    public static final DeferredBlock<Block> SPORE_SPREADER = registerBlock("spore_spreader",
            () -> new SporeSpreader(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).randomTicks()));
    public static final DeferredBlock<Block> FUNGAL_PROPAGATOR = registerBlock("fungal_propagator",
            () -> new FungalPropagator(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).randomTicks()));

    //TOTEMS---------------------------
    public static final DeferredBlock<Block> REGENERATION_TOTEM = registerBlock("regeneration_totem",
            () -> new TotemBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ANDESITE).randomTicks().noOcclusion(),
                    MobEffects.REGENERATION, DustParticleOptions.REDSTONE));
    public static final DeferredBlock<Block> NIGHT_VISION_TOTEM = registerBlock("night_vision_totem",
            () -> new TotemBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ANDESITE).randomTicks().noOcclusion(),
                    MobEffects.NIGHT_VISION, SNDustParticleOptions.NIGHT_VISION));
    public static final DeferredBlock<Block> FIRE_RESISTANCE_TOTEM = registerBlock("fire_resistance_totem",
            () -> new TotemBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ANDESITE).randomTicks().noOcclusion(),
                    MobEffects.FIRE_RESISTANCE, SNDustParticleOptions.FIRE_RESISTANCE));
    public static final DeferredBlock<Block> HASTE_TOTEM = registerBlock("haste_totem",
            () -> new TotemBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ANDESITE).randomTicks().noOcclusion(),
                    MobEffects.DIG_SPEED, SNDustParticleOptions.HASTE));

    //----------------------------------

    public static final DeferredBlock<Block> FERTILIZED_MYCELIUM = registerBlock("fertilized_mycelium",
            () -> new FertilizedMycelium(BlockBehaviour.Properties.ofFullCopy(Blocks.MYCELIUM)));
    public static final DeferredBlock<Block> ENRICHED_MYCELIUM = registerBlock("enriched_mycelium",
            () -> new EnrichedMycelium(BlockBehaviour.Properties.ofFullCopy(Blocks.MYCELIUM)));


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
