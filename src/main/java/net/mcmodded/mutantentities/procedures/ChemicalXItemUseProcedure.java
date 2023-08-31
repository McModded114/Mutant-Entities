package net.mcmodded.mutantentities.procedures;

import net.minecraft.world.item.ItemStack;

public class ChemicalXItemUseProcedure {
	public static void execute(ItemStack itemstack) {
		itemstack.shrink(1);
	}
}
