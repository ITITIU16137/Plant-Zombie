package Characters;
import java.util.*;
import org.newdawn.slick.Animation;
import org.newdawn.slick.SpriteSheet;

public class SunFlower extends Sun{
	
	public float speed =(float) 0.5;
	private int x=100,y=100,maxa=25,mina=1,maxb=5,minb=1,a,b;
	private Animation animation;
	public SunFlower(int x,int y,SpriteSheet s1)
	{
		super(x,y);
		a = ran.nextInt((maxa-mina))+mina; //random a and b in range
		b = ran.nextInt((maxb-minb))+minb;
		animation = new Animation(s1, 50);
	}
	public float getSpeed() {return speed;}
	public void setSpeed(float speed) {this.speed = speed;}
	Random ran = new Random();
	public void appear () {
		x++;
		y=a*x+b;
		animation.draw(x, y);
		animation.getSpeed();
		System.out.println(x+ "  "+ y); // see position of animation 
	}
	public static float get(float x2) {
		return x2;
	}
}
