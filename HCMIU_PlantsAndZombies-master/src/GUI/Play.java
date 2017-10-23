package GUI;
import Characters.*;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Play extends BasicGameState
{	
	BulletsControl controller=new BulletsControl();
	Zombies zombie= new Zombies();
	Plants shooter=new Plants();
	Image small,background,bullet;
    
	public Play (int state)
	{
		
	}
	
	
	public void init(GameContainer gc, StateBasedGame sbg ) throws SlickException
	{
		 small = new Image ("res/s.png");
		 background=new Image("res/bgr.png");
		 bullet=new Image("res/bl.png");
	}
	
	public void render (GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
	{
		g.drawImage(background, 0,0);                      //draw background
		g.drawString("this is the game state", 50, 50);
		g.drawImage(small,shooter.xPos,shooter.yPos);      // draw plant shooter
		controller.render(g,bullet);                     // draw bullets
		
		g.setColor(Color.red);
		g.fillRect(zombie.xPos, zombie.yPos, 30, 40);    //draw zombies
		
	}
	public void update (GameContainer gc, StateBasedGame sbg, int delta) throws SlickException
	{
		Input input = gc.getInput();
		
		if (input.isKeyDown(Input.KEY_RIGHT)) 
		{
			shooter.xPos+=shooter.speed;
		}
		else if (input.isKeyDown(Input.KEY_LEFT)) 
		{
			shooter.xPos -=shooter.speed;
		}
		else if (input.isKeyDown(Input.KEY_UP)) 
		{
			shooter.yPos -=shooter.speed;
		}
		else if (input.isKeyDown(Input.KEY_DOWN)) 
		{
			shooter.yPos +=shooter.speed;
		}
		else if(input.isKeyPressed(Input.KEY_SPACE))                         // press space to shoot
		{
			controller.addBullet(new Bullet(shooter.xPos+120,shooter.yPos+25));     // bullets fly from plant position
		}
		
		controller.shoot();
	}
	
	public int getID()
	{
        	return 1;	
	}
}
