package com.kenandwicky.api.tool;

import java.util.Random;

import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class TetrisAttackCandy {
	
	public static void tetrisattackcandy() {
		//20 takes = 1 second
		me.kenandwicky.candycrush.Board.Board.player.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 20 * 30, 2));
		me.kenandwicky.candycrush.Board.Board.player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 20 * 10, 2));
	}
	
}
