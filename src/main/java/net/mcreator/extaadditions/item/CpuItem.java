
package net.mcreator.extaadditions.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.extaadditions.ExtaAdditionsModElements;

@ExtaAdditionsModElements.ModElement.Tag
public class CpuItem extends ExtaAdditionsModElements.ModElement {
	@ObjectHolder("exta_additions:cpu")
	public static final Item block = null;
	public CpuItem(ExtaAdditionsModElements instance) {
		super(instance, 69);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.MISC).maxStackSize(12).rarity(Rarity.RARE));
			setRegistryName("cpu");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
