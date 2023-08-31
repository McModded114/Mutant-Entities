package net.mcmodded.mutantentities.init;

import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.mcmodded.mutantentities.configuration.MutantEntitiesConfigFileConfiguration;
import net.mcmodded.mutantentities.configuration.MutantEntitiesClientConfigFileConfiguration;
import net.mcmodded.mutantentities.MutantEntitiesMod;

@Mod.EventBusSubscriber(modid = MutantEntitiesMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MutantEntitiesModConfigs {
	@SubscribeEvent
	public static void register(FMLConstructModEvent event) {
		event.enqueueWork(() -> {
			ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, MutantEntitiesConfigFileConfiguration.SPEC, "mutant_entities-server.toml");
			ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, MutantEntitiesClientConfigFileConfiguration.SPEC, "mutant_entities-client.toml");
		});
	}
}
