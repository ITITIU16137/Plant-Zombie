package plant;

import org.newdawn.slick.*;

import characters.Plants;

public class AgentPeashooter extends Plants{
	public static String pngName="res/Agent.png";
	public static Image png;
	
	public AgentPeashooter(int x, int y) throws SlickException 
	{
		super(x, y);
		init();
	}
	
	public void init() throws SlickException
	{
		png=new Image(pngName); 
	}
	
	public void draw()
	{
		png.draw((float)xPos+40,(float)yPos);
	}
}
