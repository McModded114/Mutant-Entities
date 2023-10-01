package net.mcmodded.mutantentities.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
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
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.tags.TagKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Registry;

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
import net.mcmodded.mutantentities.entity.EndersoulEntity;
import net.mcmodded.mutantentities.MutantEntitiesMod;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class EntityDiesProcedure {
	@SubscribeEvent
	public static void onEntityDeath(LivingDeathEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level, event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getSource(), event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, DamageSource damagesource, Entity entity, Entity sourceentity) {
		execute(null, world, x, y, z, damagesource, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, DamageSource damagesource, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (entity.getType().is(TagKey.create(Registry.ENTITY_TYPE_REGISTRY, new ResourceLocation("mutant_entities:mutant_entities")))) {
			if (sourceentity instanceof Player || entity.isOnFire()) {
				if (entity.getType().is(TagKey.create(Registry.ENTITY_TYPE_REGISTRY, new ResourceLocation("mutant_entites:mutantzombieattack")))) {
					MutantEntitiesMod.queueServerWork(85, () -> {
						LootSystemBaseProcedure.execute(world, x, y, z, entity);
					});
				} else if (entity instanceof MutantEndermanEntity || entity instanceof EndersoulEntity) {
					if (entity instanceof EndersoulEntity) {
						MutantEntitiesMod.queueServerWork(30, () -> {
							LootSystemBaseProcedure.execute(world, x, y, z, entity);
						});
					} else {
						MutantEntitiesMod.queueServerWork(100, () -> {
							LootSystemBaseProcedure.execute(world, x, y, z, entity);
						});
					}
				} else if (entity instanceof MutantWitherSkeletonEntity || entity instanceof MutantSkeletonEntity) {
					MutantEntitiesMod.queueServerWork(60, () -> {
						LootSystemBaseProcedure.execute(world, x, y, z, entity);
					});
				} else {
					LootSystemBaseProcedure.execute(world, x, y, z, entity);
				}
			}
		}
		if (entity instanceof LivingEntity && ((LivingEntity) entity).getAttribute(MutantEntitiesModAttributes.EXT.get()) != null) {
			if (((LivingEntity) entity).getAttribute(MutantEntitiesModAttributes.EXT.get()).getBaseValue() != 0) {
				if (!((damagesource) == DamageSource.OUT_OF_WORLD && entity.isOnFire())) {
					((LivingEntity) entity).getAttribute(MutantEntitiesModAttributes.ATK.get()).setBaseValue(1);
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
					if (entity instanceof MutantDrownedEntity) {
						((MutantDrownedEntity) entity).setAnimation("death");
					}
					if (entity instanceof LivingEntity _entity)
						_entity.setHealth((float) (((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).getValue() * 0.5));
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
						if (entity instanceof MutantDrownedEntity) {
							((MutantDrownedEntity) entity).setAnimation("revive");
						}
						MutantEntitiesMod.queueServerWork(85, () -> {
							if (entity instanceof LivingEntity _entity)
								_entity.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
							MutantEntitiesMod.queueServerWork(20, () -> {
								((LivingEntity) entity).getAttribute(MutantEntitiesModAttributes.ATK.get()).setBaseValue(0);
							});
						});
					});
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
		if (entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(MutantEntitiesModMobEffects.CHEMICAL_X_EFFECT.get()) : false) {
			if (entity.getType().is(TagKey.create(Registry.ENTITY_TYPE_REGISTRY, new ResourceLocation("forge:zombie")))) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = new MutantZombieEntity(MutantEntitiesModEntities.MUTANT_ZOMBIE.get(), _level);
					entityToSpawn.moveTo(x, y, z, world.getRandom().nextFloat() * 360F, 0);
					if (entityToSpawn instanceof Mob _mobToSpawn)
						_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
					world.addFreshEntity(entityToSpawn);
				}
			} else if (entity.getType().is(TagKey.create(Registry.ENTITY_TYPE_REGISTRY, new ResourceLocation("forge:drowned")))) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = new MutantDrownedEntity(MutantEntitiesModEntities.MUTANT_DROWNED.get(), _level);
					entityToSpawn.moveTo(x, y, z, world.getRandom().nextFloat() * 360F, 0);
					if (entityToSpawn instanceof Mob _mobToSpawn)
						_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
					world.addFreshEntity(entityToSpawn);
				}
			} else if (entity.getType().is(TagKey.create(Registry.ENTITY_TYPE_REGISTRY, new ResourceLocation("forge:husk")))) {
				if (!world.isClientSide()) {
					if (Math.random() < 0.4) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = new ThornyMutantHuskEntity(MutantEntitiesModEntities.THORNY_MUTANT_HUSK.get(), _level);
							entityToSpawn.moveTo(x, y, z, world.getRandom().nextFloat() * 360F, 0);
							if (entityToSpawn instanceof Mob _mobToSpawn)
								_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
							world.addFreshEntity(entityToSpawn);
						}
					} else {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = new MutantHuskEntity(MutantEntitiesModEntities.MUTANT_HUSK.get(), _level);
							entityToSpawn.moveTo(x, y, z, world.getRandom().nextFloat() * 360F, 0);
							if (entityToSpawn instanceof Mob _mobToSpawn)
								_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
							world.addFreshEntity(entityToSpawn);
						}
					}
				}
			} else if (entity.getType().is(TagKey.create(Registry.ENTITY_TYPE_REGISTRY, new ResourceLocation("forge:zombifiedpiglin")))) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = new MutantZombifiedPiglinEntity(MutantEntitiesModEntities.MUTANT_ZOMBIFIED_PIGLIN.get(), _level);
					entityToSpawn.moveTo(x, y, z, world.getRandom().nextFloat() * 360F, 0);
					if (entityToSpawn instanceof Mob _mobToSpawn)
						_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
					world.addFreshEntity(entityToSpawn);
				}
			} else if (entity.getType().is(TagKey.create(Registry.ENTITY_TYPE_REGISTRY, new ResourceLocation("forge:skeleton")))) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = new MutantSkeletonEntity(MutantEntitiesModEntities.MUTANT_SKELETON.get(), _level);
					entityToSpawn.moveTo(x, y, z, world.getRandom().nextFloat() * 360F, 0);
					if (entityToSpawn instanceof Mob _mobToSpawn)
						_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
					world.addFreshEntity(entityToSpawn);
				}
			} else if (entity instanceof IronGolem) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = new MutantIronGolemEntity(MutantEntitiesModEntities.MUTANT_IRON_GOLEM.get(), _level);
					entityToSpawn.moveTo(x, y, z, world.getRandom().nextFloat() * 360F, 0);
					if (entityToSpawn instanceof Mob _mobToSpawn)
						_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
					world.addFreshEntity(entityToSpawn);
				}
			} else if (entity instanceof WitherSkeleton) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = new MutantWitherSkeletonEntity(MutantEntitiesModEntities.MUTANT_WITHER_SKELETON.get(), _level);
					entityToSpawn.moveTo(x, y, z, world.getRandom().nextFloat() * 360F, 0);
					if (entityToSpawn instanceof Mob _mobToSpawn)
						_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
					world.addFreshEntity(entityToSpawn);
				}
			} else if (entity instanceof Creeper) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = new MutantCreeperEntity(MutantEntitiesModEntities.MUTANT_CREEPER.get(), _level);
					entityToSpawn.moveTo(x, y, z, world.getRandom().nextFloat() * 360F, 0);
					if (entityToSpawn instanceof Mob _mobToSpawn)
						_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
					world.addFreshEntity(entityToSpawn);
				}
			} else if (entity instanceof Shulker) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = new MutantShulkerEntity(MutantEntitiesModEntities.MUTANT_SHULKER.get(), _level);
					entityToSpawn.moveTo(x, y, z, world.getRandom().nextFloat() * 360F, 0);
					if (entityToSpawn instanceof Mob _mobToSpawn)
						_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
					world.addFreshEntity(entityToSpawn);
				}
			} else if (entity instanceof EnderMan) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = new MutantEndermanEntity(MutantEntitiesModEntities.MUTANT_ENDERMAN.get(), _level);
					entityToSpawn.moveTo(x, y, z, world.getRandom().nextFloat() * 360F, 0);
					if (entityToSpawn instanceof Mob _mobToSpawn)
						_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
					world.addFreshEntity(entityToSpawn);
				}
			} else if (entity instanceof Pig) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = new SpiderPigEntity(MutantEntitiesModEntities.SPIDER_PIG.get(), _level);
					entityToSpawn.moveTo(x, y, z, world.getRandom().nextFloat() * 360F, 0);
					if (entityToSpawn instanceof Mob _mobToSpawn)
						_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
					world.addFreshEntity(entityToSpawn);
				}
			}
		}
		if (sourceentity instanceof SpiderPigEntity) {
			if (entity instanceof Pig) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = new SpiderPigEntity(MutantEntitiesModEntities.SPIDER_PIG.get(), _level);
					entityToSpawn.moveTo(x, y, z, world.getRandom().nextFloat() * 360F, 0);
					if (entityToSpawn instanceof Mob _mobToSpawn)
						_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
					world.addFreshEntity(entityToSpawn);
				}
			}
		}
	}
}
