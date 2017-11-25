package Characters;
import Event.*;

//import org.newdawn.slick.Color;
import org.newdawn.slick.*;

public class Bullet extends GameObject{
	
	public int dX=40,dY=40;       //size of bullet
	double speed=0.5;       // speed of bullet                    
	private int damage=20;
	/*
	 *  Constructor for Bullet
	 */
	public Bullet(double d,double e)
	{
		super(d,e);
	}
	/*
	 * 	
	 */
	public boolean checkEnemy(Zombies zom)              // haven't been used
	{
		if(this.xPos==zom.xPos)
		{
			return true;
		}
		return false;
	}
	
	/*
	 * 	Add bullet one by one
	 */
	public void flying()
	{
		xPos+=speed;
	}
	
	/*
	 * 	Position of bullet 
	 */
	public void draw(Graphics g, Image png)                  // load image
	{
		g.drawImage(png,(int) this.xPos+30,(int)this.yPos+0);
	}
}
