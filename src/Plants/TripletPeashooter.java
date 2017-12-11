package Plants;

import java.util.ArrayList;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import Characters.*;
import Event.Physic;
import GUI.Main;

public class TripletPeashooter extends Plants implements Characters{
	private ArrayList<Bullet> bullets=new ArrayList<>();
	Bullet tempBullet2;
	
	public static String pngName="res/TripletShooter.png";
	
	public TripletPeashooter(int x, int y)   {super(x, y);}                   
	
	@Override
	public void render(Graphics g,Image png) {                // draw bullets
		for(int i=0;i<bullets.size();i++)
		{
			tempBullet2=bullets.get(i);
			tempBullet2.render(g,png);
		}
	}
	
	@Override
	public void attack() {
		
	}    
	
	public void draw(Animation a)
	{
		a.draw((float)xPos+40,(float)yPos, a.getWidth(),a.getHeight());
	}
	public void draw(Image png)
	{
		png.draw((float)xPos+40,(float)yPos, png.getWidth(),png.getHeight());
	}
}
