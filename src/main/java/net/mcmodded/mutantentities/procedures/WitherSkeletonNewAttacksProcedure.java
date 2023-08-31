package net.mcmodded.mutantentities.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcmodded.mutantentities.entity.MutantWitherSkeletonEntity;
import net.mcmodded.mutantentities.MutantEntitiesMod;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class WitherSkeletonNewAttacksProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level, event.getSource(), event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, DamageSource damagesource, Entity entity, Entity sourceentity) {
		execute(null, world, damagesource, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, DamageSource damagesource, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (sourceentity instanceof MutantWitherSkeletonEntity) {
			if (damagesource.is(DamageTypes.MOB_ATTACK)) {
				if (event != null && event.isCancelable()) {
					event.setCanceled(true);
				}
				if (Math.random() < 0.7) {
					if (Math.random() < 0.5) {
						if (sourceentity instanceof MutantWitherSkeletonEntity) {
							((MutantWitherSkeletonEntity) sourceentity).setAnimation("sword_slash");
						}
						MutantEntitiesMod.queueServerWork(26, () -> {
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
							}).get(world, "mutantgeneric", sourceentity)), (float) ((LivingEntity) sourceentity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).getBaseValue());
						});
					} else {
						if (sourceentity instanceof MutantWitherSkeletonEntity) {
							((MutantWitherSkeletonEntity) sourceentity).setAnimation("sword_slash2");
						}
						MutantEntitiesMod.queueServerWork(26, () -> {
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
							}).get(world, "mutantgeneric", sourceentity)), (float) ((LivingEntity) sourceentity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).getBaseValue());
						});
					}
				} else {
					if (Math.random() < 0.6) {
						if (sourceentity instanceof MutantWitherSkeletonEntity) {
							((MutantWitherSkeletonEntity) sourceentity).setAnimation("multislash");
						}
					} else {
						if (sourceentity instanceof LivingEntity _entity && !_entity.level.isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 30, 9));
						if (sourceentity instanceof MutantWitherSkeletonEntity) {
							((MutantWitherSkeletonEntity) sourceentity).setAnimation("rib_attack");
						}
					}
				}
				if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.WITHER, 100, 1));
			}
		}
	}
}
