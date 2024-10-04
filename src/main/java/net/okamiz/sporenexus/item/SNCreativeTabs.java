package net.okamiz.sporenexus.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.okamiz.sporenexus.SporeNexusMod;
import net.okamiz.sporenexus.block.SNBlocks;

import java.util.function.Supplier;

public class SNCreativeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SporeNexusMod.MOD_ID);

    public static final Supplier<CreativeModeTab> SPORE_NEXUS_TAB =
            CREATIVE_MODE_TABS.register("sporenexus_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemgroup.sporenexus.sporenexus_tab"))
                    .icon(() -> new ItemStack(SNBlocks.DIRT_MUSHROOM))
                    .displayItems((itemDisplayParameters, output) -> {

                        output.accept(SNItems.NEXUS_FUNGUS);
                        output.accept(SNItems.GREAT_FUNGUS);
                        output.accept(SNItems.INFERNAL_FUNGUS);
                        output.accept(SNItems.ETHEREAL_FUNGUS);

                        output.accept(SNItems.FUNGAL_ESSENCE);
                        output.accept(SNItems.INFERNAL_ESSENCE);
                        output.accept(SNItems.ETHEREAL_ESSENCE);

                        output.accept(SNItems.MUSHROOM_SPORES);
                        output.accept(SNItems.MUSHROOM_CAP);
                        output.accept(SNItems.SPORE_RELIC);

                        output.accept(SNItems.FUNGAL_POWDER);
                        output.accept(SNItems.FUNGALSTEEL_INGOT);

            // ------------------------------------------- LEVEL 1 FRAGMENTS ---------------------------------------------------

            // -- BLOCKS FRAGMENTS

                        output.accept(SNItems.DIRT_FRAGMENTS);
                        output.accept(SNItems.GRAVEL_FRAGMENTS);
                        output.accept(SNItems.SAND_FRAGMENTS);
                        output.accept(SNItems.CLAY_FRAGMENTS);
                        output.accept(SNItems.STONE_FRAGMENTS);
                        output.accept(SNItems.MOSSY_COBBLESTONE_FRAGMENTS);

            // -- ORES FRAGMENTS

                        output.accept(SNItems.COAL_FRAGMENTS);
                        output.accept(SNItems.IRON_FRAGMENTS);
                        output.accept(SNItems.COPPER_FRAGMENTS);


            // ------------------------------------------- LEVEL 2 FRAGMENTS ---------------------------------------------------

            // -- BLOCKS FRAGMENTS



            // -- ORES FRAGMENTS

                        output.accept(SNItems.REDSTONE_FRAGMENTS);
                        output.accept(SNItems.LAPIS_LAZULI_FRAGMENTS);
                        output.accept(SNItems.GOLD_FRAGMENTS);
                        output.accept(SNItems.FUNGALSTEEL_FRAGMENTS);


            // ------------------------------------------- LEVEL 3 FRAGMENTS ---------------------------------------------------

            // -- BLOCKS FRAGMENTS



            // -- ORES FRAGMENTS

                        output.accept(SNItems.QUARTZ_FRAGMENTS);
                        output.accept(SNItems.DIAMOND_FRAGMENTS);


            // ------------------------------------------- LEVEL 4 FRAGMENTS ---------------------------------------------------

            // -- BLOCKS FRAGMENTS



            // -- ORES FRAGMENTS
                        output.accept(SNItems.EMERALD_FRAGMENTS);
                        output.accept(SNItems.NETHERITE_FRAGMENTS);

            // ------------------------------------------- ////////////////// ---------------------------------------------------

            // ------------------------------------------- LEVEL 1 MUSHROOMS ---------------------------------------------------

                        output.accept(SNBlocks.DIRT_MUSHROOM);
                        output.accept(SNBlocks.GRAVEL_MUSHROOM);
                        output.accept(SNBlocks.SAND_MUSHROOM);
                        output.accept(SNBlocks.CLAY_MUSHROOM);
                        output.accept(SNBlocks.STONE_MUSHROOM);

                        output.accept(SNBlocks.COAL_MUSHROOM);
                        output.accept(SNBlocks.IRON_MUSHROOM);
                        output.accept(SNBlocks.COPPER_MUSHROOM);

            // ------------------------------------------- LEVEL 2 MUSHROOMS ---------------------------------------------------

                        output.accept(SNBlocks.REDSTONE_MUSHROOM);
                        output.accept(SNBlocks.LAPIS_LAZULI_MUSHROOM);
                        output.accept(SNBlocks.GOLD_MUSHROOM);
                        output.accept(SNBlocks.FUNGALSTEEL_MUSHROOM);

            // ------------------------------------------- LEVEL 3 MUSHROOMS ---------------------------------------------------

                        output.accept(SNBlocks.QUARTZ_MUSHROOM);
                        output.accept(SNBlocks.DIAMOND_MUSHROOM);

            // ------------------------------------------- LEVEL 4 MUSHROOMS ---------------------------------------------------

                        output.accept(SNBlocks.EMERALD_MUSHROOM);
                        output.accept(SNBlocks.NETHERITE_MUSHROOM);

            // ------------------------------------------- ////////////////// ---------------------------------------------------


                        output.accept(SNBlocks.FERTILIZED_MYCELIUM);
                        output.accept(SNBlocks.ENRICHED_MYCELIUM);

                        output.accept(SNBlocks.FUNGAL_LANTERN);
                        output.accept(SNBlocks.FUNGALSTEEL_BLOCK);
                        output.accept(SNBlocks.SPORE_SPREADER);
                        output.accept(SNBlocks.FUNGAL_PROPAGATOR);
                        output.accept(SNBlocks.MUSHROOM_COLLECTOR);

                        output.accept(SNBlocks.REGENERATION_TOTEM);
                        output.accept(SNBlocks.NIGHT_VISION_TOTEM);
                        output.accept(SNBlocks.HASTE_TOTEM);
                        output.accept(SNBlocks.FIRE_RESISTANCE_TOTEM);

                    })
                    .build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
