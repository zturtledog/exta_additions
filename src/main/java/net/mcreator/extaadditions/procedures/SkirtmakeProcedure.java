package net.mcreator.extaadditions.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import net.mcreator.extaadditions.block.MushroomskirtBlock;
import net.mcreator.extaadditions.block.MushroomakeBlock;
import net.mcreator.extaadditions.block.MushroomCapBlock;
import net.mcreator.extaadditions.ExtaAdditionsMod;

import java.util.Map;

public class SkirtmakeProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				ExtaAdditionsMod.LOGGER.warn("Failed to load dependency x for procedure Skirtmake!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				ExtaAdditionsMod.LOGGER.warn("Failed to load dependency y for procedure Skirtmake!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				ExtaAdditionsMod.LOGGER.warn("Failed to load dependency z for procedure Skirtmake!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				ExtaAdditionsMod.LOGGER.warn("Failed to load dependency world for procedure Skirtmake!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		BlockState fill = Blocks.AIR.getDefaultState();
		fill = MushroomCapBlock.block.getDefaultState();
		if ((true)) {
			world.setBlockState(new BlockPos((int) (x + 0), (int) (y + 1), (int) (z + 0)), (fill), 3);
			world.setBlockState(new BlockPos((int) (x + 1), (int) (y + 1), (int) (z + 0)), (fill), 3);
			world.setBlockState(new BlockPos((int) (x + 0), (int) (y + 1), (int) (z + 1)), (fill), 3);
			world.setBlockState(new BlockPos((int) (x + 0), (int) (y + 1), (int) (z - 1)), (fill), 3);
			world.setBlockState(new BlockPos((int) (x - 1), (int) (y + 1), (int) (z + 0)), (fill), 3);
			world.setBlockState(new BlockPos((int) (x + 1), (int) (y + 1), (int) (z + 1)), (fill), 3);
			world.setBlockState(new BlockPos((int) (x - 1), (int) (y + 1), (int) (z - 1)), (fill), 3);
			world.setBlockState(new BlockPos((int) (x + 1), (int) (y + 1), (int) (z - 1)), (fill), 3);
			world.setBlockState(new BlockPos((int) (x - 1), (int) (y + 1), (int) (z + 1)), (fill), 3);
			world.setBlockState(new BlockPos((int) (x + 2), (int) (y + 0), (int) (z + 0)), (fill), 3);
			world.setBlockState(new BlockPos((int) (x + 2), (int) (y - 1), (int) (z + 0)), (fill), 3);
			world.setBlockState(new BlockPos((int) (x - 2), (int) (y + 0), (int) (z + 0)), (fill), 3);
			world.setBlockState(new BlockPos((int) (x - 2), (int) (y - 1), (int) (z + 0)), (fill), 3);
			world.setBlockState(new BlockPos((int) (x + 0), (int) (y + 0), (int) (z + 2)), (fill), 3);
			world.setBlockState(new BlockPos((int) (x + 0), (int) (y - 1), (int) (z + 2)), (fill), 3);
			world.setBlockState(new BlockPos((int) (x + 0), (int) (y + 0), (int) (z - 2)), (fill), 3);
			world.setBlockState(new BlockPos((int) (x + 0), (int) (y - 1), (int) (z - 2)), (fill), 3);
			world.setBlockState(new BlockPos((int) (x + 2), (int) (y + 0), (int) (z - 1)), (fill), 3);
			world.setBlockState(new BlockPos((int) (x + 2), (int) (y - 1), (int) (z - 1)), (fill), 3);
			world.setBlockState(new BlockPos((int) (x - 2), (int) (y + 0), (int) (z + 1)), (fill), 3);
			world.setBlockState(new BlockPos((int) (x - 2), (int) (y - 1), (int) (z + 1)), (fill), 3);
			world.setBlockState(new BlockPos((int) (x - 1), (int) (y + 0), (int) (z + 2)), (fill), 3);
			world.setBlockState(new BlockPos((int) (x - 1), (int) (y - 1), (int) (z + 2)), (fill), 3);
			world.setBlockState(new BlockPos((int) (x + 1), (int) (y + 0), (int) (z - 2)), (fill), 3);
			world.setBlockState(new BlockPos((int) (x + 1), (int) (y - 1), (int) (z - 2)), (fill), 3);
			world.setBlockState(new BlockPos((int) (x + 2), (int) (y + 0), (int) (z + 1)), (fill), 3);
			world.setBlockState(new BlockPos((int) (x + 2), (int) (y - 1), (int) (z + 1)), (fill), 3);
			world.setBlockState(new BlockPos((int) (x - 2), (int) (y + 0), (int) (z - 1)), (fill), 3);
			world.setBlockState(new BlockPos((int) (x - 2), (int) (y - 1), (int) (z - 1)), (fill), 3);
			world.setBlockState(new BlockPos((int) (x + 1), (int) (y + 0), (int) (z + 2)), (fill), 3);
			world.setBlockState(new BlockPos((int) (x + 1), (int) (y - 1), (int) (z + 2)), (fill), 3);
			world.setBlockState(new BlockPos((int) (x - 1), (int) (y + 0), (int) (z - 2)), (fill), 3);
			world.setBlockState(new BlockPos((int) (x - 1), (int) (y - 1), (int) (z - 2)), (fill), 3);
			if ((Math.random() < 0.2)) {
				world.setBlockState(new BlockPos((int) (x + 0), (int) (y + 0), (int) (z + 0)), MushroomakeBlock.block.getDefaultState(), 3);
			} else {
				world.setBlockState(new BlockPos((int) (x + 0), (int) (y + 0), (int) (z + 0)), MushroomskirtBlock.block.getDefaultState(), 3);
			}
		}
	}
}
