package net.mcmodded.mutantentities.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcmodded.mutantentities.entity.MutantHuskEntity;

public class MutantHuskModel extends GeoModel<MutantHuskEntity> {
	@Override
	public ResourceLocation getAnimationResource(MutantHuskEntity entity) {
		return new ResourceLocation("mutant_entities", "animations/mutant_zombie.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(MutantHuskEntity entity) {
		return new ResourceLocation("mutant_entities", "geo/mutant_zombie.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(MutantHuskEntity entity) {
		return new ResourceLocation("mutant_entities", "textures/entities/" + entity.getTexture() + ".png");
	}

}
