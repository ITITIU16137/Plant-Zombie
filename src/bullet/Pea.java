package bullet;

import org.newdawn.slick.Image;

import characters.*;

public class Pea extends Bullet{

	public static int damage=20;
	public static String pngName="res/Pea.png";
	
	public Pea(double d, double e) 
	{
		super(d, e);
	}
	
	@Override
	public void draw(Image png)                  // load image
	{
		png.draw((int)this.xPos+30,(int)this.yPos+0);
	}
}
