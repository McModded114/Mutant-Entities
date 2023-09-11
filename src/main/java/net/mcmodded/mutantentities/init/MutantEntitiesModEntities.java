
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcmodded.mutantentities.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import net.mcmodded.mutantentities.entity.ThrowableIceEntity;
import net.mcmodded.mutantentities.entity.ThrowableGrassblockEntity;
import net.mcmodded.mutantentities.entity.ThrowableEndstoneEntity;
import net.mcmodded.mutantentities.entity.ThrowableDirtEntity;
import net.mcmodded.mutantentities.entity.ThrowableCobblestoneEntity;
import net.mcmodded.mutantentities.entity.ThornyMutantHuskEntity;
import net.mcmodded.mutantentities.entity.SpiderPigEntity;
import net.mcmodded.mutantentities.entity.MutantZombifiedPiglinEntity;
import net.mcmodded.mutantentities.entity.MutantZombieEntity;
import net.mcmodded.mutantentities.entity.MutantWitherSkeletonEntity;
import net.mcmodded.mutantentities.entity.MutantSnowGolemEntity;
import net.mcmodded.mutantentities.entity.MutantSkeletonEntity;
import net.mcmodded.mutantentities.entity.MutantShulkerEntity;
import net.mcmodded.mutantentities.entity.MutantIronGolemEntity;
import net.mcmodded.mutantentities.entity.MutantHuskEntity;
import net.mcmodded.mutantentities.entity.MutantEndermanEntity;
import net.mcmodded.mutantentities.entity.MutantDrownedEntity;
import net.mcmodded.mutantentities.entity.MutantCreeperEntity;
import net.mcmodded.mutantentities.entity.MutantArrowEntity;
import net.mcmodded.mutantentities.entity.EndersoulEntity;
import net.mcmodded.mutantentities.entity.CreeperlingEntity;
import net.mcmodded.mutantentities.entity.ChemicalXItemEntity;
import net.mcmodded.mutantentities.MutantEntitiesMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class MutantEntitiesModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MutantEntitiesMod.MODID);
	public static final RegistryObject<EntityType<MutantZombieEntity>> MUTANT_ZOMBIE = register("mutant_zombie",
			EntityType.Builder.<MutantZombieEntity>of(MutantZombieEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(MutantZombieEntity::new)

					.sized(1.44f, 2.56f));
	public static final RegistryObject<EntityType<MutantHuskEntity>> MUTANT_HUSK = register("mutant_husk",
			EntityType.Builder.<MutantHuskEntity>of(MutantHuskEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(MutantHuskEntity::new)

					.sized(1.44f, 2.56f));
	public static final RegistryObject<EntityType<MutantZombifiedPiglinEntity>> MUTANT_ZOMBIFIED_PIGLIN = register("mutant_zombified_piglin", EntityType.Builder.<MutantZombifiedPiglinEntity>of(MutantZombifiedPiglinEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(MutantZombifiedPiglinEntity::new).fireImmune().sized(1.44f, 2.56f));
	public static final RegistryObject<EntityType<MutantSkeletonEntity>> MUTANT_SKELETON = register("mutant_skeleton",
			EntityType.Builder.<MutantSkeletonEntity>of(MutantSkeletonEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(MutantSkeletonEntity::new)

					.sized(1.4f, 4f));
	public static final RegistryObject<EntityType<MutantCreeperEntity>> MUTANT_CREEPER = register("mutant_creeper",
			EntityType.Builder.<MutantCreeperEntity>of(MutantCreeperEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(MutantCreeperEntity::new)

					.sized(1.4f, 2.8f));
	public static final RegistryObject<EntityType<CreeperlingEntity>> CREEPERLING = register("creeperling",
			EntityType.Builder.<CreeperlingEntity>of(CreeperlingEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CreeperlingEntity::new)

					.sized(0.3f, 0.9f));
	public static final RegistryObject<EntityType<MutantIronGolemEntity>> MUTANT_IRON_GOLEM = register("mutant_iron_golem",
			EntityType.Builder.<MutantIronGolemEntity>of(MutantIronGolemEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(MutantIronGolemEntity::new)

					.sized(1.6f, 4f));
	public static final RegistryObject<EntityType<MutantWitherSkeletonEntity>> MUTANT_WITHER_SKELETON = register("mutant_wither_skeleton", EntityType.Builder.<MutantWitherSkeletonEntity>of(MutantWitherSkeletonEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(MutantWitherSkeletonEntity::new).fireImmune().sized(1.4f, 4f));
	public static final RegistryObject<EntityType<MutantDrownedEntity>> MUTANT_DROWNED = register("mutant_drowned",
			EntityType.Builder.<MutantDrownedEntity>of(MutantDrownedEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(MutantDrownedEntity::new)

					.sized(1.44f, 2.56f));
	public static final RegistryObject<EntityType<ThornyMutantHuskEntity>> THORNY_MUTANT_HUSK = register("thorny_mutant_husk",
			EntityType.Builder.<ThornyMutantHuskEntity>of(ThornyMutantHuskEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(ThornyMutantHuskEntity::new)

					.sized(1.44f, 2.56f));
	public static final RegistryObject<EntityType<MutantEndermanEntity>> MUTANT_ENDERMAN = register("mutant_enderman",
			EntityType.Builder.<MutantEndermanEntity>of(MutantEndermanEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(MutantEndermanEntity::new)

					.sized(1.6f, 3.8f));
	public static final RegistryObject<EntityType<ChemicalXItemEntity>> CHEMICAL_X_ITEM = register("projectile_chemical_x_item",
			EntityType.Builder.<ChemicalXItemEntity>of(ChemicalXItemEntity::new, MobCategory.MISC).setCustomClientFactory(ChemicalXItemEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<EndersoulEntity>> ENDERSOUL = register("endersoul",
			EntityType.Builder.<EndersoulEntity>of(EndersoulEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(EndersoulEntity::new)

					.sized(1.6f, 3.8f));
	public static final RegistryObject<EntityType<ThrowableCobblestoneEntity>> THROWABLE_COBBLESTONE = register("projectile_throwable_cobblestone", EntityType.Builder.<ThrowableCobblestoneEntity>of(ThrowableCobblestoneEntity::new, MobCategory.MISC)
			.setCustomClientFactory(ThrowableCobblestoneEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<ThrowableEndstoneEntity>> THROWABLE_ENDSTONE = register("projectile_throwable_endstone", EntityType.Builder.<ThrowableEndstoneEntity>of(ThrowableEndstoneEntity::new, MobCategory.MISC)
			.setCustomClientFactory(ThrowableEndstoneEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<ThrowableDirtEntity>> THROWABLE_DIRT = register("projectile_throwable_dirt",
			EntityType.Builder.<ThrowableDirtEntity>of(ThrowableDirtEntity::new, MobCategory.MISC).setCustomClientFactory(ThrowableDirtEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<ThrowableGrassblockEntity>> THROWABLE_GRASSBLOCK = register("projectile_throwable_grassblock", EntityType.Builder.<ThrowableGrassblockEntity>of(ThrowableGrassblockEntity::new, MobCategory.MISC)
			.setCustomClientFactory(ThrowableGrassblockEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<SpiderPigEntity>> SPIDER_PIG = register("spider_pig",
			EntityType.Builder.<SpiderPigEntity>of(SpiderPigEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(SpiderPigEntity::new)

					.sized(1.46f, 1.23f));
	public static final RegistryObject<EntityType<MutantShulkerEntity>> MUTANT_SHULKER = register("mutant_shulker",
			EntityType.Builder.<MutantShulkerEntity>of(MutantShulkerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(MutantShulkerEntity::new)

					.sized(2f, 2f));
	public static final RegistryObject<EntityType<MutantSnowGolemEntity>> MUTANT_SNOW_GOLEM = register("mutant_snow_golem",
			EntityType.Builder.<MutantSnowGolemEntity>of(MutantSnowGolemEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(MutantSnowGolemEntity::new)

					.sized(1.7f, 3.6f));
	public static final RegistryObject<EntityType<ThrowableIceEntity>> THROWABLE_ICE = register("projectile_throwable_ice",
			EntityType.Builder.<ThrowableIceEntity>of(ThrowableIceEntity::new, MobCategory.MISC).setCustomClientFactory(ThrowableIceEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<MutantArrowEntity>> MUTANT_ARROW = register("projectile_mutant_arrow",
			EntityType.Builder.<MutantArrowEntity>of(MutantArrowEntity::new, MobCategory.MISC).setCustomClientFactory(MutantArrowEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));

	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			MutantZombieEntity.init();
			MutantHuskEntity.init();
			MutantZombifiedPiglinEntity.init();
			MutantSkeletonEntity.init();
			MutantCreeperEntity.init();
			CreeperlingEntity.init();
			MutantIronGolemEntity.init();
			MutantWitherSkeletonEntity.init();
			MutantDrownedEntity.init();
			ThornyMutantHuskEntity.init();
			MutantEndermanEntity.init();
			EndersoulEntity.init();
			SpiderPigEntity.init();
			MutantShulkerEntity.init();
			MutantSnowGolemEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(MUTANT_ZOMBIE.get(), MutantZombieEntity.createAttributes().build());
		event.put(MUTANT_HUSK.get(), MutantHuskEntity.createAttributes().build());
		event.put(MUTANT_ZOMBIFIED_PIGLIN.get(), MutantZombifiedPiglinEntity.createAttributes().build());
		event.put(MUTANT_SKELETON.get(), MutantSkeletonEntity.createAttributes().build());
		event.put(MUTANT_CREEPER.get(), MutantCreeperEntity.createAttributes().build());
		event.put(CREEPERLING.get(), CreeperlingEntity.createAttributes().build());
		event.put(MUTANT_IRON_GOLEM.get(), MutantIronGolemEntity.createAttributes().build());
		event.put(MUTANT_WITHER_SKELETON.get(), MutantWitherSkeletonEntity.createAttributes().build());
		event.put(MUTANT_DROWNED.get(), MutantDrownedEntity.createAttributes().build());
		event.put(THORNY_MUTANT_HUSK.get(), ThornyMutantHuskEntity.createAttributes().build());
		event.put(MUTANT_ENDERMAN.get(), MutantEndermanEntity.createAttributes().build());
		event.put(ENDERSOUL.get(), EndersoulEntity.createAttributes().build());
		event.put(SPIDER_PIG.get(), SpiderPigEntity.createAttributes().build());
		event.put(MUTANT_SHULKER.get(), MutantShulkerEntity.createAttributes().build());
		event.put(MUTANT_SNOW_GOLEM.get(), MutantSnowGolemEntity.createAttributes().build());
	}
}
