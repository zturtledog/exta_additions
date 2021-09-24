
package net.mcreator.extaadditions.gui;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.Minecraft;

import net.mcreator.extaadditions.ExtaAdditionsMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class CC0BGUIGuiWindow extends ContainerScreen<CC0BGUIGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = CC0BGUIGui.guistate;
	TextFieldWidget file_name;
	TextFieldWidget file_path;
	public CC0BGUIGuiWindow(CC0BGUIGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 176;
		this.ySize = 166;
	}
	private static final ResourceLocation texture = new ResourceLocation("exta_additions:textures/cc_0_bgui.png");
	@Override
	public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderHoveredTooltip(ms, mouseX, mouseY);
		file_name.render(ms, mouseX, mouseY, partialTicks);
		file_path.render(ms, mouseX, mouseY, partialTicks);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(MatrixStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.color4f(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		Minecraft.getInstance().getTextureManager().bindTexture(texture);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.blit(ms, k, l, 0, 0, this.xSize, this.ySize, this.xSize, this.ySize);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeScreen();
			return true;
		}
		if (file_name.isFocused())
			return file_name.keyPressed(key, b, c);
		if (file_path.isFocused())
			return file_path.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void tick() {
		super.tick();
		file_name.tick();
		file_path.tick();
	}

	@Override
	protected void drawGuiContainerForegroundLayer(MatrixStack ms, int mouseX, int mouseY) {
		this.font.drawString(ms, "current: " + (new Object() {
			public String getValue(BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getString(tag);
				return "";
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "file")) + "", 24, 115, -12829636);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardListener.enableRepeatEvents(false);
	}

	@Override
	public void init(Minecraft minecraft, int width, int height) {
		super.init(minecraft, width, height);
		minecraft.keyboardListener.enableRepeatEvents(true);
		file_name = new TextFieldWidget(this.font, this.guiLeft + 24, this.guiTop + 43, 120, 20, new StringTextComponent("file-name")) {
			{
				setSuggestion("file-name");
			}
			@Override
			public void writeText(String text) {
				super.writeText(text);
				if (getText().isEmpty())
					setSuggestion("file-name");
				else
					setSuggestion(null);
			}

			@Override
			public void setCursorPosition(int pos) {
				super.setCursorPosition(pos);
				if (getText().isEmpty())
					setSuggestion("file-name");
				else
					setSuggestion(null);
			}
		};
		guistate.put("text:file_name", file_name);
		file_name.setMaxStringLength(32767);
		this.children.add(this.file_name);
		this.addButton(new Button(this.guiLeft + 24, this.guiTop + 79, 45, 20, new StringTextComponent("lock"), e -> {
			if (true) {
				ExtaAdditionsMod.PACKET_HANDLER.sendToServer(new CC0BGUIGui.ButtonPressedMessage(0, x, y, z));
				CC0BGUIGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		file_path = new TextFieldWidget(this.font, this.guiLeft + 24, this.guiTop + 16, 120, 20, new StringTextComponent("file-path")) {
			{
				setSuggestion("file-path");
			}
			@Override
			public void writeText(String text) {
				super.writeText(text);
				if (getText().isEmpty())
					setSuggestion("file-path");
				else
					setSuggestion(null);
			}

			@Override
			public void setCursorPosition(int pos) {
				super.setCursorPosition(pos);
				if (getText().isEmpty())
					setSuggestion("file-path");
				else
					setSuggestion(null);
			}
		};
		guistate.put("text:file_path", file_path);
		file_path.setMaxStringLength(32767);
		this.children.add(this.file_path);
	}
}
