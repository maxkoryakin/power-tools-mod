package com.noexitsigns.power_tools.screen;

import com.noexitsigns.power_tools.ModBlocks;
import com.noexitsigns.power_tools.registry.ModMenuTypes;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.ItemStackHandler;
import net.neoforged.neoforge.items.SlotItemHandler;

public class PulverizerMillMenu extends AbstractContainerMenu {
    // 4 machine slots, 36 player slots
    private static final int MACHINE_SLOTS = 4;
    private static final int PLAYER_INV_SLOTS = 36;

    private final ContainerLevelAccess access;

    // Client constructor (dummy handler; server sync fills slot contents)
    public PulverizerMillMenu(int containerId, Inventory playerInv) {
        this(containerId, playerInv, new ItemStackHandler(MACHINE_SLOTS), ContainerLevelAccess.NULL);
    }

    // Server constructor
    public PulverizerMillMenu(int containerId, Inventory playerInv, IItemHandler machineInv, ContainerLevelAccess access) {
        super(ModMenuTypes.PULVERIZER_MILL.get(), containerId);
        this.access = access;

        if (machineInv.getSlots() != MACHINE_SLOTS) {
            throw new IllegalArgumentException("Pulverizer machine inventory must have " + MACHINE_SLOTS + " slots");
        }

        // --- Machine slots (match the texture) ---
        this.addSlot(new SlotItemHandler(machineInv, 0, 26, 17));
        this.addSlot(new SlotItemHandler(machineInv, 1, 74, 34));
        this.addSlot(new SlotItemHandler(machineInv, 2, 44, 53));

        // Output slot (no placing)
        this.addSlot(new SlotItemHandler(machineInv, 3, 134, 35) {
            @Override
            public boolean mayPlace(ItemStack stack) {
                return false;
            }
        });

        // --- Player inventory (match the texture) ---
        // 3 rows * 9
        int startX = 8;
        int startY = 84;
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 9; col++) {
                int index = col + row * 9 + 9;
                this.addSlot(new Slot(playerInv, index, startX + col * 18, startY + row * 18));
            }
        }

        // Hotbar
        int hotbarY = 142;
        for (int col = 0; col < 9; col++) {
            this.addSlot(new Slot(playerInv, col, startX + col * 18, hotbarY));
        }
    }

    @Override
    public boolean stillValid(Player player) {
        return AbstractContainerMenu.stillValid(this.access, player, ModBlocks.PULVERIZER_MILL.get());
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        Slot slot = this.slots.get(index);
        if (!slot.hasItem()) return ItemStack.EMPTY;

        ItemStack inSlot = slot.getItem();
        ItemStack copy = inSlot.copy();

        int machineStart = 0;
        int machineEnd = MACHINE_SLOTS; // exclusive
        int playerStart = machineEnd;
        int playerEnd = machineEnd + PLAYER_INV_SLOTS; // exclusive

        if (index < machineEnd) {
            // From machine -> player
            if (!this.moveItemStackTo(inSlot, playerStart, playerEnd, true)) {
                return ItemStack.EMPTY;
            }
        } else {
            // From player -> machine inputs only (0..2). Never auto-insert into output slot 3.
            if (!this.moveItemStackTo(inSlot, machineStart, 3, false)) {
                return ItemStack.EMPTY;
            }
        }

        if (inSlot.isEmpty()) slot.set(ItemStack.EMPTY);
        else slot.setChanged();

        return copy;
    }
}
