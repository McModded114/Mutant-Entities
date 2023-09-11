package net.mcmodded.mutantentities.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.commands.arguments.EntityAnchorArgument;

import net.mcmodded.mutantentities.init.MutantEntitiesModEntities;
import net.mcmodded.mutantentities.entity.MutantSkeletonEntity;
import net.mcmodded.mutantentities.entity.MutantArrowEntity;
import net.mcmodded.mutantentities.MutantEntitiesMod;

import javax.annotation.Nullable;

import java.util.stream.Collectors;
import java.util.List;
import java.util.Comparator;

@Mod.EventBusSubscriber
public class MutantSkeletonNewAttacksProcedure {
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
		boolean melee = false;
		if (sourceentity instanceof MutantSkeletonEntity) {
			if ((damagesource).is(DamageTypes.MOB_ATTACK)) {
				if (event != null && event.isCancelable()) {
					event.setCanceled(true);
				}
				{
					final Vec3 _center = new Vec3((sourceentity.getX()), (sourceentity.getY()), (sourceentity.getZ()));
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate((sourceentity.getBbWidth() + sourceentity.getBbWidth()) / 2d), e -> true).stream()
							.sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).collect(Collectors.toList());
					for (Entity entityiterator : _entfound) {
						if (entityiterator == entity) {
							melee = true;
						}
					}
				}
				if (Math.random() < 0.15) {
					sourceentity.setDeltaMovement(new Vec3((sourceentity.getDeltaMovement().x()), 0.5, (sourceentity.getDeltaMovement().z())));
				}
				if (melee != true || Math.random() < 0.15) {
					sourceentity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3((entity.getX()), (entity.getY() + entity.getBbHeight()), (entity.getZ())));
					if (sourceentity instanceof MutantSkeletonEntity) {
						((MutantSkeletonEntity) sourceentity).setAnimation("shoot");
					}
					MutantEntitiesMod.queueServerWork(20, () -> {
						{
							Entity _shootFrom = sourceentity;
							Level projectileLevel = _shootFrom.level;
							if (!projectileLevel.isClientSide()) {
								Projectile _entityToSpawn = new Object() {
									public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
										AbstractArrow entityToSpawn = new MutantArrowEntity(MutantEntitiesModEntities.MUTANT_ARROW.get(), level);
										entityToSpawn.setOwner(shooter);
										entityToSpawn.setBaseDamage(damage);
										entityToSpawn.setKnockback(knockback);
										entityToSpawn.setSilent(true);
										return entityToSpawn;
									}
								}.getArrow(projectileLevel, sourceentity, 0, 1);
								_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
								_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, (float) 1.5, (float) Math.random());
								projectileLevel.addFreshEntity(_entityToSpawn);
							}
						}
					});
				} else {
					if (sourceentity instanceof MutantSkeletonEntity) {
						((MutantSkeletonEntity) sourceentity).setAnimation("bowattack");
					}
					MutantEntitiesMod.queueServerWork(15, () -> {
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
						}).get(world, "mutantgeneric", sourceentity)), (float) ((LivingEntity) sourceentity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).getValue());
					});
				}
			}
		}
	}
}
