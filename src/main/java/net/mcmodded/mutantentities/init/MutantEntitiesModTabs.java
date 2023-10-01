
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcmodded.mutantentities.init;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;

public class MutantEntitiesModTabs {
	public static CreativeModeTab TAB_MUTANT_ENTITIES_ITEMS;
	public static CreativeModeTab TAB_MUTANT_ENTITIES_BLOCKS;
	public static CreativeModeTab TAB_MUTANT_ENTITIES_SPAWN_EGGS;

	public static void load() {
		TAB_MUTANT_ENTITIES_ITEMS = new CreativeModeTab("tabmutant_entities_items") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(MutantEntitiesModItems.ENDERSOUL_HAND.get());
			}

			@Override
			public boolean hasSearchBar() {
				return false;
			}
		};
		TAB_MUTANT_ENTITIES_BLOCKS = new CreativeModeTab("tabmutant_entities_blocks") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(MutantEntitiesModBlocks.CREEPER_BOMB.get());
			}

			@Override
			public boolean hasSearchBar() {
				return false;
			}
		};
		TAB_MUTANT_ENTITIES_SPAWN_EGGS = new CreativeModeTab("tabmutant_entities_spawn_eggs") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(MutantEntitiesModItems.MUTANT_ZOMBIE_SPAWN_EGG.get());
			}

			@Override
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
}
