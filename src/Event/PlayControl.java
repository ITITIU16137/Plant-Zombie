package Event;
import Characters.*;

import GUI.*;
import Characters.*;

import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;

import java.util.ArrayList;

public class PlayControl {
	Physic phy =new Physic();
	
	private ArrayList<Bullet> bullets=new ArrayList<>();
	Bullet tempBullet;
	private ArrayList<Zombies> zombies=new ArrayList<>();
	Zombies tempZombie;
	private ArrayList<Sun> sun=new ArrayList<>();
	Sun tempSun;
	StateBasedGame sbg;
	GameContainer gc;
	Main screen;
	
	//--------------------------------------BULLET---------------------------------------
	public void shoot()                        
	{
		for(int i=0;i<bullets.size();i++)             //shoot all the bullets in the list
		{
			tempBullet=bullets.get(i);
			
			if(tempBullet.xPos>screen.WIDTH)       // remove bullets out of screen
			{
				removeBullet(tempBullet);
			}
			
			if(phy.Collision(tempBullet, zombies))
			{
				removeBullet(tempBullet);
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
	
	
	//--------------------------------------ZOMBIE---------------------------------------
	public void zomWalk()
	{
		for(int i=0;i<zombies.size();i++)  ///shoot all the bullets in the list
		{
			tempZombie=zombies.get(i);
			tempZombie.moving(); 
			//if(tempZombie.xPos<0 || tempZombie.getHp()<=0)
			if(tempZombie.xPos<165 || tempZombie.getHp()<=0)
			{
				removeZombie(tempZombie);
			}
			if(phy.Collision(tempZombie, bullets))
			{
				tempZombie.setHp(tempZombie.getHp()-20);
			}
		}
		//int c=0;
	}
	public void renderZombie(ArrayList<Image> png,double n)
	{
		
		for(int i=0;i<zombies.size();i++)
		{
			tempZombie=zombies.get(i);
			tempZombie.draw(png,n);
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
	
	public boolean gameStatus(){                              //Check GAMEOVER
		if(tempZombie.xPos<165) return false;
		else return true;
	}
	//--------------------------------------SUN---------------------------------------
	
	public void fall()                        
	{
		for(int i=0;i<sun.size();i++)             //shoot all the bullets in the list
		{
			tempSun=sun.get(i);
			tempSun.falling();
			
			if(tempSun.xPos>screen.WIDTH)       // remove bullets out of screen
			{
				removeSun(tempSun);
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


