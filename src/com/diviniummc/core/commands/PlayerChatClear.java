package com.diviniummc.core.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import com.diviniummc.core.plugin.ConfigManager;

public class PlayerChatClear implements CommandExecutor {
	FileConfiguration prefs = ConfigManager.getPrefs();
	int amount = prefs.getInt("ClearAmount");
	
	public boolean onCommand(CommandSender cs, Command cm, String alias, String[] args) {
		if(cs instanceof Player) {
			if(cm.getName().equalsIgnoreCase("pcc") && !(args.length == 0)) {
				for(int i =0; i < amount; i++) {
					cs.sendMessage("");
				}
			}
		}
		return true;
	}
}
