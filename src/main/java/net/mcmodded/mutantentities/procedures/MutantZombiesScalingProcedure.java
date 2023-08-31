package net.mcmodded.mutantentities.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcmodded.mutantentities.init.MutantEntitiesModAttributes;

public class MutantZombiesScalingProcedure {
	public static double execute(Entity entity) {
		if (entity == null)
			return 0;
		if (((LivingEntity) entity).getAttribute(MutantEntitiesModAttributes.SMOL.get()).getBaseValue() == 1) {
			return 0.75;
		}
		return 1.25;
	}
}
