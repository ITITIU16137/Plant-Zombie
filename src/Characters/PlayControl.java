package Characters;

import GUI.*;
import Characters.*;

import org.newdawn.slick.*;
import java.util.ArrayList;

public class PlayControl {
	Physic phy =new Physic();
	private ArrayList<Bullet> bullets=new ArrayList<>();
	Bullet tempBullet;
	private ArrayList<Zombies> zombies=new ArrayList<>();
	Zombies tempZombie;
	private ArrayList<Sun> sun=new ArrayList<>();
	Sun tempSun;
	Main screen;
	Physic phy=new Physic();
	
	public void shoot()                        
	{
		for(int i=0;i<bullets.size();i++)             //shoot all the bullets in the list
		{
			tempBullet=bullets.get(i);
			
			if(tempBullet.xPos>screen.WIDTH)       // remove bullets out of screen
			{
				bullets.remove(tempBullet);
			}
			
			if(phy.Collision(tempBullet, zombies))
			{
				bullets.remove(tempBullet);
			}
			tempBullet.flying();
		}
	}
	
	public void renderBullet(Graphics g,Image png)              // draw bullets
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
			
			if(tempZombie.xPos<0 || tempZombie.hp<=0)   //remove bullet and zombies from screen    
			{
				zombies.remove(tempZombie);
			}
			if(phy.Collision(tempZombie, bullets))
			{
				tempZombie.hp-=20;
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
	
}


