package net.mcmodded.mutantentities.entity.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcmodded.mutantentities.entity.MutantZombifiedPiglinEntity;

public class MutantZombifiedPiglinModel extends AnimatedGeoModel<MutantZombifiedPiglinEntity> {
	@Override
	public ResourceLocation getAnimationResource(MutantZombifiedPiglinEntity entity) {
		return new ResourceLocation("mutant_entities", "animations/mutant_zombie.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(MutantZombifiedPiglinEntity entity) {
		return new ResourceLocation("mutant_entities", "geo/mutant_zombie.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(MutantZombifiedPiglinEntity entity) {
		return new ResourceLocation("mutant_entities", "textures/entities/" + entity.getTexture() + ".png");
	}

}
