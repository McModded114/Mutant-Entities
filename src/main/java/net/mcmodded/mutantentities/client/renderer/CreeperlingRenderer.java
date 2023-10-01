
package net.mcmodded.mutantentities.client.renderer;

import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcmodded.mutantentities.entity.model.CreeperlingModel;
import net.mcmodded.mutantentities.entity.CreeperlingEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class CreeperlingRenderer extends GeoEntityRenderer<CreeperlingEntity> {
	public CreeperlingRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new CreeperlingModel());
		this.shadowRadius = 0.3f;
	}

	@Override
	public RenderType getRenderType(CreeperlingEntity entity, float partialTicks, PoseStack stack, MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
		stack.scale(0.5f, 0.5f, 0.5f);
		return RenderType.entityTranslucent(getTextureLocation(entity));
	}
}
