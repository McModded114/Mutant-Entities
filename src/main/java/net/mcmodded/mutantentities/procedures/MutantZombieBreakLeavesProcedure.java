package net.mcmodded.mutantentities.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameRules;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class MutantZombieBreakLeavesProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world.getLevelData().getGameRules().getBoolean(GameRules.RULE_MOBGRIEFING) == true) {
			if ((world.getBlockState(new BlockPos(x + 1, y, z + 1))).is(BlockTags.create(new ResourceLocation("minecraft:leaves")))) {
				world.destroyBlock(new BlockPos(x + 1, y, z + 1), false);
			}
			if ((world.getBlockState(new BlockPos(x - 1, y, z + 1))).is(BlockTags.create(new ResourceLocation("minecraft:leaves")))) {
				world.destroyBlock(new BlockPos(x - 1, y, z + 1), false);
			}
			if ((world.getBlockState(new BlockPos(x + 1, y, z - 1))).is(BlockTags.create(new ResourceLocation("minecraft:leaves")))) {
				world.destroyBlock(new BlockPos(x + 1, y, z - 1), false);
			}
			if ((world.getBlockState(new BlockPos(x - 1, y, z - 1))).is(BlockTags.create(new ResourceLocation("minecraft:leaves")))) {
				world.destroyBlock(new BlockPos(x - 1, y, z - 1), false);
			}
			if ((world.getBlockState(new BlockPos(x + 1, y + 1, z + 1))).is(BlockTags.create(new ResourceLocation("minecraft:leaves")))) {
				world.destroyBlock(new BlockPos(x + 1, y + 1, z + 1), false);
			}
			if ((world.getBlockState(new BlockPos(x + 1, y - 1, z + 1))).is(BlockTags.create(new ResourceLocation("minecraft:leaves")))) {
				world.destroyBlock(new BlockPos(x + 1, y - 1, z + 1), false);
			}
			if ((world.getBlockState(new BlockPos(x - 1, y + 1, z + 1))).is(BlockTags.create(new ResourceLocation("minecraft:leaves")))) {
				world.destroyBlock(new BlockPos(x - 1, y + 1, z + 1), false);
			}
			if ((world.getBlockState(new BlockPos(x - 1, y - 1, z + 1))).is(BlockTags.create(new ResourceLocation("minecraft:leaves")))) {
				world.destroyBlock(new BlockPos(x - 1, y - 1, z + 1), false);
			}
			if ((world.getBlockState(new BlockPos(x - 1, y + 1, z - 1))).is(BlockTags.create(new ResourceLocation("minecraft:leaves")))) {
				world.destroyBlock(new BlockPos(x - 1, y + 1, z - 1), false);
			}
			if ((world.getBlockState(new BlockPos(x - 1, y - 1, z - 1))).is(BlockTags.create(new ResourceLocation("minecraft:leaves")))) {
				world.destroyBlock(new BlockPos(x - 1, y - 1, z - 1), false);
			}
		}
	}
}
