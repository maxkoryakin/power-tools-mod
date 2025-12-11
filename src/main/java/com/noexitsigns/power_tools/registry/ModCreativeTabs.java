package com.noexitsigns.power_tools.registry;

import com.noexitsigns.power_tools.PowerTools;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeTabs {

    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, PowerTools.MODID);

    public static final RegistryObject<CreativeModeTab> POWER_TOOLS_TAB =
            TABS.register("power_tools_tab",
                    () -> CreativeModeTab.builder()
                            .title(Component.literal("Power Tools"))
                            .icon(() -> new ItemStack(ModItems.LITHIUM_ORE_ITEM.get()))
                            .displayItems((params, output) -> {
                                output.accept(ModItems.LITHIUM_ORE_ITEM.get());
                                output.accept(ModItems.RAW_LITHIUM.get());
                            })
                            .build()
            );

    public static void register(IEventBus bus) {
        TABS.register(bus);
    }
}
