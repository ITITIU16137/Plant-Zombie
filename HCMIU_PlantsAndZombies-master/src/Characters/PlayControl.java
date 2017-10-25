package Characters;

import GUI.*;
import Characters.*;

import org.newdawn.slick.*;
import java.util.ArrayList;

public class PlayControl {
	private ArrayList<Bullet> bullets=new ArrayList<>();
	Bullet tempBullet;
	private ArrayList<Zombies> zombies=new ArrayList<>();
	Zombies tempZombie;
	private ArrayList<Sun> sun=new ArrayList<>();
	Sun tempSun;
	Main screen;

	public void shoot()                        
	{
		for(int i=0;i<bullets.size();i++)             //shoot all the bullets in the list
		{
			tempBullet=bullets.get(i);
			tempBullet.flying();
			
			if(tempBullet.xPos>screen.WIDTH)       // remove bullets out of screen
			{
				bullets.remove(tempBullet);
			}
		}
	}
	
	public void render(Graphics g,Image png)              // draw bullets
	{
		
		for(int i=0;i<bullets.size();i++)
		{
			tempBullet=bullets.get(i);
			tempBullet.draw(g,png);
			//tempBullet.dr
		}
	}
	
	public void addBullet(Bullet b)
	{
		bullets.add(b);
	}
	
	public void removeBullet(Bullet b)
	{
		bullets.remove(b);
	}
	
	
	
	public void zomWalk()
	{
		for(int i=0;i<zombies.size();i++)             //shoot all the bullets in the list
		{
			tempZombie=zombies.get(i);
			tempZombie.moving();
			
			if(tempZombie.xPos<0)       // remove bullets out of screen
			{
				bullets.remove(tempZombie);
			}
		}
	}
	
	public void renderZombie(ArrayList<Image> png,double n)              // draw bullets
	{
		
		for(int i=0;i<zombies.size();i++)
		{
			tempZombie=zombies.get(i);
			tempZombie.draw(png,n);
			//tempBullet.dr
		}
	}
	
	public void addZombie(Zombies z)
	{
		zombies.add(z);
	}
	
	public void removeZombie(Zombies z)
	{
		zombies.remove(z);
	}
	

	public void run()                        
	{
		for(int i=0;i<sun.size();i++)             //shoot all the bullets in the list
		{
			tempSun=sun.get(i);
			tempSun.flying();
			
			if(tempSun.xPos>screen.WIDTH)       // remove bullets out of screen
			{
				sun.remove(tempSun);
			}
		}
	}
	
	public void renderSun(Graphics g,Image png)              // draw bullets
	{
		
		for(int i=0;i<sun.size();i++)
		{
			tempSun=sun.get(i);
			tempSun.draw(g,png);
		}
	}
	
	public void addSun(Sun b)
	{
		sun.add(b);
	}
	
	public void removeSun(Sun b)
	{
		sun.remove(b);
	}
	
}


