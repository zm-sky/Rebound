package me.zmsky.rebound.game;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import me.zmsky.rebound.math.Vector2;
import me.zmsky.resources.ImageCenter;

public class Board {	
	/**
	 * The position of the board.
	 */
	private Vector2 position;
	
	/**
	 * The size of the board.
	 */
	private Vector2 size;
	
	/**
	 * This is the offset or padding this board has. It is used to
	 * set the position of goal markers. Since the default image of the board
	 * has a 6 pixel thick line before the actual board starts, the marker will be
	 * set 6 pixels inside the board in both x/y axis.
	 */
	private Vector2 padding;
	
	/**
	 * Contains the current goal markers on this board.
	 */
	private List<GoalMarker> goalMarkers;
	
	/**
	 * The board image.
	 */
	private BufferedImage boardImage;
	
	/**
	 * Creates a board instance in the specified position.
	 * @param pos
	 */
	public Board(Vector2 pos){
		boardImage = ImageCenter.getImage("Game Elements.png").getSubimage(0, 160, 650, 340);
		size = new Vector2(boardImage.getWidth(), boardImage.getHeight());
		position = Vector2.sub(pos, new Vector2(boardImage.getWidth()/2, boardImage.getHeight()/2));
		
		padding = new Vector2(6, 6);
		goalMarkers = new ArrayList<GoalMarker>();
		goalMarkers.add(new GoalMarker(this, GoalMarkerType.LEFT_MARKER, GoalMarker.DefaultRed));
		goalMarkers.add(new GoalMarker(this, GoalMarkerType.RIGHT_MARKER, GoalMarker.DefaultBlue));
	}
	public void Render(Graphics2D g){
		g.drawImage(boardImage, (int) position.x, (int) position.y, null);
		
		for(GoalMarker marker : goalMarkers)
			marker.draw(g);
	}
	public Vector2 getCenter(){
		Vector2 center = new Vector2(position);
		center.add(Vector2.div(size, 2));
		
		return center;
	}
	public Vector2 getSize(){ return size; }
	public Vector2 getPadding(){ return padding; }
	public Vector2 getPosition(){ return position; }
}
