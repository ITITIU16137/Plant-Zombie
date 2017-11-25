
package Characters;

import java.util.ArrayList;

import org.newdawn.slick.Image;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;

public class Peashooter extends GameObject
{
	
	public int speed = 1;
	protected int hp;
	protected int damage;
	
	/*
	 *  Constructor 
	 */
	public Peashooter(int x,int y) 
	{
		super(x,y);
		
	}
	/*
	 * 	Get-Set method
	 */
	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}
}
