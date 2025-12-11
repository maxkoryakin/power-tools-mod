package com.noexitsigns.power_tools;

import com.noexitsigns.power_tools.registry.ModBlocks;
import com.noexitsigns.power_tools.registry.ModCreativeTabs;
import com.noexitsigns.power_tools.registry.ModItems;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import com.mojang.logging.LogUtils;

@Mod(PowerTools.MODID)
public class PowerTools {

    public static final String MODID = "power_tools";
    private static final Logger LOGGER = LogUtils.getLogger();

    public PowerTools(FMLJavaModLoadingContext context) {

        IEventBus modBus = context.getModEventBus();

        // Register content
        ModBlocks.register(modBus);
        ModItems.register(modBus);
        ModCreativeTabs.register(modBus);

        // Setup events
        modBus.addListener(this::commonSetup);
        modBus.addListener(this::clientSetup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        LOGGER.info("Power Tools common setup");
    }

    private void clientSetup(FMLClientSetupEvent event) {
        LOGGER.info("Power Tools client setup");
    }
}
