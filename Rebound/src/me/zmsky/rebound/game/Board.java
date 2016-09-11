package me.zmsky.rebound.game;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import me.zmsky.rebound.math.Vector2;
import me.zmsky.resources.ImageCenter;

public class Board {
	/**
	 * The board image.
	 */
	private BufferedImage boardImage;
	
	/**
	 * The position of the board.
	 */
	private Vector2 position;
	
	/**
	 * Creates a board instance in the specified position.
	 * @param pos
	 */
	public Board(Vector2 pos){
		boardImage = ImageCenter.getImage("Game Elements.png").getSubimage(0, 160, 650, 340);
		position = Vector2.sub(pos, new Vector2(boardImage.getWidth()/2, boardImage.getHeight()/2));
		
		generateMarkers(new Color(255, 55, 55), Color.BLUE);
	}
	/**
	 * Generates
	 */
	private void generateMarkers(Color leftColor, Color rightColor){
		//Creating temporal variables.
		BufferedImage Marker = new BufferedImage(30, boardImage.getHeight() - 12, BufferedImage.TYPE_INT_ARGB);
		
		BufferedImage top = ImageCenter.getImage("Game Elements.png").getSubimage(683, 163, 30, 27);
		BufferedImage middle = ImageCenter.getImage("Game Elements.png").getSubimage(747, 194, 10, 43);
		BufferedImage bottom = ImageCenter.getImage("Game Elements.png").getSubimage(683, 194, 30, 27);
		
		Graphics2D g = (Graphics2D) Marker.getGraphics();
		
		g.drawImage(top, 0, 0, null);
		g.drawImage(middle, 0, top.getHeight(), middle.getWidth(), Marker.getHeight() - 54, null);
		g.drawImage(bottom, 0, Marker.getHeight() - bottom.getHeight(), null);
		
		g = (Graphics2D) boardImage.getGraphics();
		
		if(leftColor != null)
			Marker = ImageCenter.ChangeImageColor(Marker, 100, Color.WHITE, leftColor);
		
		g.drawImage(Marker, 6, 6, null);
		
		if(rightColor != null)
			Marker = ImageCenter.ChangeImageColor(Marker, 100, leftColor, rightColor);
		
		Marker = ImageCenter.FlipImageHorizontally(Marker);
		g.drawImage(Marker, boardImage.getWidth() - Marker.getWidth() - 6, 6, null);
		
	}
	public void Render(Graphics2D g){
		g.drawImage(boardImage, (int) position.x, (int) position.y, null);
	}
}
