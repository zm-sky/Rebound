package me.zmsky.rebound.entity;

import java.awt.Color;
import java.awt.Graphics2D;

import me.zmsky.rebound.collider.BoxCollider;
import me.zmsky.rebound.math.Vector2;

public class Ball extends RigidEntity{
	
	/**
	 * Our ball is going to be square, so we'll declare a box collider to detect collisions.
	 * Collisions arent checked here however, the job can be done by a CollisionManager.
	 */
	private BoxCollider collider;
	
	/**
	 * Creates a new ball at the desired position and size.
	 * 
	 * @param initPosition The initial position of this ball.
	 * @param ballSize The size of this ball.
	 */
	public Ball(Vector2 initPosition, Vector2 ballSize){
		initPosition = Vector2.sub(initPosition, Vector2.div(ballSize, 2));
		position = initPosition;
		size = ballSize;
		
		//Since the ball can move pretty fast, it could tunnel through other colliders.
		//We are going to be continuously checking for collision on this collider.
		collider = new BoxCollider(this, ballSize);
		collider.setCDDEnabled(true);
		
		//Setting physics properties for the ball.
		//We dont want friction to affect it.
		setFriction(0);
		acceleration = new Vector2(1, 0);
		
		//We are adding this to the component array so if an outsider wants to know if
		//this class has a certain component, we can manage it by calling the list of active components
		//in the super class.
		addComponent(collider);
	}
	public void updateEntity(double delta) {
		//We call the super class so all physics related things are updated, since
		//we are overriding the method it uses to do this.
		super.updateEntity(delta);
		
		//Ball logic goes here.
	}
	public void drawEntity(Graphics2D g) {
		g.setColor(Color.RED);
		g.fillRect((int) position.x, (int) position.y, (int) size.x, (int) size.y);
	}
}
