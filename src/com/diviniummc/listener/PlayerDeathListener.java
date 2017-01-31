package com.diviniummc.listener;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import com.diviniummc.core.plugin.ConfigManager;

public class PlayerDeathListener implements Listener {
	FileConfiguration prefs = ConfigManager.getPrefs();
	
	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent e) {
		if(e.getEntity() instanceof Player) {
			if(!e.getDeathMessage().equalsIgnoreCase(prefs.getString("DeathMsg"))) {
				e.setDeathMessage(prefs.getString("DeathMsg"));
			}
		}
	}

}
