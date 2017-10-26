package Characters;


//import org.newdawn.slick.Color;
import org.newdawn.slick.*;

public class Sun{
	
	public int dX=400,dY=400;       //size of Sun
	public double xPos,yPos;   // position of Sun
	double speed=0.5;       // speed of Sun :D           
	
	public Sun(int x,int y)
	{
		this.xPos=x;
		this.yPos=y;
	}
	

	public void flying()
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
