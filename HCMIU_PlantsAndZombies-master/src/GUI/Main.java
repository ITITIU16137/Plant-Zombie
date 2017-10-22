package GUI;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;


public class Main extends StateBasedGame {
	public static final String gamename = "Plants vs Zombies";
	public static final int menu = 0;
	public static final int play = 1;
	
	public Main(String gamename) {
		super(gamename);
		this.addState(new Menu(menu));
		this.addState(new Play(play));
	}
	
	public void initStatesList(GameContainer gc) throws SlickException {
		
		this.getState(menu).init(gc,this);
		this.getState(play).init(gc,this);
		this.enterState(menu);
	}

	
	public static void main (String[] args)  {
		AppGameContainer appgc;
		try {
			appgc = new AppGameContainer(new Main (gamename));
			appgc.setDisplayMode(1024,768, false);
			appgc.start();  //Draw screen
		}catch (SlickException e) {
			e.printStackTrace();
		}
		
	}
}
