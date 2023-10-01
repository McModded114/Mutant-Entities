package net.mcmodded.mutantentities.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.EntityDamageSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.network.chat.Component;

import net.mcmodded.mutantentities.entity.SpiderPigEntity;
import net.mcmodded.mutantentities.MutantEntitiesMod;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class OtherMutantsDmgProcedure {
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
		Entity summon = null;
		if (sourceentity instanceof SpiderPigEntity && entity instanceof LivingEntity) {
			if ((damagesource) == DamageSource.GENERIC) {
				if (event != null && event.isCancelable()) {
					event.setCanceled(true);
				}
				if (sourceentity instanceof SpiderPigEntity) {
					((SpiderPigEntity) sourceentity).setAnimation("attack");
				}
				MutantEntitiesMod.queueServerWork(15, () -> {
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
				});
			}
		}
	}
}
