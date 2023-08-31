package net.mcmodded.mutantentities.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcmodded.mutantentities.entity.EvolvedMutantDrownedEntity;

public class EvolvedMutantDrownedModel extends GeoModel<EvolvedMutantDrownedEntity> {
	@Override
	public ResourceLocation getAnimationResource(EvolvedMutantDrownedEntity entity) {
		return new ResourceLocation("mutant_entities", "animations/evolved_mutant_drowned.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(EvolvedMutantDrownedEntity entity) {
		return new ResourceLocation("mutant_entities", "geo/evolved_mutant_drowned.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(EvolvedMutantDrownedEntity entity) {
		return new ResourceLocation("mutant_entities", "textures/entities/" + entity.getTexture() + ".png");
	}

}
