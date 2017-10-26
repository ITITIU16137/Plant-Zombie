package GUI;
import Characters.*;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import java.util.ArrayList;
import java.util.Random;


public class Play extends BasicGameState
{	
	
	PlayControl controller=new PlayControl();
	SunRun runer= new SunRun();
	Plants shooter=new Plants();
	Sf sunflower=new Sf();
	Image small,background,bullet,sun,khoa;
	SpriteSheet S1;
    Animation S11;
    
    
	private Music music1;
	Menu menumusic = new Menu();
	
	
	private Integer[] zomInitPos=new Integer[5];
	private Integer[] sunInitPos=new Integer[9];
	
	private ArrayList<Image> zombieImages=new ArrayList<>();
	
	
	
	private double count=0;                                 //  this is
	private double frequencyImage=0.002;                    //  for object speed
	
	private int delayTime=0;                                // this is for
	private int delay=getDelayTime(10000);//max 10s         // delay time to spawn zombies
	
	public int getDelayTime(int maxTime)
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
		
		/*plantImages.add(new Image("res/Plant/PeaShooter_Idle1-0.png"));
		plantImages.add(new Image("res/Plant/PeaShooter_Idle1-1.png"));
		plantImages.add(new Image("res/Plant/PeaShooter_Idle1-2.png"));
		plantImages.add(new Image("res/Plant/PeaShooter_Idle1-3.png"));
		plantImages.add(new Image("res/Plant/PeaShooter_Idle1-4.png"));
		plantImages.add(new Image("res/Plant/PeaShooter_Idle1-5.png"));
		plantImages.add(new Image("res/Plant/PeaShooter_Idle1-6.png"));
		plantImages.add(new Image("res/Plant/PeaShooter_Idle1-7.png"));
		plantImages.add(new Image("res/Plant/PeaShooter_Idle1-8.png"));
		plantImages.add(new Image("res/Plant/PeaShooter_Idle1-9.png"));
		plantImages.add(new Image("res/Plant/PeaShooter_Idle1-10.png"));
		plantImages.add(new Image("res/Plant/PeaShooter_Idle1-11.png"));
		plantImages.add(new Image("res/Plant/PeaShooter_Idle1-12.png"));
		plantImages.add(new Image("res/Plant/PeaShooter_Idle1-13.png"));
		plantImages.add(new Image("res/Plant/PeaShooter_Idle1-14.png"));
		plantImages.add(new Image("res/Plant/PeaShooter_Idle1-15.png"));
		plantImages.add(new Image("res/Plant/PeaShooter_Idle1-16.png"));
		plantImages.add(new Image("res/Plant/PeaShooter_Idle1-17.png"));
		plantImages.add(new Image("res/Plant/PeaShooter_Idle1-18.png"));
		plantImages.add(new Image("res/Plant/PeaShooter_Idle1-19.png"));
		plantImages.add(new Image("res/Plant/PeaShooter_Idle1-20.png"));
		plantImages.add(new Image("res/Plant/PeaShooter_Idle1-21.png"));
		plantImages.add(new Image("res/Plant/PeaShooter_Idle1-22.png"));
		plantImages.add(new Image("res/Plant/PeaShooter_Idle1-23.png"));
		plantImages.add(new Image("res/Plant/PeaShooter_Idle1-24.png"));
		plantImages.add(new Image("res/Plant/PeaShooter_Idle1-25.png"));
		plantImages.add(new Image("res/Plant/PeaShooter_Idle1-26.png"));
		plantImages.add(new Image("res/Plant/PeaShooter_Idle1-27.png"));
		plantImages.add(new Image("res/Plant/PeaShooter_Idle1-28.png"));
		plantImages.add(new Image("res/Plant/PeaShooter_Idle1-29.png"));
		plantImages.add(new Image("res/Plant/PeaShooter_Idle1-30.png"));
		plantImages.add(new Image("res/Plant/PeaShooter_Idle1-31.png"));
		plantImages.add(new Image("res/Plant/PeaShooter_Idle1-32.png"));
		plantImages.add(new Image("res/Plant/PeaShooter_Idle1-33.png"));
		plantImages.add(new Image("res/Plant/PeaShooter_Idle1-34.png"));
		plantImages.add(new Image("res/Plant/PeaShooter_Idle1-35.png"));
		plantImages.add(new Image("res/Plant/PeaShooter_Idle1-36.png"));
		plantImages.add(new Image("res/Plant/PeaShooter_Idle1-37.png"));
		plantImages.add(new Image("res/Plant/PeaShooter_Idle1-38.png"));
		plantImages.add(new Image("res/Plant/PeaShooter_Idle1-39.png"));
		plantImages.add(new Image("res/Plant/PeaShooter_Idle1-40.png"));
		plantImages.add(new Image("res/Plant/PeaShooter_Idle1-41.png"));
		plantImages.add(new Image("res/Plant/PeaShooter_Idle1-42.png"));
		plantImages.add(new Image("res/Plant/PeaShooter_Idle1-43.png"));
		plantImages.add(new Image("res/Plant/PeaShooter_Idle1-44.png"));
		plantImages.add(new Image("res/Plant/PeaShooter_Idle1-45.png"));
		plantImages.add(new Image("res/Plant/PeaShooter_Idle1-46.png"));
		plantImages.add(new Image("res/Plant/PeaShooter_Idle1-47.png"));
		plantImages.add(new Image("res/Plant/PeaShooter_Idle1-48.png"));
		plantImages.add(new Image("res/Plant/PeaShooter_Idle1-49.png"));
		plantImages.add(new Image("res/Plant/PeaShooter_Idle1-50.png"));
		plantImages.add(new Image("res/Plant/PeaShooter_Idle1-51.png"));
		plantImages.add(new Image("res/Plant/PeaShooter_Idle1-52.png"));
		plantImages.add(new Image("res/Plant/PeaShooter_Idle1-53.png"));
		plantImages.add(new Image("res/Plant/PeaShooter_Idle1-54.png"));
		plantImages.add(new Image("res/Plant/PeaShooter_Idle1-55.png"));
		plantImages.add(new Image("res/Plant/PeaShooter_Idle1-56.png"));
		plantImages.add(new Image("res/Plant/PeaShooter_Idle1-57.png"));
		plantImages.add(new Image("res/Plant/PeaShooter_Idle1-58.png"));
		plantImages.add(new Image("res/Plant/PeaShooter_Idle1-59.png"));*/
		
		small = new Image ("res/s.png");
		 background=new Image("res/Night.png");
		 bullet=new Image("res/Pea.png");
		 sun = new Image("res/sun.png");
		 S1 = new SpriteSheet("res/khoa.png", 74, 73);// Sunflower 
	     S11 = new Animation(S1, 40);				  // animatioon
	     S11.setPingPong(true);
		 
		 
		 music1 = new Music("res/Play/Intro.ogg");
		
		 music1.setVolume(0.3f);
		 music1.loop();
	}
	
	
	public void render (GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
	{
		g.drawImage(background, 0,0);                         //draw background
		g.drawImage(small,shooter.xPos+40,shooter.yPos);      // draw plant shooter
		                       
		controller.render(g,bullet);                         // draw bullets
		controller.renderZombie(zombieImages, this.count);   //draw zombies
		
		g.drawAnimation(S11,sunflower.xPos, sunflower.yPos); // draw sunflower
		runer.render(g,sun);
		
		this.count+=this.frequencyImage ;                //  print multiple images to create animation
		if(this.count>10){this.count=0;}
		 
		g.drawString("X:  "+shooter.xPos+"Y:  "+shooter.yPos,400,200);
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
		Random rand = new Random(); // This is bullshit
		int  random = rand.nextInt(8) ; // also bullshit
		
		if (input.isKeyDown(Input.KEY_RIGHT)) 
		{
			shooter.xPos+=shooter.speed;
		}
		else if (input.isKeyDown(Input.KEY_LEFT)) 
		{
			shooter.xPos -=shooter.speed;
		}
		else if (input.isKeyDown(Input.KEY_UP)) 
		{
			shooter.yPos -=shooter.speed;
		}
		else if (input.isKeyDown(Input.KEY_DOWN)) 
		{
			shooter.yPos +=shooter.speed;
		}
		else if(input.isKeyPressed(Input.KEY_SPACE))                         // press space to shoot
		{
			controller.addBullet(new Bullet(shooter.xPos+120,shooter.yPos+25));     // bullets fly from plant position
			
		}
	
		this.delayTime+=1;                                                                //system count 
		if(this.delayTime==delay)                                                         //from 0 to delay
		{                        							 //to spawn zombies
			controller.addZombie(new Zombies(950,zomInitPos[(int)(Math.random()*5)]));
			runer.addSun(new Sun(sunInitPos[random],0)); 	//also spawn Sun but faster
			delay=getDelayTime(10000);
			this.delayTime=0;
		
		}
		this.delayTime+=1;                                                                //system count 
		if(this.delayTime==delay)                                                         //from 0 to delay
		{                        							 //also spawn Sun but faster
		
			runer.addSun(new Sun(sunInitPos[random],0));
			delay=getDelayTime(5000);
			this.delayTime=0;
		
		}
		                                                                //system count 
		
		controller.shoot();
		controller.zomWalk();
		runer.run();
	}
	
	public int getID()
	{
        	return 0;	
	}
}
