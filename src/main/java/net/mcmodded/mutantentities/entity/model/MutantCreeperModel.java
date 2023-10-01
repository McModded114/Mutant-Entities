package net.mcmodded.mutantentities.entity.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcmodded.mutantentities.entity.MutantCreeperEntity;

public class MutantCreeperModel extends AnimatedGeoModel<MutantCreeperEntity> {
	@Override
	public ResourceLocation getAnimationResource(MutantCreeperEntity entity) {
		return new ResourceLocation("mutant_entities", "animations/mutant_creeper.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(MutantCreeperEntity entity) {
		return new ResourceLocation("mutant_entities", "geo/mutant_creeper.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(MutantCreeperEntity entity) {
		return new ResourceLocation("mutant_entities", "textures/entities/" + entity.getTexture() + ".png");
	}

}
