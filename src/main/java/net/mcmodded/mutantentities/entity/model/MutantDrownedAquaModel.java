package net.mcmodded.mutantentities.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcmodded.mutantentities.entity.MutantDrownedAquaEntity;

public class MutantDrownedAquaModel extends GeoModel<MutantDrownedAquaEntity> {
	@Override
	public ResourceLocation getAnimationResource(MutantDrownedAquaEntity entity) {
		return new ResourceLocation("mutant_entities", "animations/mutant_drowned_water.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(MutantDrownedAquaEntity entity) {
		return new ResourceLocation("mutant_entities", "geo/mutant_drowned_water.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(MutantDrownedAquaEntity entity) {
		return new ResourceLocation("mutant_entities", "textures/entities/" + entity.getTexture() + ".png");
	}

}
