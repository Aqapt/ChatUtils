package com.diviniummc.core.plugin;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import com.diviniummc.core.commands.PlayerChatClear;
import com.diviniummc.listener.PlayerDeathListener;
import com.diviniummc.listener.PlayerJoinHandler;
import com.diviniummc.listener.PlayerLeaveListener;

public class Divinium extends JavaPlugin {
	//instances
	static File messages;
	static File preferences;

	@Override
	public void onEnable() {
		loadPlugin();
	}

	@Override
	public void onDisable() {}

	private void loadPlugin() {
		registerInstances();
		registerCommands();
		loadConfigurations();
	}

	private void registerInstances() {
		Bukkit.getServer().getPluginManager().registerEvents(new PlayerJoinHandler(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new PlayerLeaveListener(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new PlayerDeathListener(), this);
	}

	private void registerCommands() {
		getCommand("pcc").setExecutor(new PlayerChatClear());
	}

	private void loadConfigurations() {
		if(!new File(getDataFolder(), "messages.yml" ).exists()) {
			linkYamls();

			try {
				messages.createNewFile();
				preferences.createNewFile();
			}catch(Exception e) {}
		}else{
			linkYamls();
		}

	}
	
	private void linkYamls() {
		messages = new File(getDataFolder(), "messages.yml");
		preferences = new File(getDataFolder(), "prefs.yml");
	}
}
