package GUI;
import Characters.*;
import java.util.Random;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.newdawn.slick.GameContainer;
import java.util.ArrayList;
import java.io.File;

public class Play extends BasicGameState
{	
	
	PlayControl controller=new PlayControl();
	SunRun runer= new SunRun();
	Plants shooter=new Plants();
	Sf sunflower=new Sf();
	Image small,background,bullet,sun,khoa;
	SpriteSheet S1;
    Animation S11;
    private Animation a;
    
	private Music music1;
	
	private Integer[] zomInitPos=new Integer[5];
	private Integer[] sunInitPos=new Integer[9];
	
	private ArrayList<Image> zombieImages=new ArrayList<>();
	
	private double count=0;                                 //  this is
	private double frequencyImage=0.002;                    //  for object speed
	
	private int delayTime=0;                                // this is for
	private int delay=getDelayTime(1000);//max 10s         // delay time to spawn zombies
	
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
		
		 small = new Image ("res/s.png");
		 background=new Image("res/Night.png");
		 bullet=new Image("res/Pea.png");
		 sun = new Image("res/sun.png");
		 S1 = new SpriteSheet("res/khoa.png", 74, 73);// Sunflower 
	     S11 = new Animation(S1, 40);				  // animatioon
	     S11.setPingPong(true);						  // 
	   
	     
	     
	     
	     
	
	     File f = null;

	   
	       f = new File("res/Out.png");
	      
	    
	    
	   // BigBufferedImage image = BigBufferedImage.create(f,32);

		 
		 music1 = new Music("res/Play/Intro.ogg");
		
		 music1.setVolume(0.3f);
		 music1.loop();
	}
	
	
	public void render (GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
	{
		g.drawImage(background, 0,0);                         //draw background
		g.drawImage(small,shooter.xPos+40,shooter.yPos);      // draw plant shooter
		                       
		controller.renderBullet(g,bullet);                         // draw bullets
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
			
			delay=getDelayTime(10000);
			this.delayTime=0;
		
		}
		this.delayTime+=1;                                                                //system count 
		if(this.delayTime==delay)                                                         //from 0 to delay
		{                        							 //to spawn zombies
		
			runer.addSun(new Sun(sunInitPos[random],0));
			delay=getDelayTime(5000);
			this.delayTime=0;
		
		}
		                                                                //system count 
		
		controller.shoot();
		controller.zomWalk();
		runer.run();
		if(input.isKeyPressed(input.KEY_0))
		{
			sbg.enterState(3);
		}
	}
	
	public int getID()
	{
        	return 1;	
	}
}
