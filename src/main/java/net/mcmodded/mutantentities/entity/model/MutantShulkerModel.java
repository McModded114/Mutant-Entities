package net.mcmodded.mutantentities.entity.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcmodded.mutantentities.entity.MutantShulkerEntity;

public class MutantShulkerModel extends AnimatedGeoModel<MutantShulkerEntity> {
	@Override
	public ResourceLocation getAnimationResource(MutantShulkerEntity entity) {
		return new ResourceLocation("mutant_entities", "animations/mutant_shulker.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(MutantShulkerEntity entity) {
		return new ResourceLocation("mutant_entities", "geo/mutant_shulker.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(MutantShulkerEntity entity) {
		return new ResourceLocation("mutant_entities", "textures/entities/" + entity.getTexture() + ".png");
	}

}
