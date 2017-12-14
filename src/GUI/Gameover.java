package GUI;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import tool.Text;
import events.*;

public class Gameover extends BasicGameState {

	private static Sound sound;
	static PlayControl controller  =  new PlayControl();
	public Gameover(int state){
	}
	
	private Image overwall;
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
		
		sound = new Sound ("res/gameover/Losing Game.wav");
		overwall = new Image ("res/gameover/gameOver.jpg");
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
		g.drawImage(overwall, 0, 0);
		sound.play();
//		text.render(200,600, "PRESS ENTER TO REPLAY"+"\n"+"PRESS ESC TO EXIT", Color.white);
		g.setColor(Color.white);
		g.drawString("PRESS ENTER TO REPLAY", 450, 500);
//		g.drawString("SCORE: "+	controller.printZom(), 500, 600);
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
