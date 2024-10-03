package net.okamiz.sporenexus.block.entity;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.okamiz.sporenexus.SporeNexusMod;
import net.okamiz.sporenexus.block.SNBlocks;
import net.okamiz.sporenexus.block.entity.custom.MushroomCollectorBlockEntity;

import java.util.function.Supplier;

public class SNBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITES =
            DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, SporeNexusMod.MOD_ID);


    public static final Supplier<BlockEntityType<MushroomCollectorBlockEntity>> MUSHROOM_COLLECTOR_BE =
            BLOCK_ENTITES.register("mushroom_collector_be", () -> BlockEntityType.Builder.of(
                    MushroomCollectorBlockEntity::new, SNBlocks.MUSHROOM_COLLECTOR.get()).build(null));



    public static void register(IEventBus eventBus){
        BLOCK_ENTITES.register(eventBus);
    }
}
