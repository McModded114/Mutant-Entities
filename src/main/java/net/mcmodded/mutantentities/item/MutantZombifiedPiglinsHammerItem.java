
package net.mcmodded.mutantentities.item;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

public class MutantZombifiedPiglinsHammerItem extends Item {
	public MutantZombifiedPiglinsHammerItem() {
		super(new Item.Properties().durability(320).rarity(Rarity.RARE));
	}

	@Override
	public int getEnchantmentValue() {
		return 22;
	}

	@Override
	public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
		return 2.5f;
	}
}
