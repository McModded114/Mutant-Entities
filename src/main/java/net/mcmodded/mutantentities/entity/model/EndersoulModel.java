package net.mcmodded.mutantentities.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcmodded.mutantentities.entity.EndersoulEntity;

public class EndersoulModel extends GeoModel<EndersoulEntity> {
	@Override
	public ResourceLocation getAnimationResource(EndersoulEntity entity) {
		return new ResourceLocation("mutant_entities", "animations/mutant_enderman.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(EndersoulEntity entity) {
		return new ResourceLocation("mutant_entities", "geo/mutant_enderman.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(EndersoulEntity entity) {
		return new ResourceLocation("mutant_entities", "textures/entities/" + entity.getTexture() + ".png");
	}

}
