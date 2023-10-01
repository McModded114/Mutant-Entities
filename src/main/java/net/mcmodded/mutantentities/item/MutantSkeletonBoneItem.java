
package net.mcmodded.mutantentities.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

import net.mcmodded.mutantentities.init.MutantEntitiesModTabs;

public class MutantSkeletonBoneItem extends Item {
	public MutantSkeletonBoneItem() {
		super(new Item.Properties().tab(MutantEntitiesModTabs.TAB_MUTANT_ENTITIES_ITEMS).stacksTo(64).rarity(Rarity.RARE));
	}
}
