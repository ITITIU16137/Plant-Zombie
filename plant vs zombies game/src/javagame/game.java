package javagame;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class game extends StateBasedGame {
	public static final String gamename = "plantsvszombies";
	public static final int menu = 1;
	public static final int play = 0;
	
	public game(String gamename) {
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
			appgc = new AppGameContainer(new game (gamename));
			appgc.setDisplayMode(640, 360, false);
			appgc.start();
		}catch (SlickException e) {
			e.printStackTrace();
		}
		
	}
}