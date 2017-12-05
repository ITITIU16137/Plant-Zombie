package Characters;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import Interface.Characters;

public abstract class Bullet extends GameObject implements Characters{
	
	public int dX=40,dY=40;                        //size of bullet
	double speed=0.5;                              // speed of bullet                    
	//private int damage=20;
	
	public Bullet(double d,double e)  {super(d,e);}
	/*
	 * 	Add bullet one by one
	 */
	public void flying()    {xPos+=speed;}
	/*
	 * 	Draw position of bullet 
	 */
	public void draw(Graphics g,Image png)                  // load image
	{
		g.drawImage(png,(int) this.xPos+30,(int)this.yPos+0);
	}
	/*public boolean checkEnemy(Zombies zom)              // haven't been used
	{
		if(this.xPos==zom.xPos)
		{
			return true;
		}
		return false;
	}*/
	
	public abstract void attack();
	public abstract void render();
	public abstract void add();
	public abstract void remove();

	public void render(Graphics g, Image png) {}
	
	
}
