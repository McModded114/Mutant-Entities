package net.mcmodded.mutantentities.entity.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcmodded.mutantentities.entity.MutantWitherSkeletonEntity;

public class MutantWitherSkeletonModel extends AnimatedGeoModel<MutantWitherSkeletonEntity> {
	@Override
	public ResourceLocation getAnimationResource(MutantWitherSkeletonEntity entity) {
		return new ResourceLocation("mutant_entities", "animations/mutant_skeleton.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(MutantWitherSkeletonEntity entity) {
		return new ResourceLocation("mutant_entities", "geo/mutant_skeleton.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(MutantWitherSkeletonEntity entity) {
		return new ResourceLocation("mutant_entities", "textures/entities/" + entity.getTexture() + ".png");
	}

}
