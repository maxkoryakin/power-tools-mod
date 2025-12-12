package com.noexitsigns.power_tools;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModCreativeTabs {

    // Creative tab registry
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, PowerTools.MODID);

    // Custom “Power Tools” creative tab
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> POWER_TOOLS_TAB =
            CREATIVE_MODE_TABS.register("power_tools_tab",
                    () -> CreativeModeTab.builder()
                            // Uses your existing translation key: "itemGroup.power_tools" in en_us.json
                            .title(Component.translatable("itemGroup.power_tools"))
                            .withTabsBefore(CreativeModeTabs.COMBAT)
                            .icon(() -> ModItems.RAW_LITHIUM.get().getDefaultInstance())
                            .displayItems((parameters, output) -> {
                                // Items shown in the Power Tools tab
                                output.accept(ModItems.RAW_LITHIUM.get());
                                output.accept(ModItems.LITHIUM_ORE_ITEM.get());
                                output.accept(ModItems.DEEPSLATE_LITHIUM_ORE_ITEM.get());
                            })
                            .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
