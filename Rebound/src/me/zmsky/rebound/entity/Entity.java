package me.zmsky.rebound.entity;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import me.zmsky.rebound.component.Component;
import me.zmsky.rebound.math.Vector2;

public abstract class Entity {
	/**
	 * Determines the position on the screen of this entity.
	 */
	public Vector2 position = new Vector2(0,0);
	
	/**
	 * The list of components this entity has.
	 */
	private List<Component> components = new ArrayList<>();
	
	/**
	 * Draws the entity and renders components.
	 * 
	 * @param g The current graphical context.
	 */
	public final void draw(Graphics2D g){
		for(Component c : components)
			c.draw(g);
		
		drawEntity(g);
	}
	
	/**
	 * Updates this entity and all currently active components.
	 * 
	 * @param delta The time between frames. Is not constant.
	 */
	public final void update(double delta){
		for(Component c : components)
			c.update(delta);
		
		updateEntity(delta);
	}
	
	/**
	 * Adds a new component to this entity.
	 * @param component
	 */
	public void addComponent(Component component){
		components.add(component);
	}
	
	/**
	 * Removes a component from this entity.
	 * @param component The component to be removed.
	 */
	public void removeComponent(Component component){
		components.remove(component);
	}
	
	/**
	 * Returns the entity tag, unique for all types of entities.
	 * 
	 * @return The type of entity this is.
	 */
	public abstract EntityTag getEntityTag();
	
	/**
	 * Draws this entity on the current graphical context.
	 * @param g The current graphical context.
	 */
	protected abstract void drawEntity(Graphics2D g);
	
	/**
	 * Updates this entity.
	 * @param delta The time between frames.
	 */
	protected abstract void updateEntity(double delta);
}
