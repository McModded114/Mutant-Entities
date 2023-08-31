package net.mcmodded.mutantentities.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcmodded.mutantentities.entity.MutantCreeperEntity;

public class MutantCreeperModel extends GeoModel<MutantCreeperEntity> {
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
