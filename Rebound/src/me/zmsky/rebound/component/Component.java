package me.zmsky.rebound.component;

import java.awt.Graphics2D;

public abstract class Component {
	/**
	 * Determines if the component is enabled or not.
	 */
	private boolean isEnabled;
	
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
	public abstract void draw(Graphics2D g);
	
	/** Updates this component.
	 * @param delta The time between frames.
	 */
	public abstract void update(double delta);
}
