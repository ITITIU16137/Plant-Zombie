package GUI;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Play extends BasicGameState {
	
	Image small;
	int smallX=200;
	int smallY=200;
    
	
	public Play (int state) {
		
	}
	
	
	public void init(GameContainer gc, StateBasedGame sbg ) throws SlickException {
		 small = new Image ("res/f.png");
	}
	
	public void render (GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
		//g.drawString("this is the game state", 50, 50);
		g.drawImage(small,smallX,smallY);
		
	}
	public void update (GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
		Input input = gc.getInput();
		if (input.isKeyDown(Input.KEY_RIGHT)) {smallX +=1;}
		if (input.isKeyDown(Input.KEY_LEFT)) {smallX -=1;}
		if (input.isKeyDown(Input.KEY_UP)) {smallY -=1;}
		if (input.isKeyDown(Input.KEY_DOWN)) {smallY +=1;}
	}
	public int getID() {
         return 1;	
	}
}
