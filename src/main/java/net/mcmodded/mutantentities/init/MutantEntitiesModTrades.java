
/*
*	MCreator note: This file will be REGENERATED on each build.
*/
package net.mcmodded.mutantentities.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.common.BasicItemListing;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class MutantEntitiesModTrades {
	@SubscribeEvent
	public static void registerTrades(VillagerTradesEvent event) {
		if (event.getType() == MutantEntitiesModVillagerProfessions.NUCLEAR_SCIENTIST.get()) {
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.EMERALD, 5),

					new ItemStack(MutantEntitiesModItems.LORE_PAPER.get(), 3), 10, 5, 0.05f));
			event.getTrades().get(2)
					.add(new BasicItemListing(new ItemStack(MutantEntitiesModBlocks.SOLID_CHEMICAL_X.get(), 5), new ItemStack(MutantEntitiesModItems.LORE_PAPER.get(), 3), new ItemStack(MutantEntitiesModItems.CHEMICAL_X_ITEM.get()), 10, 5, 0.2f));
			event.getTrades().get(3)
					.add(new BasicItemListing(new ItemStack(MutantEntitiesModBlocks.WASTELAND_DIRT.get(), 3), new ItemStack(MutantEntitiesModItems.CHEMICAL_X_ITEM.get()), new ItemStack(MutantEntitiesModBlocks.TOXIC_DIRT.get(), 3), 10, 5, 0.05f));
		}
	}
}
