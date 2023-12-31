
package net.mcmodded.mutantentities.world.features;

import net.minecraft.world.level.levelgen.feature.configurations.ReplaceBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.ReplaceBlockFeature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.Level;
import net.minecraft.resources.ResourceKey;

import net.mcmodded.mutantentities.procedures.InChemicalxbiomeProcedure;

import java.util.Set;

public class NuclearBlocksSpawningFeature extends ReplaceBlockFeature {
	private final Set<ResourceKey<Level>> generateDimensions = Set.of(Level.OVERWORLD);

	public NuclearBlocksSpawningFeature() {
		super(ReplaceBlockConfiguration.CODEC);
	}

	public boolean place(FeaturePlaceContext<ReplaceBlockConfiguration> context) {
		WorldGenLevel world = context.level();
		if (!generateDimensions.contains(world.getLevel().dimension()))
			return false;
		int x = context.origin().getX();
		int y = context.origin().getY();
		int z = context.origin().getZ();
		if (!InChemicalxbiomeProcedure.execute(world, x, y, z))
			return false;
		return super.place(context);
	}
}
