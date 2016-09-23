package me.zmsky.rebound.component;

import java.awt.Graphics2D;

public abstract class Component {
	/**
	 * Determines if the component is enabled or not.
	 */
	private boolean isEnabled;
	
	/**
	 * The tag of this component. Components can have tags to distinguish
	 * a component of the same type from another of the same type.
	 */
	private String tag;
	
	/**
	 * Sets a tag for this component. Tags can be used to distinguish a component
	 * of the same type from another of the same type.
	 * 
	 * @param tag
	 */
	public final void setTag(String tag){ this.tag = tag; }
	
	/**
	 * Returns this component's tag.
	 * 
	 * @return The tag of this component.
	 */
	public final String getTag(){ return tag; }
	
	/**
	 * Returns if the component is enabled.
	 * @return
	 */
	public final boolean isEnabled(){ return isEnabled; }
	
	/**
	 * Sets the enabled flag on this component.
	 * @param value The value to set the enabled flag to.
	 */
	public final void setEnabled(boolean value){ isEnabled = value; }
	
	/**
	 * Draws this component.
	 * @param g The current graphical context of this component.
	 */
	public void draw(Graphics2D g){}
	
	/** Updates this component.
	 * @param delta The time between frames.
	 */
	public void update(double delta){}
}
