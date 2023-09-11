package net.mcmodded.mutantentities.configuration;

import net.minecraftforge.common.ForgeConfigSpec;

public class MutantEntitiesConfigFileConfiguration {
	public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec SPEC;
	public static final ForgeConfigSpec.ConfigValue<Double> DAMAGE;
	public static final ForgeConfigSpec.ConfigValue<Double> HEALTH;
	public static final ForgeConfigSpec.ConfigValue<Double> SPEED;
	public static final ForgeConfigSpec.ConfigValue<Double> KNOCKBACK;
	public static final ForgeConfigSpec.ConfigValue<Double> KBRESISTANCE;
	public static final ForgeConfigSpec.ConfigValue<Double> RANGE;
	public static final ForgeConfigSpec.ConfigValue<Double> LEAP_CHANCE;
	public static final ForgeConfigSpec.ConfigValue<Double> ROAR_CHANCE;
	public static final ForgeConfigSpec.ConfigValue<Double> MAXLIVES;
	public static final ForgeConfigSpec.ConfigValue<Double> GOLDENHAMMERDMG;
	public static final ForgeConfigSpec.ConfigValue<Double> GOLDENHAMMERSPD;
	public static final ForgeConfigSpec.ConfigValue<Double> WITHERSWORDDMG;
	public static final ForgeConfigSpec.ConfigValue<Double> WITHERSWORDSPD;
	public static final ForgeConfigSpec.ConfigValue<Double> MAXTEXTUREVARIANTS;
	public static final ForgeConfigSpec.ConfigValue<Double> BABYCHANCE;
	public static final ForgeConfigSpec.ConfigValue<Double> MINSIZE;
	public static final ForgeConfigSpec.ConfigValue<Double> MAXSIZE;
	public static final ForgeConfigSpec.ConfigValue<Boolean> SIZEVARIES;
	static {
		BUILDER.push("Mutant Stats");
		DAMAGE = BUILDER.define("damage", (double) 1);
		HEALTH = BUILDER.define("health", (double) 1);
		SPEED = BUILDER.define("speed", (double) 1);
		KNOCKBACK = BUILDER.comment("Isn't used much in newer versions but still applies to some mobs.").define("attack_knockback", (double) 1);
		KBRESISTANCE = BUILDER.comment("Knockback resistance multiplier. Default: 1").define("knockback_resistance", (double) 1);
		RANGE = BUILDER.comment("Follow range multiplier. Default: 1").define("follow_range", (double) 1);
		BUILDER.pop();
		BUILDER.push("Mutant Spawning");
		BABYCHANCE = BUILDER.comment("The chance for a mutant mob to spawn as a baby. Default: 0.1").define("babychance", (double) 0.1);
		BUILDER.pop();
		BUILDER.push("Mob Abilities");
		LEAP_CHANCE = BUILDER.comment("The chance of a mutant zombie doing the grab and leap attack. Default 0.2, meaning 20%").define("leap_chance", (double) 0.2);
		ROAR_CHANCE = BUILDER.comment("Mutant Zombie roar attack to summon other zombies. Default: 0.1").define("roar_chance", (double) 0.1);
		MAXLIVES = BUILDER.comment("Amount of extra lives for mutant zombies. Default: 5").define("maxlives", (double) 5);
		BUILDER.pop();
		BUILDER.push("Item Stats");
		GOLDENHAMMERDMG = BUILDER.comment("Attack damage of golden hammer. Default: 10").define("goldenhammerdmg", (double) 10);
		GOLDENHAMMERSPD = BUILDER.comment("Attack speed of golden hammer. Default: -3.2").define("goldenhammerspd", (double) -3.2);
		WITHERSWORDDMG = BUILDER.comment("Attack damage of wither sword. Default: 6").define("withersworddmg", (double) 6);
		WITHERSWORDSPD = BUILDER.comment("Attack speed of wither sword. Default: -2").define("witherswordspd", (double) -2);
		BUILDER.pop();
		BUILDER.push("Mutant Appearances");
		MAXTEXTUREVARIANTS = BUILDER.comment("Max texture variants. Default: 4").define("maxtexturevariants", (double) 4);
		BUILDER.pop();
		BUILDER.push("Size Variation");
		SIZEVARIES = BUILDER.comment("If mutant size varies. Default: false").define("sizevaries", (boolean) false);
		MINSIZE = BUILDER.comment("Minimum size. Default: 0.7").define("minsize", (double) 0.7);
		MAXSIZE = BUILDER.comment("Maximum size. Default: 1.3").define("maxsize", (double) 1.3);
		BUILDER.pop();

		SPEC = BUILDER.build();
	}

}
