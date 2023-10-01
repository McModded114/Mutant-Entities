package net.mcmodded.mutantentities.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcmodded.mutantentities.init.MutantEntitiesModEntities;
import net.mcmodded.mutantentities.entity.CreeperlingEntity;
import net.mcmodded.mutantentities.MutantEntitiesMod;

public class CreeperBombExplodeProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		MutantEntitiesMod.queueServerWork(80, () -> {
			if (world instanceof Level _level && !_level.isClientSide())
				_level.explode(null, x, y, z, 9, Explosion.BlockInteraction.BREAK);
			world.setBlock(new BlockPos(x, y, z), Blocks.AIR.defaultBlockState(), 3);
			for (int index0 = 0; index0 < (int) (Math.round(Math.random() * 2) + 1); index0++) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = new CreeperlingEntity(MutantEntitiesModEntities.CREEPERLING.get(), _level);
					entityToSpawn.moveTo(x, y, z, world.getRandom().nextFloat() * 360F, 0);
					if (entityToSpawn instanceof Mob _mobToSpawn)
						_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
					world.addFreshEntity(entityToSpawn);
				}
			}
		});
	}
}
