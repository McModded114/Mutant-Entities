package net.mcmodded.mutantentities.procedures;

import net.minecraft.world.entity.Entity;

import net.mcmodded.mutantentities.entity.MutantZombieEntity;

import java.util.Calendar;

public class MutantZombieTexturesProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if (Calendar.getInstance().get(Calendar.DAY_OF_MONTH) < 30 && Calendar.getInstance().get(Calendar.DAY_OF_MONTH) > 20 && Calendar.getInstance().get(Calendar.MONTH) == 12) {
			if (entity instanceof MutantZombieEntity animatable)
				animatable.setTexture("mutant_zombie_holidays");
			return "empty";
		} else if (entity.getPersistentData().getDouble("variant") != 0 && !(Calendar.getInstance().get(Calendar.DAY_OF_MONTH) < 30 && Calendar.getInstance().get(Calendar.DAY_OF_MONTH) > 20 && Calendar.getInstance().get(Calendar.MONTH) == 12)) {
			if (entity instanceof MutantZombieEntity animatable)
				animatable.setTexture(("mutant_zombie" + Math.round(entity.getPersistentData().getDouble("variant"))));
			return "empty";
		}
		return "empty";
	}
}
