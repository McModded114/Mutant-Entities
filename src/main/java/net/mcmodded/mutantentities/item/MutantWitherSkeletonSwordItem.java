
package net.mcmodded.mutantentities.item;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

import net.mcmodded.mutantentities.init.MutantEntitiesModTabs;

public class MutantWitherSkeletonSwordItem extends Item {
	public MutantWitherSkeletonSwordItem() {
		super(new Item.Properties().tab(MutantEntitiesModTabs.TAB_MUTANT_ENTITIES_ITEMS).durability(2031).rarity(Rarity.RARE));
	}

	@Override
	public int getEnchantmentValue() {
		return 15;
	}

	@Override
	public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
		return 1.5f;
	}
}
