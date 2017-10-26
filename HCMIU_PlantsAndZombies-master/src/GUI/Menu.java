package GUI;

import org.lwjgl.input.Mouse;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.newdawn.slick.GameContainer;

//import java.util.concurrent.TimeUnit;

public class Menu extends BasicGameState {
	
	protected Music music;
	
	int xpos = Mouse.getX(); //0-1024
	int ypos = Mouse.getY(); //0-768
	Main size;
	Image Start;
	Image Exit;

	private GameContainer gc;
	public Menu (int state) {
		
	}
	
	public void init(GameContainer gc, StateBasedGame sbg ) throws SlickException {
		//Image button 
		Start = new Image("res/Menu/Start.png");
		Exit = new Image("res/Menu/Exit.png"); 
		
		//Music background
		music = new Music("res/Menu/07_The_Dark_Place.ogg");
		music.setVolume(0.8f);
		music.play();
		
		//Cursor
		this.gc = gc;
		Image cursor = new Image("res/cursor/MangekyouCursor.png");
		gc.setMouseCursor(cursor, 0, 0);
		
	}	
	///Draw stuff
	public void render (GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
		
		
		Image Menuwallpaper = new Image ("res/Menu/c.png");
		g.drawImage(Menuwallpaper,0,0);
		
		Start.draw(430,310);
		Exit.draw(430,380);
	}
	public void update (GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
		Input input = gc.getInput();
		xpos = Mouse.getX();
		ypos = size.HEIGHT- Mouse.getY();
		
		///Start button
		if ( (xpos>430 && xpos<570) && (ypos>310 && ypos <360)) {
			if (input.isMouseButtonDown(0)) { 
				music.stop();
				sbg.enterState(1);
			}
		}
		//Exit button
		if ((xpos>445 && xpos<550) && (ypos >380 && ypos <440))
		{
			if ((input.isMouseButtonDown(0))){
				System.exit(0);
			}
		}
				
	}       
	
	///Return menu
	public int getID() {
         return 0;	
	}
}
