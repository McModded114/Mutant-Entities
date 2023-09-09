
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcmodded.mutantentities.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.renderer.entity.ThrownItemRenderer;

import net.mcmodded.mutantentities.client.renderer.ThrowableIceRenderer;
import net.mcmodded.mutantentities.client.renderer.ThrowableGrassblockRenderer;
import net.mcmodded.mutantentities.client.renderer.ThrowableEndstoneRenderer;
import net.mcmodded.mutantentities.client.renderer.ThrowableDirtRenderer;
import net.mcmodded.mutantentities.client.renderer.ThrowableCobblestoneRenderer;
import net.mcmodded.mutantentities.client.renderer.ThornyMutantHuskRenderer;
import net.mcmodded.mutantentities.client.renderer.SpiderPigRenderer;
import net.mcmodded.mutantentities.client.renderer.MutantZombifiedPiglinRenderer;
import net.mcmodded.mutantentities.client.renderer.MutantZombieRenderer;
import net.mcmodded.mutantentities.client.renderer.MutantWitherSkeletonRenderer;
import net.mcmodded.mutantentities.client.renderer.MutantSnowGolemRenderer;
import net.mcmodded.mutantentities.client.renderer.MutantSkeletonRenderer;
import net.mcmodded.mutantentities.client.renderer.MutantShulkerRenderer;
import net.mcmodded.mutantentities.client.renderer.MutantIronGolemRenderer;
import net.mcmodded.mutantentities.client.renderer.MutantHuskRenderer;
import net.mcmodded.mutantentities.client.renderer.MutantEndermanRenderer;
import net.mcmodded.mutantentities.client.renderer.MutantDrownedRenderer;
import net.mcmodded.mutantentities.client.renderer.MutantCreeperRenderer;
import net.mcmodded.mutantentities.client.renderer.EndersoulRenderer;
import net.mcmodded.mutantentities.client.renderer.CreeperlingRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class MutantEntitiesModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(MutantEntitiesModEntities.MUTANT_ZOMBIE.get(), MutantZombieRenderer::new);
		event.registerEntityRenderer(MutantEntitiesModEntities.MUTANT_HUSK.get(), MutantHuskRenderer::new);
		event.registerEntityRenderer(MutantEntitiesModEntities.MUTANT_ZOMBIFIED_PIGLIN.get(), MutantZombifiedPiglinRenderer::new);
		event.registerEntityRenderer(MutantEntitiesModEntities.MUTANT_SKELETON.get(), MutantSkeletonRenderer::new);
		event.registerEntityRenderer(MutantEntitiesModEntities.MUTANT_CREEPER.get(), MutantCreeperRenderer::new);
		event.registerEntityRenderer(MutantEntitiesModEntities.CREEPERLING.get(), CreeperlingRenderer::new);
		event.registerEntityRenderer(MutantEntitiesModEntities.MUTANT_IRON_GOLEM.get(), MutantIronGolemRenderer::new);
		event.registerEntityRenderer(MutantEntitiesModEntities.MUTANT_WITHER_SKELETON.get(), MutantWitherSkeletonRenderer::new);
		event.registerEntityRenderer(MutantEntitiesModEntities.MUTANT_DROWNED.get(), MutantDrownedRenderer::new);
		event.registerEntityRenderer(MutantEntitiesModEntities.THORNY_MUTANT_HUSK.get(), ThornyMutantHuskRenderer::new);
		event.registerEntityRenderer(MutantEntitiesModEntities.MUTANT_ENDERMAN.get(), MutantEndermanRenderer::new);
		event.registerEntityRenderer(MutantEntitiesModEntities.CHEMICAL_X_ITEM.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(MutantEntitiesModEntities.ENDERSOUL.get(), EndersoulRenderer::new);
		event.registerEntityRenderer(MutantEntitiesModEntities.THROWABLE_COBBLESTONE.get(), ThrowableCobblestoneRenderer::new);
		event.registerEntityRenderer(MutantEntitiesModEntities.THROWABLE_ENDSTONE.get(), ThrowableEndstoneRenderer::new);
		event.registerEntityRenderer(MutantEntitiesModEntities.THROWABLE_DIRT.get(), ThrowableDirtRenderer::new);
		event.registerEntityRenderer(MutantEntitiesModEntities.THROWABLE_GRASSBLOCK.get(), ThrowableGrassblockRenderer::new);
		event.registerEntityRenderer(MutantEntitiesModEntities.SPIDER_PIG.get(), SpiderPigRenderer::new);
		event.registerEntityRenderer(MutantEntitiesModEntities.MUTANT_SHULKER.get(), MutantShulkerRenderer::new);
		event.registerEntityRenderer(MutantEntitiesModEntities.MUTANT_SNOW_GOLEM.get(), MutantSnowGolemRenderer::new);
		event.registerEntityRenderer(MutantEntitiesModEntities.THROWABLE_ICE.get(), ThrowableIceRenderer::new);
	}
}
