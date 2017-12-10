package Event;

import org.newdawn.slick.*;

import Bullet.*;
import Characters.*;

public class LevelControl {
	
	//Zombies zombie;
	//Bullet bullet;
	public int gameLevel=1;
	
	public int setLimitness()
	{
		if(gameLevel==2)
		{
			return 10;
		}
		return 5;
	}
	
	public void setHp(Zombies zombie)
	{
		if(gameLevel==1)
		{
			//zombie.setHp(zombie.getHp()-((Pea)bullet).damage);
			zombie.setHp(zombie.getHp()-Pea.damage);
		}
		else if(gameLevel==2)
		{
			zombie.setHp(zombie.getHp()-FireBullet.damage);
		}
	}
	
	public void drawBullets(Bullet b) throws SlickException
	{
		if(gameLevel==1)
		{
			((Pea)b).draw(new Image(Pea.pngName));
		}
		if(gameLevel==2)
		{
			((FireBullet)b).draw(new Image(FireBullet.pngName));
		}
	}
}
