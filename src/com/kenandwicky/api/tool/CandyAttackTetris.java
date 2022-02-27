package com.kenandwicky.api.tool;

import java.util.Random;
import me.kenandwicky.tetris.Board.Board.*;

import org.bukkit.entity.Player;


public class CandyAttackTetris {

	public static void candyattacktetris() {
		Random rnd = new Random();
		int line = rnd.nextInt(3) + 1;
		AddLine(line);
	}	
	
	
	public static void AddLine(int line) {
		while (line > 0) {
			boolean goon = true;
			for(int i = 0; i < 10; i++) {  //to check to top most line have block or not
				if(me.kenandwicky.tetris.Board.Board.board[i][19] != me.kenandwicky.tetris.Tetromino.TetrominoType.Empty) {
					goon = false;
					line = 0;
				}
			}			
			if(goon == true) {
				for (int i = 0; i < 10; i++) {
					for (int j = 18; j >= 0; j--) {
						me.kenandwicky.tetris.Board.Board.board[i][j + 1] = me.kenandwicky.tetris.Board.Board.board[i][j];
						me.kenandwicky.tetris.Board.Board.setBlock(me.kenandwicky.tetris.Board.Board.GetBoardX() - i, me.kenandwicky.tetris.Board.Board.GetBoardY() + j + 1, me.kenandwicky.tetris.Board.Board.GetBoardZ(), me.kenandwicky.tetris.Board.Board.board[i][j]);	
					}
				}
				Random rnd = new Random();
				int x = rnd.nextInt(10);
				for(int i = 0; i < 10; i++) {
					me.kenandwicky.tetris.Board.Board.board[i][0] = me.kenandwicky.tetris.Tetromino.TetrominoType.G;
					if(i == x) {
						me.kenandwicky.tetris.Board.Board.board[i][0] = me.kenandwicky.tetris.Tetromino.TetrominoType.Empty;
					}
					me.kenandwicky.tetris.Board.Board.setBlock(me.kenandwicky.tetris.Board.Board.GetBoardX() - i, me.kenandwicky.tetris.Board.Board.GetBoardY(), me.kenandwicky.tetris.Board.Board.GetBoardZ(), me.kenandwicky.tetris.Board.Board.board[i][0]);	
				}
			} else {
				for (int i = 0; i < 10; i++) {
					for (int j = 19; j >= 0; j--) {
						me.kenandwicky.tetris.Board.Board.board[i][j + 1] = me.kenandwicky.tetris.Board.Board.board[i][j];
						me.kenandwicky.tetris.Board.Board.setBlock(me.kenandwicky.tetris.Board.Board.GetBoardX() - i, me.kenandwicky.tetris.Board.Board.GetBoardY() + j + 1, me.kenandwicky.tetris.Board.Board.GetBoardZ(), me.kenandwicky.tetris.Board.Board.board[i][j]);	
					}
				}
				Random rnd = new Random();
				int x = rnd.nextInt(10);
				for(int i = 0; i < 10; i++) {
					me.kenandwicky.tetris.Board.Board.board[i][0] = me.kenandwicky.tetris.Tetromino.TetrominoType.G;
					if(i == x) {
						me.kenandwicky.tetris.Board.Board.board[i][0] = me.kenandwicky.tetris.Tetromino.TetrominoType.Empty;
					}
					me.kenandwicky.tetris.Board.Board.setBlock(me.kenandwicky.tetris.Board.Board.GetBoardX() - i, me.kenandwicky.tetris.Board.Board.GetBoardY(), me.kenandwicky.tetris.Board.Board.GetBoardZ(), me.kenandwicky.tetris.Board.Board.board[i][0]);	
				}
			}
			line--;
		}
	}

	
}
