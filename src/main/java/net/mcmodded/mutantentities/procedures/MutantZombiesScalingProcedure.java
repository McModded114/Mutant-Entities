package net.mcmodded.mutantentities.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcmodded.mutantentities.init.MutantEntitiesModAttributes;
import net.mcmodded.mutantentities.entity.MutantDrownedEntity;

public class MutantZombiesScalingProcedure {
	public static double execute(Entity entity) {
		if (entity == null)
			return 0;
		if (entity instanceof MutantDrownedEntity) {
			if (((LivingEntity) entity).getAttribute(MutantEntitiesModAttributes.VAR.get()).getBaseValue() == 1) {
				if (entity instanceof MutantDrownedEntity animatable)
					animatable.setTexture("evolved_mutant_drowned");
				if (((LivingEntity) entity).getAttribute(MutantEntitiesModAttributes.SIZ.get()).getBaseValue() != 0) {
					return 1.25 * ((LivingEntity) entity).getAttribute(MutantEntitiesModAttributes.SIZ.get()).getBaseValue();
				}
				return 1.25;
			} else if (((LivingEntity) entity).getAttribute(MutantEntitiesModAttributes.VAR.get()).getBaseValue() == 2) {
				if (entity instanceof MutantDrownedEntity animatable)
					animatable.setTexture("mutant_drowned_pirate");
				return 1.25 * ((LivingEntity) entity).getAttribute(MutantEntitiesModAttributes.SIZ.get()).getBaseValue();
			} else if (((LivingEntity) entity).getAttribute(MutantEntitiesModAttributes.VAR.get()).getBaseValue() == 3) {
				if (entity instanceof MutantDrownedEntity animatable)
					animatable.setTexture("mutant_drowned_special");
				if (entity instanceof MutantDrownedEntity animatable)
					animatable.setTexture("mutant_drowned");
				return 1.25 * ((LivingEntity) entity).getAttribute(MutantEntitiesModAttributes.SIZ.get()).getBaseValue();
			}
			return 1.25 * ((LivingEntity) entity).getAttribute(MutantEntitiesModAttributes.SIZ.get()).getBaseValue();
		}
		return 1.25 * ((LivingEntity) entity).getAttribute(MutantEntitiesModAttributes.SIZ.get()).getBaseValue();
	}
}
