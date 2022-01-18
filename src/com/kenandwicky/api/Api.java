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
import me.kenandwicky.candycrush.Listener.EventListener;
import me.kenandwicky.tetris.Tetris;




public class Api extends JavaPlugin implements Listener {
	private Tetris api1 = (Tetris) Bukkit.getServer().getPluginManager().getPlugin("SingleTetris");
	private CandyCrush api2 = (CandyCrush) Bukkit.getServer().getPluginManager().getPlugin("SingleCandyCrush");
	
	public void onEnable() {
		Bukkit.getServer().getConsoleSender().sendMessage("api is working");
		Bukkit.getServer().getPluginManager().registerEvents(new com.kenandwicky.api.Listener.EventListener(), this);
		//this.getCommand("newgame").setExecutor(new me.kenandwicky.tetris.GameLoop.Execute());
		//this.getCommand("newgame").setExecutor(new me.kenandwicky.candycrush.GameLoop.Execute());
		this.getCommand("newgame").setExecutor(new com.kenandwicky.api.GameLoop.Execute());
	}
	
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		
			
		if(cmd.getName().equalsIgnoreCase("newgame")) {
			sender.sendMessage("i am working");
			
			CandyCrush.isStart = true;
			CandyCrush.game = new Game(CandyCrush.boardclass);
		}

		return true;
	}
	
	
}