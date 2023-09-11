package net.mcmodded.mutantentities.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcmodded.mutantentities.init.MutantEntitiesModAttributes;
import net.mcmodded.mutantentities.entity.MutantDrownedEntity;

public class MutantDrownedScalingProcedure {
	public static double execute(Entity entity) {
		if (entity == null)
			return 0;
		if (((LivingEntity) entity).getAttribute(MutantEntitiesModAttributes.MOBVAR.get()).getBaseValue() == 1) {
			if (entity instanceof MutantDrownedEntity animatable)
				animatable.setTexture("evolved_mutant_drowned");
			return MutantMobsScalingProcedure.execute(entity);
		} else if (((LivingEntity) entity).getAttribute(MutantEntitiesModAttributes.MOBVAR.get()).getBaseValue() == 2) {
			if (entity instanceof MutantDrownedEntity animatable)
				animatable.setTexture("mutant_drowned_pirate");
			return MutantMobsScalingProcedure.execute(entity);
		} else if (((LivingEntity) entity).getAttribute(MutantEntitiesModAttributes.MOBVAR.get()).getBaseValue() == 3) {
			if (entity instanceof MutantDrownedEntity animatable)
				animatable.setTexture("mutant_drowned_special");
			return MutantMobsScalingProcedure.execute(entity);
		}
		if (entity instanceof MutantDrownedEntity animatable)
			animatable.setTexture("mutant_drowned");
		return MutantMobsScalingProcedure.execute(entity);
	}
}
