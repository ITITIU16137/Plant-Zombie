package Characters;
import Event.*;

//import org.newdawn.slick.Color;
import org.newdawn.slick.*;

public class Bullet extends GameObject{
	
	public int dX=40,dY=40;       //size of bullet
	double speed=0.5;       // speed of bullet                    
	private int damage=20;
	
	public Bullet(double d,double e)
	{
		super(d,e);
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
		g.drawImage(png,(int) this.xPos+30,(int)this.yPos+0);
		//g.setColor(Color.blue);
		//g.fillOval(this.xPos, this.yPos, this.dX, this.dY);
	}
}
