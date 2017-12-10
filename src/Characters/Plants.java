package Characters;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public abstract class Plants extends GameObject{
	
	public float speed = (float) 0.6;
	private int hp;
	
	public Plants(int x,int y) 
	{
		super(x,y);
	}
	
	public float getSpeed()                     { return speed; }
	public void setSpeed(float speed)           { this.speed = speed; }
	public int getHp()                        { return hp; }
	public void setHp(int hp)                 { this.hp = hp; }
	
	public abstract void render(Graphics g, Image png);
	
	
	
}
