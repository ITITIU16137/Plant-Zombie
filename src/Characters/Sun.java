package Characters;


//import org.newdawn.slick.Color;
import org.newdawn.slick.*;
public class Sun extends GameObject{
	
	protected int dX=400,dY=400;       //size of Sun
	double speed=0.2;       // speed of Sun :D

	private int delaySun=0;
	private int durationSun=5000;
	public Sun(int x,int y)
	{
		super(x,y);
	}
	
	public void falling()
	{
		yPos+=speed;
	}
	
	public void draw(Graphics g, Image png)                  // load image
	{
		g.drawImage(png,(int) this.xPos,(int)this.yPos);
	}
}
