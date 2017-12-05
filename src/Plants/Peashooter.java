package Plants;
import java.util.ArrayList;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import Characters.Bullet;
import Characters.Plants;
import Characters.Zombies;
import Event.Physic;
import GUI.Main;
import Interface.*;
public class Peashooter extends Plants implements Characters{
	
	private ArrayList<Bullet> bullets=new ArrayList<>();
	private ArrayList<Zombies> zombies=new ArrayList<>();
	Physic phy =new Physic();
	Bullet tempBullet;
	Main screen;
	Graphics g;
	Image png;
	
	public Peashooter(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void attack()                        
	{
		for(int i=0;i<bullets.size();i++)             //shoot all the bullets in the list
		{
			tempBullet=bullets.get(i);
			
			if(tempBullet.xPos>screen.WIDTH)       // remove bullets out of screen
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
	public void render() {                      // draw bullets
		// TODO Auto-generated method stub
		for(int i=0;i<bullets.size();i++)
		{
			tempBullet=bullets.get(i);
			//tempBullet.render(g,png);
		}
	}
	
	@Override
	public void add() {
		// TODO Auto-generated method stub
		bullets.add(tempBullet);
	}
	
	@Override
	public void remove() {
		// TODO Auto-generated method stub
		bullets.remove(tempBullet);
	}

	

	
	
	
}
