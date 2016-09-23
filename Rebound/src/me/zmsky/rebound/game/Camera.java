package me.zmsky.rebound.game;

import java.awt.Graphics2D;

import me.zmsky.core.GameBox;
import me.zmsky.rebound.math.Vector2;

public class Camera {
	private float lerp = 0.05f;
	private double scale = 1;
	
	private Vector2 position;
	private Vector2 target;
	
	public Camera(Vector2 init){
		position = init;
	}
	public void update(double delta){
		if(target != null){
			position.x += (((target.x - position.x)) * lerp) * delta;
			position.y += (((target.y - position.y)) * lerp) * delta;
		}
	}
	public boolean isVisible(int x, int y, int width, int height){
		int upperLimitX1 = (int) (position.x - ((GameBox.getWindowWidth()/2) / scale));
		int upperLimitY1 = (int) (position.y - ((GameBox.getWindowHeight()/2) / scale));
		int upperLimitX2 = (int) (upperLimitX1 + (GameBox.getWindowWidth() / scale));
		int upperLimitY2 = (int) (upperLimitY1 + (GameBox.getWindowHeight() / scale));
		
		if((x >= upperLimitX1 || x + width >= upperLimitX1) && (x <= upperLimitX2)){
			if((y >= upperLimitY1 || y + height >= upperLimitY1) && (y <= upperLimitY2)){
				return true;
			}
		}
		
		return false;
	}
	public void Translate(Graphics2D g){
		g.scale(scale, scale);
		g.translate(-(position.x - (GameBox.getWindowWidth()/2)/scale), -(position.y - (GameBox.getWindowHeight()/2)/scale));
	}
	public double getScale(){ return scale; }
	public void setScale(double scale){ this.scale = scale; }
	public void setTarget(Vector2 target){ this.target = target; }
	public Vector2 getTargetPosition(){ return target; }
	public Vector2 getPosition(){ return position; }
}
