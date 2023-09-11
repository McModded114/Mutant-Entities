/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcmodded.mutantentities.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeModificationEvent;

import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import net.mcmodded.mutantentities.MutantEntitiesMod;

import java.util.List;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class MutantEntitiesModAttributes {
	public static final DeferredRegister<Attribute> ATTRIBUTES = DeferredRegister.create(ForgeRegistries.ATTRIBUTES, MutantEntitiesMod.MODID);
	public static final RegistryObject<Attribute> ATK = ATTRIBUTES.register("atk", () -> (new RangedAttribute("attribute." + MutantEntitiesMod.MODID + ".atk", 0, 0, 1)).setSyncable(true));
	public static final RegistryObject<Attribute> EXT = ATTRIBUTES.register("ext", () -> (new RangedAttribute("attribute." + MutantEntitiesMod.MODID + ".ext", 0, 0, 1024)).setSyncable(true));
	public static final RegistryObject<Attribute> SIZ = ATTRIBUTES.register("siz", () -> (new RangedAttribute("attribute." + MutantEntitiesMod.MODID + ".siz", 1, 0, 1024)).setSyncable(true));
	public static final RegistryObject<Attribute> VAR = ATTRIBUTES.register("var", () -> (new RangedAttribute("attribute." + MutantEntitiesMod.MODID + ".var", 0, 0, 1024)).setSyncable(true));
	public static final RegistryObject<Attribute> MOBVAR = ATTRIBUTES.register("mob_var", () -> (new RangedAttribute("attribute." + MutantEntitiesMod.MODID + ".mob_var", 0, 0, 1024)).setSyncable(true));

	@SubscribeEvent
	public static void register(FMLConstructModEvent event) {
		event.enqueueWork(() -> {
			ATTRIBUTES.register(FMLJavaModLoadingContext.get().getModEventBus());
		});
	}

	@SubscribeEvent
	public static void addAttributes(EntityAttributeModificationEvent event) {
		List<EntityType<? extends LivingEntity>> entityTypes = event.getTypes();
		entityTypes.forEach((e) -> {
			Class<? extends Entity> baseClass = e.getBaseClass();
			if (baseClass.isAssignableFrom(Monster.class) || baseClass.isAssignableFrom(Animal.class)) {
				event.add(e, ATK.get());
			}
		});
		entityTypes.forEach((e) -> {
			Class<? extends Entity> baseClass = e.getBaseClass();
			if (baseClass.isAssignableFrom(Monster.class) || baseClass.isAssignableFrom(Animal.class)) {
				event.add(e, EXT.get());
			}
		});
		entityTypes.forEach((e) -> {
			Class<? extends Entity> baseClass = e.getBaseClass();
			if (baseClass.isAssignableFrom(Monster.class) || baseClass.isAssignableFrom(Animal.class)) {
				event.add(e, SIZ.get());
			}
		});
		entityTypes.forEach((e) -> {
			Class<? extends Entity> baseClass = e.getBaseClass();
			if (baseClass.isAssignableFrom(Monster.class) || baseClass.isAssignableFrom(Animal.class)) {
				event.add(e, VAR.get());
			}
		});
		entityTypes.forEach((e) -> {
			Class<? extends Entity> baseClass = e.getBaseClass();
			if (baseClass.isAssignableFrom(Monster.class) || baseClass.isAssignableFrom(Animal.class)) {
				event.add(e, MOBVAR.get());
			}
		});
	}
}
