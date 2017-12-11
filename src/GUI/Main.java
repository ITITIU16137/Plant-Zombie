package GUI;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
public class Main extends StateBasedGame {
	public static final String gamename = "Plants vs Zombies";
	public static final int menu = 0;
	public static final int play = 1;
	public static final int gameover = 2;
	public static int targetFPS = 60;
  	public static boolean showFPS = true;		  	
  	public static boolean fullScreen = false;
	public static int HEIGHT=768;
	public static int WIDTH=1024;
	
	public Main(String gamename) {
		super(gamename);
		this.addState(new Menu(menu));                      //add menu to StateBaseGame
		this.addState(new Play(play));						//add play to StateBaseGame
		this.addState(new Gameover(gameover));				//add gameover to StateBaseGame
	}
	
	public void initStatesList(GameContainer gc) throws SlickException {
		
		this.getState(menu).init(gc,this);
		this.getState(play).init(gc,this);
		this.getState(gameover);
		this.enterState(menu);                              //Start with menu first
	}
	
	public static void main (String[] args)  {
		AppGameContainer appgc;
		try {
			appgc = new AppGameContainer(new Main (gamename));
			appgc.setDisplayMode(WIDTH,HEIGHT, false);       //setDisplay(false == fullScreen)
			appgc.setTargetFrameRate(targetFPS);
			appgc.start();                                   //Begin Game
		}catch (SlickException e) {
			e.printStackTrace();
		}
	}
}
