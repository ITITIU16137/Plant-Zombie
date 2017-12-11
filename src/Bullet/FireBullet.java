package Bullet;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import Characters.*;

public class FireBullet extends Bullet implements Characters{
	//public int dX=40,dY=40;       //size of bullet
	double speed=0.5;       // speed of bullet                    
	public static int damage=50;
	public static String pngName="res/Fire_Bullet.png";
	
	/*public FireBullet()
	{
		
	}*/
	
	public FireBullet(double d,double e)
	{
		super(d,e);
	}
	
	public void attack(){};
	public void render(Graphics g, Image png){};
	public void add(Bullet b){};
	public void remove(Bullet b){};
	
	public void draw(Image png)                  // load image
	{
		png.draw((int)this.xPos, (int)this.yPos,png.getWidth()*4,png.getHeight()*4);
	}
}
