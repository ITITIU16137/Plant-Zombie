package Bullet;

import java.util.ArrayList;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import Characters.Bullet;
import Characters.Characters;
import Characters.Zombies;
import Event.Physic;
import GUI.Main;

public class Pea extends Bullet implements Characters{
	private ArrayList<Bullet> bullets=new ArrayList<>();
	private ArrayList<Zombies> zombies=new ArrayList<>();
	Physic phy =new Physic();
	Bullet tempBullet;
	Main screen;
	public Pea(double d, double e) 
	{
		super(d, e);
	}
	
	@Override
	public void attack() {
		// TODO Auto-generated method stub
		for(int i=0;i<bullets.size();i++)                     //shoot all the bullets in the list
		{
			tempBullet=bullets.get(i);
			
			if(tempBullet.xPos>screen.WIDTH)                  // remove bullets out of screen
			{
				remove(tempBullet);
			}
			
			if(phy.Collision(tempBullet, zombies))
			{
				remove(tempBullet);
			}
			tempBullet.flying();
		}
	}

	@Override
	public void render(Graphics g,Image png)              // draw bullets
	{
		
		for(int i=0;i<bullets.size();i++)
		{
			tempBullet=bullets.get(i);
			tempBullet.draw(g,png);
		}
	}

	@Override
	public void add(Bullet b) {					             //add Bullets
		bullets.add(b);
	}
	
	public void remove(Bullet b) {
		bullets.remove(b);
	}
}
