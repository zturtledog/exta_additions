package net.mcreator.extaadditions.procedures;

import net.minecraftforge.fml.server.ServerLifecycleHooks;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Util;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.block.BlockState;

import net.mcreator.extaadditions.ExtaAdditionsMod;

import java.util.Map;

import java.io.IOException;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.BufferedReader;

public class CC0BUpdateTickProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				ExtaAdditionsMod.LOGGER.warn("Failed to load dependency x for procedure CC0BUpdateTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				ExtaAdditionsMod.LOGGER.warn("Failed to load dependency y for procedure CC0BUpdateTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				ExtaAdditionsMod.LOGGER.warn("Failed to load dependency z for procedure CC0BUpdateTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				ExtaAdditionsMod.LOGGER.warn("Failed to load dependency world for procedure CC0BUpdateTick!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		String action = "";
		String value = "";
		String AS = "";
		boolean AB = false;
		double A = 0;
		double TAB = 0;
		if ((new Object() {
			public boolean getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getBoolean(tag);
				return false;
			}
		}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "active"))) {
			File sasm = new File((new Object() {
				public String getValue(IWorld world, BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getString(tag);
					return "";
				}
			}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "path")), File.separator + (((new Object() {
				public String getValue(IWorld world, BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getString(tag);
					return "";
				}
			}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "file"))) + "" + (".sasm")));
			try {
				BufferedReader sasmReader = new BufferedReader(new FileReader(sasm));
				String stringiterator = "";
				while ((stringiterator = sasmReader.readLine()) != null) {
					if (((stringiterator).length() > 5)) {
						action = (String) (stringiterator.substring((int) 0, (int) 5));
						if (AB) {
							TAB = (double) 1;
						} else {
							TAB = (double) 0;
						}
						value = (String) ((((stringiterator.substring((int) 6, (int) (stringiterator).length())).replace("[A]", ("" + (A))))
								.replace("[AS]", AS)).replace("[AB]", ("" + (TAB))));
						if (((action).equals("print"))) {
							if (!world.isRemote()) {
								MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
								if (mcserv != null)
									mcserv.getPlayerList().func_232641_a_(new StringTextComponent(value), ChatType.SYSTEM, Util.DUMMY_UUID);
							}
						}
						if (((action).equals("incNA"))) {
							A = (double) (A + new Object() {
								double convert(String s) {
									try {
										return Double.parseDouble(s.trim());
									} catch (Exception e) {
									}
									return 0;
								}
							}.convert(value));
						}
						if (((action).equals("decNA"))) {
							A = (double) (A - new Object() {
								double convert(String s) {
									try {
										return Double.parseDouble(s.trim());
									} catch (Exception e) {
									}
									return 0;
								}
							}.convert(value));
						}
						if (((action).equals("modNA"))) {
							A = (double) (A % new Object() {
								double convert(String s) {
									try {
										return Double.parseDouble(s.trim());
									} catch (Exception e) {
									}
									return 0;
								}
							}.convert(value));
						}
						if (((action).equals("mulNA"))) {
							A = (double) (A * new Object() {
								double convert(String s) {
									try {
										return Double.parseDouble(s.trim());
									} catch (Exception e) {
									}
									return 0;
								}
							}.convert(value));
						}
						if (((action).equals("divNA"))) {
							A = (double) (A / new Object() {
								double convert(String s) {
									try {
										return Double.parseDouble(s.trim());
									} catch (Exception e) {
									}
									return 0;
								}
							}.convert(value));
						}
						if (((action).equals("expNA"))) {
							A = (double) Math.pow(A, new Object() {
								double convert(String s) {
									try {
										return Double.parseDouble(s.trim());
									} catch (Exception e) {
									}
									return 0;
								}
							}.convert(value));
						}
						if (((action).equals("NbtSA"))) {
							if (!world.isRemote()) {
								BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
								TileEntity _tileEntity = world.getTileEntity(_bp);
								BlockState _bs = world.getBlockState(_bp);
								if (_tileEntity != null)
									_tileEntity.getTileData().putDouble(value, A);
								if (world instanceof World)
									((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
							}
						}
						if (((action).equals("LNbTA"))) {
							A = (double) (new Object() {
								public double getValue(IWorld world, BlockPos pos, String tag) {
									TileEntity tileEntity = world.getTileEntity(pos);
									if (tileEntity != null)
										return tileEntity.getTileData().getDouble(tag);
									return -1;
								}
							}.getValue(world, new BlockPos((int) x, (int) y, (int) z), value));
						}
						if (((action).equals("SbtSA"))) {
							if (!world.isRemote()) {
								BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
								TileEntity _tileEntity = world.getTileEntity(_bp);
								BlockState _bs = world.getBlockState(_bp);
								if (_tileEntity != null)
									_tileEntity.getTileData().putString(value, AS);
								if (world instanceof World)
									((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
							}
						}
						if (((action).equals("LSbTA"))) {
							AS = (String) (new Object() {
								public String getValue(IWorld world, BlockPos pos, String tag) {
									TileEntity tileEntity = world.getTileEntity(pos);
									if (tileEntity != null)
										return tileEntity.getTileData().getString(tag);
									return "";
								}
							}.getValue(world, new BlockPos((int) x, (int) y, (int) z), value));
						}
						if (((action).equals("LBbTA"))) {
							AB = (boolean) (new Object() {
								public boolean getValue(IWorld world, BlockPos pos, String tag) {
									TileEntity tileEntity = world.getTileEntity(pos);
									if (tileEntity != null)
										return tileEntity.getTileData().getBoolean(tag);
									return false;
								}
							}.getValue(world, new BlockPos((int) x, (int) y, (int) z), value));
						}
						if (((action).equals("BbtSA"))) {
							if (!world.isRemote()) {
								BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
								TileEntity _tileEntity = world.getTileEntity(_bp);
								BlockState _bs = world.getBlockState(_bp);
								if (_tileEntity != null)
									_tileEntity.getTileData().putBoolean(value, AB);
								if (world instanceof World)
									((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
							}
						}
						if (((action).equals("catSA"))) {
							AS = (String) ((action) + "" + (value));
						}
						if (((action).equals("setSA"))) {
							AS = (String) value;
						}
						if (((action).equals("setBA"))) {
							if ((new Object() {
								double convert(String s) {
									try {
										return Double.parseDouble(s.trim());
									} catch (Exception e) {
									}
									return 0;
								}
							}.convert(value) == 0)) {
								AB = (boolean) (false);
							} else if ((new Object() {
								double convert(String s) {
									try {
										return Double.parseDouble(s.trim());
									} catch (Exception e) {
									}
									return 0;
								}
							}.convert(value) == 1)) {
								AB = (boolean) (true);
							}
						}
						if (((action).equals("ifArF"))) {
							if (AB) {
								if (!world.isRemote()) {
									BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
									TileEntity _tileEntity = world.getTileEntity(_bp);
									BlockState _bs = world.getBlockState(_bp);
									if (_tileEntity != null)
										_tileEntity.getTileData().putString("file", value);
									if (world instanceof World)
										((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
								}
							}
						}
						if (((action).equals("ifSrA"))) {
							if (((value).equals(AS))) {
								AB = (boolean) (true);
							} else {
								AB = (boolean) (false);
							}
						}
						if (((action).equals("ifNmA"))) {
							if ((A == new Object() {
								double convert(String s) {
									try {
										return Double.parseDouble(s.trim());
									} catch (Exception e) {
									}
									return 0;
								}
							}.convert(value))) {
								AB = (boolean) (true);
							} else {
								AB = (boolean) (false);
							}
						}
					}
				}
				sasmReader.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
