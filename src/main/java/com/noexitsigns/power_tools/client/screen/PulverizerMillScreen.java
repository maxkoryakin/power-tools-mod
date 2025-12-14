package com.noexitsigns.power_tools.client.screen;

import com.noexitsigns.power_tools.PowerTools;
import com.noexitsigns.power_tools.screen.PulverizerMillMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

import java.util.List;

public class PulverizerMillScreen extends AbstractContainerScreen<PulverizerMillMenu> {
    private static final ResourceLocation TEXTURE =
            ResourceLocation.fromNamespaceAndPath(PowerTools.MODID, "textures/gui/container/pulverizer_mill.png");

    // Hover area for your left vertical bar (from the texture)
    private static final int ENERGY_BAR_X = 7;
    private static final int ENERGY_BAR_Y = 16;
    private static final int ENERGY_BAR_W = 9;
    private static final int ENERGY_BAR_H = 53;

    public PulverizerMillScreen(PulverizerMillMenu menu, Inventory playerInv, Component title) {
        super(menu, playerInv, title);
        this.imageWidth = 176;
        this.imageHeight = 166;
    }

    @Override
    protected void renderBg(GuiGraphics graphics, float partialTick, int mouseX, int mouseY) {
        graphics.blit(TEXTURE, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, 256, 256);
    }

    @Override
    protected void renderLabels(GuiGraphics graphics, int mouseX, int mouseY) {
        // Title (like furnace)
        graphics.drawString(this.font, this.title, 8, 6, 0x404040, false);
        // Player inventory label
        graphics.drawString(this.font, this.playerInventoryTitle, 8, this.imageHeight - 94, 0x404040, false);
    }

    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTick) {
        super.render(graphics, mouseX, mouseY, partialTick);
        this.renderTooltip(graphics, mouseX, mouseY);

        // Tooltip when hovering the left vertical bar
        if (this.isHovering(ENERGY_BAR_X, ENERGY_BAR_Y, ENERGY_BAR_W, ENERGY_BAR_H, mouseX, mouseY)) {
            graphics.renderComponentTooltip(this.font, List.of(Component.literal("Hello world")), mouseX, mouseY);
        }
    }
}
