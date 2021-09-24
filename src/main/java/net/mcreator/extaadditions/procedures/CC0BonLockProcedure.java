package net.mcreator.extaadditions.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.block.BlockState;

import net.mcreator.extaadditions.ExtaAdditionsMod;

import java.util.Map;
import java.util.HashMap;

public class CC0BonLockProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("guistate") == null) {
			if (!dependencies.containsKey("guistate"))
				ExtaAdditionsMod.LOGGER.warn("Failed to load dependency guistate for procedure CC0BonLock!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				ExtaAdditionsMod.LOGGER.warn("Failed to load dependency x for procedure CC0BonLock!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				ExtaAdditionsMod.LOGGER.warn("Failed to load dependency y for procedure CC0BonLock!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				ExtaAdditionsMod.LOGGER.warn("Failed to load dependency z for procedure CC0BonLock!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				ExtaAdditionsMod.LOGGER.warn("Failed to load dependency world for procedure CC0BonLock!");
			return;
		}
		HashMap guistate = (HashMap) dependencies.get("guistate");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (!world.isRemote()) {
			BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
			TileEntity _tileEntity = world.getTileEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_tileEntity != null)
				_tileEntity.getTileData().putString("file", (new Object() {
					public String getText() {
						TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:file_name");
						if (_tf != null) {
							return _tf.getText();
						}
						return "";
					}
				}.getText()));
			if (world instanceof World)
				((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
		}
		if (!world.isRemote()) {
			BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
			TileEntity _tileEntity = world.getTileEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_tileEntity != null)
				_tileEntity.getTileData().putString("path", (new Object() {
					public String getText() {
						TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:file_path");
						if (_tf != null) {
							return _tf.getText();
						}
						return "";
					}
				}.getText()));
			if (world instanceof World)
				((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
		}
	}
}
