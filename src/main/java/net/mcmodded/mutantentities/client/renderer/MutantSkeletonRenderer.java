
package net.mcmodded.mutantentities.client.renderer;

import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import net.minecraft.world.level.Level;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcmodded.mutantentities.procedures.MutantMobsScalingProcedure;
import net.mcmodded.mutantentities.entity.model.MutantSkeletonModel;
import net.mcmodded.mutantentities.entity.MutantSkeletonEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class MutantSkeletonRenderer extends GeoEntityRenderer<MutantSkeletonEntity> {
	public MutantSkeletonRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new MutantSkeletonModel());
		this.shadowRadius = 1f;
	}

	@Override
	public RenderType getRenderType(MutantSkeletonEntity entity, float partialTicks, PoseStack stack, MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
		Level world = entity.level;
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		float scale = (float) MutantMobsScalingProcedure.execute(entity);
		stack.scale(scale, scale, scale);
		return RenderType.entityTranslucent(getTextureLocation(entity));
	}

	@Override
	protected float getDeathMaxRotation(MutantSkeletonEntity entityLivingBaseIn) {
		return 0.0F;
	}
}
