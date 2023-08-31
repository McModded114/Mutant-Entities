
package net.mcmodded.mutantentities.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class MutantSkeletonBoneItem extends Item {
	public MutantSkeletonBoneItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.RARE));
	}
}
