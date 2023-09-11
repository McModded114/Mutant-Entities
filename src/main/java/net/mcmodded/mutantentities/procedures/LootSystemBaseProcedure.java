package net.mcmodded.mutantentities.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;

import net.mcmodded.mutantentities.init.MutantEntitiesModAttributes;

public class LootSystemBaseProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide() && world.getServer() != null) {
			for (ItemStack itemstackiterator : world.getServer().getLootTables()
					.get(new ResourceLocation((("mutant_entities:entities/" + (ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).replace("mutant_entities:", "") + "_loot")).toLowerCase(java.util.Locale.ENGLISH)))
					.getRandomItems(new LootContext.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY))) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, itemstackiterator);
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			}
		}
		if (((LivingEntity) entity).getAttribute(MutantEntitiesModAttributes.MOBVAR.get()).getBaseValue() != 0) {
			if (!world.isClientSide() && world.getServer() != null) {
				for (ItemStack itemstackiterator : world.getServer().getLootTables()
						.get(new ResourceLocation((("mutant_entities:entities/" + (ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).replace("mutant_entities:", "") + "_loot"
								+ Math.round(((LivingEntity) entity).getAttribute(MutantEntitiesModAttributes.MOBVAR.get()).getBaseValue()))).toLowerCase(java.util.Locale.ENGLISH)))
						.getRandomItems(new LootContext.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY))) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, itemstackiterator);
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
				}
			}
		}
	}
}
