package net.mcmodded.mutantentities.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.IndirectEntityDamageSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.network.chat.Component;

public class MutantArrowDmgProcedure {
	public static void execute(LevelAccessor world, Entity entity, Entity immediatesourceentity, Entity sourceentity) {
		if (entity == null || immediatesourceentity == null || sourceentity == null)
			return;
		if (!(sourceentity == null)) {
			if (!(sourceentity == entity)) {
				entity.hurt(((new Object() {
					public DamageSource get(final String _msgID, Entity _directSource, Entity _indirectSource) {
						return new IndirectEntityDamageSource(_msgID, _directSource, _indirectSource) {
							@Override
							public Component getLocalizedDeathMessage(LivingEntity _livingEntity) {
								Component _attackerName = null;
								Component _entityName = _livingEntity.getDisplayName();
								Component _itemName = null;
								Entity _attacker = this.getEntity();
								ItemStack _itemStack = ItemStack.EMPTY;
								if (_attacker == null) {
									_attacker = this.getDirectEntity();
								}
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
				}).get("mutantarrow", immediatesourceentity, sourceentity)), (float) ((LivingEntity) sourceentity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).getValue());
			}
		} else {
			entity.hurt((new DamageSource("mutantarrow")), 5);
		}
	}
}
