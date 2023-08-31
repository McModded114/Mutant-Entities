
package net.mcmodded.mutantentities.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class MutantWitherSkeletonBoneItem extends Item {
	public MutantWitherSkeletonBoneItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.RARE));
	}
}
