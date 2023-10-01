package net.mcmodded.mutantentities.entity.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcmodded.mutantentities.entity.CreeperlingEntity;

public class CreeperlingModel extends AnimatedGeoModel<CreeperlingEntity> {
	@Override
	public ResourceLocation getAnimationResource(CreeperlingEntity entity) {
		return new ResourceLocation("mutant_entities", "animations/creeperling.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(CreeperlingEntity entity) {
		return new ResourceLocation("mutant_entities", "geo/creeperling.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(CreeperlingEntity entity) {
		return new ResourceLocation("mutant_entities", "textures/entities/" + entity.getTexture() + ".png");
	}

}
