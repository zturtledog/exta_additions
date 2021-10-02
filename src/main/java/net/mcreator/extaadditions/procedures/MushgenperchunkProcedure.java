package net.mcreator.extaadditions.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import net.mcreator.extaadditions.block.NbtholdBlock;
import net.mcreator.extaadditions.block.Musgenstage2Block;
import net.mcreator.extaadditions.block.Musgenstage1Block;
import net.mcreator.extaadditions.ExtaAdditionsMod;

import java.util.Map;

public class MushgenperchunkProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				ExtaAdditionsMod.LOGGER.warn("Failed to load dependency x for procedure Mushgenperchunk!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				ExtaAdditionsMod.LOGGER.warn("Failed to load dependency y for procedure Mushgenperchunk!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				ExtaAdditionsMod.LOGGER.warn("Failed to load dependency z for procedure Mushgenperchunk!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				ExtaAdditionsMod.LOGGER.warn("Failed to load dependency world for procedure Mushgenperchunk!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		BlockState fill = Blocks.AIR.getDefaultState();
		fill = Musgenstage2Block.block.getDefaultState();
		world.setBlockState(new BlockPos((int) (x + 2), (int) 255, (int) (z + 2)), (fill), 3);
		world.setBlockState(new BlockPos((int) (x + 5), (int) 255, (int) (z + 5)), (fill), 3);
		world.setBlockState(new BlockPos((int) (x + 8), (int) 255, (int) (z + 8)), (fill), 3);
		world.setBlockState(new BlockPos((int) (x + 11), (int) 255, (int) (z + 11)), (fill), 3);
		world.setBlockState(new BlockPos((int) (x + 14), (int) 255, (int) (z + 14)), (fill), 3);
		world.setBlockState(new BlockPos((int) (x + 2), (int) 255, (int) (z + 8)), (fill), 3);
		world.setBlockState(new BlockPos((int) (x + 8), (int) 255, (int) (z + 2)), (fill), 3);
		world.setBlockState(new BlockPos((int) (x + 2), (int) 255, (int) (z + 11)), (fill), 3);
		world.setBlockState(new BlockPos((int) (x + 11), (int) 255, (int) (z + 2)), (fill), 3);
		world.setBlockState(new BlockPos((int) (x + 14), (int) 255, (int) (z + 2)), (fill), 3);
		world.setBlockState(new BlockPos((int) (x + 14), (int) 255, (int) (z + 11)), (fill), 3);
		world.setBlockState(new BlockPos((int) (x + 2), (int) 255, (int) (z + 14)), (fill), 3);
		world.setBlockState(new BlockPos((int) (x + 11), (int) 255, (int) (z + 14)), (fill), 3);
		if (!world.isRemote()) {
			BlockPos _bp = new BlockPos((int) x, (int) y, (int) (z + 1));
			TileEntity _tileEntity = world.getTileEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_tileEntity != null)
				_tileEntity.getTileData().putBoolean("true", (true));
			if (world instanceof World)
				((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
		}
		world.setBlockState(new BlockPos((int) (x + 16), (int) 0, (int) (z + 16)), Musgenstage1Block.block.getDefaultState(), 3);
		world.setBlockState(new BlockPos((int) (x + 16), (int) 0, (int) (z + 17)), NbtholdBlock.block.getDefaultState(), 3);
	}
}
