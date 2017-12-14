package events;

import org.newdawn.slick.*;

import bullet.*;
import characters.*;
import plant.*;

public class LevelControl {
	
	public int gameLevel=1;
	
	public int setScoreLimitness()
	{
		if(gameLevel==2)
		{
			return 10*50;
		}
		else if(gameLevel==3)
		{
			return 10*50;
		}
		return 1*50;
	}
	
	public void drawPlants(Plants p) throws SlickException
	{
		if(gameLevel==1)
		{
			
			//((Peashooter)p).draw(new Animation(new SpriteSheet(Peashooter.pngName,125,106),20));
			((Peashooter)p).draw();
			//((Agentshooter)p).draw(new Image(Agentshooter.pngName));
		}
		if(gameLevel==2)
		{
			//((Agentshooter)p).draw(new Animation(new SpriteSheet(Agentshooter.pngName, 125, 106),20));
			//((TripletPeashooter)p).draw(new Image(TripletPeashooter.pngName));
			((TripletPeashooter)p).draw();
		}
		if(gameLevel==3)
		{
			((AgentPeashooter)p).draw();
		}
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
		else if(gameLevel==3)
		{
			zombie.setHp(zombie.getHp()-RocketBullet.damage);
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
		if(gameLevel==3)
		{
			((RocketBullet)b).draw(new Image(RocketBullet.pngName));
		}
	}
}
