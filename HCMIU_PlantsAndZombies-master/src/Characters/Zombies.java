package Characters;

import org.newdawn.slick.*;
import java.util.ArrayList;

public class Zombies{
	
	protected int hp;
	protected int damage;
	protected double speed=-0.05;
	public double xPos,yPos;
	
	public Zombies(int x,int y)
	{
		this.xPos=x;
		this.yPos=y;
	}
	
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
	
	public void draw( ArrayList<Image> zom,double i)
	{
		zom.get((int)i).draw((int)this.xPos, (int)this.yPos, zom.get((int)i).getWidth()/3, zom.get((int)i).getHeight()/3);
		//use this code to RESIZE image
	}
}
