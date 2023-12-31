package net.mcmodded.mutantentities.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcmodded.mutantentities.entity.MutantDrownedEntity;

public class MutantDrownedModel extends GeoModel<MutantDrownedEntity> {
	@Override
	public ResourceLocation getAnimationResource(MutantDrownedEntity entity) {
		return new ResourceLocation("mutant_entities", "animations/mutant_drowned.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(MutantDrownedEntity entity) {
		return new ResourceLocation("mutant_entities", "geo/mutant_drowned.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(MutantDrownedEntity entity) {
		return new ResourceLocation("mutant_entities", "textures/entities/" + entity.getTexture() + ".png");
	}

}
