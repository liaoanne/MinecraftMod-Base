package com.project.pufferfish.screen;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import com.project.pufferfish.Invaders;
import com.project.pufferfish.container.ArcadeMachineContainer;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class ArcadeMachineScreen extends ContainerScreen<ArcadeMachineContainer> {

    private final ResourceLocation GUI = new ResourceLocation(Invaders.MOD_ID,
            "textures/gui/arcade_machine_gui.png");

    public ArcadeMachineScreen(ArcadeMachineContainer screenContainer, PlayerInventory inv, ITextComponent titleIn) {
        super(screenContainer, inv, titleIn);
    }

    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(matrixStack);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
        this.renderHoveredTooltip(matrixStack, mouseX, mouseY);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(MatrixStack matrixStack, float partialTicks, int x, int y) {
        // draws the GUI screen
        RenderSystem.color4f(1f, 1f, 1f, 1f);
        this.minecraft.getTextureManager().bindTexture(GUI);
        int i = this.guiLeft;
        int j = this.guiTop;
        this.blit(matrixStack, i, j, 0, 0, this.xSize, this.ySize);

        // changes the GUI indicator when there's a prize ticket available
//        if(container.isArcadeMachineWinner()) {
//            this.blit(matrixStack, i + 82, j + 9, 176, 0, 13, 17);
//        }
    }

}
