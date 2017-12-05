package Event;
import Characters.*;
import GUI.*;
import java.util.concurrent.ThreadLocalRandom;
import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;
import java.util.ArrayList;

public class PlayControl {
	Physic phy =new Physic();
	private ArrayList<Zombies> zombies=new ArrayList<>();
	private ArrayList<Bullet> bullets=new ArrayList<>();
	private ArrayList<Sun> sun=new ArrayList<>();
	private Integer[] stopPos=new Integer[5];
	Zombies tempZombie;
	Peashooter shooter;
	Bullet tempBullet;
	Sun tempSun;
	StateBasedGame sbg;
	GameContainer gc;
	Main screen;
	Graphics g;
	Sound Punch;
	Sound ZomWalk;
	private int check ;
	private int delayTimeSun=0;
	private int delaySun=getDelayTimeSun(80);

//	double a, b, c, d;
	public int getDelayTimeSun(int maxTime)
	{
		return (int)(Math.random()*maxTime)+1;
	}
	//private int k=595;                                    // sun fall into random area
	//--------------------------------------BULLET---------------------------------------
			public void shoot()
			{
				for(int i=0;i<bullets.size();i++)             //shoot all the bullets in the list
				{
					tempBullet=bullets.get(i);

					if(tempBullet.xPos>screen.WIDTH)       // remove bullets out of screen
					{
						removeBullet(tempBullet);
					}

					if(phy.Collision(tempBullet, zombies))
					{
						removeBullet(tempBullet);
					}
					tempBullet.flying();
				}
			}

			public void renderBullet(Graphics g,Image png)              // draw bullets
			{

				for(int i=0;i<bullets.size();i++)
				{
					tempBullet=bullets.get(i);
					tempBullet.draw(g,png);
				}
			}

			public void addBullet(Bullet b)
			{
				bullets.add(b);
			}

			public void removeBullet(Bullet b)
			{
				bullets.remove(b);
			}


	//--------------------------------------ZOMBIE---------------------------------------
	public void zomWalk() throws SlickException
	{
		for(int i=0;i<zombies.size();i++)  ///shoot all the bullets in the list
		{
			Punch = new Sound("res/Play/Punch.wav");
			ZomWalk = new Sound("res/Play/zombie.wav");
			tempZombie=zombies.get(i);
			tempZombie.moving();
			//ZomWalk.loop();
			//if(tempZombie.xPos<0 || tempZombie.getHp()<=0)
			if(tempZombie.xPos<165 || tempZombie.getHp()<=0)
			{
				removeZombie(tempZombie);
				Punch.play();
			}
			if(phy.Collision(tempZombie, bullets))
			{
				tempZombie.setHp(tempZombie.getHp()-20);
			}
		}
		//int c=0;
	}
	public void renderZombie(ArrayList<Image> png,double n)
	{

		for(int i=0;i<zombies.size();i++)
		{
			tempZombie=zombies.get(i);
			tempZombie.draw(png,n);
		}
	}

	public void addZombie(Zombies z)
	{
		zombies.add(z);
	}

	public void removeZombie(Zombies z)
	{
		zombies.remove(z);
	}

	//--------------------------------------SUN---------------------------------------

	public void fall() throws SlickException
	{	stopPos[0]=195;
		stopPos[1]=295;
		stopPos[2]=395;
		stopPos[3]=495;
		stopPos[4]=595;


		for(int i=0;i<sun.size();i++)             //shoot all the bullets in the list
		{
			tempSun=sun.get(i);
			//tempSun.falling(1);
			//this.delayTimeSun+=1;
			//if(this.delayTimeSun==delaySun)                                        //to spawn sun
			//{
				//check = (int)(Math.random()*1)+(int)(Math.random()*5);

				//delaySun=getDelayTimeSun(80);
				//this.delayTimeSun=0;
			//}
			if(tempSun.yPos <= stopPos[tempSun.getRandomInt])
				tempSun.yPos += 1;
			}			
			/*if(check == 4 )
				{tempSun.falling();
				if(tempSun.yPos >= stopPos[4])
					removeSun(tempSun);}

			if(check == 3 )
				{tempSun.falling();
				if(tempSun.yPos >= stopPos[3])
				removeSun(tempSun);	}
			if(check == 2 )
				{tempSun.falling();
				if(tempSun.yPos >= stopPos[2])
				removeSun(tempSun);	}
			if(check == 1 )
				{tempSun.falling();
				if(tempSun.yPos >= stopPos[1])
				removeSun(tempSun);	}
			if(check == 0 )
				{tempSun.falling();
				if(tempSun.yPos >= stopPos[0])
				removeSun(tempSun);	}
			*/
			/*
			switch(check) {
			case 0:
				if(tempSun.yPos >= stopPos[0])
					removeSun(tempSun);
				break;
			case 1:
				if(tempSun.yPos >= stopPos[1])
					removeSun(tempSun);
				break;
			case 2:
				if(tempSun.yPos >= stopPos[2])
					removeSun(tempSun);
				break;
			case 3:
				if(tempSun.yPos >= stopPos[3])
					removeSun(tempSun);
				break;
			case 4:
				if(tempSun.yPos >= stopPos[4])
					removeSun(tempSun);
				break;

			}*/


	}

	public void renderSun(Graphics g,Image png)              // draw bullets
	{

		for(int i=0;i<sun.size();i++)
		{
			tempSun=sun.get(i);
			tempSun.draw(g,png);
		}
	}

	public void addSun(Sun b)
	{
		sun.add(b);
	}

	public void removeSun(Sun b)
	{
		//tempSun.stop();
		sun.remove(b);
		/*
		}*/
	}
}
	/*
	public void checkEat() {
		a=shooter.xPos-60;
		b=shooter.xPos+60;
		c=shooter.yPos-65;
		d=shooter.yPos+65;
		if (tempSun.yPos>=c && tempSun.yPos<=d && tempSun.xPos>=a && tempSun.xPos<=b )
			{
				removeSun(tempSun);
			}
	}
}
*/
