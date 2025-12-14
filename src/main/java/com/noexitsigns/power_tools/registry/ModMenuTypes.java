package com.noexitsigns.power_tools.registry;

import com.noexitsigns.power_tools.PowerTools;
import com.noexitsigns.power_tools.screen.PulverizerMillMenu;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(Registries.MENU, PowerTools.MODID);

    public static final Supplier<MenuType<PulverizerMillMenu>> PULVERIZER_MILL =
            MENUS.register("pulverizer_mill",
                    () -> new MenuType<>(PulverizerMillMenu::new, FeatureFlags.DEFAULT_FLAGS));
}
