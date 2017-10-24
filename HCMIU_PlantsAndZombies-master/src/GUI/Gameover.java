package GUI;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
public class Gameover {
	Image gameover;
	private Music music;
	private GameContainer gc;
	public Gameover(int state){
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
	    //what should I put here?
//		Gameover = new Image()
		//Cursor
		this.gc = gc;
		Image cursor = new Image("res/cursor/MangekyouCursor.png");
		gc.setMouseCursor(cursor, 0, 0);
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{

	//what should I put here?

	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{

	//what should I put here?

	}

	public int getID(){
	    return 4;
	}
}
