
package net.mcreator.extaadditions.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Rarity;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;

import net.mcreator.extaadditions.ExtaAdditionsModElements;

@ExtaAdditionsModElements.ModElement.Tag
public class SeventhmoonItem extends ExtaAdditionsModElements.ModElement {
	@ObjectHolder("exta_additions:seventhmoon")
	public static final Item block = null;
	public SeventhmoonItem(ExtaAdditionsModElements instance) {
		super(instance, 68);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}
	public static class MusicDiscItemCustom extends MusicDiscItem {
		public MusicDiscItemCustom() {
			super(0, ExtaAdditionsModElements.sounds.get(new ResourceLocation("exta_additions:seventhmoon")),
					new Item.Properties().group(ItemGroup.MISC).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("seventhmoon");
		}
	}
}
