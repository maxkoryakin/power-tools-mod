package com.noexitsigns.power_tools;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {

    // Items registry (NeoForge helper for items)
    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(PowerTools.MODID);

    // Block item for Lithium Ore
    public static final DeferredItem<BlockItem> LITHIUM_ORE_ITEM =
            ITEMS.registerSimpleBlockItem("lithium_ore", ModBlocks.LITHIUM_ORE);

    // Block item for Deepslate Lithium Ore
    public static final DeferredItem<BlockItem> DEEPSLATE_LITHIUM_ORE_ITEM =
            ITEMS.registerSimpleBlockItem("deepslate_lithium_ore", ModBlocks.DEEPSLATE_LITHIUM_ORE);

    // Block item for Pulverizer Mill
    public static final DeferredItem<BlockItem> PULVERIZER_MILL_ITEM =
            ITEMS.registerSimpleBlockItem("pulverizer_mill", ModBlocks.PULVERIZER_MILL);

    // Raw Lithium item
    public static final DeferredItem<Item> RAW_LITHIUM =
            ITEMS.registerSimpleItem("raw_lithium");

    // Lithium Chunk item
    public static final DeferredItem<Item> LITHIUM_CHUNK =
            ITEMS.registerSimpleItem("lithium_chunk");

    // Called from the main mod class to hook into the mod event bus
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
