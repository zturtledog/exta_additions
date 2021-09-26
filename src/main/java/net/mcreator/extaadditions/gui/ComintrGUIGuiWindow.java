
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
public class ComintrGUIGuiWindow extends ContainerScreen<ComintrGUIGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = ComintrGUIGui.guistate;
	TextFieldWidget nbtname;
	TextFieldWidget value;
	public ComintrGUIGuiWindow(ComintrGUIGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 176;
		this.ySize = 166;
	}
	private static final ResourceLocation texture = new ResourceLocation("exta_additions:textures/comintr_gui.png");
	@Override
	public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderHoveredTooltip(ms, mouseX, mouseY);
		nbtname.render(ms, mouseX, mouseY, partialTicks);
		value.render(ms, mouseX, mouseY, partialTicks);
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
		if (nbtname.isFocused())
			return nbtname.keyPressed(key, b, c);
		if (value.isFocused())
			return value.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void tick() {
		super.tick();
		nbtname.tick();
		value.tick();
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
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "lock")) + "", 15, 124, -12829636);
		this.font.drawString(ms, "interface", 6, 7, -12829636);
		this.font.drawString(ms, "side", 87, 70, -12829636);
		this.font.drawString(ms, "side: " + (new Object() {
			public String getValue(BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getString(tag);
				return "";
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "side")) + "", 15, 142, -12829636);
		this.font.drawString(ms, "value: " + (new Object() {
			public String getValue(BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getString(tag);
				return "";
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "value")) + "", 15, 133, -12829636);
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
		nbtname = new TextFieldWidget(this.font, this.guiLeft + 24, this.guiTop + 25, 120, 20, new StringTextComponent("nbt name")) {
			{
				setSuggestion("nbt name");
			}
			@Override
			public void writeText(String text) {
				super.writeText(text);
				if (getText().isEmpty())
					setSuggestion("nbt name");
				else
					setSuggestion(null);
			}

			@Override
			public void setCursorPosition(int pos) {
				super.setCursorPosition(pos);
				if (getText().isEmpty())
					setSuggestion("nbt name");
				else
					setSuggestion(null);
			}
		};
		guistate.put("text:nbtname", nbtname);
		nbtname.setMaxStringLength(32767);
		this.children.add(this.nbtname);
		this.addButton(new Button(this.guiLeft + 24, this.guiTop + 88, 45, 20, new StringTextComponent("lock"), e -> {
			if (true) {
				ExtaAdditionsMod.PACKET_HANDLER.sendToServer(new ComintrGUIGui.ButtonPressedMessage(0, x, y, z));
				ComintrGUIGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 87, this.guiTop + 79, 30, 20, new StringTextComponent("N"), e -> {
			if (true) {
				ExtaAdditionsMod.PACKET_HANDLER.sendToServer(new ComintrGUIGui.ButtonPressedMessage(1, x, y, z));
				ComintrGUIGui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 114, this.guiTop + 79, 30, 20, new StringTextComponent("S"), e -> {
			if (true) {
				ExtaAdditionsMod.PACKET_HANDLER.sendToServer(new ComintrGUIGui.ButtonPressedMessage(2, x, y, z));
				ComintrGUIGui.handleButtonAction(entity, 2, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 87, this.guiTop + 97, 30, 20, new StringTextComponent("E"), e -> {
			if (true) {
				ExtaAdditionsMod.PACKET_HANDLER.sendToServer(new ComintrGUIGui.ButtonPressedMessage(3, x, y, z));
				ComintrGUIGui.handleButtonAction(entity, 3, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 114, this.guiTop + 97, 30, 20, new StringTextComponent("W"), e -> {
			if (true) {
				ExtaAdditionsMod.PACKET_HANDLER.sendToServer(new ComintrGUIGui.ButtonPressedMessage(4, x, y, z));
				ComintrGUIGui.handleButtonAction(entity, 4, x, y, z);
			}
		}));
		value = new TextFieldWidget(this.font, this.guiLeft + 24, this.guiTop + 43, 120, 20, new StringTextComponent("value")) {
			{
				setSuggestion("value");
			}
			@Override
			public void writeText(String text) {
				super.writeText(text);
				if (getText().isEmpty())
					setSuggestion("value");
				else
					setSuggestion(null);
			}

			@Override
			public void setCursorPosition(int pos) {
				super.setCursorPosition(pos);
				if (getText().isEmpty())
					setSuggestion("value");
				else
					setSuggestion(null);
			}
		};
		guistate.put("text:value", value);
		value.setMaxStringLength(32767);
		this.children.add(this.value);
	}
}
