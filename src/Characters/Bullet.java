package Characters;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public abstract class Bullet extends GameObject{
	
	public int dX=40,dY=40;                        //size of bullet
	double speed=0.5;                              // speed of bullet                    
	//private int damage=20;					   haven't been used
	
	public Bullet(double d,double e)  {super(d,e);}
	public void flying()    
	{
		xPos+=speed;                               //set speed for bullets while flying
	}       
	public abstract void attack();
	public abstract void render(Graphics g, Image png);
	public abstract void add(Bullet b);
	public abstract void remove(Bullet b);
}
