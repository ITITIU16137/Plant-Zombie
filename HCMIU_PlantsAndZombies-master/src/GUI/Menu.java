package GUI;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import java.util.concurrent.TimeUnit;

public class Menu extends BasicGameState {
	
	private Music music;
	
	int xpos = Mouse.getX(); //0-1024
	int ypos = Mouse.getY(); //0-768
	Main size;
	Image Start;
	Image Exit;
	public Menu (int state) {
		
	}
	public void init(GameContainer gc, StateBasedGame sbg ) throws SlickException {
		 
		Start = new Image("res/Start.png");
		Exit = new Image("res/Exit.png");
		music = new Music("sound/03-choose-your-seeds.ogg");
		music.setVolume(0.5f);
		music.loop();
		
		
		
	}	
	///Draw stuff
	public void render (GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
		
		Image Menuwallpaper = new Image ("res/c.png");
		g.drawImage(Menuwallpaper,0,0);
		Start.draw(430,310);
		Exit.draw(430,380);
	}
	public void update (GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
		Input input = gc.getInput();
		xpos = Mouse.getX();
		ypos = size.HEIGHT- Mouse.getY();
		//mouse = "Mouse position x: " +xpos + "y: " +ypos;
		///Start button
		if ( (xpos>430 && xpos<570) && (ypos>310 && ypos <360)) {
			if (input.isMouseButtonDown(0)) { 
				music.stop();
				sbg.enterState(1);
			}
		}
		//Exit button
		if ((xpos>=430 && xpos<500) && (ypos >=380 && ypos <430)){
			if ((input.isMouseButtonDown(0))){
				/*try        
				{
				    Thread.sleep(1000);
				} 
				catch(InterruptedException ex) 
				{
				    Thread.currentThread().interrupt();
				}*/
				System.exit(0);
			}
		}
				
	}       
	
	///Return menu
	public int getID() {
         return 0;	
	}
}
