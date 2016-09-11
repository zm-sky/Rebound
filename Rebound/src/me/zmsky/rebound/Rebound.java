package me.zmsky.rebound;

import me.zmsky.core.GameBox;
import me.zmsky.rebound.states.GameStates;
import me.zmsky.rebound.states.MainMenu;
import me.zmsky.resources.ImageCenter;

public class Rebound {

	public static final String VERSION = "BETA 1.0";
	
	public static void main(String[] args){
		ImageCenter.setImageCenterDefaultPath("me/zmsky/rebound/resources/");
		GameBox.InitGame("Rebound " + VERSION, 1000, 600);
		
		MainMenu mainmenu = new MainMenu();
		
		GameBox.getStateHandler().registerState(mainmenu);
		GameBox.getStateHandler().enterState(GameStates.MAINMENU);
		
		GameBox.StartGame();
	}
}
