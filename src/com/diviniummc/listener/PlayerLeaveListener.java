package com.diviniummc.listener;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import com.diviniummc.core.plugin.ConfigManager;

public class PlayerLeaveListener implements Listener {
	FileConfiguration prefs = ConfigManager.getPrefs();
	
	@EventHandler
	public void onPlayerLeave(PlayerQuitEvent e) {
		if(!e.getQuitMessage().equalsIgnoreCase(prefs.getString("LeaveMsg"))) {
			e.setQuitMessage(prefs.getString("LeaveMsg"));
		}
	}
}
