package net.mcmodded.mutantentities.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.particles.SimpleParticleType;

import net.mcmodded.mutantentities.init.MutantEntitiesModParticleTypes;

public class ChemicalXEffectParticleProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		world.addParticle((SimpleParticleType) (MutantEntitiesModParticleTypes.CHEMICAL_X_PARTICLE.get()), (entity.getX()), (entity.getY() + entity.getBbHeight()), (entity.getZ()), (entity.getBbWidth() + 3), (entity.getBbHeight() / 2),
				(entity.getBbWidth() + 3));
	}
}
