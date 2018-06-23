package CEngine.Core;

import CEngine.Controls.KeyManager;
import CEngine.Controls.MouseManager;


public class Handler{

//VARIABLE 
	private Core core;
	
	
	
	
	
//CONSTRUCTOR
	public Handler(Core core) {
		this.core = core;
		
	}
	
	
//GETTER AND SETTER
	
	//Controls
	public KeyManager getKeyManager() {
		return core.getKeyManager();
	}
	
	public MouseManager getMouseManager() {
		return core.getmouseManager();
	}
	
	//Frame size
	public int getWidth() {
		return core.getWidth();
		
	}
	
	public int getHeight() {
		return core.getHeight();
	}
	
	
	//Objects
	//(Auto)Core
	public Core getCore() {
		return core;
	}
	public void setCore(Core core) {
		this.core = core;
	}
	
	
	//Auto(World)
	
	
	


}
