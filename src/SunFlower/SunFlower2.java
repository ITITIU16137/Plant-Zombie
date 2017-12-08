package SunFlower;
import java.util.*;

import org.newdawn.slick.Animation;
import org.newdawn.slick.SpriteSheet;

import Characters.SunFlower;
public class SunFlower2 extends SunFlower {

	public SunFlower2(int x, int y,SpriteSheet s1) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	
	Animation ani;
	double x=100,y=100,maxa=5,mina=1,maxb=5,minb=1,a,b;
	Random ran = new Random();
	
	
	
	public void appear (double x, double y) {
		y=a*x+b;
		a = ran.nextFloat()*(maxa-mina) + mina;
		b = ran.nextFloat()*(maxb-minb) + minb;
		
	}
	
	
	
	
}
