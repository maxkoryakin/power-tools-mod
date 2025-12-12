package com.noexitsigns.power_tools;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlocks {

    // Blocks registry (NeoForge helper for blocks)
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(PowerTools.MODID);

    // Lithium Ore block
    public static final DeferredBlock<Block> LITHIUM_ORE = BLOCKS.register("lithium_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.STONE)
                    .strength(3.0F, 3.0F)
                    .requiresCorrectToolForDrops()));

    // Deepslate Lithium Ore block
    public static final DeferredBlock<Block> DEEPSLATE_LITHIUM_ORE = BLOCKS.register("deepslate_lithium_ore",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_IRON_ORE)));

    // Called from the main mod class to hook into the mod event bus
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
