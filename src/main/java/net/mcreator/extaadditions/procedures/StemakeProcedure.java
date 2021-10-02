package net.mcreator.extaadditions.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.Blocks;

import net.mcreator.extaadditions.block.MushroomstemBlock;
import net.mcreator.extaadditions.block.MushroomceliusBlock;
import net.mcreator.extaadditions.block.MushroomakeBlock;
import net.mcreator.extaadditions.block.MushroomCapBlock;
import net.mcreator.extaadditions.ExtaAdditionsMod;

import java.util.Map;
import java.util.HashMap;

public class StemakeProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				ExtaAdditionsMod.LOGGER.warn("Failed to load dependency x for procedure Stemake!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				ExtaAdditionsMod.LOGGER.warn("Failed to load dependency y for procedure Stemake!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				ExtaAdditionsMod.LOGGER.warn("Failed to load dependency z for procedure Stemake!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				ExtaAdditionsMod.LOGGER.warn("Failed to load dependency world for procedure Stemake!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double nom = 0;
		double ran = 0;
		double fan = 0;
		nom = (double) 0.6;
		fan = (double) Math.random();
		if ((fan < nom)) {
			if ((((((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == Blocks.GRASS_BLOCK)
					|| ((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == Blocks.MYCELIUM))
					|| ((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == Blocks.PODZOL))
					|| (((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == Blocks.COARSE_DIRT)
							|| ((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == Blocks.DIRT)))) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), MushroomceliusBlock.block.getDefaultState(), 3);
			} else {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), MushroomstemBlock.block.getDefaultState(), 3);
			}
			world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), MushroomstemBlock.block.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) x, (int) (y + 2), (int) z), MushroomstemBlock.block.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) x, (int) (y + 3), (int) z), MushroomstemBlock.block.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) x, (int) (y + 5), (int) z), MushroomakeBlock.block.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) x, (int) (y + 4), (int) z), MushroomstemBlock.block.getDefaultState(), 3);
			if ((ran < nom)) {
				world.setBlockState(new BlockPos((int) (x + 1), (int) (y + 0), (int) (z + 0)), MushroomCapBlock.block.getDefaultState(), 3);
				world.setBlockState(new BlockPos((int) (x - 1), (int) (y + 0), (int) (z + 0)), MushroomCapBlock.block.getDefaultState(), 3);
				world.setBlockState(new BlockPos((int) (x - 0), (int) (y + 0), (int) (z + 1)), MushroomCapBlock.block.getDefaultState(), 3);
				world.setBlockState(new BlockPos((int) (x - 0), (int) (y + 0), (int) (z - 1)), MushroomCapBlock.block.getDefaultState(), 3);
			}
		} else if ((fan > nom)) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), MushroomstemBlock.block.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), MushroomstemBlock.block.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) x, (int) (y + 2), (int) z), MushroomstemBlock.block.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) x, (int) (y + 3), (int) z), MushroomstemBlock.block.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) x, (int) (y + 4), (int) z), MushroomstemBlock.block.getDefaultState(), 3);
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("world", world);
				$_dependencies.put("x", x);
				$_dependencies.put("y", (y + 5));
				$_dependencies.put("z", z);
				SkirtmakeProcedure.executeProcedure($_dependencies);
			}
		}
	}
}
