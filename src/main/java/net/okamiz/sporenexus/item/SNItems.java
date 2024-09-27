package net.okamiz.sporenexus.item;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.okamiz.sporenexus.SporeNexusMod;
import net.okamiz.sporenexus.item.custom.WIPItem;

import java.util.function.Supplier;

public class SNItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(SporeNexusMod.MOD_ID);

    public static final DeferredItem<Item> MUSHROOM_CAP = ITEMS.registerItem("mushroom_cap",
            WIPItem::new, new Item.Properties());
    public static final DeferredItem<Item> FUNGAL_ESSENCE = ITEMS.registerItem("fungal_essence",
            WIPItem::new, new Item.Properties());


    public static final DeferredItem<Item> MUSHROOM_SPORES = ITEMS.registerSimpleItem("mushroom_spores");

    public static final DeferredItem<Item> COAL_FRAGMENTS = ITEMS.registerSimpleItem("coal_fragments");
    public static final DeferredItem<Item> LAPIS_LAZULI_FRAGMENTS = ITEMS.registerSimpleItem("lapis_lazuli_fragments");
    public static final DeferredItem<Item> QUARTZ_FRAGMENTS = ITEMS.registerSimpleItem("quartz_fragments");
    public static final DeferredItem<Item> REDSTONE_FRAGMENTS = ITEMS.registerSimpleItem("redstone_fragments");
    public static final DeferredItem<Item> IRON_FRAGMENTS = ITEMS.registerSimpleItem("iron_fragments");
    public static final DeferredItem<Item> COPPER_FRAGMENTS = ITEMS.registerSimpleItem("copper_fragments");
    public static final DeferredItem<Item> GOLD_FRAGMENTS = ITEMS.registerSimpleItem("gold_fragments");
    public static final DeferredItem<Item> DIAMOND_FRAGMENTS = ITEMS.registerSimpleItem("diamond_fragments");
    public static final DeferredItem<Item> EMERALD_FRAGMENTS = ITEMS.registerSimpleItem("emerald_fragments");
    public static final DeferredItem<Item> NETHERITE_FRAGMENTS = ITEMS.registerSimpleItem("netherite_fragments");

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
