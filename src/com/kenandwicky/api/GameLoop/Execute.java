package com.kenandwicky.api.GameLoop;

import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;


public class Execute implements CommandExecutor {
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command commnd, String label, String[] args) {
		Server server = Bukkit.getServer();
		server.dispatchCommand(server.getConsoleSender(), "tetrisstart");
		server.dispatchCommand(server.getConsoleSender(), "candystart");
		
		
		
		
		return true;
	}

}
