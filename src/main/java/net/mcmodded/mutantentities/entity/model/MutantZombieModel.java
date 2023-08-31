package net.mcmodded.mutantentities.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcmodded.mutantentities.entity.MutantZombieEntity;

public class MutantZombieModel extends GeoModel<MutantZombieEntity> {
	@Override
	public ResourceLocation getAnimationResource(MutantZombieEntity entity) {
		return new ResourceLocation("mutant_entities", "animations/mutant_zombie.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(MutantZombieEntity entity) {
		return new ResourceLocation("mutant_entities", "geo/mutant_zombie.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(MutantZombieEntity entity) {
		return new ResourceLocation("mutant_entities", "textures/entities/" + entity.getTexture() + ".png");
	}

}
