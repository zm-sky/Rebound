package me.zmsky.rebound.game;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import me.zmsky.rebound.collider.BoxCollider;
import me.zmsky.rebound.collider.Collider;
import me.zmsky.rebound.entity.Entity;
import me.zmsky.rebound.entity.EntityTag;
import me.zmsky.rebound.math.Vector2;
import me.zmsky.resources.ImageCenter;

public class Board extends Entity{	
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
	 * Contains a list of colliders that make up its boundries.
	 */
	private List<Collider> boardBoundries;
	
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
		
		createBoundries();
		createGoalMarkers();
	}
	protected void drawEntity(Graphics2D g){
		g.drawImage(boardImage, (int) position.x, (int) position.y, null);
		
		for(GoalMarker marker : goalMarkers)
			marker.draw(g);
		
		for(Collider c : boardBoundries)
			c.draw(g);
	}
	public Vector2 getCenter(){
		Vector2 center = new Vector2(position);
		center.add(Vector2.div(size, 2));
		
		return center;
	}
	private void createBoundries(){
		boardBoundries = new ArrayList<>();
		
		//Creating boundry vectors and position.		
		Vector2 topSize = new Vector2(size.x, 20);
		Vector2 bottomSize = new Vector2(topSize);
		Vector2 leftSize = new Vector2(20, size.y);
		Vector2 rightSize = new Vector2(leftSize);
		
		Vector2 topPosition = new Vector2(position.x, position.y - topSize.y);
		Vector2 bottomPosition = new Vector2(position.x, position.y + size.y);
		Vector2 leftPosition = new Vector2(position.x - leftSize.x, position.y);
		Vector2 rightPosition = new Vector2(position.x + size.x, position.y);
		
		//Creating colliders.
		BoxCollider topBoundry = new BoxCollider(this, topPosition, topSize);
		BoxCollider bottomBoundry = new BoxCollider(this, bottomPosition, bottomSize);
		BoxCollider leftBoundry = new BoxCollider(this, leftPosition, leftSize);
		BoxCollider rightBoundry = new BoxCollider(this, rightPosition, rightSize);
		
		//Adding colliders to the list of boundries.
		boardBoundries.add(topBoundry);
		boardBoundries.add(bottomBoundry);
		boardBoundries.add(leftBoundry);
		boardBoundries.add(rightBoundry);
	}
	private void createGoalMarkers(){
		goalMarkers = new ArrayList<>();
		goalMarkers.add(new GoalMarker(this, GoalMarkerType.LEFT_MARKER, GoalMarker.DefaultRed));
		goalMarkers.add(new GoalMarker(this, GoalMarkerType.RIGHT_MARKER, GoalMarker.DefaultBlue));
	}
	public Vector2 getSize(){ return size; }
	public Vector2 getPadding(){ return padding; }
	public EntityTag getEntityTag() { return null; }
	public void updateEntity(double delta) {}
}
