package net.mcreator.extaadditions.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.extaadditions.ExtaAdditionsMod;

import java.util.Map;

public class StoneRemovalTechnicalExplosiveOnInitProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				ExtaAdditionsMod.LOGGER.warn("Failed to load dependency x for procedure StoneRemovalTechnicalExplosiveOnInit!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				ExtaAdditionsMod.LOGGER.warn("Failed to load dependency y for procedure StoneRemovalTechnicalExplosiveOnInit!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				ExtaAdditionsMod.LOGGER.warn("Failed to load dependency z for procedure StoneRemovalTechnicalExplosiveOnInit!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				ExtaAdditionsMod.LOGGER.warn("Failed to load dependency world for procedure StoneRemovalTechnicalExplosiveOnInit!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double x1 = 0;
		double y1 = 0;
		double z1 = 0;
		if (!world.isRemote()) {
			BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
			TileEntity _tileEntity = world.getTileEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_tileEntity != null)
				_tileEntity.getTileData().putDouble("rad", 20);
			if (world instanceof World)
				((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
		}
		x1 = (double) (x1 - ((new Object() {
			public double getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getDouble(tag);
				return -1;
			}
		}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "rad")) / 2));
		y1 = (double) (y1 - ((new Object() {
			public double getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getDouble(tag);
				return -1;
			}
		}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "rad")) / 2));
		z1 = (double) (z1 - ((new Object() {
			public double getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getDouble(tag);
				return -1;
			}
		}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "rad")) / 2));
		for (int index0 = 0; index0 < (int) ((new Object() {
			public double getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getDouble(tag);
				return -1;
			}
		}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "rad"))); index0++) {
			x1 = (double) (x1 + 1);
			for (int index1 = 0; index1 < (int) ((new Object() {
				public double getValue(IWorld world, BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getDouble(tag);
					return -1;
				}
			}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "rad"))); index1++) {
				y1 = (double) (y1 + 1);
				for (int index2 = 0; index2 < (int) ((new Object() {
					public double getValue(IWorld world, BlockPos pos, String tag) {
						TileEntity tileEntity = world.getTileEntity(pos);
						if (tileEntity != null)
							return tileEntity.getTileData().getDouble(tag);
						return -1;
					}
				}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "rad"))); index2++) {
					z1 = (double) (z1 + 1);
					ExtaAdditionsMod.LOGGER.info(("" + (/* @BlockState */(world.getBlockState(new BlockPos((int) x1, (int) y1, (int) z1))))));
					if (((world.getBlockState(new BlockPos((int) x1, (int) y1, (int) z1))).getBlock() == Blocks.STONE)) {
						if ((false)) {
							if ((Math.random() < 0.5)) {
								if (world instanceof World) {
									Block.spawnDrops(world.getBlockState(new BlockPos((int) x1, (int) y1, (int) z1)), (World) world,
											new BlockPos((int) x, (int) y, (int) z));
									world.destroyBlock(new BlockPos((int) x1, (int) y1, (int) z1), false);
								}
							}
						} else if ((true)) {
							if (world instanceof World) {
								Block.spawnDrops(world.getBlockState(new BlockPos((int) x1, (int) y1, (int) z1)), (World) world,
										new BlockPos((int) x, (int) y, (int) z));
								world.destroyBlock(new BlockPos((int) x1, (int) y1, (int) z1), false);
							}
						}
					}
				}
			}
		}
		world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
	}
}
