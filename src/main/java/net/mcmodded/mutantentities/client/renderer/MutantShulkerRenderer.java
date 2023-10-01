
package net.mcmodded.mutantentities.client.renderer;

import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import net.minecraft.world.level.Level;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcmodded.mutantentities.procedures.MutantMobsScalingProcedure;
import net.mcmodded.mutantentities.entity.model.MutantShulkerModel;
import net.mcmodded.mutantentities.entity.MutantShulkerEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class MutantShulkerRenderer extends GeoEntityRenderer<MutantShulkerEntity> {
	public MutantShulkerRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new MutantShulkerModel());
		this.shadowRadius = 0.5f;
	}

	@Override
	public RenderType getRenderType(MutantShulkerEntity entity, float partialTicks, PoseStack stack, MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
		Level world = entity.level;
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		float scale = (float) MutantMobsScalingProcedure.execute(entity);
		stack.scale(scale, scale, scale);
		return RenderType.entityTranslucent(getTextureLocation(entity));
	}

	@Override
	protected float getDeathMaxRotation(MutantShulkerEntity entityLivingBaseIn) {
		return 0.0F;
	}
}
