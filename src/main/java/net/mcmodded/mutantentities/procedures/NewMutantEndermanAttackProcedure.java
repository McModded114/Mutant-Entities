package net.mcmodded.mutantentities.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.EntityDamageSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;

import net.mcmodded.mutantentities.init.MutantEntitiesModEntities;
import net.mcmodded.mutantentities.init.MutantEntitiesModAttributes;
import net.mcmodded.mutantentities.entity.ThrowableGrassblockEntity;
import net.mcmodded.mutantentities.entity.ThrowableEndstoneEntity;
import net.mcmodded.mutantentities.entity.ThrowableDirtEntity;
import net.mcmodded.mutantentities.entity.ThrowableCobblestoneEntity;
import net.mcmodded.mutantentities.entity.MutantZombieEntity;
import net.mcmodded.mutantentities.entity.MutantEndermanEntity;
import net.mcmodded.mutantentities.entity.EndersoulEntity;
import net.mcmodded.mutantentities.MutantEntitiesMod;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class NewMutantEndermanAttackProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		Entity entity = event.getEntity();
		if (event != null && entity != null) {
			execute(event, entity.getLevel(), event.getSource(), entity, event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, DamageSource damagesource, Entity entity, Entity sourceentity) {
		execute(null, world, damagesource, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, DamageSource damagesource, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (sourceentity instanceof MutantEndermanEntity && entity instanceof LivingEntity) {
			if (Math.random() < 0.3) {
				for (int index0 = 0; index0 < Math.round(1 + Math.random() * 3); index0++) {
					if (Math.random() < 0.5) {
						if (world instanceof ServerLevel _level) {
							Entity _entityToSpawn = MutantEntitiesModEntities.ENDERSOUL.get().create(_level);
							_entityToSpawn.moveTo((entity.getX()), (entity.getY()), (entity.getZ()), world.getRandom().nextFloat() * 360.0F, 0.0F);
							if (_entityToSpawn instanceof Mob _mobToSpawn) {
								_mobToSpawn.finalizeSpawn(_level, _level.getCurrentDifficultyAt(_entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
							}
							if ((_entityToSpawn) instanceof Mob _entity && entity instanceof LivingEntity _ent)
								_entity.setTarget(_ent);
							_level.addFreshEntity(_entityToSpawn);
						}
					} else {
						if (world instanceof ServerLevel _level) {
							Entity _entityToSpawn = MutantEntitiesModEntities.ENDERSOUL.get().create(_level);
							_entityToSpawn.moveTo((sourceentity.getX()), (sourceentity.getY()), (sourceentity.getZ()), world.getRandom().nextFloat() * 360.0F, 0.0F);
							if (_entityToSpawn instanceof Mob _mobToSpawn) {
								_mobToSpawn.finalizeSpawn(_level, _level.getCurrentDifficultyAt(_entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
							}
							if ((_entityToSpawn) instanceof Mob _entity && entity instanceof LivingEntity _ent)
								_entity.setTarget(_ent);
							_level.addFreshEntity(_entityToSpawn);
						}
					}
				}
			}
		}
		if ((sourceentity instanceof MutantEndermanEntity || sourceentity instanceof EndersoulEntity) && entity instanceof LivingEntity) {
			if ((damagesource) == DamageSource.GENERIC) {
				if (event != null && event.isCancelable()) {
					event.setCanceled(true);
				}
				if (((LivingEntity) entity).getAttribute(MutantEntitiesModAttributes.ATK.get()).getBaseValue() == 0) {
					if (Math.random() < 0.75) {
						((LivingEntity) sourceentity).getAttribute(MutantEntitiesModAttributes.ATK.get()).setBaseValue(1);
						if (Math.random() < 0.5) {
							if (Math.random() < 0.5) {
								if (sourceentity instanceof MutantZombieEntity) {
									((MutantZombieEntity) sourceentity).setAnimation("attack");
								}
							} else {
								if (sourceentity instanceof MutantZombieEntity) {
									((MutantZombieEntity) sourceentity).setAnimation("attack2");
								}
							}
						} else {
							if (Math.random() < 0.5) {
								if (sourceentity instanceof MutantZombieEntity) {
									((MutantZombieEntity) sourceentity).setAnimation("attack3");
								}
							} else {
								if (sourceentity instanceof MutantZombieEntity) {
									((MutantZombieEntity) sourceentity).setAnimation("attack4");
								}
							}
						}
						MutantEntitiesMod.queueServerWork(16, () -> {
							entity.hurt(((new Object() {
								public DamageSource get(final String _msgID, Entity _directSource) {
									return new EntityDamageSource(_msgID, _directSource) {
										@Override
										public Component getLocalizedDeathMessage(LivingEntity _livingEntity) {
											Component _attackerName = null;
											Component _entityName = _livingEntity.getDisplayName();
											Component _itemName = null;
											Entity _attacker = this.getEntity();
											ItemStack _itemStack = ItemStack.EMPTY;
											if (_attacker != null) {
												_attackerName = _attacker.getDisplayName();
											}
											if (_attacker instanceof LivingEntity _livingAttacker) {
												_itemStack = _livingAttacker.getMainHandItem();
											}
											if (!_itemStack.isEmpty() && _itemStack.hasCustomHoverName()) {
												_itemName = _itemStack.getDisplayName();
											}
											if (_attacker != null && _itemName != null) {
												return Component.translatable("death.attack." + _msgID + ".player.item", _entityName, _attackerName, _itemName);
											} else if (_attacker != null) {
												return Component.translatable("death.attack." + _msgID + ".player", _entityName, _attackerName);
											} else {
												return Component.translatable("death.attack." + _msgID, _entityName);
											}
										}
									};
								}
							}).get("mutantgeneric", sourceentity)), (float) ((LivingEntity) sourceentity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).getValue());
							MutantEntitiesMod.queueServerWork(16, () -> {
								((LivingEntity) sourceentity).getAttribute(MutantEntitiesModAttributes.ATK.get()).setBaseValue(0);
							});
						});
					} else {
						((LivingEntity) sourceentity).getAttribute(MutantEntitiesModAttributes.ATK.get()).setBaseValue(1);
						if (Math.random() < 0.5) {
							if (Math.random() < 0.5) {
								if (sourceentity instanceof MutantZombieEntity) {
									((MutantZombieEntity) sourceentity).setAnimation("attack");
								}
							} else {
								if (sourceentity instanceof MutantZombieEntity) {
									((MutantZombieEntity) sourceentity).setAnimation("attack2");
								}
							}
						} else {
							if (Math.random() < 0.5) {
								if (sourceentity instanceof MutantZombieEntity) {
									((MutantZombieEntity) sourceentity).setAnimation("attack3");
								}
							} else {
								if (sourceentity instanceof MutantZombieEntity) {
									((MutantZombieEntity) sourceentity).setAnimation("attack4");
								}
							}
						}
						MutantEntitiesMod.queueServerWork(16, () -> {
							entity.hurt(((new Object() {
								public DamageSource get(final String _msgID, Entity _directSource) {
									return new EntityDamageSource(_msgID, _directSource) {
										@Override
										public Component getLocalizedDeathMessage(LivingEntity _livingEntity) {
											Component _attackerName = null;
											Component _entityName = _livingEntity.getDisplayName();
											Component _itemName = null;
											Entity _attacker = this.getEntity();
											ItemStack _itemStack = ItemStack.EMPTY;
											if (_attacker != null) {
												_attackerName = _attacker.getDisplayName();
											}
											if (_attacker instanceof LivingEntity _livingAttacker) {
												_itemStack = _livingAttacker.getMainHandItem();
											}
											if (!_itemStack.isEmpty() && _itemStack.hasCustomHoverName()) {
												_itemName = _itemStack.getDisplayName();
											}
											if (_attacker != null && _itemName != null) {
												return Component.translatable("death.attack." + _msgID + ".player.item", _entityName, _attackerName, _itemName);
											} else if (_attacker != null) {
												return Component.translatable("death.attack." + _msgID + ".player", _entityName, _attackerName);
											} else {
												return Component.translatable("death.attack." + _msgID, _entityName);
											}
										}
									};
								}
							}).get("mutantgeneric", sourceentity)), (float) ((LivingEntity) sourceentity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).getValue());
							if (Math.random() < 0.5) {
								if (Math.random() < 0.5) {
									{
										Entity _shootFrom = sourceentity;
										Level projectileLevel = _shootFrom.level;
										if (!projectileLevel.isClientSide()) {
											Projectile _entityToSpawn = new Object() {
												public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
													AbstractArrow entityToSpawn = new ThrowableCobblestoneEntity(MutantEntitiesModEntities.THROWABLE_COBBLESTONE.get(), level);
													entityToSpawn.setOwner(shooter);
													entityToSpawn.setBaseDamage(damage);
													entityToSpawn.setKnockback(knockback);
													entityToSpawn.setSilent(true);
													return entityToSpawn;
												}
											}.getArrow(projectileLevel, sourceentity, (float) (((LivingEntity) sourceentity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).getValue() / 1.3), 1);
											_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
											_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1, 0);
											projectileLevel.addFreshEntity(_entityToSpawn);
										}
									}
								} else {
									{
										Entity _shootFrom = sourceentity;
										Level projectileLevel = _shootFrom.level;
										if (!projectileLevel.isClientSide()) {
											Projectile _entityToSpawn = new Object() {
												public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
													AbstractArrow entityToSpawn = new ThrowableEndstoneEntity(MutantEntitiesModEntities.THROWABLE_ENDSTONE.get(), level);
													entityToSpawn.setOwner(shooter);
													entityToSpawn.setBaseDamage(damage);
													entityToSpawn.setKnockback(knockback);
													entityToSpawn.setSilent(true);
													return entityToSpawn;
												}
											}.getArrow(projectileLevel, sourceentity, (float) (((LivingEntity) sourceentity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).getValue() / 1.3), 1);
											_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
											_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1, 0);
											projectileLevel.addFreshEntity(_entityToSpawn);
										}
									}
								}
							} else {
								if (Math.random() < 0.5) {
									{
										Entity _shootFrom = sourceentity;
										Level projectileLevel = _shootFrom.level;
										if (!projectileLevel.isClientSide()) {
											Projectile _entityToSpawn = new Object() {
												public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
													AbstractArrow entityToSpawn = new ThrowableDirtEntity(MutantEntitiesModEntities.THROWABLE_DIRT.get(), level);
													entityToSpawn.setOwner(shooter);
													entityToSpawn.setBaseDamage(damage);
													entityToSpawn.setKnockback(knockback);
													entityToSpawn.setSilent(true);
													return entityToSpawn;
												}
											}.getArrow(projectileLevel, sourceentity, (float) (((LivingEntity) sourceentity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).getValue() / 2.3), 1);
											_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
											_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1, 0);
											projectileLevel.addFreshEntity(_entityToSpawn);
										}
									}
								} else {
									{
										Entity _shootFrom = sourceentity;
										Level projectileLevel = _shootFrom.level;
										if (!projectileLevel.isClientSide()) {
											Projectile _entityToSpawn = new Object() {
												public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
													AbstractArrow entityToSpawn = new ThrowableGrassblockEntity(MutantEntitiesModEntities.THROWABLE_GRASSBLOCK.get(), level);
													entityToSpawn.setOwner(shooter);
													entityToSpawn.setBaseDamage(damage);
													entityToSpawn.setKnockback(knockback);
													entityToSpawn.setSilent(true);
													return entityToSpawn;
												}
											}.getArrow(projectileLevel, sourceentity, (float) (((LivingEntity) sourceentity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).getValue() / 2.3), 1);
											_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
											_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1, 0);
											projectileLevel.addFreshEntity(_entityToSpawn);
										}
									}
								}
							}
							MutantEntitiesMod.queueServerWork(16, () -> {
								((LivingEntity) sourceentity).getAttribute(MutantEntitiesModAttributes.ATK.get()).setBaseValue(0);
							});
						});
					}
				}
			}
		}
	}
}
