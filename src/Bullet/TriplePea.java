package Bullet;

import java.util.ArrayList;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import Characters.*;
import Event.Physic;
import GUI.Main;

public class TriplePea extends Bullet implements Characters {
	private ArrayList<Bullet> bullets=new ArrayList<>();
	private ArrayList<Zombies> zombies=new ArrayList<>();
	Physic phy =new Physic();
	Bullet tempBullet2;
	Main screen;
	
	public TriplePea(double d, double e) {
		super(d, e);
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		for(int i=0;i<bullets.size();i++)                     //shoot all the bullets in the list
		{
			tempBullet2=bullets.get(i);
			
			if(tempBullet2.xPos>screen.WIDTH)                  // remove bullets out of screen
			{
				remove(tempBullet2);
			}
			
			if(phy.Collision(tempBullet2, zombies))
			{
				remove(tempBullet2);
			}
			tempBullet2.flyingtripUP();
			tempBullet2.flying();
			tempBullet2.flyingtripDOWN();
		}
	}

	@Override
	public void render(Graphics g, Image png) {
		for(int i=0;i<bullets.size();i++)
		{
			tempBullet2=bullets.get(i);
			tempBullet2.draw(g,png);
		}
	}

	@Override
	public void add(Bullet b) {
		bullets.add(b);
		
	}

	@Override
	public void remove(Bullet b) {
		bullets.remove(b);
	}

}
