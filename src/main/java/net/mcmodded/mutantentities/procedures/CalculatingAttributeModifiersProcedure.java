package net.mcmodded.mutantentities.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.ItemAttributeModifierEvent;

import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.EquipmentSlot;

import net.mcmodded.mutantentities.init.MutantEntitiesModItems;
import net.mcmodded.mutantentities.init.MutantEntitiesModEnchantments;
import net.mcmodded.mutantentities.configuration.MutantEntitiesConfigFileConfiguration;

import javax.annotation.Nullable;

import java.util.UUID;

@Mod.EventBusSubscriber
public class CalculatingAttributeModifiersProcedure {
	@SubscribeEvent
	public static void addAttributeModifier(ItemAttributeModifierEvent event) {
		execute(event, event.getItemStack());
	}

	public static void execute(ItemStack itemstack) {
		execute(null, itemstack);
	}

	private static void execute(@Nullable Event event, ItemStack itemstack) {
		if (itemstack.getItem() == MutantEntitiesModItems.MUTANT_ZOMBIFIED_PIGLINS_HAMMER.get()) {
			if (event instanceof ItemAttributeModifierEvent _event && _event.getSlotType() == EquipmentSlot.MAINHAND) {
				_event.addModifier(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE,
						(new AttributeModifier(UUID.fromString("fb6db092-ddb7-44fa-be05-15be4440bf49"), "goldenhammerdmg", (double) MutantEntitiesConfigFileConfiguration.GOLDENHAMMERDMG.get(), AttributeModifier.Operation.ADDITION)));
				_event.addModifier(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_SPEED,
						(new AttributeModifier(UUID.fromString("401e18d9-30e4-4b31-9f76-a9388e79e906"), "goldenhammerspd", (double) MutantEntitiesConfigFileConfiguration.GOLDENHAMMERSPD.get(), AttributeModifier.Operation.ADDITION)));
			}
		}
		if (itemstack.getItem() == MutantEntitiesModItems.MUTANT_WITHER_SKELETON_SWORD.get()) {
			if (event instanceof ItemAttributeModifierEvent _event && _event.getSlotType() == EquipmentSlot.MAINHAND) {
				_event.addModifier(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE,
						(new AttributeModifier(UUID.fromString("a14fb917-39e9-4a43-ab62-3be3c3ff76fd"), "withersworddmg", (double) MutantEntitiesConfigFileConfiguration.WITHERSWORDDMG.get(), AttributeModifier.Operation.ADDITION)));
				_event.addModifier(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_SPEED,
						(new AttributeModifier(UUID.fromString("82134986-fc91-4414-8dd0-bea7b7023039"), "witherswordspd", (double) MutantEntitiesConfigFileConfiguration.WITHERSWORDSPD.get(), AttributeModifier.Operation.ADDITION)));
			}
		}
		if (EnchantmentHelper.getItemEnchantmentLevel(MutantEntitiesModEnchantments.CLEAVING.get(), itemstack) != 0) {
			if (event instanceof ItemAttributeModifierEvent _event && _event.getSlotType() == EquipmentSlot.MAINHAND) {
				_event.addModifier(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE, (new AttributeModifier(UUID.fromString("5ef16418-277c-4eeb-8f20-f568be461218"), "cleavingdmg",
						(1.25 + EnchantmentHelper.getItemEnchantmentLevel(MutantEntitiesModEnchantments.CLEAVING.get(), itemstack) * 0.75), AttributeModifier.Operation.ADDITION)));
			}
		}
	}
}
