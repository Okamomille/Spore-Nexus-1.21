package net.okamiz.sporenexus.screen.custom;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.neoforge.items.SlotItemHandler;
import net.okamiz.sporenexus.block.SNBlocks;
import net.okamiz.sporenexus.block.entity.custom.MushroomCollectorBlockEntity;
import net.okamiz.sporenexus.screen.SNMenuTypes;


public class MushroomCollectorMenu extends AbstractContainerMenu {
    public final MushroomCollectorBlockEntity blockEntity;
    private final Level level;
    public MushroomCollectorMenu(int containerId, Inventory inventory, FriendlyByteBuf extraData) {
        this(containerId, inventory, inventory.player.level().getBlockEntity(extraData.readBlockPos()));
    }

    public MushroomCollectorMenu(int containerId, Inventory inventory, BlockEntity blockEntity) {
        super(SNMenuTypes.MUSHROOM_COLLECTOR_MENU.get(), containerId);
        this.blockEntity = ((MushroomCollectorBlockEntity) blockEntity);
        this.level = inventory.player.level();

        addPlayerHotbar(inventory);
        addPlayerInventory(inventory);

        this.addSlot(new SlotItemHandler(this.blockEntity.inventory, 0, 44, 17));
        this.addSlot(new SlotItemHandler(this.blockEntity.inventory, 1, 62, 17));
        this.addSlot(new SlotItemHandler(this.blockEntity.inventory, 2, 80, 17));
        this.addSlot(new SlotItemHandler(this.blockEntity.inventory, 3, 98, 17));
        this.addSlot(new SlotItemHandler(this.blockEntity.inventory, 4, 116, 17));
        this.addSlot(new SlotItemHandler(this.blockEntity.inventory, 5, 44, 35));
        this.addSlot(new SlotItemHandler(this.blockEntity.inventory, 6, 62, 35));
        this.addSlot(new SlotItemHandler(this.blockEntity.inventory, 7, 80, 35));
        this.addSlot(new SlotItemHandler(this.blockEntity.inventory, 8, 98, 35));
        this.addSlot(new SlotItemHandler(this.blockEntity.inventory, 9, 116, 35));
        this.addSlot(new SlotItemHandler(this.blockEntity.inventory, 10, 44, 53));
        this.addSlot(new SlotItemHandler(this.blockEntity.inventory, 11, 62, 53));
        this.addSlot(new SlotItemHandler(this.blockEntity.inventory, 12, 80, 53));
        this.addSlot(new SlotItemHandler(this.blockEntity.inventory, 13, 98, 53));
        this.addSlot(new SlotItemHandler(this.blockEntity.inventory, 14, 116, 53));
    }

    // CREDIT GOES TO: diesieben07 | https://github.com/diesieben07/SevenCommons
    // must assign a slot number to each of the slots used by the GUI.
    // For this container, we can see both the tile inventory's slots as well as the player inventory slots and the hotbar.
    // Each time we add a Slot to the container, it automatically increases the slotIndex, which means
    //  0 - 8 = hotbar slots (which will map to the InventoryPlayer slot numbers 0 - 8)
    //  9 - 35 = player inventory slots (which map to the InventoryPlayer slot numbers 9 - 35)
    //  36 - 44 = TileInventory slots, which map to our TileEntity slot numbers 0 - 8)
    private static final int HOTBAR_SLOT_COUNT = 9;
    private static final int PLAYER_INVENTORY_ROW_COUNT = 3;
    private static final int PLAYER_INVENTORY_COLUMN_COUNT = 9;
    private static final int PLAYER_INVENTORY_SLOT_COUNT = PLAYER_INVENTORY_COLUMN_COUNT * PLAYER_INVENTORY_ROW_COUNT;
    private static final int VANILLA_SLOT_COUNT = HOTBAR_SLOT_COUNT + PLAYER_INVENTORY_SLOT_COUNT;
    private static final int VANILLA_FIRST_SLOT_INDEX = 0;
    private static final int TE_INVENTORY_FIRST_SLOT_INDEX = VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT;

    // THIS YOU HAVE TO DEFINE!
    private static final int TE_INVENTORY_SLOT_COUNT = 15;  // must be the number of slots you have!
    @Override
    public ItemStack quickMoveStack(Player playerIn, int pIndex) {
        Slot sourceSlot = slots.get(pIndex);
        if (sourceSlot == null || !sourceSlot.hasItem()) return ItemStack.EMPTY;  //EMPTY_ITEM
        ItemStack sourceStack = sourceSlot.getItem();
        ItemStack copyOfSourceStack = sourceStack.copy();

        // Check if the slot clicked is one of the vanilla container slots
        if (pIndex < VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT) {
            // This is a vanilla container slot so merge the stack into the tile inventory
            if (!moveItemStackTo(sourceStack, TE_INVENTORY_FIRST_SLOT_INDEX, TE_INVENTORY_FIRST_SLOT_INDEX
                    + TE_INVENTORY_SLOT_COUNT, false)) {
                return ItemStack.EMPTY;  // EMPTY_ITEM
            }
        } else if (pIndex < TE_INVENTORY_FIRST_SLOT_INDEX + TE_INVENTORY_SLOT_COUNT) {
            // This is a TE slot so merge the stack into the players inventory
            if (!moveItemStackTo(sourceStack, VANILLA_FIRST_SLOT_INDEX, VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT, false)) {
                return ItemStack.EMPTY;
            }
        } else {
            System.out.println("Invalid slotIndex:" + pIndex);
            return ItemStack.EMPTY;
        }
        // If stack size == 0 (the entire stack was moved) set slot contents to null
        if (sourceStack.getCount() == 0) {
            sourceSlot.set(ItemStack.EMPTY);
        } else {
            sourceSlot.setChanged();
        }
        sourceSlot.onTake(playerIn, sourceStack);
        return copyOfSourceStack;
    }

    @Override
    public boolean stillValid(Player player) {
        return stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()), player, SNBlocks.MUSHROOM_COLLECTOR.get());
    }

    private void addPlayerInventory(Inventory playerInventory) {
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 84 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(Inventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
        }
    }
}
