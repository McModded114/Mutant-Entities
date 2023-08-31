package net.mcmodded.mutantentities.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import net.mcmodded.mutantentities.entity.MutantSkeletonEntity;
import net.mcmodded.mutantentities.MutantEntitiesMod;

public class MutantSkeletonShootArrowProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (Math.random() < 0.2) {
			if (Math.random() < 0.5) {
				for (int index0 = 0; index0 < Math.round(1 + Math.random() * 3); index0++) {
					MutantEntitiesMod.queueServerWork(26, () -> {
						MutantEntitiesMod.queueServerWork(10, () -> {
							if (entity instanceof MutantSkeletonEntity) {
								((MutantSkeletonEntity) entity).setAnimation("shoot");
							}
							MutantEntitiesMod.queueServerWork(20, () -> {
								{
									Entity _shootFrom = entity;
									Level projectileLevel = _shootFrom.level;
									if (!projectileLevel.isClientSide()) {
										Projectile _entityToSpawn = new Object() {
											public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
												AbstractArrow entityToSpawn = new Arrow(EntityType.ARROW, level);
												entityToSpawn.setOwner(shooter);
												entityToSpawn.setBaseDamage(damage);
												entityToSpawn.setKnockback(knockback);
												entityToSpawn.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
												return entityToSpawn;
											}
										}.getArrow(projectileLevel, entity, 15, (int) 0.5);
										_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
										_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1, (float) Math.random());
										projectileLevel.addFreshEntity(_entityToSpawn);
									}
								}
							});
						});
						MutantEntitiesMod.queueServerWork(10, () -> {
							if (entity instanceof MutantSkeletonEntity) {
								((MutantSkeletonEntity) entity).setAnimation("shoot");
							}
							MutantEntitiesMod.queueServerWork(20, () -> {
								{
									Entity _shootFrom = entity;
									Level projectileLevel = _shootFrom.level;
									if (!projectileLevel.isClientSide()) {
										Projectile _entityToSpawn = new Object() {
											public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
												AbstractArrow entityToSpawn = new Arrow(EntityType.ARROW, level);
												entityToSpawn.setOwner(shooter);
												entityToSpawn.setBaseDamage(damage);
												entityToSpawn.setKnockback(knockback);
												entityToSpawn.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
												return entityToSpawn;
											}
										}.getArrow(projectileLevel, entity, 20, (int) 0.5);
										_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
										_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 2, (float) Math.random());
										projectileLevel.addFreshEntity(_entityToSpawn);
									}
								}
							});
						});
						MutantEntitiesMod.queueServerWork(10, () -> {
							if (entity instanceof MutantSkeletonEntity) {
								((MutantSkeletonEntity) entity).setAnimation("shoot");
							}
							MutantEntitiesMod.queueServerWork(20, () -> {
								{
									Entity _shootFrom = entity;
									Level projectileLevel = _shootFrom.level;
									if (!projectileLevel.isClientSide()) {
										Projectile _entityToSpawn = new Object() {
											public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
												AbstractArrow entityToSpawn = new Arrow(EntityType.ARROW, level);
												entityToSpawn.setOwner(shooter);
												entityToSpawn.setBaseDamage(damage);
												entityToSpawn.setKnockback(knockback);
												entityToSpawn.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
												return entityToSpawn;
											}
										}.getArrow(projectileLevel, entity, 25, (int) 0.5);
										_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
										_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 3, (float) Math.random());
										projectileLevel.addFreshEntity(_entityToSpawn);
									}
								}
							});
						});
					});
				}
			}
		}
	}
}
