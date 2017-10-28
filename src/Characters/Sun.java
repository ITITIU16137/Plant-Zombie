package Characters;


//import org.newdawn.slick.Color;
import org.newdawn.slick.*;

public class Sun extends GameObject{
	
	protected int dX=400,dY=400;       //size of Sun
	protected double speed=0.2;       // speed of Sun :D           
	
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
		//g.setColor(Color.blue);
		//g.fillOval(this.xPos, this.yPos, this.dX, this.dY);
	}
}
