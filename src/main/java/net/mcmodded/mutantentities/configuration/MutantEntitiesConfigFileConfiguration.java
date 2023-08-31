package net.mcmodded.mutantentities.configuration;

import net.minecraftforge.common.ForgeConfigSpec;

public class MutantEntitiesConfigFileConfiguration {
	public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec SPEC;
	public static final ForgeConfigSpec.ConfigValue<Double> DAMAGE;
	public static final ForgeConfigSpec.ConfigValue<Double> STATPERCENTS;
	public static final ForgeConfigSpec.ConfigValue<Double> HEALTH;
	public static final ForgeConfigSpec.ConfigValue<Double> SPEED;
	public static final ForgeConfigSpec.ConfigValue<Double> KNOCKBACK;
	public static final ForgeConfigSpec.ConfigValue<Double> KBRESISTANCE;
	public static final ForgeConfigSpec.ConfigValue<Double> RANGE;
	public static final ForgeConfigSpec.ConfigValue<Double> LEAP_CHANCE;
	public static final ForgeConfigSpec.ConfigValue<Double> SLAM_CHANCE;
	public static final ForgeConfigSpec.ConfigValue<Double> ROAR_CHANCE;
	public static final ForgeConfigSpec.ConfigValue<Double> MAXLIVES;
	public static final ForgeConfigSpec.ConfigValue<Double> GOLDENHAMMERDMG;
	public static final ForgeConfigSpec.ConfigValue<Double> GOLDENHAMMERSPD;
	public static final ForgeConfigSpec.ConfigValue<Double> WITHERSWORDDMG;
	public static final ForgeConfigSpec.ConfigValue<Double> WITHERSWORDSPD;
	public static final ForgeConfigSpec.ConfigValue<Double> MAXTEXTUREVARIANTS;
	public static final ForgeConfigSpec.ConfigValue<Double> BABYCHANCE;
	static {
		BUILDER.push("Mutant Stats");
		DAMAGE = BUILDER.define("damage", (double) 1);
		STATPERCENTS = BUILDER.comment("Mob stats in percent. Applies to health, damage and speed. Default: 100").define("STATPERCENTS", (double) 100);
		HEALTH = BUILDER.define("health", (double) 1);
		SPEED = BUILDER.define("speed", (double) 1);
		KNOCKBACK = BUILDER.comment("Isn't used much in 0.0.7 but still works for mutant skeletons.").define("attack_knockback", (double) 1);
		KBRESISTANCE = BUILDER.define("knockback_resistance", (double) 1);
		RANGE = BUILDER.define("follow_range", (double) 1);
		BUILDER.pop();
		BUILDER.push("Mutant Spawning");
		BABYCHANCE = BUILDER.comment("The chance for a mutant mob to spawn as baby version which is weaker but a bit faster. 0.2 = 20%").define("babychance", (double) 0.2);
		BUILDER.pop();
		BUILDER.push("Mob Abilities");
		LEAP_CHANCE = BUILDER.comment("The chance of a mutant zombie doing the grab and leap attack. Default 0.2, meaning 20%").define("leap_chance", (double) 0.2);
		SLAM_CHANCE = BUILDER.comment("Chance for mutant zombie slam attack. Default: 0.25").define("slam_chance", (double) 0.25);
		ROAR_CHANCE = BUILDER.comment("Mutant Zombie roar attack to summon other zombies").define("roar_chance", (double) 0.1);
		MAXLIVES = BUILDER.comment("Maximum amount of extra lives for mutant zombies.").define("maxlives", (double) 5);
		BUILDER.pop();
		BUILDER.push("Item Stats");
		GOLDENHAMMERDMG = BUILDER.comment("Attack damage of golden hammer").define("goldenhammerdmg", (double) 10);
		GOLDENHAMMERSPD = BUILDER.comment("Attack speed of golden hammer").define("goldenhammerspd", (double) -3.2);
		WITHERSWORDDMG = BUILDER.comment("Attack damage of wither sword").define("withersworddmg", (double) 6);
		WITHERSWORDSPD = BUILDER.comment("Attack speed of wither sword").define("witherswordspd", (double) -2);
		BUILDER.pop();
		BUILDER.push("Mutant Appearances");
		MAXTEXTUREVARIANTS = BUILDER.comment("Max texture variants.(Only visible if client config has random textures enabled.) Default: 4").define("maxtexturevariants", (double) 4);
		BUILDER.pop();

		SPEC = BUILDER.build();
	}

}
