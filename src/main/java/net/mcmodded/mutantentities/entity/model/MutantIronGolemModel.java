package net.mcmodded.mutantentities.entity.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcmodded.mutantentities.entity.MutantIronGolemEntity;

public class MutantIronGolemModel extends AnimatedGeoModel<MutantIronGolemEntity> {
	@Override
	public ResourceLocation getAnimationResource(MutantIronGolemEntity entity) {
		return new ResourceLocation("mutant_entities", "animations/mutant_iron_golem.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(MutantIronGolemEntity entity) {
		return new ResourceLocation("mutant_entities", "geo/mutant_iron_golem.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(MutantIronGolemEntity entity) {
		return new ResourceLocation("mutant_entities", "textures/entities/" + entity.getTexture() + ".png");
	}

}
