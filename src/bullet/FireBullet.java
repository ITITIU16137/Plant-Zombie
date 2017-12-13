package Bullet;

import org.newdawn.slick.Image;

import Characters.*;

public class FireBullet extends Bullet{
               
	public static int damage=50;
	public static String pngName="res/Fire_Bullet.png";
	
	public FireBullet(double d,double e)
	{
		super(d,e);
	}

	public void draw(Image png)                  // load image
	{
		png.draw((int)this.xPos, (int)this.yPos,png.getWidth()*4,png.getHeight()*4);
	}
}
