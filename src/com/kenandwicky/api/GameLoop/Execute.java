package com.kenandwicky.api.GameLoop;

import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.kenandwicky.api.Api;


public class Execute implements CommandExecutor {
	
	public static int gameLoopID = -1; //gameLoopId return -1 when failed
	public static Loop loop;
	public static boolean isGameGoing = false;
	
	@Override
	public boolean onCommand(CommandSender sender, Command commnd, String label, String[] args) {
		Server server = Bukkit.getServer();
		server.dispatchCommand(server.getConsoleSender(), "tetrisstart");
		server.dispatchCommand(server.getConsoleSender(), "candystart");
		
		if (gameLoopID != -1) {
			Bukkit.getScheduler().cancelTask(gameLoopID);
		}
		
		loop = new Loop();
		
		gameLoopID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Api.plugin,
							loop,
							0, 5);	

		
		return true;
	}

}
