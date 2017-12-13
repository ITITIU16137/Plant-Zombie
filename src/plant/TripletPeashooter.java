package plant;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

//import Characters.Plants;
import Characters.*;

public class TripletPeashooter extends Plants{

	public static String pngName="res/TripletShooter.png";
	public static Image png;
	public TripletPeashooter(int x, int y) throws SlickException 
	{
		super(x, y);
		init();
	}                   

	public void init() throws SlickException
	{
		png=new Image(pngName);
	}
	
	public void draw(Animation a)
	{
		a.draw((float)xPos+40,(float)yPos, a.getWidth(),a.getHeight());
	}
	public void draw()
	{
		png.draw((float)xPos+40,(float)yPos, png.getWidth(),png.getHeight());
	}
}
