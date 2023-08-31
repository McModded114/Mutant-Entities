
package net.mcmodded.mutantentities.block;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcmodded.mutantentities.procedures.RadiationDamageProcedure;
import net.mcmodded.mutantentities.init.MutantEntitiesModFluids;

public class ChemicalXBlock extends LiquidBlock {
	public ChemicalXBlock() {
		super(() -> MutantEntitiesModFluids.CHEMICAL_X.get(), BlockBehaviour.Properties.of(Material.WATER, MaterialColor.COLOR_LIGHT_GREEN).strength(100f).lightLevel(s -> 10).noCollission().noLootTable());
	}

	@Override
	public void entityInside(BlockState blockstate, Level world, BlockPos pos, Entity entity) {
		super.entityInside(blockstate, world, pos, entity);
		RadiationDamageProcedure.execute(entity);
	}
}
