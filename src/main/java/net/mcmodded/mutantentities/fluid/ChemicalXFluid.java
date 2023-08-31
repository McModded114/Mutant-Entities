
package net.mcmodded.mutantentities.fluid;

import net.minecraftforge.fluids.ForgeFlowingFluid;

import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.LiquidBlock;

import net.mcmodded.mutantentities.init.MutantEntitiesModFluids;
import net.mcmodded.mutantentities.init.MutantEntitiesModFluidTypes;
import net.mcmodded.mutantentities.init.MutantEntitiesModBlocks;

public abstract class ChemicalXFluid extends ForgeFlowingFluid {
	public static final ForgeFlowingFluid.Properties PROPERTIES = new ForgeFlowingFluid.Properties(() -> MutantEntitiesModFluidTypes.CHEMICAL_X_TYPE.get(), () -> MutantEntitiesModFluids.CHEMICAL_X.get(),
			() -> MutantEntitiesModFluids.FLOWING_CHEMICAL_X.get()).explosionResistance(100f).block(() -> (LiquidBlock) MutantEntitiesModBlocks.CHEMICAL_X.get());

	private ChemicalXFluid() {
		super(PROPERTIES);
	}

	public static class Source extends ChemicalXFluid {
		public int getAmount(FluidState state) {
			return 8;
		}

		public boolean isSource(FluidState state) {
			return true;
		}
	}

	public static class Flowing extends ChemicalXFluid {
		protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
			super.createFluidStateDefinition(builder);
			builder.add(LEVEL);
		}

		public int getAmount(FluidState state) {
			return state.getValue(LEVEL);
		}

		public boolean isSource(FluidState state) {
			return false;
		}
	}
}
