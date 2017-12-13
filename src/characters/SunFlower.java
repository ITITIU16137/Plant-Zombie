package characters;

import java.util.*;
import org.newdawn.slick.*;

public class SunFlower extends GameObject{
	
	public int speed =1;
	int hp;
	int damage;
	Random ran = new Random();
	int x, y, xR, yR, a, b;
	public static String pngName="res/SunFlower.png";
	public static Animation png;
	
	public SunFlower(int x,int y) throws SlickException
	{
		super(x,y);
		init();
	}

	public void init()throws SlickException
	{
		png=new Animation(new SpriteSheet(pngName,74,73),40);
	}
	
	public void draw()
	{
		png.draw((float)xPos,(float)yPos);
	}
	
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
	
	public int getx()          {return x;}
	public void setx(double xPos) {this.x = x;}
	public int gety()          {return y;}
	public void sety(double yPos) {this.y = y;}
	
	public void appear() {
		xR=ran.nextInt(651)+201;
		yR=ran.nextInt(395)+201;
		a=(y-yR)/(x-xR);
		b=y-a*x;
	}
}
