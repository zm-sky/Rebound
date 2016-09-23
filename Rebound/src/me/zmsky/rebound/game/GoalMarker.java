package me.zmsky.rebound.game;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import me.zmsky.rebound.entity.Entity;
import me.zmsky.rebound.entity.EntityTag;
import me.zmsky.rebound.math.Vector2;
import me.zmsky.resources.ImageCenter;

public class GoalMarker extends Entity{
	
	/**
	 * The color of this goal marker.
	 */
	private Color markerColor;
	
	/**
	 * The marker type defines if the marker is going to be facing
	 * up, down left or right.
	 */
	private GoalMarkerType markerType;
	
	/**
	 * The size of this goal marker.
	 */
	private Vector2 markerSize;
	
	/**
	 * The current position of this marker.
	 */
	private Vector2 position;
	
	/**
	 * This will be the generated image of the goal marker, which will be
	 * drawn on screen.
	 */
	private BufferedImage markerImage;
	
	/**
	 * These colors are the default marker colors. 
	 */
	public static final Color DefaultRed = new Color(255, 55, 55);
	public static final Color DefaultBlue = new Color(55, 55, 255);
	
	/**
	 * Creates a goal marker with the specified position and color.
	 * 
	 * @param type
	 * @param markerColor
	 */
	public GoalMarker(Board board, GoalMarkerType markerType, Color markerColor){
		this.markerColor = markerColor;
		this.markerType = markerType;
		
		generateMarkerImage(board);
	}
	private void generateMarkerImage(Board board){
		//The actual image of the marker we will draw on.
		BufferedImage Marker = new BufferedImage(30, (int) board.getSize().y - 12, BufferedImage.TYPE_INT_ARGB);
		//The end sides of the marker and the middle part of it.
		BufferedImage firstSide = null, middle = null, lastSide = null;
		
		//This is so we can paint on our marker image.
		Graphics2D g = (Graphics2D) Marker.getGraphics();
		
		//The position this marker will be at on the board.
		float markerX = 0, markerY = 0;
		
		//Here we're getting the marker's individual parts.
		firstSide = ImageCenter.getImage("Game Elements.png").getSubimage(787, 161, 30, 27);
		middle = ImageCenter.getImage("Game Elements.png").getSubimage(787, 190, 10, 43);
		lastSide = ImageCenter.FlipImageVertically(firstSide);
		
		//Here we're drawing each part in position.
		g.drawImage(firstSide, 0, 0, null);
		g.drawImage(middle, 0, firstSide.getHeight(), middle.getWidth(), Marker.getHeight() - 54, null);
		g.drawImage(lastSide, 0, Marker.getHeight() - lastSide.getHeight(), null);
		
		g.dispose();
		
		//Depending what type of marker we'll be generating, we'll be flipping the marker image to match
		//sides.
		if(markerType == GoalMarkerType.LEFT_MARKER){
			markerX = board.getPosition().x + board.getPadding().x;
			markerY = board.getPosition().y + board.getPadding().y;
		}
		else if(markerType == GoalMarkerType.RIGHT_MARKER){
			markerX = board.getPosition().x + board.getSize().x - board.getPadding().x - Marker.getWidth();
			markerY = board.getPosition().y + board.getPadding().y;
			
			Marker = ImageCenter.FlipImageHorizontally(Marker);
		}
		
		Marker = ImageCenter.ChangeImageColor(Marker, 100, Color.WHITE, markerColor);
		markerImage = Marker;
		
		markerSize = new Vector2(Marker.getWidth(), Marker.getHeight());
		position = new Vector2(markerX, markerY);
	}
	@Override
	public void drawEntity(Graphics2D g) {
		g.drawImage(markerImage, (int) position.x, (int) position.y, null);
	}
	@Override
	public void updateEntity(double delta) {
		
	}
	@Override
	public EntityTag getEntityTag() { return EntityTag.GOALMARKER; }
}
