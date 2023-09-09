package net.mcmodded.mutantentities.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.monster.WitherSkeleton;
import net.minecraft.world.entity.monster.Shulker;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.tags.TagKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import net.mcmodded.mutantentities.init.MutantEntitiesModMobEffects;
import net.mcmodded.mutantentities.init.MutantEntitiesModEntities;
import net.mcmodded.mutantentities.init.MutantEntitiesModAttributes;
import net.mcmodded.mutantentities.entity.ThornyMutantHuskEntity;
import net.mcmodded.mutantentities.entity.SpiderPigEntity;
import net.mcmodded.mutantentities.entity.MutantZombifiedPiglinEntity;
import net.mcmodded.mutantentities.entity.MutantZombieEntity;
import net.mcmodded.mutantentities.entity.MutantWitherSkeletonEntity;
import net.mcmodded.mutantentities.entity.MutantSkeletonEntity;
import net.mcmodded.mutantentities.entity.MutantShulkerEntity;
import net.mcmodded.mutantentities.entity.MutantIronGolemEntity;
import net.mcmodded.mutantentities.entity.MutantHuskEntity;
import net.mcmodded.mutantentities.entity.MutantEndermanEntity;
import net.mcmodded.mutantentities.entity.MutantDrownedEntity;
import net.mcmodded.mutantentities.entity.MutantCreeperEntity;
import net.mcmodded.mutantentities.MutantEntitiesMod;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class EntityDiesProcedure {
	@SubscribeEvent
	public static void onEntityDeath(LivingDeathEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level, event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		execute(null, world, x, y, z, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		double random = 0;
		double random1 = 0;
		double random2 = 0;
		if (((LivingEntity) entity).getAttribute(MutantEntitiesModAttributes.EXT.get()).getBaseValue() != 0) {
			if (!entity.isOnFire()) {
				((LivingEntity) entity).getAttribute(MutantEntitiesModAttributes.EXT.get()).setBaseValue((((LivingEntity) entity).getAttribute(MutantEntitiesModAttributes.EXT.get()).getBaseValue() - 1));
				if (event != null && event.isCancelable()) {
					event.setCanceled(true);
				}
				if (entity instanceof ThornyMutantHuskEntity) {
					((ThornyMutantHuskEntity) entity).setAnimation("death");
				}
				if (entity instanceof MutantHuskEntity) {
					((MutantHuskEntity) entity).setAnimation("death");
				}
				if (entity instanceof MutantZombieEntity) {
					((MutantZombieEntity) entity).setAnimation("death");
				}
				if (entity instanceof MutantZombifiedPiglinEntity) {
					((MutantZombifiedPiglinEntity) entity).setAnimation("death");
				}
				if (((LivingEntity) entity).getAttribute(MutantEntitiesModAttributes.EXT.get()).getBaseValue() == 3) {
					if (entity instanceof MutantDrownedEntity) {
						((MutantDrownedEntity) entity).setAnimation("finaldeath2");
					}
				} else {
					if (entity instanceof MutantDrownedEntity) {
						((MutantDrownedEntity) entity).setAnimation("finaldeath");
					}
				}
				if (entity instanceof LivingEntity _entity)
					_entity.setHealth((float) ((((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).getValue() / 100) * 40));
				if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 180, 9));
				MutantEntitiesMod.queueServerWork(90, () -> {
					if (entity instanceof ThornyMutantHuskEntity) {
						((ThornyMutantHuskEntity) entity).setAnimation("revive");
					}
					if (entity instanceof MutantHuskEntity) {
						((MutantHuskEntity) entity).setAnimation("revive");
					}
					if (entity instanceof MutantZombieEntity) {
						((MutantZombieEntity) entity).setAnimation("revive");
					}
					if (entity instanceof MutantZombifiedPiglinEntity) {
						((MutantZombifiedPiglinEntity) entity).setAnimation("revive");
					}
					if (((LivingEntity) entity).getAttribute(MutantEntitiesModAttributes.EXT.get()).getBaseValue() == 3) {
						if (entity instanceof MutantDrownedEntity) {
							((MutantDrownedEntity) entity).setAnimation("revive2");
						}
					} else {
						if (entity instanceof MutantDrownedEntity) {
							((MutantDrownedEntity) entity).setAnimation("revive");
						}
					}
					MutantEntitiesMod.queueServerWork(85, () -> {
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
					});
				});
			}
		} else {
			if (entity instanceof ThornyMutantHuskEntity) {
				((ThornyMutantHuskEntity) entity).setAnimation("finaldeath");
			}
			if (entity instanceof MutantHuskEntity) {
				((MutantHuskEntity) entity).setAnimation("finaldeath");
			}
			if (entity instanceof MutantZombieEntity) {
				((MutantZombieEntity) entity).setAnimation("finaldeath");
			}
			if (entity instanceof MutantZombifiedPiglinEntity) {
				((MutantZombifiedPiglinEntity) entity).setAnimation("finaldeath");
			}
			if (((LivingEntity) entity).getAttribute(MutantEntitiesModAttributes.EXT.get()).getBaseValue() == 3) {
				if (entity instanceof MutantDrownedEntity) {
					((MutantDrownedEntity) entity).setAnimation("finaldeath2");
				}
			} else {
				if (entity instanceof MutantDrownedEntity) {
					((MutantDrownedEntity) entity).setAnimation("finaldeath");
				}
			}
		}
		if (entity instanceof MutantEndermanEntity) {
			if (entity instanceof MutantEndermanEntity animatable)
				animatable.setTexture("mutant_enderman_dies");
			MutantEntitiesMod.queueServerWork(15, () -> {
				if (entity instanceof MutantEndermanEntity animatable)
					animatable.setTexture("mutant_enderman_dies2");
				MutantEntitiesMod.queueServerWork(15, () -> {
					if (entity instanceof MutantEndermanEntity animatable)
						animatable.setTexture("mutant_enderman_dies3");
				});
			});
		}
		if (entity instanceof LivingEntity _livEnt37 && _livEnt37.hasEffect(MutantEntitiesModMobEffects.CHEMICAL_X_EFFECT.get())) {
			if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:zombie")))) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = new MutantZombieEntity(MutantEntitiesModEntities.MUTANT_ZOMBIE.get(), _level);
					entityToSpawn.moveTo(x, y, z, world.getRandom().nextFloat() * 360F, 0);
					if (entityToSpawn instanceof Mob _mobToSpawn)
						_mobToSpawn.finalizeSpawn(_level, _level.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
					_level.addFreshEntity(entityToSpawn);
				}
			} else if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:drowned")))) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = new MutantDrownedEntity(MutantEntitiesModEntities.MUTANT_DROWNED.get(), _level);
					entityToSpawn.moveTo(x, y, z, world.getRandom().nextFloat() * 360F, 0);
					if (entityToSpawn instanceof Mob _mobToSpawn)
						_mobToSpawn.finalizeSpawn(_level, _level.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
					_level.addFreshEntity(entityToSpawn);
				}
			} else if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:husk")))) {
				if (!world.isClientSide()) {
					random2 = Math.random();
				}
				if (random2 < 0.4) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = new ThornyMutantHuskEntity(MutantEntitiesModEntities.THORNY_MUTANT_HUSK.get(), _level);
						entityToSpawn.moveTo(x, y, z, world.getRandom().nextFloat() * 360F, 0);
						if (entityToSpawn instanceof Mob _mobToSpawn)
							_mobToSpawn.finalizeSpawn(_level, _level.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
						_level.addFreshEntity(entityToSpawn);
					}
				} else {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = new MutantHuskEntity(MutantEntitiesModEntities.MUTANT_HUSK.get(), _level);
						entityToSpawn.moveTo(x, y, z, world.getRandom().nextFloat() * 360F, 0);
						if (entityToSpawn instanceof Mob _mobToSpawn)
							_mobToSpawn.finalizeSpawn(_level, _level.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
						_level.addFreshEntity(entityToSpawn);
					}
				}
			} else if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:zombifiedpiglin")))) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = new MutantZombifiedPiglinEntity(MutantEntitiesModEntities.MUTANT_ZOMBIFIED_PIGLIN.get(), _level);
					entityToSpawn.moveTo(x, y, z, world.getRandom().nextFloat() * 360F, 0);
					if (entityToSpawn instanceof Mob _mobToSpawn)
						_mobToSpawn.finalizeSpawn(_level, _level.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
					_level.addFreshEntity(entityToSpawn);
				}
			} else if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:skeleton")))) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = new MutantSkeletonEntity(MutantEntitiesModEntities.MUTANT_SKELETON.get(), _level);
					entityToSpawn.moveTo(x, y, z, world.getRandom().nextFloat() * 360F, 0);
					if (entityToSpawn instanceof Mob _mobToSpawn)
						_mobToSpawn.finalizeSpawn(_level, _level.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
					_level.addFreshEntity(entityToSpawn);
				}
			} else if (entity instanceof IronGolem) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = new MutantIronGolemEntity(MutantEntitiesModEntities.MUTANT_IRON_GOLEM.get(), _level);
					entityToSpawn.moveTo(x, y, z, world.getRandom().nextFloat() * 360F, 0);
					if (entityToSpawn instanceof Mob _mobToSpawn)
						_mobToSpawn.finalizeSpawn(_level, _level.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
					_level.addFreshEntity(entityToSpawn);
				}
			} else if (entity instanceof WitherSkeleton) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = new MutantWitherSkeletonEntity(MutantEntitiesModEntities.MUTANT_WITHER_SKELETON.get(), _level);
					entityToSpawn.moveTo(x, y, z, world.getRandom().nextFloat() * 360F, 0);
					if (entityToSpawn instanceof Mob _mobToSpawn)
						_mobToSpawn.finalizeSpawn(_level, _level.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
					_level.addFreshEntity(entityToSpawn);
				}
			} else if (entity instanceof Creeper) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = new MutantCreeperEntity(MutantEntitiesModEntities.MUTANT_CREEPER.get(), _level);
					entityToSpawn.moveTo(x, y, z, world.getRandom().nextFloat() * 360F, 0);
					if (entityToSpawn instanceof Mob _mobToSpawn)
						_mobToSpawn.finalizeSpawn(_level, _level.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
					_level.addFreshEntity(entityToSpawn);
				}
			} else if (entity instanceof Shulker) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = new MutantShulkerEntity(MutantEntitiesModEntities.MUTANT_SHULKER.get(), _level);
					entityToSpawn.moveTo(x, y, z, world.getRandom().nextFloat() * 360F, 0);
					if (entityToSpawn instanceof Mob _mobToSpawn)
						_mobToSpawn.finalizeSpawn(_level, _level.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
					_level.addFreshEntity(entityToSpawn);
				}
			} else if (entity instanceof EnderMan) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = new MutantEndermanEntity(MutantEntitiesModEntities.MUTANT_ENDERMAN.get(), _level);
					entityToSpawn.moveTo(x, y, z, world.getRandom().nextFloat() * 360F, 0);
					if (entityToSpawn instanceof Mob _mobToSpawn)
						_mobToSpawn.finalizeSpawn(_level, _level.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
					_level.addFreshEntity(entityToSpawn);
				}
			} else if (entity instanceof Pig) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = new SpiderPigEntity(MutantEntitiesModEntities.SPIDER_PIG.get(), _level);
					entityToSpawn.moveTo(x, y, z, world.getRandom().nextFloat() * 360F, 0);
					if (entityToSpawn instanceof Mob _mobToSpawn)
						_mobToSpawn.finalizeSpawn(_level, _level.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
					_level.addFreshEntity(entityToSpawn);
				}
			}
		}
		if (sourceentity instanceof SpiderPigEntity) {
			if (entity instanceof Pig) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = new SpiderPigEntity(MutantEntitiesModEntities.SPIDER_PIG.get(), _level);
					entityToSpawn.moveTo(x, y, z, world.getRandom().nextFloat() * 360F, 0);
					if (entityToSpawn instanceof Mob _mobToSpawn)
						_mobToSpawn.finalizeSpawn(_level, _level.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
					_level.addFreshEntity(entityToSpawn);
				}
			}
		}
	}
}
