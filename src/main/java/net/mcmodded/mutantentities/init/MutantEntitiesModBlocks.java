
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcmodded.mutantentities.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.mcmodded.mutantentities.block.WastelandDirtBlock;
import net.mcmodded.mutantentities.block.ToxicDirtBlock;
import net.mcmodded.mutantentities.block.SolidChemicalXBlock;
import net.mcmodded.mutantentities.block.NuclearSciencetableBlock;
import net.mcmodded.mutantentities.block.DeadGrassBlock;
import net.mcmodded.mutantentities.block.CreeperBombBlock;
import net.mcmodded.mutantentities.block.ChemicalXBlock;
import net.mcmodded.mutantentities.block.AncientBushBlock;
import net.mcmodded.mutantentities.MutantEntitiesMod;

public class MutantEntitiesModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, MutantEntitiesMod.MODID);
	public static final RegistryObject<Block> SOLID_CHEMICAL_X = REGISTRY.register("solid_chemical_x", () -> new SolidChemicalXBlock());
	public static final RegistryObject<Block> TOXIC_DIRT = REGISTRY.register("toxic_dirt", () -> new ToxicDirtBlock());
	public static final RegistryObject<Block> WASTELAND_DIRT = REGISTRY.register("wasteland_dirt", () -> new WastelandDirtBlock());
	public static final RegistryObject<Block> CHEMICAL_X = REGISTRY.register("chemical_x", () -> new ChemicalXBlock());
	public static final RegistryObject<Block> DEAD_GRASS = REGISTRY.register("dead_grass", () -> new DeadGrassBlock());
	public static final RegistryObject<Block> CREEPER_BOMB = REGISTRY.register("creeper_bomb", () -> new CreeperBombBlock());
	public static final RegistryObject<Block> NUCLEAR_SCIENCETABLE = REGISTRY.register("nuclear_sciencetable", () -> new NuclearSciencetableBlock());
	public static final RegistryObject<Block> ANCIENT_BUSH = REGISTRY.register("ancient_bush", () -> new AncientBushBlock());
}
