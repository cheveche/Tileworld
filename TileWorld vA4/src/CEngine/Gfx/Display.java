package CEngine.Gfx;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Display {
	private JFrame frame;
	private Canvas canvas;
	
	
	private String title;
	private int width, height;
	
	
	public Display(String title, int width, int height) {
		//This is the Jframe set up. This is because the name of the variables are the same as the class
		this.title = title;
		this.width = width;
		this.height = height;
		
		CreateDisplay();
	}
	

	private void CreateDisplay() {
		frame = new JFrame(title);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		//Canvas 
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		
		//In order for the keyboard listener to work : 
		canvas.setFocusable(false);
		
		frame.add(canvas);
		frame.pack();//Frame.pack resise the windows to addapt to the canvas
		
	}
	
	
	/*To draw stuff the code will need to access Canvas 
	 * Rather the variable can be made public (not recommanded)
	 * or you can create a getter 
	 */
	
	public Canvas getCanvas() {
		return canvas;
	}
	
	
	//As we need to have access to the JFrame for the deplacement of the player, we need to create the method :
	
	public JFrame getFrame() {
		return frame;
	}
}
