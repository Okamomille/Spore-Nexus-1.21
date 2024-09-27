package net.okamiz.sporenexus.util;


import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.okamiz.sporenexus.SporeNexusMod;

public class SNTags {
    public static class Blocks{

        public static final TagKey<Block> MYCELIUM_SOILS = createTag("mycelium_soils");
        public static final TagKey<Block> RESOURCES_MUSHROOMS = createTag("resources_mushrooms");

        private static TagKey<Block> createTag(String name){
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(SporeNexusMod.MOD_ID, name));
        }
    }

    public static class Items{
        private static TagKey<Item> createTag(String name){
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(SporeNexusMod.MOD_ID, name));
        }
    }
}
