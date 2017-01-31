package com.diviniummc.core.plugin;

import org.bukkit.configuration.file.YamlConfiguration;

public class ConfigManager {
	
	public static YamlConfiguration getMessages() {
		return YamlConfiguration.loadConfiguration(Divinium.messages);
	}
	
	public static YamlConfiguration getPrefs() {
		return YamlConfiguration.loadConfiguration(Divinium.preferences);
	}
}
