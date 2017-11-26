package GUI;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.ini4j.Ini;
import org.ini4j.InvalidFileFormatException;
import java.io.File;
import java.io.IOException;


public class Main extends StateBasedGame {
	public static final String gamename = "Plants vs Zombies";
	public static final String filename = "Engine.ini";
	public static final int menu = 0;
	public static final int play = 1;
	public static final int gameover = 2;
	public static int targetFPS = 60;
  	public static boolean showFPS = true;		  	
  	public static boolean fullScreen = false;
  	//public static final boolean vSync = true;
	public static int HEIGHT=768;
	public static int WIDTH=1024;
	
	public Main(String gamename) {
		super(gamename);
		/*
		 * 	Getting Key names into file to parsing
		 */
		try {
			Ini ini = new Ini(new File(filename));
			WIDTH      = Integer.parseInt	  (ini.get("DISPLAY", "width"	  ));
			HEIGHT     = Integer.parseInt	  (ini.get("DISPLAY", "height"	  ));
			targetFPS  = Integer.parseInt	  (ini.get("DISPLAY", "targetFPS" ));
			showFPS    = Boolean.parseBoolean (ini.get("DISPLAY", "showFPS"	  ));
			fullScreen = Boolean.parseBoolean (ini.get("DISPLAY", "fullScreen"));
		}catch (InvalidFileFormatException e) {
		 		e.printStackTrace();
		} catch (IOException e) {
		 		e.printStackTrace();
		 }
		this.addState(new Menu(menu));
		this.addState(new Play(play));
		this.addState(new Gameover(gameover));
	}
	
	public void initStatesList(GameContainer gc) throws SlickException {
		
		this.getState(menu).init(gc,this);
		this.getState(play).init(gc,this);
		this.getState(gameover);
		this.enterState(menu);                            //Start with menu first
	}

	
	public static void main (String[] args)  {
		AppGameContainer appgc;
		try {
			appgc = new AppGameContainer(new Main (gamename));
			appgc.setDisplayMode(WIDTH,HEIGHT, fullScreen);
			appgc.setTargetFrameRate(targetFPS);
			//appgc.setVSync(vSync);
			appgc.start();                                   //Begin draw screen
		}catch (SlickException e) {
			e.printStackTrace();
		}
		
	}
}
