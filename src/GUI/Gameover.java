package GUI;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Gameover extends BasicGameState {
	protected Music music;
	Sound sound;
	Animation goani = new Animation();
	private GameContainer gc;
	public Gameover(int state){
	}
	
	private Image overwall;
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
		
		goani.addFrame(new Image ("res/gameover/0.png"), 300);   //animation of gameover 
		goani.addFrame(new Image("res/gameover/0.5.png"), 300);
		sound = new Sound ("res/gameover/Losing Game.wav");
		overwall = new Image ("res/gameover/20.jpg");
		
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
	//g.drawAnimation(goani, 512, 384);
		g.drawImage(overwall, 150, 150);
		/*g.setColor(Color.white);
		g.drawString("PRESS 1 TO PLAY AGAIN", 50 , 50);
		g.setColor(Color.white);
		g.drawString("PRESS 2 TO EXIT", 100, 100);*/
		sound.play();
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
		Input input = gc.getInput();
		if (input.isKeyPressed(Input.KEY_1))
		{
			sbg.enterState(1);
		}
		if (input.isKeyPressed(Input.KEY_2))
		{
			System.exit(0);
		}
		
	}

	public int getID(){
	    return 2;
	}
}
