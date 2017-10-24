package Characters;

import org.newdawn.slick.*;

public class Zombies{
	
	protected int hp;
	protected int damage;
	protected int speed=-1;
	public int xPos=500,yPos=90;
	
	public void moving()
	{
		xPos+=speed;
	}
	
	public void attack(Plants plant)
	{
		plant.hp-=this.damage;
	}
	
	public boolean checkShot(Bullet b)
	{
		if(b.xPos==this.xPos)
		{
			return true;
		}
		return false;
	}
}
