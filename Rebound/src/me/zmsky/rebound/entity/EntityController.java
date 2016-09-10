package me.zmsky.rebound.entity;

import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

public class EntityController {
	private Map<Integer, Boolean> keyMap;
	
	public EntityController(int[] bindedKeys){
		keyMap = new HashMap<Integer, Boolean>();
		
		for(int key : bindedKeys){
			keyMap.put(key, false);
		}
	}
	public void KeyPressed(KeyEvent e){
		if(keyMap.containsKey(e.getKeyCode())){
			keyMap.put(e.getKeyCode(), true);
		}
	}
	public void KeyReleased(KeyEvent e){
		if(keyMap.containsKey(e.getKeyCode())){
			keyMap.put(e.getKeyCode(), false);
		}
	}
	public boolean isKeyPressed(int key){
		if(keyMap.containsKey(key)){
			return keyMap.get(key);
		}
		
		return false;
	}
}
