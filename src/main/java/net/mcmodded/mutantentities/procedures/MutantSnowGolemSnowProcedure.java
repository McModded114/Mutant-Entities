package net.mcmodded.mutantentities.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class MutantSnowGolemSnowProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (world.getLevelData().getGameRules().getBoolean(GameRules.RULE_MOBGRIEFING) == true) {
			if ((new Object() {
				public boolean replaceable(LevelAccessor _world, BlockState _blockState) {
					Level _level = _world instanceof Level ? (Level) _world : null;
					BlockHitResult _pos = new BlockHitResult(Vec3.ZERO, Direction.DOWN, BlockPos.ZERO, false);
					boolean _flag = _blockState.getMaterial().isReplaceable();
					boolean _flag2 = _level == null ? false : _blockState.canBeReplaced(new BlockPlaceContext(_level, null, InteractionHand.MAIN_HAND, ItemStack.EMPTY, _pos));
					boolean _flag3 = _level == null ? false : _blockState.canBeReplaced(new BlockPlaceContext(_level, null, InteractionHand.OFF_HAND, ItemStack.EMPTY, _pos));
					return _flag || _flag2 || _flag3;
				}
			}).replaceable(world, (world.getBlockState(new BlockPos(entity.getX(), entity.getY(), entity.getZ()))))) {
				world.setBlock(new BlockPos(entity.getX(), entity.getY(), entity.getZ()), Blocks.SNOW.defaultBlockState(), 3);
			}
			if ((new Object() {
				public boolean replaceable(LevelAccessor _world, BlockState _blockState) {
					Level _level = _world instanceof Level ? (Level) _world : null;
					BlockHitResult _pos = new BlockHitResult(Vec3.ZERO, Direction.DOWN, BlockPos.ZERO, false);
					boolean _flag = _blockState.getMaterial().isReplaceable();
					boolean _flag2 = _level == null ? false : _blockState.canBeReplaced(new BlockPlaceContext(_level, null, InteractionHand.MAIN_HAND, ItemStack.EMPTY, _pos));
					boolean _flag3 = _level == null ? false : _blockState.canBeReplaced(new BlockPlaceContext(_level, null, InteractionHand.OFF_HAND, ItemStack.EMPTY, _pos));
					return _flag || _flag2 || _flag3;
				}
			}).replaceable(world, (world.getBlockState(new BlockPos(entity.getX() + 1, entity.getY(), entity.getZ()))))) {
				world.setBlock(new BlockPos(entity.getX() + 1, entity.getY(), entity.getZ()), Blocks.SNOW.defaultBlockState(), 3);
			}
			if ((new Object() {
				public boolean replaceable(LevelAccessor _world, BlockState _blockState) {
					Level _level = _world instanceof Level ? (Level) _world : null;
					BlockHitResult _pos = new BlockHitResult(Vec3.ZERO, Direction.DOWN, BlockPos.ZERO, false);
					boolean _flag = _blockState.getMaterial().isReplaceable();
					boolean _flag2 = _level == null ? false : _blockState.canBeReplaced(new BlockPlaceContext(_level, null, InteractionHand.MAIN_HAND, ItemStack.EMPTY, _pos));
					boolean _flag3 = _level == null ? false : _blockState.canBeReplaced(new BlockPlaceContext(_level, null, InteractionHand.OFF_HAND, ItemStack.EMPTY, _pos));
					return _flag || _flag2 || _flag3;
				}
			}).replaceable(world, (world.getBlockState(new BlockPos(entity.getX() - 1, entity.getY(), entity.getZ()))))) {
				world.setBlock(new BlockPos(entity.getX() - 1, entity.getY(), entity.getZ()), Blocks.SNOW.defaultBlockState(), 3);
			}
			if ((new Object() {
				public boolean replaceable(LevelAccessor _world, BlockState _blockState) {
					Level _level = _world instanceof Level ? (Level) _world : null;
					BlockHitResult _pos = new BlockHitResult(Vec3.ZERO, Direction.DOWN, BlockPos.ZERO, false);
					boolean _flag = _blockState.getMaterial().isReplaceable();
					boolean _flag2 = _level == null ? false : _blockState.canBeReplaced(new BlockPlaceContext(_level, null, InteractionHand.MAIN_HAND, ItemStack.EMPTY, _pos));
					boolean _flag3 = _level == null ? false : _blockState.canBeReplaced(new BlockPlaceContext(_level, null, InteractionHand.OFF_HAND, ItemStack.EMPTY, _pos));
					return _flag || _flag2 || _flag3;
				}
			}).replaceable(world, (world.getBlockState(new BlockPos(entity.getX(), entity.getY(), entity.getZ() + 1))))) {
				world.setBlock(new BlockPos(entity.getX(), entity.getY(), entity.getZ() + 1), Blocks.SNOW.defaultBlockState(), 3);
			}
			if ((new Object() {
				public boolean replaceable(LevelAccessor _world, BlockState _blockState) {
					Level _level = _world instanceof Level ? (Level) _world : null;
					BlockHitResult _pos = new BlockHitResult(Vec3.ZERO, Direction.DOWN, BlockPos.ZERO, false);
					boolean _flag = _blockState.getMaterial().isReplaceable();
					boolean _flag2 = _level == null ? false : _blockState.canBeReplaced(new BlockPlaceContext(_level, null, InteractionHand.MAIN_HAND, ItemStack.EMPTY, _pos));
					boolean _flag3 = _level == null ? false : _blockState.canBeReplaced(new BlockPlaceContext(_level, null, InteractionHand.OFF_HAND, ItemStack.EMPTY, _pos));
					return _flag || _flag2 || _flag3;
				}
			}).replaceable(world, (world.getBlockState(new BlockPos(entity.getX(), entity.getY(), entity.getZ() - 1))))) {
				world.setBlock(new BlockPos(entity.getX(), entity.getY(), entity.getZ() - 1), Blocks.SNOW.defaultBlockState(), 3);
			}
		}
	}
}
