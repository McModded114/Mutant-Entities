
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcmodded.mutantentities.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.effect.MobEffect;

import net.mcmodded.mutantentities.potion.ChemicalXEffectMobEffect;
import net.mcmodded.mutantentities.MutantEntitiesMod;

public class MutantEntitiesModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, MutantEntitiesMod.MODID);
	public static final RegistryObject<MobEffect> CHEMICAL_X_EFFECT = REGISTRY.register("chemical_x_effect", () -> new ChemicalXEffectMobEffect());
}
