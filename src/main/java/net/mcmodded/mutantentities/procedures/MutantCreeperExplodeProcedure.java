package net.mcmodded.mutantentities.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.entity.Entity;

public class MutantCreeperExplodeProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (world.getLevelData().getGameRules().getBoolean(GameRules.RULE_MOBGRIEFING) == true) {
			if (world instanceof Level _level && !_level.isClientSide()) {
				_level.explode(entity, (entity.getX()), (entity.getY()), (entity.getZ()), 9, false, Explosion.BlockInteraction.BREAK);
			}
		}
	}
}
