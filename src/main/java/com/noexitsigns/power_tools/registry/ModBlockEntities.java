package com.noexitsigns.power_tools.registry;

import com.noexitsigns.power_tools.ModBlocks;
import com.noexitsigns.power_tools.PowerTools;
import com.noexitsigns.power_tools.block.entity.PulverizerMillBlockEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, PowerTools.MODID);

    public static final Supplier<BlockEntityType<PulverizerMillBlockEntity>> PULVERIZER_MILL =
            BLOCK_ENTITIES.register("pulverizer_mill",
                    () -> BlockEntityType.Builder.of(
                            PulverizerMillBlockEntity::new,
                            ModBlocks.PULVERIZER_MILL.get()
                    ).build(null));
}
