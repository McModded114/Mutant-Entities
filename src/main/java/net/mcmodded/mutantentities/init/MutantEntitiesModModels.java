
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcmodded.mutantentities.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcmodded.mutantentities.client.model.Modelmutant_arrow;
import net.mcmodded.mutantentities.client.model.Modelblock_projectile;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class MutantEntitiesModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(Modelblock_projectile.LAYER_LOCATION, Modelblock_projectile::createBodyLayer);
		event.registerLayerDefinition(Modelmutant_arrow.LAYER_LOCATION, Modelmutant_arrow::createBodyLayer);
	}
}
