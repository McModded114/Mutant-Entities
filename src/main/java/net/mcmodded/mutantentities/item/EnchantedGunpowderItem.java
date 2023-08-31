
package net.mcmodded.mutantentities.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class EnchantedGunpowderItem extends Item {
	public EnchantedGunpowderItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.RARE));
	}
}
