package com.project.pufferfish.screen;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import com.project.pufferfish.Invaders;
import com.project.pufferfish.container.ArcadeMachineContainer;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.gui.widget.Widget;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class ArcadeMachineScreen extends ContainerScreen<ArcadeMachineContainer> {

    private final ResourceLocation GUI = new ResourceLocation(Invaders.MOD_ID,
            "textures/gui/arcade_machine_gui.png");

    public ArcadeMachineScreen(ArcadeMachineContainer screenContainer, PlayerInventory inv, ITextComponent titleIn) {
        super(screenContainer, inv, titleIn);
    }

    @Override
    public void init() {
        super.init();

        // TODO: implement GuiScreen that will open on button click. Currently null.
        this.addButton(new Button(this.width / 2 - 25, this.guiTop + 50, 50, 20,
                new TranslationTextComponent("PLAY"),
                (p_213070_1_) -> {this.minecraft.displayGuiScreen((Screen)null);
                    this.minecraft.mouseHelper.grabMouse();}
        ));
    }

    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(matrixStack);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
        this.renderHoveredTooltip(matrixStack, mouseX, mouseY);

        for(Widget button : buttons){
            button.render(matrixStack, mouseX, mouseY, partialTicks);
        }
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(MatrixStack matrixStack, float partialTicks, int x, int y) {
        // draws the GUI screen
        RenderSystem.color4f(1f, 1f, 1f, 1f);
        this.minecraft.getTextureManager().bindTexture(GUI);
        int i = this.guiLeft;
        int j = this.guiTop;
        this.blit(matrixStack, i, j, 0, 0, this.xSize, this.ySize);

    }

}
