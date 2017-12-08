package GUI;
import Characters.*;
import Event.*;
import Plants.*;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import Bullet.Pea;

import java.util.ArrayList;
import org.lwjgl.input.Mouse;
public class Play extends BasicGameState
{	
	PlayControl controller = new PlayControl();
	public static Peashooter shooter=new Peashooter(200,200);
	SunFlower sunflower=new SunFlower(100,100);
	Pea bullet = new Pea(0,0);
	Zombies zombie;
	Image small,background,pea,sun,text;
	SpriteSheet S1,S2;
    Animation S11,S22;

//    private int delayTime = 0; // this is for
//	private int delay = (5000);
	
    Sound pow;
    Music coming;
    
    public static Peashooter getShooter() { return shooter;}
    
	private Integer[] zomInitPos=new Integer[5];
	private Integer[] sunInitPos=new Integer[9];

	private Integer[] stopPos=new Integer[5];
	
	private ArrayList<Image> zombieImages=new ArrayList<>();
	private double count=0;                                      //  this is
	private double frequencyImage=0.002;                         //  for object speed
	private int delayTimeZom=0;                                  // this is for
	private int delayZom=getDelayTimeZom(10000);                 // delay time to spawn zombies(max 10s)
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
		
		stopPos[0]=195;
		stopPos[1]=295;
		stopPos[2]=395;
		stopPos[3]=495;
		stopPos[4]=595;
		
		sunInitPos[0]=204+27;
		sunInitPos[1]=276+27;
		sunInitPos[2]=364+27;
		sunInitPos[3]=442+27;
		sunInitPos[4]=520+27;
		sunInitPos[5]=602+27;
		sunInitPos[6]=686+27;
		sunInitPos[7]=764+27;
		sunInitPos[8]=851+27;
		
		
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
		 pea=new Image("res/Pea.png");
		 sun = new Image("res/sun.png");
		 text = new Image("res/text.png");
		 
		 S1 = new SpriteSheet("res/SunFlower.png", 74, 73);                  // Sunflower 
	     S11 = new Animation(S1, 40);				                         // animation
	     S11.setPingPong(true);						  
	     
	     S2 = new SpriteSheet("res/PeaShooter.png", 125, 106);               // Peashooter 
	     S22 = new Animation(S2, 20);				                         // animation
	     S22.setPingPong(true);		
	      
	     //Sound-Music
	     coming = new Music("res/Play/zombies_coming.ogg");
	     pow = new Sound("res/Play/POW.wav");
	}
	
	
	public void render (GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
	{
		g.drawImage(background, 0,0);                                         //draw background
		g.drawAnimation(S22,(float)shooter.xPos+40,(float)shooter.yPos);      //draw peashooter
		g.drawAnimation(S11,(float)sunflower.xPos,(float) sunflower.yPos);    //draw sunflower
		
		if(delayText<durationText) 
			{
				coming.play();                                     			  //play Sound
				g.drawImage(text, 80, 300);                                   //draw text
			}
		
		bullet.render(g,pea);                                             //draw bullets
		controller.renderZombie(zombieImages, this.count);                    //draw zombies
		controller.renderSun(g,sun);
		
		this.count+=this.frequencyImage ;                                     //print multiple images to create animation
		if(this.count>10){this.count=0;}
		
		g.setColor(Color.white); 
		g.drawString("X:  "+shooter.xPos+" Y:  "+shooter.yPos,400,100);         // debug
		
		g.drawImage(sun, 0, 0);                                                //
		g.setColor(Color.black);                                               // Sun board
		g.fillRoundRect(100, 30, 150, 50, 10 );                                //
		
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
		
		if (input.isKeyDown(Input.KEY_RIGHT)) 								//Move RIGHT
		{
			shooter.xPos +=shooter.speed;
			System.out.println("RIGHT");
			if(shooter.xPos<850) shooter.xPos +=shooter.speed;
			else shooter.xPos=850;
		}
		else if (input.isKeyDown(Input.KEY_LEFT)) 						    //Move LEFT
		{
			shooter.xPos -=shooter.speed;
			System.out.println("LEFT");
			if(shooter.xPos>200) shooter.xPos -=shooter.speed;
			else shooter.xPos=200;
		}
		else if (input.isKeyDown(Input.KEY_UP)) 							//Move UP
		{
			shooter.yPos -=shooter.speed;
			System.out.println("UP");
			if(shooter.yPos>200) shooter.yPos -=shooter.speed;
			else shooter.yPos=200;
		}
		else if (input.isKeyDown(Input.KEY_DOWN))                            //Move DOWN
		{
			shooter.yPos +=shooter.speed;
			System.out.println("DOWN");
			if(shooter.yPos<595) shooter.yPos +=shooter.speed;
			else shooter.yPos=595;
		}
		else if(input.isKeyPressed(Input.KEY_SPACE))                         // press SPACE to shoot
		{
			bullet.add(new Pea(shooter.xPos+120,shooter.yPos+25));  // bullets fly from plant position	
			
			pow.play();
			System.out.println("SHOOTING");
		} 
		if (input.isKeyDown(Input.KEY_A))
		{
			sbg.enterState(2);   
													//Gameover
		}
		
		
		this.delayTimeZom+=1;                                                                //system count 
		if(this.delayTimeZom==delayZom)                                                      //from 0 to delay
		{                        							                                 //to spawn zombies
		//	controller.addZombie(new Zombies(950,zomInitPos[(int)(Math.random()*5)]));
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
		bullet.attack();
		controller.zomWalk();
		controller.fall();
		controller.onClickSun();
	}
		
		
		/*if(controller.gameStatus()==false) 
		{
			sbg.enterState(3);
		} */
		//controller.gameStatus();

	
	public int getID()
	{
        	return 1;	
	}
}
