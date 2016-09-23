package me.zmsky.rebound.entity;

import me.zmsky.rebound.math.Vector2;

public abstract class RigidEntity extends Entity{
	
	public Vector2 acceleration = new Vector2(0,0);
	public Vector2 velocity = new Vector2(0,0);
	public Vector2 size = new Vector2(0,0);
	public Vector2 friction = new Vector2(0,0);
	
	public Float limitMax;
	public Float limitMin;
	
	private float c = 0.05f;
	private float normal = 1f;
	protected float frictionMag = c*normal;
	
	/**
	 * Updates this rigid entity to enable movement.
	 * 
	 * @param delta The delta time between frames.
	 */
	public void updateEntity(double delta) {		
		friction = new Vector2(velocity.x, velocity.y);
		friction.mult(-1 * frictionMag);
		
		applyForce(friction);
		velocity.add(Vector2.mult(acceleration, (float) delta));
		
		if(limitMax != null)
			velocity.limitMax(limitMax);
		if(limitMin != null)
			velocity.limitMin(limitMin);
		
		position.add(velocity);
		acceleration.mult(0);
	}
	/**
	 * Sets the friction of this rigid entity.
	 * 
	 * @param frictionMag The desired friction to set to.
	 */
	public void setFriction(float frictionMag){ this.frictionMag = frictionMag; }
	
	/**
	 * Sets the max limit of the velocity.
	 * @param limitMax The desired max.
	 */
	public void setLimitMax(float limitMax){ this.limitMax = limitMax; }
	/**
	 * Applies force to this rigid entity.
	 * @param v The desired force to add to.
	 */
	public void applyForce(Vector2 v) { acceleration.add(v); }
	/**
	 * Returns the entity tag of this instance.
	 */
	public EntityTag getEntityTag() { return EntityTag.ENTITY; }
}
