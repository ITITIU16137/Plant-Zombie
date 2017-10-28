package GUI;

import org.lwjgl.input.Mouse;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import Characters.Zombies;

import org.newdawn.slick.GameContainer;

//import java.util.concurrent.TimeUnit;

public class Menu extends BasicGameState {
	
	protected Music music;
	Sound sound;
	
	int xpos = Mouse.getX(); //0-1024
	int ypos = Mouse.getY(); //0-768
	Main size;
	Image Logo;
	Image Start;
	Image Exit;
	private int delayTime=0;                                // this is for
	private int delay=(80);
	
	private GameContainer gc;
	public Menu (int state) {
		
	}
	
	public void init(GameContainer gc, StateBasedGame sbg ) throws SlickException {
		//Logo
		Logo = new Image("res/logo.png");
		//Image button 
		Start = new Image("res/Menu/Start.png");
		Exit = new Image("res/Menu/Exit.png"); 
		
		//Music background
		music = new Music("res/Menu/07_The_Dark_Place.ogg");
		music.setVolume(0.5f);
		music.loop();
		//Click sound
		sound = new Sound("res/Menu/click.wav");
		//Cursor
		this.gc = gc;
		Image cursor = new Image("res/cursor/MangekyouCursor.png");
		gc.setMouseCursor(cursor, 0, 0);
		gc.setTargetFrameRate(15);
		
		
	}	
	///Draw stuff
	public void render (GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
		
		Image[] Background = new Image[102];
		String fileLocation = new String();
		for (int i = 1; i < 102; i++)
		    {
		        fileLocation = "res/background/back ("+i+").png";
		        Background [i] = new Image(fileLocation);
		    }
		int i = 1;
		for(i = 1; i < 102; i++)
	    {
		
			this.delayTime+=1;                                                             
			if(this.delayTime==delay)                                                         			{                        							
				 	
				g.drawImage(Background[i],0,0);	
				delay=(102);
				this.delayTime=0;
				if (i == 101) i = 1;
			}	
	    }
		//Image Menuwallpaper = new Image ("res/Menu/c.png");
		//g.drawImage(Menuwallpaper,0,0);
		Logo.draw(280, 50);
		Start.draw(430,350);
		Exit.draw(430,450);
	}
	public void update (GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
		
		Input input = gc.getInput();
		xpos = Mouse.getX();
		ypos = size.HEIGHT- Mouse.getY();
		
		///Start button
		if ( (xpos>430 && xpos<570) && (ypos>350 && ypos <400)) {
			if (input.isMouseButtonDown(0)) { 
				gc.setTargetFrameRate(999);
				sound.play();
				music.stop();
				sbg.enterState(1);
			}
		}
		//Exit button
		if ((xpos>445 && xpos<550) && (ypos >450 && ypos <510))
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
