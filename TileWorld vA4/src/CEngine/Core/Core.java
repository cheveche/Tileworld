package CEngine.Core;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import CEngine.Controls.KeyManager;
import CEngine.Controls.MouseManager;
import CEngine.Gfx.Display;



public class Core implements Runnable{

//VARIABLES 
	
	//FRAME
		private Display display;
		private int width, height;
		public String title;
		
	
	//RUNNABLE
		//Thread is to separate the games mechanics from the main program 
		private Thread thread;
		//Boolean to check if the game run
		private boolean running = false;
	
	//GRAPHIC
		//Graphic Variables to be imported:
		private BufferStrategy bs;
		private Graphics g;
		
	//CONTROLS
		private KeyManager Keymanager;
		private MouseManager Mousemanager; 
		
	
	//HANDLER
		private Handler handler;
		
		
	
//METHODS	
	public Core(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
		
		
		//control initialize
		Keymanager = new KeyManager();
		Mousemanager = new MouseManager();
				
	}
	
	

	private void init() {
		
		
		//FRAME 
			//Create the Frame
			display = new Display(title, width, height);
			//activate the keylistener within the frame
			display.getFrame().addKeyListener(Keymanager);
			//activate the MouseListener within the frame and Canvas
			display.getFrame().addMouseListener(Mousemanager);
			display.getFrame().addMouseMotionListener(Mousemanager);
			display.getCanvas().addMouseListener(Mousemanager);
			display.getCanvas().addMouseMotionListener(Mousemanager);
		
		//ASSETS
			
			
			
		//HANDLER 
			//handler = new Handler(this);
			
			
		//CAMERA
		

			
		//STATE
		
		
	}
	
	

	
	//UPDATE AND DRAW
	private void tick(){ 
		
		//UPDATE KEYMANAGER
		Keymanager.tick();
		
		//UPDATE STATE STATUS
		
		
		
	}
	
	private void render(){ 
		//BUFFERSTRATEGY
			bs = display.getCanvas().getBufferStrategy(); //a way for the computer how to draw to the screen using a buffer (a hidden screen)
			
			//if there is no bufferstrategy in place (like when the game start) then create one
			if(bs == null) { 
				display.getCanvas().createBufferStrategy(3);
				return;
			}
			
			g = bs.getDrawGraphics(); //paintbrush basically
			
			//Clear before drawing (to refresh)
			g.clearRect(0, 0, width, height);
			
			
				/*-----------------
				*DRAW HERE
				*-----------------
				*/
				
				g.setColor(Color.white);//testcode
				g.fillRect(1,1,100,100);//testcode
				
				
				/*-----------------
				*END DRAW
				*-----------------
				*/
			
			//display the drawing :
			bs.show();
			//Make sure the graphic object are done ok 
			g.dispose();	
							
	}
	
	
	
	public void run() {
		
		//INIT
		init();
		
		
		//FRAME RATE 
		
		//Variable for the Frame Rate
		int fps =60;
		double timePerTick = 1000000000 /fps; //Give the max time before refresh
		double delta =0; // The amount time we have until we call the tick and render
		long now; //Current time of our computer
		long lasttime = System.nanoTime(); //this convert the system time in nanosecond
		
		//FPS counter
		long timer =0; 
		int ticks =0;
		
		
		
		//Gameloop is what make the game work until finish
		while(running) {
			//Bring now 
			now = System.nanoTime();
			//Calculate the time since the last refresh
			delta += (now - lasttime)/timePerTick; 
			timer += now - lasttime;
			lasttime = now;
			
			if(delta >=1) {
			tick();
			render();
			ticks++;
			delta--;
			}
		
			//FPS Counter 
			if(timer >= 1000000000) {
				System.out.println("Ticks and Frames:" + ticks);
				ticks = 0;
				timer = 0; 
			}
			
			
			
		}
		
		
		
	}
	
	
	//STATE
	public synchronized void start() {
		if(running) //check if running is at true to avoid breaking
		return;
		
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop() {
		if(!running)//check if the game is not running
			return;
		
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}
	
	//GETTER AND SETTER 
	//Controls
	//Get the keyboard key 
	public KeyManager getKeyManager() {
		return Keymanager;
	}
	
	//Get the Mouse button/coordonate
	public MouseManager getmouseManager() {
		return Mousemanager;
	}
	
	
	
	//Camera
	
	
	
	
	//Window size
		public int getWidth() {
			return width;
			
		}
		
		public int getHeight(){
			return height;
			
		}
	//Mechanic
		
		
	
	

}
