package net.okamiz.sporenexus.item;

import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.okamiz.sporenexus.SporeNexusMod;
import net.okamiz.sporenexus.item.custom.SporeRelicItem;
import net.okamiz.sporenexus.item.custom.WIPItem;

import java.util.function.Supplier;

public class SNItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(SporeNexusMod.MOD_ID);

    public static final DeferredItem<Item> MUSHROOM_CAP = ITEMS.registerItem("mushroom_cap",
            WIPItem::new, new Item.Properties());
    public static final DeferredItem<Item> SPORE_RELIC = ITEMS.registerItem("spore_relic",
            SporeRelicItem::new, new Item.Properties());


    public static final DeferredItem<Item> FUNGAL_POWDER = ITEMS.registerSimpleItem("fungal_powder");
    public static final DeferredItem<Item> FUNGALSTEEL_INGOT = ITEMS.registerSimpleItem("fungalsteel_ingot");
    public static final DeferredItem<Item> MUSHROOM_SPORES = ITEMS.registerSimpleItem("mushroom_spores");

    public static final DeferredItem<Item> NEXUS_FUNGUS = ITEMS.registerSimpleItem("nexus_fungus");
    public static final DeferredItem<Item> GREAT_FUNGUS = ITEMS.registerSimpleItem("great_fungus");
    public static final DeferredItem<Item> INFERNAL_FUNGUS = ITEMS.registerSimpleItem("infernal_fungus");
    public static final DeferredItem<Item> ETHEREAL_FUNGUS = ITEMS.registerSimpleItem("ethereal_fungus");

    public static final DeferredItem<Item> FUNGAL_ESSENCE = ITEMS.registerSimpleItem("fungal_essence");
    public static final DeferredItem<Item> INFERNAL_ESSENCE = ITEMS.registerSimpleItem("infernal_essence");
    public static final DeferredItem<Item> ETHEREAL_ESSENCE = ITEMS.registerSimpleItem("ethereal_essence");

    public static final DeferredItem<Item> FUNGAL_DIAMOND = ITEMS.registerSimpleItem("fungal_diamond");
    public static final DeferredItem<Item> INFERNAL_DIAMOND = ITEMS.registerSimpleItem("infernal_diamond");
    public static final DeferredItem<Item> ETHEREAL_DIAMOND = ITEMS.registerSimpleItem("ethereal_diamond");





    // ------------------------------------------- LEVEL 1 FRAGMENTS ---------------------------------------------------

    // -- BLOCKS FRAGMENTS
    public static final DeferredItem<Item> DIRT_FRAGMENTS = ITEMS.registerSimpleItem("dirt_fragments");
    public static final DeferredItem<Item> GRAVEL_FRAGMENTS = ITEMS.registerSimpleItem("gravel_fragments");
    public static final DeferredItem<Item> SAND_FRAGMENTS = ITEMS.registerSimpleItem("sand_fragments");
    public static final DeferredItem<Item> CLAY_FRAGMENTS = ITEMS.registerSimpleItem("clay_fragments");
    public static final DeferredItem<Item> STONE_FRAGMENTS = ITEMS.registerSimpleItem("stone_fragments");
    public static final DeferredItem<Item> MOSSY_COBBLESTONE_FRAGMENTS = ITEMS.registerSimpleItem("mossy_cobblestone_fragments");

    // -- ORES FRAGMENTS
    public static final DeferredItem<Item> COAL_FRAGMENTS = ITEMS.registerSimpleItem("coal_fragments");
    public static final DeferredItem<Item> IRON_FRAGMENTS = ITEMS.registerSimpleItem("iron_fragments");
    public static final DeferredItem<Item> COPPER_FRAGMENTS = ITEMS.registerSimpleItem("copper_fragments");




    // ------------------------------------------- LEVEL 2 FRAGMENTS ---------------------------------------------------

    // -- BLOCKS FRAGMENTS
    public static final DeferredItem<Item> ICE_FRAGMENTS = ITEMS.registerSimpleItem("ice_fragments");


    // -- ORES FRAGMENTS
    public static final DeferredItem<Item> REDSTONE_FRAGMENTS = ITEMS.registerSimpleItem("redstone_fragments");
    public static final DeferredItem<Item> GOLD_FRAGMENTS = ITEMS.registerSimpleItem("gold_fragments");
    public static final DeferredItem<Item> FUNGALSTEEL_FRAGMENTS = ITEMS.registerSimpleItem("fungalsteel_fragments");
    public static final DeferredItem<Item> LAPIS_LAZULI_FRAGMENTS = ITEMS.registerSimpleItem("lapis_lazuli_fragments");



    // ------------------------------------------- LEVEL 3 FRAGMENTS ---------------------------------------------------

    // -- BLOCKS FRAGMENTS
    public static final DeferredItem<Item> BLACKSTONE_FRAGMENTS = ITEMS.registerSimpleItem("blackstone_fragments");
    public static final DeferredItem<Item> GLOWSTONE_FRAGMENTS = ITEMS.registerSimpleItem("glowstone_fragments");
    public static final DeferredItem<Item> NETHERRACK_FRAGMENTS = ITEMS.registerSimpleItem("netherrack_fragments");
    public static final DeferredItem<Item> SOUL_SAND_FRAGMENTS = ITEMS.registerSimpleItem("soul_sand_fragments");

    // -- ORES FRAGMENTS
    public static final DeferredItem<Item> QUARTZ_FRAGMENTS = ITEMS.registerSimpleItem("quartz_fragments");
    public static final DeferredItem<Item> DIAMOND_FRAGMENTS = ITEMS.registerSimpleItem("diamond_fragments");



    // ------------------------------------------- LEVEL 4 FRAGMENTS ---------------------------------------------------



    // -- ORES FRAGMENTS
    public static final DeferredItem<Item> EMERALD_FRAGMENTS = ITEMS.registerSimpleItem("emerald_fragments");
    public static final DeferredItem<Item> NETHERITE_FRAGMENTS = ITEMS.registerSimpleItem("netherite_fragments");








    // ------------------------------------------- FUNGAL TOOLS ---------------------------------------------------

    public static final DeferredItem<Item> FUNGAL_DIAMOND_SWORD = ITEMS.register("fungal_diamond_sword",
            ()-> new SwordItem(SNToolTiers.FUNGAL_DIAMOND, new Item.Properties()
                    .attributes(SwordItem.createAttributes(SNToolTiers.FUNGAL_DIAMOND, 3, -2.4f))));
    public static final DeferredItem<Item> FUNGAL_DIAMOND_PICKAXE = ITEMS.register("fungal_diamond_pickaxe",
            ()-> new PickaxeItem(SNToolTiers.FUNGAL_DIAMOND, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(SNToolTiers.FUNGAL_DIAMOND, 1, -2.8f))));
    public static final DeferredItem<Item> FUNGAL_DIAMOND_AXE = ITEMS.register("fungal_diamond_axe",
            ()-> new AxeItem(SNToolTiers.FUNGAL_DIAMOND, new Item.Properties()
                    .attributes(AxeItem.createAttributes(SNToolTiers.FUNGAL_DIAMOND, 5f, -3.0f))));
    public static final DeferredItem<Item> FUNGAL_DIAMOND_SHOVEL = ITEMS.register("fungal_diamond_shovel",
            ()-> new ShovelItem(SNToolTiers.FUNGAL_DIAMOND, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(SNToolTiers.FUNGAL_DIAMOND, 1.5f, -3.0f))));
    public static final DeferredItem<Item> FUNGAL_DIAMOND_HOE = ITEMS.register("fungal_diamond_hoe",
            ()-> new HoeItem(SNToolTiers.FUNGAL_DIAMOND, new Item.Properties()
                    .attributes(HoeItem.createAttributes(SNToolTiers.FUNGAL_DIAMOND, -3.0f, 0f))));


    // ------------------------------------------- INFERNAL TOOLS ---------------------------------------------------

    public static final DeferredItem<Item> INFERNAL_DIAMOND_SWORD = ITEMS.register("infernal_diamond_sword",
            ()-> new SwordItem(SNToolTiers.INFERNAL_DIAMOND, new Item.Properties()
                    .attributes(SwordItem.createAttributes(SNToolTiers.INFERNAL_DIAMOND, 3, -2.4f))));
    public static final DeferredItem<Item> INFERNAL_DIAMOND_PICKAXE = ITEMS.register("infernal_diamond_pickaxe",
            ()-> new PickaxeItem(SNToolTiers.INFERNAL_DIAMOND, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(SNToolTiers.INFERNAL_DIAMOND, 1, -2.8f))));
    public static final DeferredItem<Item> INFERNAL_DIAMOND_AXE = ITEMS.register("infernal_diamond_axe",
            ()-> new AxeItem(SNToolTiers.INFERNAL_DIAMOND, new Item.Properties()
                    .attributes(AxeItem.createAttributes(SNToolTiers.INFERNAL_DIAMOND, 5f, -3.0f))));
    public static final DeferredItem<Item> INFERNAL_DIAMOND_SHOVEL = ITEMS.register("infernal_diamond_shovel",
            ()-> new ShovelItem(SNToolTiers.INFERNAL_DIAMOND, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(SNToolTiers.INFERNAL_DIAMOND, 1.5f, -3.0f))));
    public static final DeferredItem<Item> INFERNAL_DIAMOND_HOE = ITEMS.register("infernal_diamond_hoe",
            ()-> new HoeItem(SNToolTiers.INFERNAL_DIAMOND, new Item.Properties()
                    .attributes(HoeItem.createAttributes(SNToolTiers.INFERNAL_DIAMOND, -3.0f, 0f))));


    // ------------------------------------------- ETHEREAL TOOLS ---------------------------------------------------

    public static final DeferredItem<Item> ETHEREAL_DIAMOND_SWORD = ITEMS.register("ethereal_diamond_sword",
            ()-> new SwordItem(SNToolTiers.ETHEREAL_DIAMOND, new Item.Properties()
                    .attributes(SwordItem.createAttributes(SNToolTiers.ETHEREAL_DIAMOND, 3, -2.4f))));
    public static final DeferredItem<Item> ETHEREAL_DIAMOND_PICKAXE = ITEMS.register("ethereal_diamond_pickaxe",
            ()-> new PickaxeItem(SNToolTiers.ETHEREAL_DIAMOND, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(SNToolTiers.ETHEREAL_DIAMOND, 1, -2.8f))));
    public static final DeferredItem<Item> ETHEREAL_DIAMOND_AXE = ITEMS.register("ethereal_diamond_axe",
            ()-> new AxeItem(SNToolTiers.ETHEREAL_DIAMOND, new Item.Properties()
                    .attributes(AxeItem.createAttributes(SNToolTiers.ETHEREAL_DIAMOND, 5f, -3.0f))));
    public static final DeferredItem<Item> ETHEREAL_DIAMOND_SHOVEL = ITEMS.register("ethereal_diamond_shovel",
            ()-> new ShovelItem(SNToolTiers.ETHEREAL_DIAMOND, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(SNToolTiers.ETHEREAL_DIAMOND, 1.5f, -3.0f))));
    public static final DeferredItem<Item> ETHEREAL_DIAMOND_HOE = ITEMS.register("ethereal_diamond_hoe",
            ()-> new HoeItem(SNToolTiers.ETHEREAL_DIAMOND, new Item.Properties()
                    .attributes(HoeItem.createAttributes(SNToolTiers.ETHEREAL_DIAMOND, -3.0f, 0f))));






    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
