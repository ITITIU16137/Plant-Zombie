package Characters;

import GUI.*;
import Characters.*;

import org.newdawn.slick.*;
import java.util.ArrayList;

public class BulletsControl {
	
	private ArrayList<Bullet> bullets=new ArrayList<>();
	Bullet tempBullet;
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
	
}
