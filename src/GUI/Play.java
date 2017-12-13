package GUI;
import characters.*;
import events.*;
import plant.*;
import tool.*;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import bullet.*;

import java.util.ArrayList;

public class Play extends BasicGameState
{	
	Animation ani;
	Image pausebutton,playbutton;
	int xposition,yposition;
	static ArrayList<Plants> shooter = new ArrayList<>();
	static PlayControl controller  =  new PlayControl();
    
	private Zombies zombieControl=new Zombies();
	private ArrayList<Image> zombieImages=new ArrayList<>();
	private Sun sunControll=new Sun();
	private SunFlower sunflower;
	
	private Integer[] zomInitPos=new Integer[5];
	private Integer[] sunInitPos=new Integer[9];
	private Integer[] stopPos=new Integer[5];
	private Main size;
	
	private static Image background,text,sunboard;
    private static Sound pow;
    private static Music coming;
    private static Text ScoreBoardText;
    
	private double count=0;                                      //  this is
	private double frequencyImage=0.002;                         //  for object speed
	private int delayText=0;									 //  this is
	private int durationText=3000;                               //  for delay text 
	
	public Play (int state) {}
	
	public static Plants getShooter() {return shooter.get(controller.level.gameLevel-1);}
	
	///  Initialization  ///
	public void init(GameContainer gc, StateBasedGame sbg ) throws SlickException
	{
		////  Types of shooters in an array  ////
		shooter.add(new Peashooter(200,200));
		shooter.add(new TripletPeashooter((int)shooter.get(0).xPos,(int)shooter.get(0).yPos));
		
		sunflower=new SunFlower(150,150);
		
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
				
		background = new Image("res/Night.png");
		text = new Image("res/text.png");
		sunboard = new Image("res/sunboard.png");
		ScoreBoardText = new Text (17.0f); 				  		
	    //Sound-Music
	    coming = new Music("res/Play/zombies_coming.ogg");
	    pow = new Sound("res/Play/POW.wav");
	    pausebutton = new Image ("res/pause button.png"); 
	    playbutton = new Image ("res/playbutton.png");
//	    // Music background
//	  	music = new Music("res/Play/Investigations.ogg");
//	  	SoundStore.get().setMusicVolume(0.2f);
// 	    music.loop();
	  	
	}
	
	
	public void render (GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
	{
		g.drawImage(background, 0,0);                                         //draw background
//		g.drawAnimation(S22,(float)shooter.get(controller.level.gameLevel-1).xPos+40,(float)shooter.get(controller.level.gameLevel-1).yPos);      //draw peashooter
		controller.renderPlants(shooter.get(controller.level.gameLevel-1));
//	    g.drawImage(triplet,(float) shooter2.xPos,(float) shooter.get(controller.level.gameLevel-1).yPos);      //draw tripletshooter
//	    g.drawAnimation(S11,(float)sunflower.xPos,(float) sunflower.yPos);    //draw sunflower
		controller.renderSunFlowers(sunflower);
		
		if(delayText<durationText) 
		{
			coming.play();                                     			  //play sound for text
			g.drawImage(text, 80, 300);                                   //draw text
		}
		 
		controller.renderBullet(g);                                 //draw pea bullets										  //draw triplet bullets
		controller.renderZombie(zombieImages, this.count);                    //draw zombies
		controller.renderSun();
		
		this.count+=this.frequencyImage ;                                     //print multiple images to create animation
		if(this.count>10){this.count=0;}
		
		g.setColor(Color.white); 

//      g.drawString("X:  "+shooter.get(controller.level.gameLevel-1).xPos+" Y:  "+shooter.get(controller.level.gameLevel-1).yPos,400,50);         // debug
		g.drawString("X: "+Mouse.getX()+ " Y: " + Mouse.getY(),400,50); 
		g.setColor(Color.white);
//      g.drawString("X2:  "+shooter2.xPos+"Y2:  "+shooter2.yPos, 400,100);    //debug
//		SunBoard.draw(2,35,SunBoard.getWidth()/5,SunBoard.getHeight()/5);						//SunBoard
//		ScoreBoardText.render(35,162, "Score : " +controller.printscore(),Color.red);               

	//	g.drawString("X:  "+shooter.get(controller.level.gameLevel-1).xPos+" Y:  "+shooter.get(controller.level.gameLevel-1).yPos,400,50);         // debug

	    //// Sun board ////  
		addSunBoard(sunboard,ScoreBoardText);
		drawpausebutton(pausebutton);
		drawplaybutton(playbutton);
	}
	
	public void update (GameContainer gc, StateBasedGame sbg, int delta) throws SlickException
	{
		/*
		 *    PEASHOOTER CONTROLLER
		 */
		if (gc.isPaused() == false ) {
			
		Input input = gc.getInput();
		if (input.isKeyDown(Input.KEY_RIGHT)) 								//Move RIGHT
		{
			/*shooter.xPos +=shooter.speed;
			if(shooter.xPos<850) shooter.xPos +=shooter.speed;
			else shooter.xPos=850;*/
			shooter.get(controller.level.gameLevel-1).goRight();
		}
		else if (input.isKeyDown(Input.KEY_LEFT)) 						    //Move LEFT
		{
			/*shooter.xPos -=shooter.speed;
			if(shooter.xPos>200) shooter.xPos -=shooter.speed;
			else shooter.xPos=200;*/
			shooter.get(controller.level.gameLevel-1).goLeft();
		}
		else if (input.isKeyDown(Input.KEY_UP)) 							//Move UP
		{
			/*shooter.yPos -=shooter.speed;
			if(shooter.yPos>200) shooter.yPos -=shooter.speed;
			else shooter.yPos=200;*/
			shooter.get(controller.level.gameLevel-1).goUp();
		}
		else if (input.isKeyDown(Input.KEY_DOWN))                            //Move DOWN
		{
			/*shooter.yPos +=shooter.speed;
			if(shooter.yPos<595) shooter.yPos +=shooter.speed;
			else shooter.yPos=595;*/
			shooter.get(controller.level.gameLevel-1).goDown();
		}
		else if(input.isKeyPressed(Input.KEY_SPACE))                         // press SPACE to shoot
		{
			if(controller.level.gameLevel==1)
			{
				controller.addBullet(new Pea(shooter.get(controller.level.gameLevel-1).xPos+120,shooter.get(controller.level.gameLevel-1).yPos+25));
			}
			else if(controller.level.gameLevel==2)
			{
				controller.addBullet(new FireBullet(shooter.get(controller.level.gameLevel-1).xPos+120,shooter.get(controller.level.gameLevel-1).yPos+25));
			}
			pow.play();
			System.out.println("PEASHOOTER SHOOTING");
		} 
		
		
		
		zombieControl.delayTimeZom+=1;                                                                      //system count 
		if(zombieControl.delayTimeZom==zombieControl.delayZom)                                              //from 0 to delay
		{                        							                                                //to spawn zombies
			controller.addZombie(new Zombies(950,zomInitPos[(int)(Math.random()*5)]));
			zombieControl.delayZom=zombieControl.getDelayTimeZom(zombieControl.maxTime);
			zombieControl.delayTimeZom=0;
		}
		
		sunControll.delayTimeSun+=1;                                                                
		if(sunControll.delayTimeSun==sunControll.delaySun)                                                  //to spawn sun                 
		{                        							 
			controller.addSun(new Sun(sunInitPos[(int)(Math.random()*9)],0));
			sunControll.delaySun=sunControll.getDelayTimeSun(sunControll.maxTime);
			sunControll.delayTimeSun=0;
		}
		
		this.delayText+=delta;
		controller.shoot();
		controller.zomWalk();
		controller.fall();
		controller.onClickSun();
		for(int i=0;i<controller.getZombies().size();i++)
			{
				if(controller.getZombies().get(i) == null) continue;
				controller.zomWalk();
			    controller.clearscore();
			    controller.renderZombie(zombieImages, this.count);
			    controller.checkGame(sbg,controller.getZombies().get(i).xPos);
			}
		}
		Input input = gc.getInput();
		xposition = Mouse.getX();
		yposition = Mouse.getY();		
		if ((xposition > 930 && xposition < 980) && (yposition >677 && yposition < 750 ) ) {
			if (input.isMouseButtonDown(0)) {
				gc.setPaused(true);
			}
			
		}
		
		
		if ((xposition > 863 && xposition < 900) && (yposition >690 && yposition < 736 ) ) {
			if (input.isMouseButtonDown(0)) {
			gc.setPaused(false);
			}
		}
	}
	
	private void addSunBoard(Image png,Text text) throws SlickException {
		png.draw(2,35,png.getWidth()/5,png.getHeight()/5);
		text.render(35, 165,""+controller.printscore(),Color.black);    
	}
	
	private void drawpausebutton (Image png ) {
		png.draw(950,35,png.getWidth()/10,png.getHeight()/10);
	}
	
	private void drawplaybutton (Image png) {
		png.draw(860,25,png.getWidth()/22,png.getHeight()/22);
	}
	public int getID()
	{
        	return 1;	
	}
}
