package com.kenandwicky.api.Listener;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.kenandwicky.tetris.Board.Board;
import me.kenandwicky.tetris.Board.SettingsManager;

public class EventListener implements Listener {
	me.kenandwicky.tetris.Board.SettingsManager settings1 = me.kenandwicky.tetris.Board.SettingsManager.getInstance();
	me.kenandwicky.candycrush.Board.SettingsManager settings2 = me.kenandwicky.candycrush.Board.SettingsManager.getInstance();
	
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerJoing(PlayerJoinEvent e) {
    	
    	if (e.getPlayer().getGameMode() == GameMode.ADVENTURE || 1 == 1) {
    		if(Bukkit.getOnlinePlayers().size() == 1) {
    			me.kenandwicky.tetris.Board.Board.initialize(e.getPlayer(), settings1);
    			me.kenandwicky.tetris.Board.Board.NameUpdate(e.getPlayer().getName());
    		} else {
    			me.kenandwicky.candycrush.Board.Board.initialize(e.getPlayer(), settings2);
    			me.kenandwicky.candycrush.Board.Board.NameUpdate(e.getPlayer().getName());
    		}
    	}
    	
    	
    }

}
