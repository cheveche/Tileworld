package CEngine.Controls;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {

//VARIABLES 
	private boolean [] keys;
	
	
	
	
//UPDATE
	public void tick() {
		//List of the keys in use 
			//up =  keys[KeyEvent.VK_W];
	}



	public KeyManager() {
		keys = new boolean [256];
	}
	
	
//KEY METHODS
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}


	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}


	public void keyTyped(KeyEvent e) {

		
	}

	
	
	
}
