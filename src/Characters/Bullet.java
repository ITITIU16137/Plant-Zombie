package Characters;


//import org.newdawn.slick.Color;
import org.newdawn.slick.*;

public class Bullet extends GameObject{
	
	public int dX=40,dY=40;       //size of bullet
	double speed=0.5;       // speed of bullet                    
	private int damage=20;
	
	public Bullet(int x,int y)
	{
		super(x,y);
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
		g.drawImage(png,(int) this.xPos+20,(int)this.yPos+34);
		//g.setColor(Color.blue);
		//g.fillOval(this.xPos, this.yPos, this.dX, this.dY);
	}
}
