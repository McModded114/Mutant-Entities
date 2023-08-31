
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcmodded.mutantentities.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.enchantment.Enchantment;

import net.mcmodded.mutantentities.enchantment.CrushingEnchantment;
import net.mcmodded.mutantentities.enchantment.CleavingEnchantment;
import net.mcmodded.mutantentities.MutantEntitiesMod;

public class MutantEntitiesModEnchantments {
	public static final DeferredRegister<Enchantment> REGISTRY = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, MutantEntitiesMod.MODID);
	public static final RegistryObject<Enchantment> CRUSHING = REGISTRY.register("crushing", () -> new CrushingEnchantment());
	public static final RegistryObject<Enchantment> CLEAVING = REGISTRY.register("cleaving", () -> new CleavingEnchantment());
}
