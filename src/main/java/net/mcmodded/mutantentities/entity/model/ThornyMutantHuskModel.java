package net.mcmodded.mutantentities.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcmodded.mutantentities.entity.ThornyMutantHuskEntity;

public class ThornyMutantHuskModel extends GeoModel<ThornyMutantHuskEntity> {
	@Override
	public ResourceLocation getAnimationResource(ThornyMutantHuskEntity entity) {
		return new ResourceLocation("mutant_entities", "animations/mutant_zombie.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(ThornyMutantHuskEntity entity) {
		return new ResourceLocation("mutant_entities", "geo/mutant_zombie.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(ThornyMutantHuskEntity entity) {
		return new ResourceLocation("mutant_entities", "textures/entities/" + entity.getTexture() + ".png");
	}

}
