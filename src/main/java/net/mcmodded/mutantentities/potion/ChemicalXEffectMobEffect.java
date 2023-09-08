
package net.mcmodded.mutantentities.potion;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcmodded.mutantentities.procedures.KillEntityProcedure;
import net.mcmodded.mutantentities.procedures.ChemicalXEffectParticleProcedure;

public class ChemicalXEffectMobEffect extends MobEffect {
	public ChemicalXEffectMobEffect() {
		super(MobEffectCategory.NEUTRAL, -1);
	}

	@Override
	public String getDescriptionId() {
		return "effect.mutant_entities.chemical_x_effect";
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		ChemicalXEffectParticleProcedure.execute(entity.level, entity.getX(), entity.getY(), entity.getZ());
	}

	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		super.removeAttributeModifiers(entity, attributeMap, amplifier);
		KillEntityProcedure.execute(entity.level, entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
