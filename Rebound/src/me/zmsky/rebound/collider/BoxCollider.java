package me.zmsky.rebound.collider;

import java.awt.Graphics2D;

import me.zmsky.rebound.entity.Entity;
import me.zmsky.rebound.math.Vector2;

public class BoxCollider extends Collider{

	/**
	 * Creates a new BoxCollider. 
	 * 
	 * @param parent The parent entity of this box collider. Can be null.
	 * @param boxSize The size of this box collider.
	 */
	public BoxCollider(Entity parent, Vector2 boxSize){
		this.parent = parent;
		colliderSize = boxSize;
		
	}
	public boolean collides(Collider other){
		if(other instanceof BoxCollider){
			return (Math.abs(position.x - other.position.x) * 2 < (colliderSize.x + other.colliderSize.x)) &&
				   (Math.abs(position.y - other.position.y) * 2 < (colliderSize.y + other.colliderSize.y));
		}
		
		return false;
	}
	@Override
	public void draw(Graphics2D g) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void update(double delta) {
		// TODO Auto-generated method stub
		
	}
}
