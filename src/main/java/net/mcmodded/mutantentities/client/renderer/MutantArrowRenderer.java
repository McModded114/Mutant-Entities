package net.mcmodded.mutantentities.client.renderer;

import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcmodded.mutantentities.entity.MutantArrowEntity;
import net.mcmodded.mutantentities.client.model.Modelmutant_arrow;

import com.mojang.math.Axis;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class MutantArrowRenderer extends EntityRenderer<MutantArrowEntity> {
	private static final ResourceLocation texture = new ResourceLocation("mutant_entities:textures/entities/mutant_arrow.png");
	private final Modelmutant_arrow model;

	public MutantArrowRenderer(EntityRendererProvider.Context context) {
		super(context);
		model = new Modelmutant_arrow(context.bakeLayer(Modelmutant_arrow.LAYER_LOCATION));
	}

	@Override
	public void render(MutantArrowEntity entityIn, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource bufferIn, int packedLightIn) {
		VertexConsumer vb = bufferIn.getBuffer(RenderType.entityCutout(this.getTextureLocation(entityIn)));
		poseStack.pushPose();
		poseStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(partialTicks, entityIn.yRotO, entityIn.getYRot()) - 90));
		poseStack.mulPose(Axis.ZP.rotationDegrees(90 + Mth.lerp(partialTicks, entityIn.xRotO, entityIn.getXRot())));
		model.renderToBuffer(poseStack, vb, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 0.0625f);
		poseStack.popPose();
		super.render(entityIn, entityYaw, partialTicks, poseStack, bufferIn, packedLightIn);
	}

	@Override
	public ResourceLocation getTextureLocation(MutantArrowEntity entity) {
		return texture;
	}
}
