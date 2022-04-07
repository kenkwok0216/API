package com.kenandwicky.api.GameLoop;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import com.kenandwicky.api.tool.AttackVariable;
import com.kenandwicky.api.tool.CandyAttackTetris;
import com.kenandwicky.api.tool.TetrisAttackCandy;



public class Loop implements Runnable {
		
	@Override
	public void run() {
		// if it can move down then move down if not "gamenext"
		int tetris_score = me.kenandwicky.tetris.Board.Board.Getplayerscore();
		int candy_score = me.kenandwicky.candycrush.Board.Board.score;
		
		if(me.kenandwicky.tetris.Tetris.isStart == false && me.kenandwicky.candycrush.CandyCrush.isStart == true) {
			Bukkit.getScheduler().cancelTask(Execute.gameLoopID); //stop this tasks
			me.kenandwicky.candycrush.CandyCrush.isStart = false; //stop candycrush tasks
			if(tetris_score > candy_score) {
				me.kenandwicky.tetris.Board.Board.player.sendTitle(ChatColor.AQUA + "You Win", ChatColor.YELLOW + "Your Score is " + tetris_score, 10, 100, 10);
				me.kenandwicky.candycrush.Board.Board.player.sendTitle(ChatColor.RED + "You Loss", ChatColor.YELLOW + "Your Score is " + candy_score, 10, 100, 10);
			} else if (tetris_score < candy_score) {
				me.kenandwicky.tetris.Board.Board.player.sendTitle(ChatColor.RED + "You Loss", ChatColor.YELLOW + "Your Score is " + tetris_score, 10, 100, 10);
				me.kenandwicky.candycrush.Board.Board.player.sendTitle(ChatColor.AQUA + "You Win", ChatColor.YELLOW + "Your Score is " + candy_score, 10, 100, 10);
			} else {
				me.kenandwicky.tetris.Board.Board.player.sendTitle(ChatColor.AQUA + "DRAW", ChatColor.YELLOW + "Your Score is " + tetris_score, 10, 100, 10);
				me.kenandwicky.candycrush.Board.Board.player.sendTitle(ChatColor.AQUA + "DRAW", ChatColor.YELLOW + "Your Score is " + candy_score, 10, 100, 10);
			}
		} else if(tetris_score >= 10000 && candy_score < 10000) {
			Bukkit.getScheduler().cancelTask(Execute.gameLoopID); //stop this tasks
			me.kenandwicky.candycrush.CandyCrush.isStart = false; //stop candycrush tasks
			me.kenandwicky.tetris.Board.Board.player.sendTitle(ChatColor.AQUA + "You Win", ChatColor.YELLOW + "Your Score is " + tetris_score, 10, 100, 10);
			me.kenandwicky.candycrush.Board.Board.player.sendTitle(ChatColor.RED + "You Loss", ChatColor.YELLOW + "Your Score is " + candy_score, 10, 100, 10);
		} else if(tetris_score < 10000 && candy_score >= 10000) {
			Bukkit.getScheduler().cancelTask(Execute.gameLoopID); //stop this tasks
			me.kenandwicky.candycrush.CandyCrush.isStart = false; //stop candycrush tasks
			me.kenandwicky.tetris.Board.Board.player.sendTitle(ChatColor.RED + "You Loss", ChatColor.YELLOW + "Your Score is " + tetris_score, 10, 100, 10);
			me.kenandwicky.candycrush.Board.Board.player.sendTitle(ChatColor.AQUA + "You Win", ChatColor.YELLOW + "Your Score is " + candy_score, 10, 100, 10);
		} else if(tetris_score >= 10000 && candy_score >= 10000){
			if(tetris_score > candy_score) {
				me.kenandwicky.tetris.Board.Board.player.sendTitle(ChatColor.AQUA + "You Win", ChatColor.YELLOW + "Your Score is " + tetris_score, 10, 100, 10);
				me.kenandwicky.candycrush.Board.Board.player.sendTitle(ChatColor.RED + "You Loss", ChatColor.YELLOW + "Your Score is " + candy_score, 10, 100, 10);
			} else if (tetris_score < candy_score) {
				me.kenandwicky.tetris.Board.Board.player.sendTitle(ChatColor.RED + "You Loss", ChatColor.YELLOW + "Your Score is " + tetris_score, 10, 100, 10);
				me.kenandwicky.candycrush.Board.Board.player.sendTitle(ChatColor.AQUA + "You Win", ChatColor.YELLOW + "Your Score is " + candy_score, 10, 100, 10);
			} else {
				me.kenandwicky.tetris.Board.Board.player.sendTitle(ChatColor.AQUA + "DRAW", ChatColor.YELLOW + "Your Score is " + tetris_score, 10, 100, 10);
				me.kenandwicky.candycrush.Board.Board.player.sendTitle(ChatColor.AQUA + "DRAW", ChatColor.YELLOW + "Your Score is " + candy_score, 10, 100, 10);
			}
		} else {
			//nothing happen
		}
		
		
		if(me.kenandwicky.tetris.Board.Board.GetPlayerline() - AttackVariable.tetrisattack >= 2) {
			//Tetris attack Candy
			AttackVariable.tetrisattack = me.kenandwicky.tetris.Board.Board.GetPlayerline();
			TetrisAttackCandy.tetrisattackcandy();
		}
		if (me.kenandwicky.candycrush.Board.Board.match - AttackVariable.candyattack >= 200) {
			//Candy attack Tetris
			AttackVariable.candyattack = me.kenandwicky.candycrush.Board.Board.match;
			CandyAttackTetris.candyattacktetris();
		}
		
	}	

}
