
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcmodded.mutantentities.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.CreativeModeTabEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class MutantEntitiesModTabs {
	@SubscribeEvent
	public static void buildTabContentsVanilla(CreativeModeTabEvent.BuildContents tabData) {

		if (tabData.getTab() == CreativeModeTabs.COMBAT) {
			tabData.accept(MutantEntitiesModItems.MUTANT_SKELETON_BONE_ARMOR_ARMOR_HELMET.get());
			tabData.accept(MutantEntitiesModItems.MUTANT_SKELETON_BONE_ARMOR_ARMOR_CHESTPLATE.get());
			tabData.accept(MutantEntitiesModItems.MUTANT_SKELETON_BONE_ARMOR_ARMOR_LEGGINGS.get());
			tabData.accept(MutantEntitiesModItems.MUTANT_SKELETON_BONE_ARMOR_ARMOR_BOOTS.get());
			tabData.accept(MutantEntitiesModItems.MUTANT_WITHER_SKELETON_BONE_ARMOR_ARMOR_HELMET.get());
			tabData.accept(MutantEntitiesModItems.MUTANT_WITHER_SKELETON_BONE_ARMOR_ARMOR_CHESTPLATE.get());
			tabData.accept(MutantEntitiesModItems.MUTANT_WITHER_SKELETON_BONE_ARMOR_ARMOR_LEGGINGS.get());
			tabData.accept(MutantEntitiesModItems.MUTANT_WITHER_SKELETON_BONE_ARMOR_ARMOR_BOOTS.get());
			tabData.accept(MutantEntitiesModItems.MUTANT_ARROW.get());
		}
	}

	@SubscribeEvent
	public static void buildTabContentsModded(CreativeModeTabEvent.Register event) {
		event.registerCreativeModeTab(new ResourceLocation("mutant_entities", "mutant_entities_blocks"),
				builder -> builder.title(Component.translatable("item_group.mutant_entities.mutant_entities_blocks")).icon(() -> new ItemStack(MutantEntitiesModBlocks.CREEPER_BOMB.get())).displayItems((parameters, tabData) -> {
					tabData.accept(MutantEntitiesModBlocks.SOLID_CHEMICAL_X.get().asItem());
					tabData.accept(MutantEntitiesModBlocks.TOXIC_DIRT.get().asItem());
					tabData.accept(MutantEntitiesModBlocks.WASTELAND_DIRT.get().asItem());
					tabData.accept(MutantEntitiesModBlocks.DEAD_GRASS.get().asItem());
					tabData.accept(MutantEntitiesModBlocks.CREEPER_BOMB.get().asItem());
					tabData.accept(MutantEntitiesModBlocks.NUCLEAR_SCIENCETABLE.get().asItem());
					tabData.accept(MutantEntitiesModBlocks.ANCIENT_BUSH.get().asItem());
				})

		);
		event.registerCreativeModeTab(new ResourceLocation("mutant_entities", "mutant_entities_items"),
				builder -> builder.title(Component.translatable("item_group.mutant_entities.mutant_entities_items")).icon(() -> new ItemStack(MutantEntitiesModItems.ENDERSOUL_HAND.get())).displayItems((parameters, tabData) -> {
					tabData.accept(MutantEntitiesModItems.MUTANT_SKELETON_BONE.get());
					tabData.accept(MutantEntitiesModItems.ENCHANTED_GUNPOWDER.get());
					tabData.accept(MutantEntitiesModItems.MUTANT_WITHER_SKELETON_BONE.get());
					tabData.accept(MutantEntitiesModItems.LORE_PAPER.get());
					tabData.accept(MutantEntitiesModItems.CHEMICAL_X_ITEM.get());
					tabData.accept(MutantEntitiesModItems.ENDERSOUL_HAND.get());
					tabData.accept(MutantEntitiesModItems.MUTANT_ZOMBIFIED_PIGLINS_HAMMER.get());
					tabData.accept(MutantEntitiesModItems.MUTANT_WITHER_SKELETON_SWORD.get());
				})

		);
		event.registerCreativeModeTab(new ResourceLocation("mutant_entities", "mutant_entities_spawn_eggs"),
				builder -> builder.title(Component.translatable("item_group.mutant_entities.mutant_entities_spawn_eggs")).icon(() -> new ItemStack(MutantEntitiesModItems.MUTANT_ZOMBIE_SPAWN_EGG.get())).displayItems((parameters, tabData) -> {
					tabData.accept(MutantEntitiesModItems.MUTANT_ZOMBIE_SPAWN_EGG.get());
					tabData.accept(MutantEntitiesModItems.MUTANT_HUSK_SPAWN_EGG.get());
					tabData.accept(MutantEntitiesModItems.MUTANT_ZOMBIFIED_PIGLIN_SPAWN_EGG.get());
					tabData.accept(MutantEntitiesModItems.MUTANT_SKELETON_SPAWN_EGG.get());
					tabData.accept(MutantEntitiesModItems.MUTANT_CREEPER_SPAWN_EGG.get());
					tabData.accept(MutantEntitiesModItems.CREEPERLING_SPAWN_EGG.get());
					tabData.accept(MutantEntitiesModItems.MUTANT_IRON_GOLEM_SPAWN_EGG.get());
					tabData.accept(MutantEntitiesModItems.MUTANT_WITHER_SKELETON_SPAWN_EGG.get());
					tabData.accept(MutantEntitiesModItems.MUTANT_DROWNED_SPAWN_EGG.get());
					tabData.accept(MutantEntitiesModItems.THORNY_MUTANT_HUSK_SPAWN_EGG.get());
					tabData.accept(MutantEntitiesModItems.MUTANT_ENDERMAN_SPAWN_EGG.get());
					tabData.accept(MutantEntitiesModItems.ENDERSOUL_SPAWN_EGG.get());
					tabData.accept(MutantEntitiesModItems.SPIDER_PIG_SPAWN_EGG.get());
					tabData.accept(MutantEntitiesModItems.MUTANT_SHULKER_SPAWN_EGG.get());
					tabData.accept(MutantEntitiesModItems.MUTANT_SNOW_GOLEM_SPAWN_EGG.get());
				})

		);
	}
}
