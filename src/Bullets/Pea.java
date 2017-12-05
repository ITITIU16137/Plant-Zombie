package Bullets;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import Characters.Bullet;
import Interface.Characters;

public class Pea extends Bullet implements Characters{
	
	
	public Pea(double d, double e) {
		super(d, e);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void attack() {
		// TODO Auto-generated method stub
		return;
	}

	@Override
	/*
	 * 	Draw position of bullet 
	 */
	public void draw(Graphics g,Image png)                  // load image
	{
		g.drawImage(png,(int) this.xPos+30,(int)this.yPos+0);
	}

	@Override
	public void add() {
		// TODO Auto-generated method stub
		return;
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		return;
	}
	
}
