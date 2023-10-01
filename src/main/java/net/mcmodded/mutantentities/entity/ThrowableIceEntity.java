
package net.mcmodded.mutantentities.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.util.RandomSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.Packet;

import net.mcmodded.mutantentities.procedures.ThrowableIceProjectileHitsEntityProcedure;
import net.mcmodded.mutantentities.procedures.ThrowableIceProjectileHitsBlockProcedure;
import net.mcmodded.mutantentities.procedures.ThrowableIceParticlesProcedure;
import net.mcmodded.mutantentities.init.MutantEntitiesModEntities;

@OnlyIn(value = Dist.CLIENT, _interface = ItemSupplier.class)
public class ThrowableIceEntity extends AbstractArrow implements ItemSupplier {
	public ThrowableIceEntity(PlayMessages.SpawnEntity packet, Level world) {
		super(MutantEntitiesModEntities.THROWABLE_ICE.get(), world);
	}

	public ThrowableIceEntity(EntityType<? extends ThrowableIceEntity> type, Level world) {
		super(type, world);
	}

	public ThrowableIceEntity(EntityType<? extends ThrowableIceEntity> type, double x, double y, double z, Level world) {
		super(type, x, y, z, world);
	}

	public ThrowableIceEntity(EntityType<? extends ThrowableIceEntity> type, LivingEntity entity, Level world) {
		super(type, entity, world);
	}

	@Override
	public Packet<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public ItemStack getItem() {
		return ItemStack.EMPTY;
	}

	@Override
	protected ItemStack getPickupItem() {
		return ItemStack.EMPTY;
	}

	@Override
	protected void doPostHurtEffects(LivingEntity entity) {
		super.doPostHurtEffects(entity);
		entity.setArrowCount(entity.getArrowCount() - 1);
	}

	@Override
	public void playerTouch(Player entity) {
		super.playerTouch(entity);
		ThrowableIceProjectileHitsEntityProcedure.execute(this.level, entity, this, this.getOwner());
	}

	@Override
	public void onHitEntity(EntityHitResult entityHitResult) {
		super.onHitEntity(entityHitResult);
		ThrowableIceProjectileHitsEntityProcedure.execute(this.level, entityHitResult.getEntity(), this, this.getOwner());
	}

	@Override
	public void onHitBlock(BlockHitResult blockHitResult) {
		super.onHitBlock(blockHitResult);
		ThrowableIceProjectileHitsBlockProcedure.execute(this.level, blockHitResult.getBlockPos().getX(), blockHitResult.getBlockPos().getY(), blockHitResult.getBlockPos().getZ());
	}

	@Override
	public void tick() {
		super.tick();
		ThrowableIceParticlesProcedure.execute(this.level, this.getX(), this.getY(), this.getZ());
		if (this.inGround)
			this.discard();
	}

	public static ThrowableIceEntity shoot(Level world, LivingEntity entity, RandomSource random, float power, double damage, int knockback) {
		ThrowableIceEntity entityarrow = new ThrowableIceEntity(MutantEntitiesModEntities.THROWABLE_ICE.get(), entity, world);
		entityarrow.shoot(entity.getViewVector(1).x, entity.getViewVector(1).y, entity.getViewVector(1).z, power * 2, 0);
		entityarrow.setSilent(true);
		entityarrow.setCritArrow(false);
		entityarrow.setBaseDamage(damage);
		entityarrow.setKnockback(knockback);
		world.addFreshEntity(entityarrow);
		world.playSound(null, entity.getX(), entity.getY(), entity.getZ(), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.glass.place")), SoundSource.PLAYERS, 1, 1f / (random.nextFloat() * 0.5f + 1) + (power / 2));
		return entityarrow;
	}

	public static ThrowableIceEntity shoot(LivingEntity entity, LivingEntity target) {
		ThrowableIceEntity entityarrow = new ThrowableIceEntity(MutantEntitiesModEntities.THROWABLE_ICE.get(), entity, entity.level);
		double dx = target.getX() - entity.getX();
		double dy = target.getY() + target.getEyeHeight() - 1.1;
		double dz = target.getZ() - entity.getZ();
		entityarrow.shoot(dx, dy - entityarrow.getY() + Math.hypot(dx, dz) * 0.2F, dz, 1f * 2, 12.0F);
		entityarrow.setSilent(true);
		entityarrow.setBaseDamage(0);
		entityarrow.setKnockback(1);
		entityarrow.setCritArrow(false);
		entity.level.addFreshEntity(entityarrow);
		entity.level.playSound(null, entity.getX(), entity.getY(), entity.getZ(), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.glass.place")), SoundSource.PLAYERS, 1, 1f / (RandomSource.create().nextFloat() * 0.5f + 1));
		return entityarrow;
	}
}
