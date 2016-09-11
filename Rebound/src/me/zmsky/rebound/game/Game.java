package me.zmsky.rebound.game;

import java.awt.Graphics2D;

import me.zmsky.core.GameBox;
import me.zmsky.rebound.math.Vector2;

public class Game {
	
	/**
	 * The game board.
	 */
	private Board board;
	
	public Game(){
		board = new Board(new Vector2(GameBox.getWindowWidth()/2, GameBox.getWindowHeight()/2));
	}
	public void Render(Graphics2D g){
		board.Render(g);
	}
	public void Update(double delta){
		
	}
}
