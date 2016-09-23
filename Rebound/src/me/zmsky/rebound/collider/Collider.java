package me.zmsky.rebound.collider;

import java.util.List;

import me.zmsky.rebound.component.Component;
import me.zmsky.rebound.entity.Entity;
import me.zmsky.rebound.math.Vector2;

public abstract class Collider extends Component{
	/**
	 * Determines the size of this box collider. Any other collider that is inside
	 * these bounds will make any collision call return true.
	 */
	protected Vector2 colliderSize;
	
	/**
	 * Determines the position of this box collider. It is usually fixed to an entity, 
	 * if it has one attached to it.
	 */
	protected Vector2 position;
	
	/**
	 * The list of collision listeners we will be calling whenever a collision occurs.
	 */
	private List<CollisionListener> listeners;
	
	/**
	 * The parent of this collider. This can be null. We can use this to determine
	 * who this collider belongs to, incase it is needed to know.
	 */
	protected Entity parent;
	
	/**
	 * A flag that indicates if Continuous Collision Detection is activated.
	 * This ensures more precise collision detection at the cost of performance.
	 * Should only be enabled for very fast moving objects.
	 */
	protected boolean isCCDActivated;
	
	/**
	 * Adds a new listener to the list of collision listeners.
	 * 
	 * @param listener The new listener to be added.
	 */
	public final void addListener(CollisionListener listener){
		listeners.add(listener);
	}
	
	/**
	 * Removes a listener from the list of collision listeners.
	 * 
	 * @param listener The listener to be removed.
	 */
	public final void removeListener(CollisionListener listener){
		listeners.remove(listener);
	}
	
	/**
	 * Changes the CDD's flag to the determined value, either turning
	 * Continuous Collision Detection off or on.
	 * @param value
	 */
	public final void setCDDEnabled(boolean value){
		isCCDActivated = value;
	}
	
	/**
	 * Returns the list of current listeners attached to this collider.
	 * @return
	 */
	public List<CollisionListener> getListeners(){ return listeners; }
	
	/**
	 * Determines if another collider has collided with this instance.
	 * 
	 * @param other The other collider we will be testing for collisions.
	 * @return If the collider has collided with this instance.
	 */
	public abstract boolean collides(Collider other);
	
	/**
	 * Indicates if Continuous Collision Detection is activated for this collider.
	 * 
	 * @return If the above statement is true.
	 */
	public final boolean isCDDEnabled(){ return isCCDActivated; }
}
