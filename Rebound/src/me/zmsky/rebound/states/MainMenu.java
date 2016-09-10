package me.zmsky.rebound.states;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseWheelEvent;

import me.zmsky.core.states.GameState;

public class MainMenu implements GameState{
	public void onMouseMove(int button, int x, int y, boolean Drag) { }
	public void onMouseWheelMove(MouseWheelEvent e) {}
	public void onKeyPressed(KeyEvent e) {  }
	public void onKeyReleased(KeyEvent e) { }
	public void onMouseClick(int button, int x, int y) {  }
	public void onMouseRelease(int button, int x, int y) { }
	public void RenderGui(Graphics2D g) {}
	public void Render(Graphics2D g) {  }
	public void Update(double delta) { }
	public void EnterState() {}
	public void LeftState() {}
	public void GameClosing() {}
	public Enum<?> getStateID() { return GameStates.MAINMENU; }
}
