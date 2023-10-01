package net.mcmodded.mutantentities.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Registry;

public class KillEntityProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (!entity.getType().is(TagKey.create(Registry.ENTITY_TYPE_REGISTRY, new ResourceLocation("mutant_entities:mutant_entities")))) {
			if (entity instanceof LivingEntity _entity)
				_entity.setHealth(0);
			entity.hurt(DamageSource.CRAMMING, 100);
		}
	}
}
