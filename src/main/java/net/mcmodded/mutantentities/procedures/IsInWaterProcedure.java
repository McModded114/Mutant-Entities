package net.mcmodded.mutantentities.procedures;

import net.minecraft.world.entity.Entity;

public class IsInWaterProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return entity.isInWaterOrBubble();
	}
}
