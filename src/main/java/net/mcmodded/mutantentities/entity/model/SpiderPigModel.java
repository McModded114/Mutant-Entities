package net.mcmodded.mutantentities.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcmodded.mutantentities.entity.SpiderPigEntity;

public class SpiderPigModel extends GeoModel<SpiderPigEntity> {
	@Override
	public ResourceLocation getAnimationResource(SpiderPigEntity entity) {
		return new ResourceLocation("mutant_entities", "animations/spiderpig.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(SpiderPigEntity entity) {
		return new ResourceLocation("mutant_entities", "geo/spiderpig.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(SpiderPigEntity entity) {
		return new ResourceLocation("mutant_entities", "textures/entities/" + entity.getTexture() + ".png");
	}

}
