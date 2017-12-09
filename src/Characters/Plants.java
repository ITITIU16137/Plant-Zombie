package Characters;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public abstract class Plants extends GameObject{
	
	public double speed = 0.2;
	protected int hp;
	//protected int damage;
	
	public Plants(int x,int y) 
	{
		super(x,y);
	}
	
	public double getSpeed()                     { return speed; }
	public void setSpeed(int speed)           { this.speed = speed; }
	public int getHp()                        { return hp; }
	public void setHp(int hp)                 { this.hp = hp; }
	
	public abstract void render(Graphics g, Image png);
	
	
	
}
