
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcmodded.mutantentities.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.level.levelgen.feature.Feature;

import net.mcmodded.mutantentities.world.features.ToxicDirtFeatureFeature;
import net.mcmodded.mutantentities.world.features.SolidChemicalXFeatureFeature;
import net.mcmodded.mutantentities.world.features.NuclearBlocksSpawningFeature;
import net.mcmodded.mutantentities.world.features.DeadGrassFeatureFeature;
import net.mcmodded.mutantentities.world.features.ChemicalXFeatureFeature;
import net.mcmodded.mutantentities.world.features.AncientBushFeatureFeature;
import net.mcmodded.mutantentities.MutantEntitiesMod;

@Mod.EventBusSubscriber
public class MutantEntitiesModFeatures {
	public static final DeferredRegister<Feature<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.FEATURES, MutantEntitiesMod.MODID);
	public static final RegistryObject<Feature<?>> CHEMICAL_X_FEATURE = REGISTRY.register("chemical_x_feature", ChemicalXFeatureFeature::new);
	public static final RegistryObject<Feature<?>> NUCLEAR_BLOCKS_SPAWNING = REGISTRY.register("nuclear_blocks_spawning", NuclearBlocksSpawningFeature::new);
	public static final RegistryObject<Feature<?>> TOXIC_DIRT_FEATURE = REGISTRY.register("toxic_dirt_feature", ToxicDirtFeatureFeature::new);
	public static final RegistryObject<Feature<?>> SOLID_CHEMICAL_X_FEATURE = REGISTRY.register("solid_chemical_x_feature", SolidChemicalXFeatureFeature::new);
	public static final RegistryObject<Feature<?>> DEAD_GRASS_FEATURE = REGISTRY.register("dead_grass_feature", DeadGrassFeatureFeature::new);
	public static final RegistryObject<Feature<?>> ANCIENT_BUSH_FEATURE = REGISTRY.register("ancient_bush_feature", AncientBushFeatureFeature::new);
}
