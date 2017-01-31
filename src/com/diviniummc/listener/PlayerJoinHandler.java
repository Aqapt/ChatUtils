package com.diviniummc.listener;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.diviniummc.core.plugin.ConfigManager;

public class PlayerJoinHandler implements Listener {
	FileConfiguration prefs = ConfigManager.getPrefs();

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		if(e.getJoinMessage().equalsIgnoreCase(prefs.getString("JoinMsg"))) {
			e.setJoinMessage(prefs.getString("JoinMsg"));
		}
	}
}
