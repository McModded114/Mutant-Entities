
package net.mcmodded.mutantentities.client.renderer;

import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import net.minecraft.world.level.Level;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcmodded.mutantentities.procedures.MutantZombiesScalingProcedure;
import net.mcmodded.mutantentities.entity.model.MutantZombieModel;
import net.mcmodded.mutantentities.entity.MutantZombieEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class MutantZombieRenderer extends GeoEntityRenderer<MutantZombieEntity> {
	public MutantZombieRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new MutantZombieModel());
		this.shadowRadius = 0f;
	}

	@Override
	public RenderType getRenderType(MutantZombieEntity entity, float partialTicks, PoseStack stack, MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
		Level world = entity.level;
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		float scale = (float) MutantZombiesScalingProcedure.execute(entity);
		stack.scale(scale, scale, scale);
		return RenderType.entityTranslucent(getTextureLocation(entity));
	}

	@Override
	protected float getDeathMaxRotation(MutantZombieEntity entityLivingBaseIn) {
		return 0.0F;
	}
}
