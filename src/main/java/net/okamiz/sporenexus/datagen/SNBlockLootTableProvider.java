package net.okamiz.sporenexus.datagen;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.okamiz.sporenexus.block.SNBlocks;

import java.util.Set;

public class SNBlockLootTableProvider extends BlockLootSubProvider {
    protected SNBlockLootTableProvider(HolderLookup.Provider provider) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), provider);
    }

    @Override
    protected void generate() {

        dropSelf(SNBlocks.DIRT_MUSHROOM.get());
        dropSelf(SNBlocks.GRAVEL_MUSHROOM.get());
        dropSelf(SNBlocks.SAND_MUSHROOM.get());
        dropSelf(SNBlocks.CLAY_MUSHROOM.get());
        dropSelf(SNBlocks.STONE_MUSHROOM.get());


        dropSelf(SNBlocks.COAL_MUSHROOM.get());
        dropSelf(SNBlocks.IRON_MUSHROOM.get());
        dropSelf(SNBlocks.COPPER_MUSHROOM.get());

        dropSelf(SNBlocks.ICE_MUSHROOM.get());

        dropSelf(SNBlocks.REDSTONE_MUSHROOM.get());
        dropSelf(SNBlocks.LAPIS_LAZULI_MUSHROOM.get());
        dropSelf(SNBlocks.GOLD_MUSHROOM.get());
        dropSelf(SNBlocks.FUNGALSTEEL_MUSHROOM.get());



        dropSelf(SNBlocks.BLACKSTONE_MUSHROOM.get());
        dropSelf(SNBlocks.GLOWSTONE_MUSHROOM.get());
        dropSelf(SNBlocks.NETHERRACK_MUSHROOM.get());
        dropSelf(SNBlocks.SOUL_SAND_MUSHROOM.get());

        dropSelf(SNBlocks.QUARTZ_MUSHROOM.get());
        dropSelf(SNBlocks.DIAMOND_MUSHROOM.get());

        dropSelf(SNBlocks.EMERALD_MUSHROOM.get());
        dropSelf(SNBlocks.NETHERITE_MUSHROOM.get());


        dropSelf(SNBlocks.FERTILIZED_MYCELIUM.get());
        dropSelf(SNBlocks.ENRICHED_MYCELIUM.get());

        dropSelf(SNBlocks.SPORE_SPREADER.get());
        dropSelf(SNBlocks.FUNGAL_PROPAGATOR.get());
        dropSelf(SNBlocks.MUSHROOM_COLLECTOR.get());

        dropSelf(SNBlocks.FUNGALSTEEL_BLOCK.get());

        dropSelf(SNBlocks.FUNGAL_DIAMOND_BLOCK.get());
        dropSelf(SNBlocks.INFERNAL_DIAMOND_BLOCK.get());
        dropSelf(SNBlocks.ETHEREAL_DIAMOND_BLOCK.get());

        dropSelf(SNBlocks.FUNGAL_LANTERN.get());


        dropSelf(SNBlocks.REGENERATION_TOTEM.get());
        dropSelf(SNBlocks.FIRE_RESISTANCE_TOTEM.get());
        dropSelf(SNBlocks.NIGHT_VISION_TOTEM.get());
        dropSelf(SNBlocks.HASTE_TOTEM.get());



        /*
        LootItemCondition.Builder lootItemConditionBuilder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(SNBlocks.IRON_MUSHROOM.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(ResourcesMushroomBlock.AGE, 6));
        this.add(SNBlocks.IRON_MUSHROOM.get(), this.createCropDrops(SNBlocks.IRON_MUSHROOM.get(),
                Items.RAW_IRON, SNBlocks.IRON_MUSHROOM.asItem(), lootItemConditionBuilder));

         */

    }

    protected LootTable.Builder createMultipleOreDrops(Block block, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(block, (LootPoolEntryContainer.Builder)this.applyExplosionDecay(block,
                LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                        .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return SNBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
