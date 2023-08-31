
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcmodded.mutantentities.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleType;

import net.mcmodded.mutantentities.MutantEntitiesMod;

public class MutantEntitiesModParticleTypes {
	public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, MutantEntitiesMod.MODID);
	public static final RegistryObject<SimpleParticleType> CHEMICAL_X_PARTICLE = REGISTRY.register("chemical_x_particle", () -> new SimpleParticleType(true));
}
