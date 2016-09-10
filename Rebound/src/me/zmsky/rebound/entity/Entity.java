package me.zmsky.rebound.entity;

import java.awt.Graphics2D;

public interface Entity {
	
	public void draw(Graphics2D g);
	public void update(double delta);
	
	public EntityTag getEntityTag();
}
