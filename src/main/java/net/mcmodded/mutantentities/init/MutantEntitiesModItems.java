
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcmodded.mutantentities.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.ForgeSpawnEggItem;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import net.mcmodded.mutantentities.item.ThrowableIceItem;
import net.mcmodded.mutantentities.item.ThrowableGrassblockItem;
import net.mcmodded.mutantentities.item.ThrowableEndstoneItem;
import net.mcmodded.mutantentities.item.ThrowableDirtItem;
import net.mcmodded.mutantentities.item.ThrowableCobblestoneItem;
import net.mcmodded.mutantentities.item.MutantZombifiedPiglinsHammerItem;
import net.mcmodded.mutantentities.item.MutantWitherSkeletonSwordItem;
import net.mcmodded.mutantentities.item.MutantWitherSkeletonBoneItem;
import net.mcmodded.mutantentities.item.MutantWitherSkeletonBoneArmorArmorItem;
import net.mcmodded.mutantentities.item.MutantSkeletonBoneItem;
import net.mcmodded.mutantentities.item.MutantSkeletonBoneArmorArmorItem;
import net.mcmodded.mutantentities.item.LorePaperItem;
import net.mcmodded.mutantentities.item.EndersoulHandItem;
import net.mcmodded.mutantentities.item.EnchantedGunpowderItem;
import net.mcmodded.mutantentities.item.ChemicalXItemItem;
import net.mcmodded.mutantentities.MutantEntitiesMod;

public class MutantEntitiesModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, MutantEntitiesMod.MODID);
	public static final RegistryObject<Item> SOLID_CHEMICAL_X = block(MutantEntitiesModBlocks.SOLID_CHEMICAL_X);
	public static final RegistryObject<Item> TOXIC_DIRT = block(MutantEntitiesModBlocks.TOXIC_DIRT);
	public static final RegistryObject<Item> WASTELAND_DIRT = block(MutantEntitiesModBlocks.WASTELAND_DIRT);
	public static final RegistryObject<Item> DEAD_GRASS = block(MutantEntitiesModBlocks.DEAD_GRASS);
	public static final RegistryObject<Item> MUTANT_ZOMBIE_SPAWN_EGG = REGISTRY.register("mutant_zombie_spawn_egg", () -> new ForgeSpawnEggItem(MutantEntitiesModEntities.MUTANT_ZOMBIE, -16732241, -8807323, new Item.Properties()));
	public static final RegistryObject<Item> MUTANT_HUSK_SPAWN_EGG = REGISTRY.register("mutant_husk_spawn_egg", () -> new ForgeSpawnEggItem(MutantEntitiesModEntities.MUTANT_HUSK, -8818591, -1651564, new Item.Properties()));
	public static final RegistryObject<Item> MUTANT_ZOMBIFIED_PIGLIN_SPAWN_EGG = REGISTRY.register("mutant_zombified_piglin_spawn_egg",
			() -> new ForgeSpawnEggItem(MutantEntitiesModEntities.MUTANT_ZOMBIFIED_PIGLIN, -1404013, -11767511, new Item.Properties()));
	public static final RegistryObject<Item> MUTANT_SKELETON_SPAWN_EGG = REGISTRY.register("mutant_skeleton_spawn_egg", () -> new ForgeSpawnEggItem(MutantEntitiesModEntities.MUTANT_SKELETON, -4079167, -11974327, new Item.Properties()));
	public static final RegistryObject<Item> MUTANT_SKELETON_BONE = REGISTRY.register("mutant_skeleton_bone", () -> new MutantSkeletonBoneItem());
	public static final RegistryObject<Item> MUTANT_CREEPER_SPAWN_EGG = REGISTRY.register("mutant_creeper_spawn_egg", () -> new ForgeSpawnEggItem(MutantEntitiesModEntities.MUTANT_CREEPER, -15882485, -16121856, new Item.Properties()));
	public static final RegistryObject<Item> CREEPERLING_SPAWN_EGG = REGISTRY.register("creeperling_spawn_egg", () -> new ForgeSpawnEggItem(MutantEntitiesModEntities.CREEPERLING, -15882485, -16777216, new Item.Properties()));
	public static final RegistryObject<Item> MUTANT_IRON_GOLEM_SPAWN_EGG = REGISTRY.register("mutant_iron_golem_spawn_egg", () -> new ForgeSpawnEggItem(MutantEntitiesModEntities.MUTANT_IRON_GOLEM, -2372158, -9133262, new Item.Properties()));
	public static final RegistryObject<Item> CREEPER_BOMB = block(MutantEntitiesModBlocks.CREEPER_BOMB);
	public static final RegistryObject<Item> ENCHANTED_GUNPOWDER = REGISTRY.register("enchanted_gunpowder", () -> new EnchantedGunpowderItem());
	public static final RegistryObject<Item> MUTANT_SKELETON_BONE_ARMOR_ARMOR_HELMET = REGISTRY.register("mutant_skeleton_bone_armor_armor_helmet", () -> new MutantSkeletonBoneArmorArmorItem.Helmet());
	public static final RegistryObject<Item> MUTANT_SKELETON_BONE_ARMOR_ARMOR_CHESTPLATE = REGISTRY.register("mutant_skeleton_bone_armor_armor_chestplate", () -> new MutantSkeletonBoneArmorArmorItem.Chestplate());
	public static final RegistryObject<Item> MUTANT_SKELETON_BONE_ARMOR_ARMOR_LEGGINGS = REGISTRY.register("mutant_skeleton_bone_armor_armor_leggings", () -> new MutantSkeletonBoneArmorArmorItem.Leggings());
	public static final RegistryObject<Item> MUTANT_SKELETON_BONE_ARMOR_ARMOR_BOOTS = REGISTRY.register("mutant_skeleton_bone_armor_armor_boots", () -> new MutantSkeletonBoneArmorArmorItem.Boots());
	public static final RegistryObject<Item> MUTANT_WITHER_SKELETON_SPAWN_EGG = REGISTRY.register("mutant_wither_skeleton_spawn_egg",
			() -> new ForgeSpawnEggItem(MutantEntitiesModEntities.MUTANT_WITHER_SKELETON, -15461356, -12104371, new Item.Properties()));
	public static final RegistryObject<Item> MUTANT_WITHER_SKELETON_BONE = REGISTRY.register("mutant_wither_skeleton_bone", () -> new MutantWitherSkeletonBoneItem());
	public static final RegistryObject<Item> MUTANT_WITHER_SKELETON_BONE_ARMOR_ARMOR_HELMET = REGISTRY.register("mutant_wither_skeleton_bone_armor_armor_helmet", () -> new MutantWitherSkeletonBoneArmorArmorItem.Helmet());
	public static final RegistryObject<Item> MUTANT_WITHER_SKELETON_BONE_ARMOR_ARMOR_CHESTPLATE = REGISTRY.register("mutant_wither_skeleton_bone_armor_armor_chestplate", () -> new MutantWitherSkeletonBoneArmorArmorItem.Chestplate());
	public static final RegistryObject<Item> MUTANT_WITHER_SKELETON_BONE_ARMOR_ARMOR_LEGGINGS = REGISTRY.register("mutant_wither_skeleton_bone_armor_armor_leggings", () -> new MutantWitherSkeletonBoneArmorArmorItem.Leggings());
	public static final RegistryObject<Item> MUTANT_WITHER_SKELETON_BONE_ARMOR_ARMOR_BOOTS = REGISTRY.register("mutant_wither_skeleton_bone_armor_armor_boots", () -> new MutantWitherSkeletonBoneArmorArmorItem.Boots());
	public static final RegistryObject<Item> MUTANT_DROWNED_SPAWN_EGG = REGISTRY.register("mutant_drowned_spawn_egg", () -> new ForgeSpawnEggItem(MutantEntitiesModEntities.MUTANT_DROWNED, -7343657, -8807323, new Item.Properties()));
	public static final RegistryObject<Item> MUTANT_DROWNED_AQUA_SPAWN_EGG = REGISTRY.register("mutant_drowned_aqua_spawn_egg", () -> new ForgeSpawnEggItem(MutantEntitiesModEntities.MUTANT_DROWNED_AQUA, -7343657, -8807323, new Item.Properties()));
	public static final RegistryObject<Item> EVOLVED_MUTANT_DROWNED_SPAWN_EGG = REGISTRY.register("evolved_mutant_drowned_spawn_egg",
			() -> new ForgeSpawnEggItem(MutantEntitiesModEntities.EVOLVED_MUTANT_DROWNED, -7343657, -8807323, new Item.Properties()));
	public static final RegistryObject<Item> THORNY_MUTANT_HUSK_SPAWN_EGG = REGISTRY.register("thorny_mutant_husk_spawn_egg", () -> new ForgeSpawnEggItem(MutantEntitiesModEntities.THORNY_MUTANT_HUSK, -8818591, -1651564, new Item.Properties()));
	public static final RegistryObject<Item> LORE_PAPER = REGISTRY.register("lore_paper", () -> new LorePaperItem());
	public static final RegistryObject<Item> MUTANT_ENDERMAN_SPAWN_EGG = REGISTRY.register("mutant_enderman_spawn_egg", () -> new ForgeSpawnEggItem(MutantEntitiesModEntities.MUTANT_ENDERMAN, -15329770, -16777216, new Item.Properties()));
	public static final RegistryObject<Item> NUCLEAR_SCIENCETABLE = block(MutantEntitiesModBlocks.NUCLEAR_SCIENCETABLE);
	public static final RegistryObject<Item> CHEMICAL_X_ITEM = REGISTRY.register("chemical_x_item", () -> new ChemicalXItemItem());
	public static final RegistryObject<Item> ENDERSOUL_SPAWN_EGG = REGISTRY.register("endersoul_spawn_egg", () -> new ForgeSpawnEggItem(MutantEntitiesModEntities.ENDERSOUL, -10992800, -12241588, new Item.Properties()));
	public static final RegistryObject<Item> ENDERSOUL_HAND = REGISTRY.register("endersoul_hand", () -> new EndersoulHandItem());
	public static final RegistryObject<Item> THROWABLE_COBBLESTONE = REGISTRY.register("throwable_cobblestone", () -> new ThrowableCobblestoneItem());
	public static final RegistryObject<Item> THROWABLE_ENDSTONE = REGISTRY.register("throwable_endstone", () -> new ThrowableEndstoneItem());
	public static final RegistryObject<Item> THROWABLE_DIRT = REGISTRY.register("throwable_dirt", () -> new ThrowableDirtItem());
	public static final RegistryObject<Item> THROWABLE_GRASSBLOCK = REGISTRY.register("throwable_grassblock", () -> new ThrowableGrassblockItem());
	public static final RegistryObject<Item> SPIDER_PIG_SPAWN_EGG = REGISTRY.register("spider_pig_spawn_egg", () -> new ForgeSpawnEggItem(MutantEntitiesModEntities.SPIDER_PIG, -13357785, -1006174, new Item.Properties()));
	public static final RegistryObject<Item> MUTANT_SHULKER_SPAWN_EGG = REGISTRY.register("mutant_shulker_spawn_egg", () -> new ForgeSpawnEggItem(MutantEntitiesModEntities.MUTANT_SHULKER, -7051372, -11716526, new Item.Properties()));
	public static final RegistryObject<Item> MUTANT_SNOW_GOLEM_SPAWN_EGG = REGISTRY.register("mutant_snow_golem_spawn_egg", () -> new ForgeSpawnEggItem(MutantEntitiesModEntities.MUTANT_SNOW_GOLEM, -2493710, -8280924, new Item.Properties()));
	public static final RegistryObject<Item> MUTANT_ZOMBIFIED_PIGLINS_HAMMER = REGISTRY.register("mutant_zombified_piglins_hammer", () -> new MutantZombifiedPiglinsHammerItem());
	public static final RegistryObject<Item> MUTANT_WITHER_SKELETON_SWORD = REGISTRY.register("mutant_wither_skeleton_sword", () -> new MutantWitherSkeletonSwordItem());
	public static final RegistryObject<Item> THROWABLE_ICE = REGISTRY.register("throwable_ice", () -> new ThrowableIceItem());
	public static final RegistryObject<Item> ANCIENT_BUSH = block(MutantEntitiesModBlocks.ANCIENT_BUSH);

	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
