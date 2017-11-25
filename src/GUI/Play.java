package GUI;
import Characters.*;
import Event.*;
import CheckGame.*;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import java.util.ArrayList;

public class Play extends BasicGameState
{	
	PlayControl controller=new PlayControl();
	Plants shooter=new Plants(200,200);
	SunFlower sunflower=new SunFlower(100,100);
	Zombies zombie;
	Image small,background,bullet,sun,khoa,text;
	SpriteSheet S1,S2;
    Animation S11,S22;
   
    Sound pow;
    Music coming;
    
    private Animation a;
	
	private Integer[] zomInitPos=new Integer[5];
	private Integer[] sunInitPos=new Integer[9];
	
	private ArrayList<Image> zombieImages=new ArrayList<>();
	
	private double count=0;                                 //  this is
	private double frequencyImage=0.002;                    //  for object speed
	
	private int delayTimeZom=0;                                // this is for
	private int delayZom=getDelayTimeZom(10000);//max 10s         // delay time to spawn zombies
	private int delayTimeSun=0;
	private int delaySun=getDelayTimeSun(5000);
	private int delayText=0;
	private int durationText=3000;
	public int getDelayTimeZom(int maxTime)
	{	
		return (int)(Math.random()*maxTime)+1;
	}
	public int getDelayTimeSun(int maxTime)
	{
		return (int)(Math.random()*maxTime)+1;
	}
	
	public Play (int state){	
	}
	
	public void init(GameContainer gc, StateBasedGame sbg ) throws SlickException
	{
		zomInitPos[0]=120;
		zomInitPos[1]=220;
		zomInitPos[2]=320;
		zomInitPos[3]=420;
		zomInitPos[4]=520;
		
		
		sunInitPos[0]=200;
		sunInitPos[1]=276;
		sunInitPos[2]=359;
		sunInitPos[3]=447;
		sunInitPos[4]=519;
		sunInitPos[5]=607;
		sunInitPos[6]=684;
		sunInitPos[7]=764;
		sunInitPos[8]=847;
		
		
		zombieImages.add(new Image("res/Zombie/male/walk1.png"));
		zombieImages.add(new Image("res/Zombie/male/walk2.png"));
		zombieImages.add(new Image("res/Zombie/male/walk3.png"));
		zombieImages.add(new Image("res/Zombie/male/walk4.png"));
		zombieImages.add(new Image("res/Zombie/male/walk5.png"));
		zombieImages.add(new Image("res/Zombie/male/walk6.png"));
		zombieImages.add(new Image("res/Zombie/male/walk7.png"));
		zombieImages.add(new Image("res/Zombie/male/walk8.png"));
		zombieImages.add(new Image("res/Zombie/male/walk9.png"));
		zombieImages.add(new Image("res/Zombie/male/walk10.png"));
				
		 background=new Image("res/Night.png");
		 
		 bullet=new Image("res/Pea.png");
		 
		 sun = new Image("res/sun.png");
		 
		 text = new Image("res/text.png");
		 //text.destroy();
		 S1 = new SpriteSheet("res/khoa.png", 74, 73);// Sunflower 
	     S11 = new Animation(S1, 40);				  // animatioon
	     S11.setPingPong(true);						  // 
	     
	     S2 = new SpriteSheet("res/PeaShooter.png", 125, 106);// Peashooter 
	     S22 = new Animation(S2, 20);				  // animatioon
	     S22.setPingPong(true);		
	      
	     //Sound
	     coming = new Music("res/Play/zombies_coming.ogg");
	     pow = new Sound("res/Play/POW.wav");
	}
	
	
	public void render (GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
	{
		g.drawImage(background, 0,0);                         //draw background
		g.drawAnimation(S22,(float)shooter.xPos+40,(float)shooter.yPos); // draw peashooter
		g.drawAnimation(S11,(float)sunflower.xPos,(float) sunflower.yPos); // draw sunflower
		
		if(delayText<durationText) 
			{
				coming.play();                                     //annoucement
				g.drawImage(text, 80, 300);                        //draw text
			}
		
		controller.renderBullet(g,bullet);                         // draw bullets
		controller.renderZombie(zombieImages, this.count);   //draw zombies
		controller.renderSun(g,sun);
		
		this.count+=this.frequencyImage ;                //  print multiple images to create animation
		if(this.count>10){this.count=0;}
		
		g.setColor(Color.white); 
		g.drawString("X:  "+shooter.xPos+"Y:  "+shooter.yPos,400,100);          // debug
		//Sun Collects
		g.drawImage(sun, 0, 0);
		g.setColor(Color.black);
		//g.setColor(100, 30, new Color(1, 1, 1, 0.5f));
		g.fillRoundRect(100, 30, 150, 50, 10 );
		/*g.setColor(Color.red);                              //debug
		for(int i=0;i<5;i++)
		{
			g.fillOval(950, zomInitPos[i], 10, 10);
		}*/
		
		//g.drawString(" "+this.count2+" "+delay, 500, 500);     //debug
		
	}
	
	public void update (GameContainer gc, StateBasedGame sbg, int delta) throws SlickException
	{
		Input input = gc.getInput();
		
		if (input.isKeyDown(Input.KEY_RIGHT)) 
		{
			shooter.xPos +=shooter.speed;
			if(shooter.xPos<850) shooter.xPos +=shooter.speed;
			else shooter.xPos=850;
		}
		else if (input.isKeyDown(Input.KEY_LEFT)) 
		{
			shooter.xPos -=shooter.speed;
			if(shooter.xPos>200) shooter.xPos -=shooter.speed;
			else shooter.xPos=200;
		}
		else if (input.isKeyDown(Input.KEY_UP)) 
		{
			shooter.yPos -=shooter.speed;
			if(shooter.yPos>200) shooter.yPos -=shooter.speed;
			else shooter.yPos=200;
		}
		else if (input.isKeyDown(Input.KEY_DOWN)) 
		{
			shooter.yPos +=shooter.speed;
			if(shooter.yPos<595) shooter.yPos +=shooter.speed;
			else shooter.yPos=595;
		}
		else if(input.isKeyPressed(Input.KEY_SPACE))                         // press space to shoot
		{
			controller.addBullet(new Bullet(shooter.xPos+120,shooter.yPos+25));     // bullets fly from plant position	
			pow.play();
		}
		if (input.isKeyDown(Input.KEY_A))
		{
			sbg.enterState(2);                                    //Gameover
		}
		this.delayTimeZom+=1;                                                                //system count 
		if(this.delayTimeZom==delayZom)                                                      //from 0 to delay
		{                        							                                 //to spawn zombies
			controller.addZombie(new Zombies(950,zomInitPos[(int)(Math.random()*5)]));
			delayZom=getDelayTimeZom(10000);
			this.delayTimeZom=0;
		}
		
		this.delayTimeSun+=1;                                                                
		if(this.delayTimeSun==delaySun)                                        //to spawn sun                 
		{                        							 
			controller.addSun(new Sun(sunInitPos[(int)(Math.random()*9)],0));
			delaySun=getDelayTimeSun(5000);
			this.delayTimeSun=0;
		}

		this.delayText+=delta;
		controller.shoot();
		controller.zomWalk();
		controller.fall();
		/*if(controller.gameStatus()==false) 
		{
			sbg.enterState(3);
		} */
		controller.shoot();
		controller.zomWalk();
		controller.fall();
		//controller.gameStatus();
		
	}
	
	public int getID()
	{
        	return 1;	
	}
}
