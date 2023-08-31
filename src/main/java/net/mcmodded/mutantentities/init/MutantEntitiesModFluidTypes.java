
/*
 * MCreator note: This file will be REGENERATED on each build.
 */
package net.mcmodded.mutantentities.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fluids.FluidType;

import net.mcmodded.mutantentities.fluid.types.ChemicalXFluidType;
import net.mcmodded.mutantentities.MutantEntitiesMod;

public class MutantEntitiesModFluidTypes {
	public static final DeferredRegister<FluidType> REGISTRY = DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, MutantEntitiesMod.MODID);
	public static final RegistryObject<FluidType> CHEMICAL_X_TYPE = REGISTRY.register("chemical_x", () -> new ChemicalXFluidType());
}
