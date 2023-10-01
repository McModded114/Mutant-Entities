
package net.mcmodded.mutantentities.client.renderer;

import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import net.minecraft.world.level.Level;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcmodded.mutantentities.procedures.MutantDrownedScalingProcedure;
import net.mcmodded.mutantentities.entity.model.MutantDrownedModel;
import net.mcmodded.mutantentities.entity.MutantDrownedEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class MutantDrownedRenderer extends GeoEntityRenderer<MutantDrownedEntity> {
	public MutantDrownedRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new MutantDrownedModel());
		this.shadowRadius = 0f;
	}

	@Override
	public RenderType getRenderType(MutantDrownedEntity entity, float partialTicks, PoseStack stack, MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
		Level world = entity.level;
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		float scale = (float) MutantDrownedScalingProcedure.execute(entity);
		stack.scale(scale, scale, scale);
		return RenderType.entityTranslucent(getTextureLocation(entity));
	}

	@Override
	protected float getDeathMaxRotation(MutantDrownedEntity entityLivingBaseIn) {
		return 0.0F;
	}
}
