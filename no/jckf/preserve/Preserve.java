package no.jckf.preserve;

import org.bukkit.entity.Enderman;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityBreakDoorEvent;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Preserve extends JavaPlugin implements Listener {
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this,this);
	}

	public void onDisable() {

	}

	@EventHandler
	public void onExplode(EntityExplodeEvent event) {
		if (event.getEntity() instanceof LivingEntity) {
			event.blockList().clear();
		}
	}

	@EventHandler
	public void onYoink(EntityChangeBlockEvent event) {
		if (event.getEntity() instanceof Enderman) {
			event.setCancelled(true);
		}
	}

	@EventHandler
	public void onBreakin(EntityBreakDoorEvent event) {
		if (event.getEntity() instanceof Zombie) {
			event.setCancelled(true);
		}
	}
}
