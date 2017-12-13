package characters;
import org.newdawn.slick.*;

public class Sun extends GameObject{

	protected int dX=400,dY=400;         //size of Sun
	private int randomInt;
	int speed = 1;                       // speed of Sun :D
	public int delayTimeSun=0;
	public int delaySun=getDelayTimeSun(5000);
	public int maxTime=5000;
	public static String pngName="res/sun.png";
	public static Image png;
	
	public Sun() {}
	
	public Sun(int x,int y) throws SlickException
	{
		super(x,y);
		init();
	}

	public void init() throws SlickException
	{
		this.randomInt = (int)(Math.random()*1)+(int)(Math.random()*5);
		png=new Image(pngName);
	}
	
	public int getRandomInt()
	{
			return randomInt;
	}

	/*
	 * 	 Add sun one by one
	 */
	public void falling(int k)
	{
		if (k == 1)
		yPos+=speed;
		else yPos -= 1 ;

	}
	public void stop() {

		yPos-=speed;
	}

	public int getDelayTimeSun(int maxTime)
	{
		return (int)(Math.random()*maxTime)+1;
	}
	
	public void draw()                  // load image
	{
		png.draw((int) this.xPos,(int)this.yPos);
	}
}
