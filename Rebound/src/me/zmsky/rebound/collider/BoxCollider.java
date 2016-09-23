package me.zmsky.rebound.collider;

import java.awt.Color;
import java.awt.Graphics2D;

import me.zmsky.rebound.entity.Entity;
import me.zmsky.rebound.math.Vector2;

public class BoxCollider extends Collider{

	/**
	 * Creates a new BoxCollider on the position of the given parent.
	 * The collider will move accordingly to the parent's position.
	 * 
	 * @param parent The parent entity of this box collider. Can be null.
	 * @param boxSize The size of this box collider.
	 */
	public BoxCollider(Entity parent, Vector2 boxSize){
		this.parent = parent;
		colliderSize = boxSize;
		
		position = parent.position;
	}
	
	/**
	 * Creates a new BoxCollider with a parent, on a given position and size.
	 * This will make the collider fixed on this position.
	 * 
	 * @param parent The parent entity of this box collider. Can be null.
	 * @param position The position of this collider.
	 * @param boxSize The size of this box collider.
	 */
	public BoxCollider(Entity parent, Vector2 position, Vector2 boxSize){
		this.parent = parent;
		colliderSize = boxSize;
		
		this.position = position;
	}
	
	/**
	 * Creates a new BoxCollider on a specified position, and no parent. 
	 * 
	 * @param position The position of this box collider.
	 * @param boxSize The size of this box collider.
	 */
	public BoxCollider(Vector2 position, Vector2 boxSize){
		colliderSize = boxSize;
		this.position = position;
	}
	
	/**
	 * Determines if a collider is inside of this one.
	 * 
	 * @param other The collider we will be testing a collision for.
	 * @return If a collision has occured with the specified collider.
	 */
	public boolean collides(Collider other){
		if(other instanceof BoxCollider){
			return (Math.abs(position.x - other.position.x) * 2 < (colliderSize.x + other.colliderSize.x)) &&
				   (Math.abs(position.y - other.position.y) * 2 < (colliderSize.y + other.colliderSize.y));
		}
		
		return false;
	}
	public void draw(Graphics2D g) {
		g.setColor(Color.GREEN);
		g.drawRect((int) position.x, (int) position.y, (int) colliderSize.x, (int) colliderSize.y);
	}
}
