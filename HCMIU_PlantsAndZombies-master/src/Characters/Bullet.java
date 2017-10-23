package Characters;


//import org.newdawn.slick.Color;
import org.newdawn.slick.*;

public class Bullet{
	
	public int dX=40,dY=40;       //size of bullet
	public double xPos,yPos;   // position of bullet
	double speed=0.5;       // speed of bullet           
	
	public Bullet(int x,int y)
	{
		this.xPos=x;
		this.yPos=y;
	}
	
	public boolean checkEnemy(Zombies zom)              // haven't been used
	{
		if(this.xPos==zom.xPos)
		{
			return true;
		}
		return false;
	}
	
	public void flying()
	{
		xPos+=speed;
	}
	
	public void draw(Graphics g, Image png)                  // load image
	{
		g.drawImage(png,(int) this.xPos,(int)this.yPos);
		//g.setColor(Color.blue);
		//g.fillOval(this.xPos, this.yPos, this.dX, this.dY);
	}
}
