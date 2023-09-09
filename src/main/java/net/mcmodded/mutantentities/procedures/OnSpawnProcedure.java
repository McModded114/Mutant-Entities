package net.mcmodded.mutantentities.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Items;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import net.mcmodded.mutantentities.init.MutantEntitiesModAttributes;
import net.mcmodded.mutantentities.entity.MutantDrownedEntity;
import net.mcmodded.mutantentities.configuration.MutantEntitiesConfigFileConfiguration;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class OnSpawnProcedure {
	@SubscribeEvent
	public static void onEntitySpawned(EntityJoinLevelEvent event) {
		execute(event, event.getLevel(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double var = 0;
		if (entity instanceof Pig) {
			((Pig) entity).goalSelector.addGoal(0, new TemptGoal(((Pig) entity), 1, Ingredient.of(Items.SPIDER_EYE), false));
		}
		if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("mutant_entities:mutant_entities")))) {
			if (entity.getPersistentData().getBoolean("textured") == false) {
				if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("mutant_entities:extralives")))) {
					((LivingEntity) entity).getAttribute(MutantEntitiesModAttributes.EXT.get()).setBaseValue((double) MutantEntitiesConfigFileConfiguration.MAXLIVES.get());
				}
				entity.getPersistentData().putBoolean("textured", true);
				if (!world.isClientSide()) {
					entity.getPersistentData().putDouble("variant", Math.round(Math.random() * (double) MutantEntitiesConfigFileConfiguration.MAXTEXTUREVARIANTS.get()));
					var = entity.getPersistentData().getDouble("variant");
					if (Math.random() < (double) MutantEntitiesConfigFileConfiguration.BABYCHANCE.get()) {
						((LivingEntity) entity).getAttribute(MutantEntitiesModAttributes.SIZ.get()).setBaseValue(0.5);
						((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH)
								.setBaseValue((((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).getBaseValue() / 2));
						((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE)
								.setBaseValue((((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).getBaseValue() / 2));
					}
				}
				entity.getPersistentData().putDouble("variant", var);
			}
		}
		if (entity instanceof MutantDrownedEntity) {
			if (!world.isClientSide()) {
				if (Math.random() < 0.5) {
					if (Math.random() < 0.2) {
						((LivingEntity) entity).getAttribute(MutantEntitiesModAttributes.VAR.get()).setBaseValue(1);
						((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH)
								.setBaseValue((((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).getBaseValue() * 1.5));
						((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE)
								.setBaseValue((((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).getBaseValue() * 1.2));
					} else {
						((LivingEntity) entity).getAttribute(MutantEntitiesModAttributes.VAR.get()).setBaseValue(2);
					}
				} else {
					if (Math.random() < 0.5) {
						((LivingEntity) entity).getAttribute(MutantEntitiesModAttributes.VAR.get()).setBaseValue(3);
					} else {
						((LivingEntity) entity).getAttribute(MutantEntitiesModAttributes.VAR.get()).setBaseValue(0);
					}
				}
			}
			if (entity instanceof LivingEntity _entity)
				_entity.setHealth(entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
		}
	}
}
