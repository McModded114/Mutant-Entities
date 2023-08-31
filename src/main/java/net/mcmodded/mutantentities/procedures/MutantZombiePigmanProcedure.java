package net.mcmodded.mutantentities.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcmodded.mutantentities.configuration.MutantEntitiesConfigFileConfiguration;

public class MutantZombiePigmanProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH)
				.setBaseValue((((350 * (double) MutantEntitiesConfigFileConfiguration.HEALTH.get()) / 100) * (double) MutantEntitiesConfigFileConfiguration.STATPERCENTS.get()));
		if (entity instanceof LivingEntity _entity)
			_entity.setHealth(entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
		((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE)
				.setBaseValue((((25 * (double) MutantEntitiesConfigFileConfiguration.DAMAGE.get()) / 100) * (double) MutantEntitiesConfigFileConfiguration.STATPERCENTS.get()));
		((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED)
				.setBaseValue((((0.3 * (double) MutantEntitiesConfigFileConfiguration.SPEED.get()) / 100) * (double) MutantEntitiesConfigFileConfiguration.STATPERCENTS.get()));
		((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.FOLLOW_RANGE).setBaseValue((48 * (double) MutantEntitiesConfigFileConfiguration.RANGE.get()));
		((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.KNOCKBACK_RESISTANCE).setBaseValue((0.5 * (double) MutantEntitiesConfigFileConfiguration.KBRESISTANCE.get()));
	}
}
