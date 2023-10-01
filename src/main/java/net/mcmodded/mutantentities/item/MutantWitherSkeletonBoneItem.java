
package net.mcmodded.mutantentities.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

import net.mcmodded.mutantentities.init.MutantEntitiesModTabs;

public class MutantWitherSkeletonBoneItem extends Item {
	public MutantWitherSkeletonBoneItem() {
		super(new Item.Properties().tab(MutantEntitiesModTabs.TAB_MUTANT_ENTITIES_ITEMS).stacksTo(64).rarity(Rarity.RARE));
	}
}
