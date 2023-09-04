package net.mcmodded.mutantentities.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.particles.ParticleTypes;

public class ThrowableIceParticlesProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (Math.random() < 0.2) {
			world.addParticle(ParticleTypes.ITEM_SNOWBALL, x, y, z, 0.5, 0.5, 0.5);
		}
	}
}
