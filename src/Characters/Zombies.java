package Characters;
import org.newdawn.slick.*;
import java.util.ArrayList;

public abstract class Zombies extends GameObject{
	
	protected int hp=100;
	protected int damage;
	protected double speed=-0.09;
	
	public Zombies(int x,int y)
	{
		super(x,y);
	}
	
	public int getHp()                { return hp; }
	public void setHp(int hp)         { this.hp = hp; }
	public int getDamage()            { return damage; }
	public void setDamage(int damage) { this.damage = damage;}
	public double getSpeed()          { return speed; }
	public void setSpeed(double speed){ this.speed = speed; }
	
	public abstract void attack();
	public abstract void render();
	public abstract void add();
	public abstract void remove();
	
	public void moving()
	{
		xPos+=speed;
	}
	
	public void draw( ArrayList<Image> zom,double i)
	{
		//use this code to RESIZE image
		zom.get((int)i).draw((int)this.xPos, (int)this.yPos, zom.get((int)i).getWidth()/3, zom.get((int)i).getHeight()/3);
	}
	
	/*public void attack(Peashooter plant)        // have not been used yet
	{
		plant.hp-=this.damage;
	}*/
	
	/*public boolean checkShot(Bullet b)        // have not been used yet
	{
		if(b.xPos==this.xPos)
		{
			return true;
		}
		return false;
	}*/
}
