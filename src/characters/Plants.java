package characters;

import org.newdawn.slick.SlickException;

public abstract class Plants extends GameObject{
	
	public float speed = (float) 0.6;
	
	public Plants(int x,int y)              {super(x,y);}
	
	public void goRight()
	{
		xPos+=speed;
		if(xPos<850) xPos +=speed;
		else xPos=850;
	}
	public void goLeft()
	{
		xPos -=speed;
		if(xPos>200) xPos -=speed;
		else xPos=200;
	}
	public void goUp()
	{
		yPos -=speed;

		if(yPos>200) yPos -=speed;
		else yPos=200;
	}
	public void goDown()
	{
		yPos +=speed;
		if(yPos<595) yPos +=speed;
		else yPos=595;
	}
	public double getSpeed()                  { return speed; }
	public void setSpeed(int speed)           { this.speed = speed; }
	public abstract void draw();
	public abstract void init() throws SlickException;
}
