package com.kenandwicky.api;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import me.kenandwicky.candycrush.CandyCrush;
import me.kenandwicky.candycrush.Board.Board;
import me.kenandwicky.candycrush.GameLoop.Game;
import me.kenandwicky.tetris.Tetris;
import me.kenandwicky.tetris.GameLoop.Execute;




public class Api extends JavaPlugin implements Listener {
	private Tetris api1 = (Tetris) Bukkit.getServer().getPluginManager().getPlugin("SingleTetris");
	
	
	public void onEnable() {
		Bukkit.getServer().getConsoleSender().sendMessage("api is working");
		this.getCommand("newgame").setExecutor(new me.kenandwicky.tetris.GameLoop.Execute());
	}
	
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		
			
		if(cmd.getName().equalsIgnoreCase("newgame")) {
			CandyCrush.isStart = true;
			CandyCrush.game = new Game(CandyCrush.boardclass);
		}

		return true;
	}
	
	
}
