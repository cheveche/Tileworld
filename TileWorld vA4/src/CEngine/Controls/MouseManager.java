package CEngine.Controls;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseManager implements MouseListener, MouseMotionListener{

//VARIABLE
	
	private boolean leftPressed, rightPressed;
	private int mouseX, mouseY; 
	
	
	
//METHOD
	public MouseManager() {
		
		
	}
	
	
//GETTERS
	//Actions
		public boolean isLeftPressed() {
			return leftPressed;
		}
		public boolean isRightPressed() {
			return rightPressed;
		}
	//Coordinate
		public int getMouseX() {
			return mouseX;
		}
		public int getMouseY() {
			return mouseY;
		}
		
	
	
	
	
	
	
	
//MOUSE EVENTS
	
	public void mouseDragged(MouseEvent e) {

		
	}

	
	public void mouseMoved(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
		
	}

	
	public void mouseClicked(MouseEvent e) {

		
	}

	
	public void mouseEntered(MouseEvent e) {
		
		
	}

	
	public void mouseExited(MouseEvent e) {
		
		
	}

	
	public void mousePressed(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1)
			leftPressed = true;
		else if (e.getButton() == MouseEvent.BUTTON3)//Button 2 is middle
			rightPressed = true;
		
	}


	public void mouseReleased(MouseEvent e) {

		
	}

	
	
	
	
}
