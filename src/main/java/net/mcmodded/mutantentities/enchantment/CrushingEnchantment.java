
package net.mcmodded.mutantentities.enchantment;

import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.EquipmentSlot;

import net.mcmodded.mutantentities.init.MutantEntitiesModItems;

public class CrushingEnchantment extends Enchantment {
	public CrushingEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.UNCOMMON, EnchantmentCategory.BREAKABLE, slots);
	}

	@Override
	public int getMaxLevel() {
		return 3;
	}

	@Override
	public boolean canApplyAtEnchantingTable(ItemStack itemstack) {
		return Ingredient.of(new ItemStack(MutantEntitiesModItems.MUTANT_ZOMBIFIED_PIGLINS_HAMMER.get())).test(itemstack);
	}
}
