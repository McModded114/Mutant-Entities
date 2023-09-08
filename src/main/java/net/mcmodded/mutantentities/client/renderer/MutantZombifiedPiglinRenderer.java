
package net.mcmodded.mutantentities.client.renderer;

import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.cache.object.BakedGeoModel;

import net.minecraft.world.level.Level;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcmodded.mutantentities.procedures.MutantZombiesScalingProcedure;
import net.mcmodded.mutantentities.entity.model.MutantZombifiedPiglinModel;
import net.mcmodded.mutantentities.entity.MutantZombifiedPiglinEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class MutantZombifiedPiglinRenderer extends GeoEntityRenderer<MutantZombifiedPiglinEntity> {
	public MutantZombifiedPiglinRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new MutantZombifiedPiglinModel());
		this.shadowRadius = 0f;
	}

	@Override
	public RenderType getRenderType(MutantZombifiedPiglinEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void preRender(PoseStack poseStack, MutantZombifiedPiglinEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		Level world = entity.level;
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		float scale = (float) MutantZombiesScalingProcedure.execute(entity);
		this.scaleHeight = scale;
		this.scaleWidth = scale;
		super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	protected float getDeathMaxRotation(MutantZombifiedPiglinEntity entityLivingBaseIn) {
		return 0.0F;
	}
}
