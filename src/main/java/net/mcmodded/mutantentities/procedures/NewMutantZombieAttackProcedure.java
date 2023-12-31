package net.mcmodded.mutantentities.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.TagKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.arguments.EntityAnchorArgument;

import net.mcmodded.mutantentities.init.MutantEntitiesModAttributes;
import net.mcmodded.mutantentities.entity.ThornyMutantHuskEntity;
import net.mcmodded.mutantentities.entity.MutantZombifiedPiglinEntity;
import net.mcmodded.mutantentities.entity.MutantZombieEntity;
import net.mcmodded.mutantentities.entity.MutantHuskEntity;
import net.mcmodded.mutantentities.entity.MutantDrownedEntity;
import net.mcmodded.mutantentities.configuration.MutantEntitiesConfigFileConfiguration;
import net.mcmodded.mutantentities.MutantEntitiesMod;

import javax.annotation.Nullable;

import java.util.stream.Collectors;
import java.util.List;
import java.util.Comparator;

@Mod.EventBusSubscriber
public class NewMutantZombieAttackProcedure {
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
		if (sourceentity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("mutant_entities:mutantzombieattack"))) && entity instanceof LivingEntity) {
			if ((damagesource).is(DamageTypes.MOB_ATTACK)) {
				if (event != null && event.isCancelable()) {
					event.setCanceled(true);
				}
				if (((LivingEntity) sourceentity).getAttribute(MutantEntitiesModAttributes.ATK.get()).getBaseValue() == 0) {
					if (Math.random() < (double) MutantEntitiesConfigFileConfiguration.LEAP_CHANCE.get()) {
						((LivingEntity) sourceentity).getAttribute(MutantEntitiesModAttributes.ATK.get()).setBaseValue(1);
						if (sourceentity instanceof MutantZombieEntity) {
							((MutantZombieEntity) sourceentity).setAnimation("throw");
						}
						if (sourceentity instanceof MutantDrownedEntity) {
							((MutantDrownedEntity) sourceentity).setAnimation("throw");
						}
						if (sourceentity instanceof MutantHuskEntity) {
							((MutantHuskEntity) sourceentity).setAnimation("throw");
						}
						if (sourceentity instanceof MutantZombifiedPiglinEntity) {
							((MutantZombifiedPiglinEntity) sourceentity).setAnimation("throw");
						}
						if (sourceentity instanceof ThornyMutantHuskEntity) {
							((ThornyMutantHuskEntity) sourceentity).setAnimation("throw");
						}
						sourceentity
								.setDeltaMovement(new Vec3(Math.cos(((LivingEntity) sourceentity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED).getBaseValue() * 3 * (sourceentity.getYRot() + 90) * (Math.PI / 180)),
										0.4, Math.sin(((LivingEntity) sourceentity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED).getBaseValue() * 3 * (sourceentity.getYRot() + 90) * (Math.PI / 180))));
						sourceentity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3((entity.getX()), (entity.getY() + entity.getBbHeight()), (entity.getZ())));
						entity.hurt(((new Object() {
							public DamageSource get(LevelAccessor _world, final String _msgID, Entity _directSource) {
								return new DamageSource(((Level) _world).registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.CACTUS), _directSource) {
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
						}).get(world, "slam", sourceentity)), (float) ((LivingEntity) sourceentity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).getValue());
						MutantEntitiesMod.queueServerWork(10, () -> {
							((LivingEntity) sourceentity).getAttribute(MutantEntitiesModAttributes.ATK.get()).setBaseValue(0);
						});
						sourceentity
								.setDeltaMovement(new Vec3(Math.cos(((LivingEntity) sourceentity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED).getBaseValue() * 3 * (sourceentity.getYRot() + 90) * (Math.PI / 180)),
										0.5, Math.sin(((LivingEntity) sourceentity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED).getBaseValue() * 3 * (sourceentity.getYRot() + 90) * (Math.PI / 180))));
						entity.setDeltaMovement(new Vec3(Math.cos(((LivingEntity) sourceentity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED).getBaseValue() * 30 * (entity.getYRot() + 90) * (Math.PI / 180)), 1.5,
								Math.sin(((LivingEntity) sourceentity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED).getBaseValue() * 30 * (entity.getYRot() + 90) * (Math.PI / 180))));
					} else {
						((LivingEntity) sourceentity).getAttribute(MutantEntitiesModAttributes.ATK.get()).setBaseValue(1);
						if (sourceentity instanceof MutantZombieEntity) {
							((MutantZombieEntity) sourceentity).setAnimation("smash");
						}
						if (sourceentity instanceof MutantDrownedEntity) {
							((MutantDrownedEntity) sourceentity).setAnimation("smash");
						}
						if (sourceentity instanceof MutantHuskEntity) {
							((MutantHuskEntity) sourceentity).setAnimation("smash");
						}
						if (sourceentity instanceof MutantZombifiedPiglinEntity) {
							((MutantZombifiedPiglinEntity) sourceentity).setAnimation("smash");
						}
						if (sourceentity instanceof ThornyMutantHuskEntity) {
							((ThornyMutantHuskEntity) sourceentity).setAnimation("smash");
						}
						MutantEntitiesMod.queueServerWork(16, () -> {
							{
								final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
								List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
										.collect(Collectors.toList());
								for (Entity entityiterator : _entfound) {
									if (!(entityiterator == sourceentity)) {
										if (entityiterator == entity && entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("mutant_entities:mutantzombiepassive")))) {
											entityiterator.hurt(((new Object() {
												public DamageSource get(LevelAccessor _world, final String _msgID, Entity _directSource) {
													return new DamageSource(((Level) _world).registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.CACTUS), _directSource) {
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
											}).get(world, "slam", sourceentity)), (float) ((LivingEntity) sourceentity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).getValue());
											for (int index0 = 0; index0 < 4; index0++) {
												world.levelEvent(2001, BlockPos.containing(entityiterator.getX() + Mth.nextInt(RandomSource.create(), 1, 3), entityiterator.getY(), entityiterator.getZ() + Mth.nextInt(RandomSource.create(), 1, 3)),
														Block.getId((world.getBlockState(BlockPos.containing(entityiterator.getX(), entityiterator.getY() - 1, entityiterator.getZ())))));
											}
										} else if (!entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("mutant_entities:mutantzombiepassive")))) {
											if (!entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("mutant_entities:mutantzombiepassive")))) {
												entityiterator.hurt(((new Object() {
													public DamageSource get(LevelAccessor _world, final String _msgID, Entity _directSource) {
														return new DamageSource(((Level) _world).registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.CACTUS), _directSource) {
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
												}).get(world, "slam", sourceentity)), (float) ((LivingEntity) sourceentity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).getValue());
												for (int index1 = 0; index1 < 4; index1++) {
													world.levelEvent(2001, BlockPos.containing(entityiterator.getX() + Mth.nextInt(RandomSource.create(), 1, 3), entityiterator.getY(), entityiterator.getZ() + Mth.nextInt(RandomSource.create(), 1, 3)),
															Block.getId((world.getBlockState(BlockPos.containing(entityiterator.getX(), entityiterator.getY() - 1, entityiterator.getZ())))));
												}
											}
										}
									}
								}
							}
							((LivingEntity) sourceentity).getAttribute(MutantEntitiesModAttributes.ATK.get()).setBaseValue(0);
						});
					}
				}
			}
		}
		if (entity instanceof MutantZombieEntity && sourceentity instanceof LivingEntity) {
			if (((LivingEntity) entity).getAttribute(MutantEntitiesModAttributes.ATK.get()).getBaseValue() == 0) {
				if (Math.random() < (double) MutantEntitiesConfigFileConfiguration.ROAR_CHANCE.get()) {
					((LivingEntity) entity).getAttribute(MutantEntitiesModAttributes.ATK.get()).setBaseValue(1);
					if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 999, 9, false, true));
					if (entity instanceof MutantZombieEntity) {
						((MutantZombieEntity) entity).setAnimation("roar");
					}
					for (int index2 = 0; index2 < 4; index2++) {
						if (Math.random() < 0.5) {
							world.levelEvent(2001, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), Block.getId((world.getBlockState(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())))));
							if (world instanceof ServerLevel _level) {
								Entity _entityToSpawn = EntityType.ZOMBIE.create(_level);
								_entityToSpawn.moveTo((entity.getX()), (entity.getY()), (entity.getZ()), world.getRandom().nextFloat() * 360.0F, 0.0F);
								if (_entityToSpawn instanceof Mob _mobToSpawn) {
									_mobToSpawn.finalizeSpawn(_level, _level.getCurrentDifficultyAt(_entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
								}
								if ((_entityToSpawn) instanceof Mob _entity && sourceentity instanceof LivingEntity _ent)
									_entity.setTarget(_ent);
								_level.addFreshEntity(_entityToSpawn);
							}
						} else {
							world.levelEvent(2001, BlockPos.containing(sourceentity.getX(), sourceentity.getY(), sourceentity.getZ()),
									Block.getId((world.getBlockState(BlockPos.containing(sourceentity.getX(), sourceentity.getY(), sourceentity.getZ())))));
							if (world instanceof ServerLevel _level) {
								Entity _entityToSpawn = EntityType.ZOMBIE.create(_level);
								_entityToSpawn.moveTo((sourceentity.getX()), (sourceentity.getY()), (sourceentity.getZ()), world.getRandom().nextFloat() * 360.0F, 0.0F);
								if (_entityToSpawn instanceof Mob _mobToSpawn) {
									_mobToSpawn.finalizeSpawn(_level, _level.getCurrentDifficultyAt(_entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
								}
								if ((_entityToSpawn) instanceof Mob _entity && sourceentity instanceof LivingEntity _ent)
									_entity.setTarget(_ent);
								_level.addFreshEntity(_entityToSpawn);
							}
						}
					}
					MutantEntitiesMod.queueServerWork(144, () -> {
						((LivingEntity) entity).getAttribute(MutantEntitiesModAttributes.ATK.get()).setBaseValue(0);
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
					});
				}
			}
		}
	}
}
