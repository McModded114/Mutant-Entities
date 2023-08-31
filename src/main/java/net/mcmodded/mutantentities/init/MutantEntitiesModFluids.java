
/*
 * MCreator note: This file will be REGENERATED on each build.
 */
package net.mcmodded.mutantentities.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ItemBlockRenderTypes;

import net.mcmodded.mutantentities.fluid.ChemicalXFluid;
import net.mcmodded.mutantentities.MutantEntitiesMod;

public class MutantEntitiesModFluids {
	public static final DeferredRegister<Fluid> REGISTRY = DeferredRegister.create(ForgeRegistries.FLUIDS, MutantEntitiesMod.MODID);
	public static final RegistryObject<FlowingFluid> CHEMICAL_X = REGISTRY.register("chemical_x", () -> new ChemicalXFluid.Source());
	public static final RegistryObject<FlowingFluid> FLOWING_CHEMICAL_X = REGISTRY.register("flowing_chemical_x", () -> new ChemicalXFluid.Flowing());

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			ItemBlockRenderTypes.setRenderLayer(CHEMICAL_X.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_CHEMICAL_X.get(), RenderType.translucent());
		}
	}
}
