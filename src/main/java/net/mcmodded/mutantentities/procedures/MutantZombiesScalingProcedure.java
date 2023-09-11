package net.mcmodded.mutantentities.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcmodded.mutantentities.init.MutantEntitiesModAttributes;
import net.mcmodded.mutantentities.entity.MutantZombieEntity;

import java.util.Calendar;

public class MutantZombiesScalingProcedure {
	public static double execute(Entity entity) {
		if (entity == null)
			return 0;
		if (Calendar.getInstance().get(Calendar.DAY_OF_MONTH) < 30 && Calendar.getInstance().get(Calendar.DAY_OF_MONTH) > 20 && Calendar.getInstance().get(Calendar.MONTH) == 12) {
			if (entity instanceof MutantZombieEntity animatable)
				animatable.setTexture("mutant_zombie_holidays");
			return 1.25 * ((LivingEntity) entity).getAttribute(MutantEntitiesModAttributes.SIZ.get()).getBaseValue();
		} else if (((LivingEntity) entity).getAttribute(MutantEntitiesModAttributes.VAR.get()).getBaseValue() != 0
				&& !(Calendar.getInstance().get(Calendar.DAY_OF_MONTH) < 30 && Calendar.getInstance().get(Calendar.DAY_OF_MONTH) > 20 && Calendar.getInstance().get(Calendar.MONTH) == 12)) {
			if (entity instanceof MutantZombieEntity animatable)
				animatable.setTexture(("mutant_zombie" + Math.round(((LivingEntity) entity).getAttribute(MutantEntitiesModAttributes.VAR.get()).getBaseValue())));
			return 1.25 * ((LivingEntity) entity).getAttribute(MutantEntitiesModAttributes.SIZ.get()).getBaseValue();
		}
		if (entity instanceof MutantZombieEntity animatable)
			animatable.setTexture("mutant_zombie");
		return 1.25 * ((LivingEntity) entity).getAttribute(MutantEntitiesModAttributes.SIZ.get()).getBaseValue();
	}
}
