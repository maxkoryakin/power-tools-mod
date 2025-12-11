package com.noexitsigns.power_tools.registry;

import com.noexitsigns.power_tools.PowerTools;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, PowerTools.MODID);

    public static final RegistryObject<Item> LITHIUM_ORE_ITEM =
            ITEMS.register("lithium_ore",
                    () -> new BlockItem(ModBlocks.LITHIUM_ORE.get(), new Item.Properties()));

    public static final RegistryObject<Item> RAW_LITHIUM =
            ITEMS.register("raw_lithium",
                    () -> new Item(new Item.Properties()));

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }
}
