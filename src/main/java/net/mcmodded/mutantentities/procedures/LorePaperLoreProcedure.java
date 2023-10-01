package net.mcmodded.mutantentities.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcmodded.mutantentities.network.MutantEntitiesModVariables;

public class LorePaperLoreProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (Math.random() < 0.4) {
			MutantEntitiesModVariables.MapVariables.get(world).lorepaper = "Project: HostileGone started. Hopefully nothing goes wrong";
			MutantEntitiesModVariables.MapVariables.get(world).syncData(world);
		} else if (Math.random() < 0.3) {
			MutantEntitiesModVariables.MapVariables.get(world).lorepaper = "Project: HostileGone Day 5: the zombies Chemical X was tested on seem to look different";
			MutantEntitiesModVariables.MapVariables.get(world).syncData(world);
		} else {
			MutantEntitiesModVariables.MapVariables.get(world).lorepaper = "Project: HostileGone Day 7: the zombies that were hit with Chemical X seem to be showing increased physical stats and are still quite hostile. More research needed";
			MutantEntitiesModVariables.MapVariables.get(world).syncData(world);
		}
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(Component.literal(MutantEntitiesModVariables.MapVariables.get(world).lorepaper), false);
		(itemstack).shrink(1);
	}
}
