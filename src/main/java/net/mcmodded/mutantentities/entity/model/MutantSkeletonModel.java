package net.mcmodded.mutantentities.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcmodded.mutantentities.entity.MutantSkeletonEntity;

public class MutantSkeletonModel extends GeoModel<MutantSkeletonEntity> {
	@Override
	public ResourceLocation getAnimationResource(MutantSkeletonEntity entity) {
		return new ResourceLocation("mutant_entities", "animations/mutant_skeleton.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(MutantSkeletonEntity entity) {
		return new ResourceLocation("mutant_entities", "geo/mutant_skeleton.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(MutantSkeletonEntity entity) {
		return new ResourceLocation("mutant_entities", "textures/entities/" + entity.getTexture() + ".png");
	}

}
