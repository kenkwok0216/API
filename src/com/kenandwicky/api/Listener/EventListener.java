package com.kenandwicky.api.Listener;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class EventListener implements Listener {
	me.kenandwicky.tetris.Board.SettingsManager settings1 = me.kenandwicky.tetris.Board.SettingsManager.getInstance();
	me.kenandwicky.candycrush.Board.SettingsManager settings2 = me.kenandwicky.candycrush.Board.SettingsManager.getInstance();
	
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerJoing(PlayerJoinEvent e) {
    	
    	if (e.getPlayer().getGameMode() == GameMode.ADVENTURE || 1 == 1) {
    		if(Bukkit.getOnlinePlayers().size() == 1) {
    			return;
    		} else {
    			Player[] player = new Player[2];
    			int i = 0;
    			for(Player all : Bukkit.getServer().getOnlinePlayers()) {
    				player[i] = all;
    				i++;
    			}
    			me.kenandwicky.tetris.Board.Board.initialize(player[0], settings1);
    			me.kenandwicky.tetris.Board.Board.NameUpdate(player[0].getName());
    			me.kenandwicky.candycrush.Board.Board.initialize(player[1], settings2);
    			me.kenandwicky.candycrush.Board.Board.NameUpdate(player[1].getName());
    			
    		}
    	}
    	
    	
    }

}
