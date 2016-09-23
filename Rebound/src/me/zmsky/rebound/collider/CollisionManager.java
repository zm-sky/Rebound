package me.zmsky.rebound.collider;

import java.util.ArrayList;
import java.util.List;

public class CollisionManager {
	private List<Collider> colliders;
	
	private static CollisionManager manager;
	
	/**
	 * Only purpose of this is to defeat instantiation, and forcing a call
	 * on getInstance();
	 */
	protected CollisionManager(){
		colliders = new ArrayList<>();
	}
	
	/**
	 * Gets an instance of a CollisionManager, which will be used to determine
	 * which colliders can interact with who. The purpose this class follows the Singleton
	 * pattern, is because in a world, all colliders should theorically be able to interact with
	 * each other. It would make no sense to have various collision managers since it would practically
	 * be grouping colliders in different sorts of groups, which cant interact with anything else outside
	 * of that certain group.
	 * 
	 * @return An instance of a CollisionManager.
	 */
	public static CollisionManager getInstance(){
		if(manager == null)
			manager = new CollisionManager();
		
		return manager;
	}
	
	/**
	 * Adds a new collider to this collision manager, which
	 * will be used to determine which colliders it can interact with.
	 * 
	 * @param c The collider that is part of the game world.
	 */
	public void registerCollider(Collider c){
		synchronized(colliders){
			colliders.add(c);
		}
	}
	
	/**
	 * Removes a collider from the list of active colliders.
	 * 
	 * @param c The collider that is part of the game world.
	 */
	public void removeCollider(Collider c){
		synchronized(colliders){
			colliders.remove(c);
		}
	}
	
	/**
	 * Returns the list of registered colliders in the game world.
	 * 
	 * @return The list of colliders currently in the game world.
	 */
	public List<Collider> getRegisteredColliders(){
		return colliders;
	}
}
