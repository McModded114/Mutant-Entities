package net.mcmodded.mutantentities.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;

import net.mcmodded.mutantentities.init.MutantEntitiesModEntities;
import net.mcmodded.mutantentities.entity.CreeperlingEntity;

import java.util.Comparator;

public class SpawnCreeperlingProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		Entity creeperling = null;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) * 0.7) {
			if (sourceentity instanceof Player || sourceentity instanceof LivingEntity) {
				for (int index0 = 0; index0 < 3; index0++) {
					if (Math.random() < 0.3) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = new CreeperlingEntity(MutantEntitiesModEntities.CREEPERLING.get(), _level);
							entityToSpawn.moveTo(x, y, z, world.getRandom().nextFloat() * 360F, 0);
							if (entityToSpawn instanceof Mob _mobToSpawn)
								_mobToSpawn.finalizeSpawn(_level, _level.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
							_level.addFreshEntity(entityToSpawn);
						}
						creeperling = (Entity) world.getEntitiesOfClass(CreeperlingEntity.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null);
						if (creeperling instanceof Mob _entity && sourceentity instanceof LivingEntity _ent)
							_entity.setTarget(_ent);
					}
				}
			}
		}
	}
}
