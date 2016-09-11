
package me.zmsky.rebound.ui;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import me.zmsky.core.GameBox;

/**
 * 
 * @author Raul Karim Sabag Ballesteros
 */
public class Button extends GUI{

	/**
	 * Text inside of the button that will be displayed in its center.
	 */
	private String text;
	
	/**
	 * The padding between the inner text and the
	 * button's boundries.
	 */
	private int padding = 15;
	
	/**
	 * Indicates if the cursor is currently ontop of the button.
	 */
	private boolean isHoveredOn;
	
	/**
	 * Indicates if the text should be shifted to the left when drawing.
	 */
	private boolean shiftTextLeft;
	
	/**
	 * Indicates this button's opacity when being drawn.
	 */
	private float opacity = 1.0f;
	
	/**
	 * Creates a basic button.
	 * 
	 * @param stateID The stateID on which this button belongs to.
	 * @param distinctiveID This button's distinctiveID.
	 * @param text The text that will be rendered in the button's center.
	 */
	public Button(int stateID, String distinctiveID, String text){
		this.text = text;
		this.stateID = stateID;
		this.distinctiveID = distinctiveID;
		
		adjustSize();
	}
	
	/**
	 * Creates a basic button, independent of any sort of parent UI element,
	 * as this sets attributes directly instead of automatically.
	 * 
	 * @param stateID The stateID on which this button belongs to.
	 * @param distinctiveID This button's distinctiveID.
	 * @param text The text that will be rendered in the button's center.
	 * @param x The x coordinate of this button.
	 * @param y The y coordinate of this button.
	 * @param width The width of this button in pixels.
	 * @param height The height of this button in pixels.
	 */
	public Button(int stateID, String distinctiveID, String text, int x, int y, int width, int height){
		this.text = text;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.stateID = stateID;
		this.distinctiveID = distinctiveID;
		
		adjustSize();
	}
	
	/**
	 * Adjusts the button's size incase the text inside is bigger than
	 * the actual button's given width, considering the padding.
	 */
	public void adjustSize(){
		FontMetrics m = (new BufferedImage(1,1, BufferedImage.TYPE_INT_RGB).getGraphics().getFontMetrics(UIFont));
		
		int stringWidth = m.stringWidth(text);
		
		if(stringWidth > width - padding){
			width+= (stringWidth - (width + padding)) + padding*2;
		}
		
		if(m.getHeight() + m.getDescent() > height)
			height = m.getHeight() + m.getDescent();
	}

    /**
     * Draws the button.
     * 
     * @param g The current graphical context.
     */
    public void draw(Graphics2D g) { 
    	g.setComposite(GameBox.getDefaultComposite().derive(opacity));
    	g.setColor(backgroundColor);
    	g.fillRect(x, y, width, height);
    	
    	if(isHoveredOn){
    		g.setColor(highlightColor);
    		g.fillRect(x, y, width, height);
    	}
    	
    	//Drawing text inside the button.
    	g.setComposite(GameBox.getDefaultComposite());
    	g.setColor(highlightColor);
    	g.drawRect(x, y, width, height);
    	
    	g.setColor(Color.WHITE);
    	
    	int textX = (x + width/2) - (g.getFontMetrics().stringWidth(text)/2);
    	int textY = (y + padding) + (height/2 - ((g.getFontMetrics().getHeight() + g.getFontMetrics().getDescent())/2));
    	
    	if(shiftTextLeft)
    		textX = x + padding/2;
    	
    	g.drawString(text, textX , textY);
    }
    
    public void onMouseMove(int button, int x, int y, boolean Drag) { 
    	if(x >= this.x && x <= this.x + width){
    		if(y >= this.y && y <= this.y + height){
        		isHoveredOn = true;
        		
        		return;
        	}
    	}
    	
    	isHoveredOn = false;
    }
    
	/**
	 * Updates the button.
	 */
    public void update() { 
    	if(isHoveredOn)
    		opacity = opacity < 0.9f ? opacity + 0.02f : 1.0f;
    	else
    		opacity = opacity > 0.5f ? opacity - 0.02f : 0.5f;
    }
    public void onMouseClick(int button, int x, int y) {  }
    public void setShiftLeftMode(boolean value){ shiftTextLeft = value; }
}
