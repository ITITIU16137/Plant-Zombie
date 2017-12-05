package Characters;

import org.newdawn.slick.*;
import java.util.ArrayList;

public class Zombies extends GameObject{
	
	protected int hp=100;
	protected int damage;
	protected double speed=-0.09;
	/*
	 * 	Constructor
	 */
	public Zombies(int x,int y)
	{
		super(x,y);
	}
	/*
	 * 	
	 */
	public void moving()
	{
		xPos+=speed;
		
	}
	/*
	 * 	
	 */
	/*public void attack(Peashooter plant)        // have not been used yet
	{
		plant.hp-=this.damage;
	}*/
	/*
	 * 		
	 */
	public boolean checkShot(Bullet b)        // have not been used yet
	{
		if(b.xPos==this.xPos)
		{
			return true;
		}
		return false;
	}
	/*
	 * 		
	 */
	public void draw( ArrayList<Image> zom,double i)
	{
		zom.get((int)i).draw((int)this.xPos, (int)this.yPos, zom.get((int)i).getWidth()/3, zom.get((int)i).getHeight()/3);
		//use this code to RESIZE image
	}
	/*
	 * 	Get-Set method
	 */
	public int getHp()
	{
		return hp;
	}

	public void setHp(int hp) 
	{
		this.hp = hp;
	}

	public int getDamage()
	{
		return damage;
	}

	public void setDamage(int damage)
	{
		this.damage = damage;
	}

	public double getSpeed()
	{
		return speed;
	}

	public void setSpeed(double speed) 
	{
		this.speed = speed;
	}
}
