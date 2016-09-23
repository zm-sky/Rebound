package me.zmsky.rebound.game;

import java.awt.Graphics2D;

import me.zmsky.core.GameBox;
import me.zmsky.rebound.collider.BoxCollider;
import me.zmsky.rebound.entity.Ball;
import me.zmsky.rebound.math.Vector2;

public class Game {
	
	/**
	 * The game board.
	 */
	private Board board;
	
	private Ball ball;
	
	public Game(){
		board = new Board(new Vector2(GameBox.getWindowWidth()/2, GameBox.getWindowHeight()/2));
		ball = new Ball(board.getCenter(), new Vector2(20, 20));
	}
	public void Render(Graphics2D g){
		board.draw(g);
		ball.draw(g);
	}
	public void Update(double delta){
		ball.update(delta);
	}
	
//	Color c1 = new Color(0 ,0, 0, 255);
//	Color c2 = new Color(0, 0, 0, 0);
//	float fractions[] = { 0.0f, 1.0f };
//	Point p1 = new Point(650, 0);
//	Point p2 = new Point(830, 0);
//	GradientPaint paint = new GradientPaint(p1, c1, p2, c2);
}
