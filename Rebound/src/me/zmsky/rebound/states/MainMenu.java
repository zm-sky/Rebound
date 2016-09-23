package me.zmsky.rebound.states;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseWheelEvent;

import me.zmsky.core.GameBox;
import me.zmsky.core.states.GameState;
import me.zmsky.rebound.game.Game;
import me.zmsky.rebound.ui.Button;
import me.zmsky.rebound.ui.UIManager;
import me.zmsky.resources.ImageCenter;

public class MainMenu implements GameState{
	/**
	 * UIManager that will keep in charge of UI events.
	 */
	private UIManager manager;
	/**
	 * This game instance will be rendered in the background as a demo.
	 * Just for esthetic purposes.
	 */
	private Game game;
	
	public MainMenu(){
		initUIElements();
		
		game = new Game();
	}
	private void initUIElements(){
		manager = new UIManager();
		manager.addUIElement(new Button(0,"PlayButton", "Play Game", 0, GameBox.getWindowHeight()/2 - 40, 125, 35));
		manager.addUIElement(new Button(0,"ExitButton", "Quit", 0, manager.getUIElement("PlayButton").getY() + 36, 125, 35));
		
		manager.getUIElement("PlayButton").setBackgroundColor(new Color(72,61,139));
		manager.getUIElement("PlayButton").setHighlightColor(new Color(72,61,139));
	}
	public void Render(Graphics2D g) { 
		manager.renderUI(g); 
		game.Render(g);
	}
	public void onMouseMove(int button, int x, int y, boolean Drag) { manager.onMouseMove(button, x, y, Drag); }
	public void onMouseWheelMove(MouseWheelEvent e) {}
	public void onKeyPressed(KeyEvent e) {  }
	public void onKeyReleased(KeyEvent e) { }
	public void onMouseClick(int button, int x, int y) { manager.onMouseClick(button, x, y); }
	public void onMouseRelease(int button, int x, int y) { }
	public void RenderGui(Graphics2D g) {}
	public void Update(double delta) { manager.update(); game.Update(delta); }
	public void EnterState() {}
	public void LeftState() {}
	public void GameClosing() {}
	public Enum<?> getStateID() { return GameStates.MAINMENU; }
}
