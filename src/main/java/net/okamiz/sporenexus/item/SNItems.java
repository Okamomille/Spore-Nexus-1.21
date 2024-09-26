package net.okamiz.sporenexus.item;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.okamiz.sporenexus.SporeNexusMod;

import java.util.function.Supplier;

public class SNItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(SporeNexusMod.MOD_ID);

    //public static final DeferredItem<Item> EXEMPLE_ITEM = ITEMS.registerSimpleItem("exemple_item");

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
