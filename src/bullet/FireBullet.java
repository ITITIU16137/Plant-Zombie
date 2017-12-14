package bullet;

import org.newdawn.slick.Image;

import characters.*;

public class FireBullet extends Bullet{
               
	public static int damage=50;
	public static String pngName="res/Fire_Bullet.png";
	
	public FireBullet(double d,double e)
	{
		super(d,e);
	}

	@Override
	public void draw(Image png) {
		png.draw((int)this.xPos, (int)this.yPos,png.getWidth()*4,png.getHeight()*4);
	}


}
