package net.mcmodded.mutantentities.procedures;

import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.Entity;

import net.mcmodded.mutantentities.entity.SpiderPigEntity;

public class SpiderPigTexturesProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if (entity instanceof TamableAnimal _tamEnt ? _tamEnt.isTame() : false) {
			if (entity instanceof SpiderPigEntity animatable)
				animatable.setTexture("spider_pig_saddled");
			return "empty";
		} else if (!(entity instanceof TamableAnimal _tamEnt ? _tamEnt.isTame() : false)) {
			if (entity instanceof SpiderPigEntity animatable)
				animatable.setTexture("spider_pig");
			return "empty";
		}
		return "empty";
	}
}
