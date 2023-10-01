package net.mcmodded.mutantentities.entity.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcmodded.mutantentities.entity.MutantSnowGolemEntity;

public class MutantSnowGolemModel extends AnimatedGeoModel<MutantSnowGolemEntity> {
	@Override
	public ResourceLocation getAnimationResource(MutantSnowGolemEntity entity) {
		return new ResourceLocation("mutant_entities", "animations/mutant_snow_golem.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(MutantSnowGolemEntity entity) {
		return new ResourceLocation("mutant_entities", "geo/mutant_snow_golem.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(MutantSnowGolemEntity entity) {
		return new ResourceLocation("mutant_entities", "textures/entities/" + entity.getTexture() + ".png");
	}

}
