package com.noexitsigns.power_tools.registry;

import com.noexitsigns.power_tools.PowerTools;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, PowerTools.MODID);

    public static final RegistryObject<Block> LITHIUM_ORE =
            BLOCKS.register("lithium_ore",
                    () -> new Block(BlockBehaviour.Properties.of()
                            .mapColor(MapColor.STONE)
                            .strength(1.5F, 3.0F)
                            .requiresCorrectToolForDrops()
                    ));

    public static void register(IEventBus bus) {
        BLOCKS.register(bus);
    }
}
