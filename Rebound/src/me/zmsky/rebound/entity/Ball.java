package me.zmsky.rebound.entity;

import java.awt.Graphics2D;

import me.zmsky.rebound.math.Vector2;

public class Ball extends RigidEntity{
	
	/**
	 * Empty constructor.
	 */
	public Ball(){
		setFriction(0);
	}
	
	/**
	 * Creates a ball instance with defined position and speed.
	 * 
	 * @param initPosition The initial position of the ball.
	 * @param speed The initial speed of the ball.
	 * @param size The size of the ball.
	 */
	public Ball(Vector2 initPosition, Vector2 speed, Vector2 defaultSize){
		setFriction(0);
		
		position = initPosition;
		acceleration = speed;
		size = defaultSize;
	}
	
	/**
	 * Updates the ball. This method does not keep in charge
	 * of movement. Update() should be called instead of this method,
	 * as Update() automatically calls this method after it ends.
	 * 
	 * @param delta The delta value between frames.
	 */
	public void entityUpdate(double delta){
		
	}
	
	/**
	 * Draws the ball.
	 * 
	 * @param g The current graphical context to draw on.
	 */
	public void draw(Graphics2D g){
		
	}
}
