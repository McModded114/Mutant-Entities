package net.mcmodded.mutantentities.configuration;

import net.minecraftforge.common.ForgeConfigSpec;

public class MutantEntitiesClientConfigFileConfiguration {
	public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec SPEC;
	public static final ForgeConfigSpec.ConfigValue<Boolean> RANDOMTEXTURES;
	static {
		BUILDER.push("Client Settings");
		RANDOMTEXTURES = BUILDER.comment("If mutants will have random textures.").define("randomtextures", (boolean) true);
		BUILDER.pop();

		SPEC = BUILDER.build();
	}

}
