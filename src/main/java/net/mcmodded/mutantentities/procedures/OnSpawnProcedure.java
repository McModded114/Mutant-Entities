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
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
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
		if (entity instanceof Pig) {
			((Pig) entity).goalSelector.addGoal(0, new TemptGoal(((Pig) entity), 1, Ingredient.of(Items.SPIDER_EYE), false));
		}
		if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("mutant_entities:mutant_entities")))) {
			if (entity.getPersistentData().getBoolean("textured") == false) {
				if (MutantEntitiesConfigFileConfiguration.SIZEVARIES.get() == true) {
					((LivingEntity) entity).getAttribute(MutantEntitiesModAttributes.SIZ.get())
							.setBaseValue((Mth.nextDouble(RandomSource.create(), (double) MutantEntitiesConfigFileConfiguration.MINSIZE.get(), (double) MutantEntitiesConfigFileConfiguration.MAXSIZE.get())));
					((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).setBaseValue(
							(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).getBaseValue() * ((LivingEntity) entity).getAttribute(MutantEntitiesModAttributes.SIZ.get()).getBaseValue()));
					((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).setBaseValue(
							(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).getBaseValue() * ((LivingEntity) entity).getAttribute(MutantEntitiesModAttributes.SIZ.get()).getBaseValue()));
				}
				if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("mutant_entities:extralives")))) {
					((LivingEntity) entity).getAttribute(MutantEntitiesModAttributes.EXT.get()).setBaseValue((double) MutantEntitiesConfigFileConfiguration.MAXLIVES.get());
				}
				entity.getPersistentData().putBoolean("textured", true);
				if (!world.isClientSide()) {
					if (entity instanceof MutantDrownedEntity) {
						if (Math.random() < 0.5) {
							if (Math.random() < 0.3) {
								((LivingEntity) entity).getAttribute(MutantEntitiesModAttributes.MOBVAR.get()).setBaseValue(1);
								((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH)
										.setBaseValue((((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).getBaseValue() * 1.5));
								((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE)
										.setBaseValue((((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).getBaseValue() * 1.2));
								((LivingEntity) entity).getAttribute(MutantEntitiesModAttributes.SIZ.get()).setBaseValue((((LivingEntity) entity).getAttribute(MutantEntitiesModAttributes.SIZ.get()).getBaseValue() * 1.3));
							} else {
								((LivingEntity) entity).getAttribute(MutantEntitiesModAttributes.MOBVAR.get()).setBaseValue(2);
							}
						} else {
							if (Math.random() < 0.5) {
								((LivingEntity) entity).getAttribute(MutantEntitiesModAttributes.MOBVAR.get()).setBaseValue(3);
							} else {
								((LivingEntity) entity).getAttribute(MutantEntitiesModAttributes.MOBVAR.get()).setBaseValue(0);
							}
						}
					}
					((LivingEntity) entity).getAttribute(MutantEntitiesModAttributes.VAR.get()).setBaseValue(Math.round(Math.random() * (double) MutantEntitiesConfigFileConfiguration.MAXTEXTUREVARIANTS.get()));
					if (Math.random() < (double) MutantEntitiesConfigFileConfiguration.BABYCHANCE.get()) {
						((LivingEntity) entity).getAttribute(MutantEntitiesModAttributes.SIZ.get()).setBaseValue((((LivingEntity) entity).getAttribute(MutantEntitiesModAttributes.SIZ.get()).getBaseValue() / 2));
						((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH)
								.setBaseValue((((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).getBaseValue() / 2));
						((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE)
								.setBaseValue((((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).getBaseValue() / 2));
					}
				}
				if (entity instanceof LivingEntity _entity)
					_entity.setHealth(entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
			}
		}
	}
}
