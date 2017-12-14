package bullet;

import org.newdawn.slick.Image;

import characters.*;

public class RocketBullet extends Bullet{
	public static int damage=100;
	public static String pngName="res/rocket.png";
	
	public RocketBullet(double d,double e)
	{
		super(d,e);
	}

	public void draw(Image png)                  // load image
	{
		png.draw((int)this.xPos, (int)this.yPos,png.getWidth()/8,png.getHeight()/8);
	}
}
