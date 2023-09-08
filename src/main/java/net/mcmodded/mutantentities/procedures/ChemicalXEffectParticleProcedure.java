package net.mcmodded.mutantentities.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.particles.SimpleParticleType;

import net.mcmodded.mutantentities.init.MutantEntitiesModParticleTypes;

public class ChemicalXEffectParticleProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		world.addParticle((SimpleParticleType) (MutantEntitiesModParticleTypes.CHEMICAL_X_PARTICLE.get()), x, y, z, 2, 1, 2);
	}
}
