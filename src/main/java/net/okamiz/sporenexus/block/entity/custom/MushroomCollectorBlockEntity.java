package net.okamiz.sporenexus.block.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.items.ItemStackHandler;
import net.okamiz.sporenexus.block.custom.ResourcesMushroomBlock;
import net.okamiz.sporenexus.block.entity.SNBlockEntities;
import net.okamiz.sporenexus.screen.custom.MushroomCollectorMenu;
import org.jetbrains.annotations.Nullable;


import java.util.List;

public class MushroomCollectorBlockEntity extends BlockEntity implements MenuProvider {

    private boolean isHarvesting;
    public final ItemStackHandler inventory = new ItemStackHandler(15){

        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
            if(!level.isClientSide()){
                level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
            }
        }
    };

    public MushroomCollectorBlockEntity(BlockPos pos, BlockState blockState) {
        super(SNBlockEntities.MUSHROOM_COLLECTOR_BE.get(), pos, blockState);
        isHarvesting = false;
    }

    public void clearContents(){
        inventory.setStackInSlot(0, ItemStack.EMPTY);
    }

    public void dropContent(){
        SimpleContainer inv = new SimpleContainer(inventory.getSlots());
        for (int i = 0; i < inventory.getSlots(); i++) {
            inv.setItem(i, inventory.getStackInSlot(i));
        }

        Containers.dropContents(this.level, this.worldPosition, inv);
    }


    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);
        tag.put("inventory", inventory.serializeNBT(registries));
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        inventory.deserializeNBT(registries,tag.getCompound("inventory"));
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("gui.sporenexus.mushroom_collector");
    }

    public ItemStackHandler getItemHandler() {
        return inventory;
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int containerId, Inventory playerInventory, Player player) {
        return new MushroomCollectorMenu(containerId, playerInventory, this);
    }

    public void harvestMushrooms() {
        if (this.level == null) return;
        if(this.level.isClientSide()) return;
        // Check if there is space in the inventory
        if (!hasSpaceInInventory()) {
            return; // If the inventory is full, do not collect mushrooms
        }

        BlockPos startPos = this.worldPosition.offset(-1, 0, -1); // Define a radius around the block
        BlockPos endPos = this.worldPosition.offset(1, 0, 1);

        for (BlockPos pos : BlockPos.betweenClosed(startPos, endPos)) {
            BlockState blockState = level.getBlockState(pos);
            Block block = blockState.getBlock();

            // Check if the block is a mushroom
            if (block instanceof  ResourcesMushroomBlock resourcesMushroomBlock) {

                if(resourcesMushroomBlock.getAge(blockState) == resourcesMushroomBlock.getMaxAge() && !isHarvesting){
                    isHarvesting = true;
                    // Reset the block and collect its drops
                    List<ItemStack> drops = resourcesMushroomBlock.getCustomDrops();

                    for (ItemStack drop : drops) {
                        addToInventory(drop);
                    }

                    resourcesMushroomBlock.resetAge(level, pos);
                    isHarvesting = false;
                }
                else{
                    return; // If the mushroom is not grown, do not collect mushrooms
                }
            }
        }
    }



    private boolean hasSpaceInInventory() {
        for (int i = 0; i < inventory.getSlots(); i++) {
            ItemStack slotStack = inventory.getStackInSlot(i);
            // Check if the slot is empty or if it can stack with an existing item
            if (slotStack.isEmpty() || (ItemStack.isSameItem(slotStack, new ItemStack(slotStack.getItem(), 1)) &&
                    slotStack.getCount() < slotStack.getMaxStackSize())) {
                return true; // Found space in inventory
            }
        }
        return false; // No space available in inventory
    }

    private boolean addToInventory(ItemStack stack) {

        if(stack != null){
            // Iterate over each slot in the inventory
            for (int i = 0; i < inventory.getSlots(); i++) {
                ItemStack slotStack = inventory.getStackInSlot(i);

                // If the slot is empty, place the item there
                if (slotStack.isEmpty()) {
                    inventory.setStackInSlot(i, stack);
                    return true; // Successfully added the item
                }

                // Check if the item can stack with the existing item in the slot
                if (slotStack.is(stack.getItem()) && ItemStack.isSameItem(stack, slotStack)) {
                    int newCount = slotStack.getCount() + stack.getCount();

                    // If the new count exceeds the max stack size, we can only fill the slot
                    if (newCount <= slotStack.getMaxStackSize()) {
                        slotStack.setCount(newCount); // Set the new count
                        inventory.setStackInSlot(i, slotStack); // Update the slot in the inventory
                        return true; // Successfully stacked the item
                    } else {
                        // If it exceeds the max stack size, fill the slot to the max and reduce the stack count
                        int spaceLeft = slotStack.getMaxStackSize() - slotStack.getCount();
                        slotStack.setCount(slotStack.getMaxStackSize());
                        inventory.setStackInSlot(i, slotStack); // Update the slot

                        // Update the remaining count of the stack to return
                        stack.setCount(stack.getCount() - spaceLeft);

                        // If there's no more items left in the stack, return true
                        if (stack.isEmpty()) {
                            return true; // Successfully stacked the item
                        }
                    }
                }
            }
        }
        // If we still have items left in the stack, it means it couldn't fully fit in the inventory
        return false; // Not all items were added
    }


    public static void tick(Level level, BlockPos pos, BlockState state, MushroomCollectorBlockEntity blockEntity) {
        if (!level.isClientSide) {
            if (level.getGameTime() % 20 == 0) {  // Run every second (20 ticks)
                blockEntity.harvestMushrooms();
            }
        }
    }




}
