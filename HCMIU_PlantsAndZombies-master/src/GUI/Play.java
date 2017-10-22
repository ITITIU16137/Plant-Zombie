package GUI;
import Characters.*;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Play extends BasicGameState
{	
	BulletsControl controller=new BulletsControl();
	Zombies zombie= new Zombies();
	Plants shooter=new Plants();
	Image small;
    
	public Play (int state)
	{
		
	}
	
	
	public void init(GameContainer gc, StateBasedGame sbg ) throws SlickException
	{
		 small = new Image ("res/f.png");
	}
	
	public void render (GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
	{
		//g.drawString("this is the game state", 50, 50);
		
		controller.render(g);                     // draw bullets
		
		g.setColor(Color.red);
		g.fillRect(zombie.xPos, zombie.yPos, 30, 40);    //draw zombies
		
		g.drawImage(small,shooter.xPos,shooter.yPos);      // draw plant shooter
		
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
			controller.addBullet(new Bullet(shooter.xPos,shooter.yPos));     // bullets fly from plant position
		}
		
		controller.shoot();
	}
	
	public int getID()
	{
        	return 1;	
	}
}
