package net.mcmodded.mutantentities.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcmodded.mutantentities.init.MutantEntitiesModAttributes;

public class MutantMobsScalingProcedure {
	public static double execute(Entity entity) {
		if (entity == null)
			return 0;
		if (((LivingEntity) entity).getAttribute(MutantEntitiesModAttributes.SIZ.get()).getBaseValue() != 0) {
			return 1 * ((LivingEntity) entity).getAttribute(MutantEntitiesModAttributes.SIZ.get()).getBaseValue();
		}
		return 1;
	}
}
