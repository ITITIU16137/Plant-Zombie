package GUI;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Gameover extends BasicGameState {
	Music music;
	Sound sound;
	Animation goani = new Animation();
	private GameContainer gc;
	public Gameover(int state){
	}
	
	private Image overwall;
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
		
//		goani.addFrame(new Image ("res/gameover/0.png"), 300);   //animation of gameover 
//		goani.addFrame(new Image("res/gameover/0.5.png"), 300);
		sound = new Sound ("res/gameover/Losing Game.wav");
		overwall = new Image ("res/gameover/gameOver.jpg");
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
		g.drawImage(overwall, 0, 0);
		sound.play();
		g.drawString("PRESS ENTER TO REPLAY", 300, 750);
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
		Input input = gc.getInput();
		if (input.isKeyPressed(Input.KEY_ENTER))
		{
			sbg.enterState(1);
		}
		if (input.isKeyPressed(Input.KEY_ESCAPE))
		{
			System.exit(0);
		}
		
	}

	public int getID(){
	    return 2;
	}
}
