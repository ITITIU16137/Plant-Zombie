package GUI;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Menu extends BasicGameState {
	
	int mouseX=200;
	int mouseY=200;
	String mouse  = "Press this to play";
	
	int xpos = Mouse.getX();
	int ypos = Mouse.getY();
	
	
	public Menu (int state) {
		
	}
	public void init(GameContainer gc, StateBasedGame sbg ) throws SlickException {
		 mouse = new String (mouse);
	}
	///Draw stuff
	public void render (GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
		
		Image wallpaper = new Image ("res/c.png");
		g.drawImage(wallpaper,0,0);
		g.drawString(mouse, 200, 200);
	}
	public void update (GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
		Input input = gc.getInput();
		int xpos = Mouse.getX();
		//int ypos = Mouse.getY();
		if (xpos>200 && xpos<400) {
			if (input.isMouseButtonDown(0)) {
				sbg.enterState(0);
			}
		}
        
	}
	///Return menu
	public int getID() {
         return 1;	
	}
}
