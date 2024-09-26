package net.okamiz.sporenexus.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
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
                    .icon(() -> new ItemStack(SNBlocks.IRON_MUSHROOM))
                    .displayItems((itemDisplayParameters, output) -> {

                        output.accept(SNBlocks.IRON_MUSHROOM);
                        output.accept(SNBlocks.FERTILIZED_MYCELIUM);

                    })
                    .build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}