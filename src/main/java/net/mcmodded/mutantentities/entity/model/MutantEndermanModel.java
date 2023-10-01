package net.mcmodded.mutantentities.entity.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcmodded.mutantentities.entity.MutantEndermanEntity;

public class MutantEndermanModel extends AnimatedGeoModel<MutantEndermanEntity> {
	@Override
	public ResourceLocation getAnimationResource(MutantEndermanEntity entity) {
		return new ResourceLocation("mutant_entities", "animations/mutant_enderman.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(MutantEndermanEntity entity) {
		return new ResourceLocation("mutant_entities", "geo/mutant_enderman.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(MutantEndermanEntity entity) {
		return new ResourceLocation("mutant_entities", "textures/entities/" + entity.getTexture() + ".png");
	}

}
