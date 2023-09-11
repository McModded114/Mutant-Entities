
package net.mcmodded.mutantentities.client.renderer;

import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.cache.object.BakedGeoModel;

import net.minecraft.world.level.Level;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcmodded.mutantentities.procedures.MutantMobsScalingProcedure;
import net.mcmodded.mutantentities.entity.model.MutantSnowGolemModel;
import net.mcmodded.mutantentities.entity.MutantSnowGolemEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class MutantSnowGolemRenderer extends GeoEntityRenderer<MutantSnowGolemEntity> {
	public MutantSnowGolemRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new MutantSnowGolemModel());
		this.shadowRadius = 0f;
	}

	@Override
	public RenderType getRenderType(MutantSnowGolemEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void preRender(PoseStack poseStack, MutantSnowGolemEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		Level world = entity.level;
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		float scale = (float) MutantMobsScalingProcedure.execute(entity);
		this.scaleHeight = scale;
		this.scaleWidth = scale;
		super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	protected float getDeathMaxRotation(MutantSnowGolemEntity entityLivingBaseIn) {
		return 0.0F;
	}
}
