package net.mcmodded.mutantentities.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcmodded.mutantentities.configuration.MutantEntitiesConfigFileConfiguration;

public class MutantIronGolemStatsProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).setBaseValue((1000 * (double) MutantEntitiesConfigFileConfiguration.HEALTH.get()));
		if (entity instanceof LivingEntity _entity)
			_entity.setHealth(entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
		((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).setBaseValue((50 * (double) MutantEntitiesConfigFileConfiguration.DAMAGE.get()));
		((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED).setBaseValue((0.25 * (double) MutantEntitiesConfigFileConfiguration.SPEED.get()));
		((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.FOLLOW_RANGE).setBaseValue((48 * (double) MutantEntitiesConfigFileConfiguration.RANGE.get()));
		((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_KNOCKBACK).setBaseValue((1.75 * (double) MutantEntitiesConfigFileConfiguration.KNOCKBACK.get()));
		((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.KNOCKBACK_RESISTANCE).setBaseValue((0.9 * (double) MutantEntitiesConfigFileConfiguration.KBRESISTANCE.get()));
	}
}
