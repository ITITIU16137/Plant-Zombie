package GUI;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.newdawn.slick.openal.SoundStore;

public class Menu extends BasicGameState{
	private Sound sound;
	private Music music;
	private Image start, exit, logo;
	private int delayTime = 0; // this is for
	private int delay = (80);
	public int xpos = Mouse.getX(); // 0-1024
	public int ypos = Mouse.getY(); // 0-768
	private GameContainer gc;
	private Main size;
	public Menu(int state) {}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		//Background Music
		music = new Music("res/Menu/Level1.ogg");
		SoundStore.get().setCurrentMusicVolume(0.9f);
		music.loop();
		// Image button
		start = new Image("res/Menu/Start.png");
		exit = new Image("res/Menu/Exit.png");
		logo = new Image("res/Menu/logo.png");
		// Click sound
		sound = new Sound("res/Menu/click.wav");
		// Cursor
		this.gc = gc;
		Image cursor = new Image("res/cursor/cursor.png");
		gc.setMouseCursor(cursor, 0, 0);
		gc.setTargetFrameRate(15);
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		Image[] Background = new Image[102];  // BackGround //
		String fileLocation = new String();
		for (int i = 1; i < 102; i++) 
		   {
			 fileLocation = "res/background/back (" + i + ").png";
			 Background[i] = new Image(fileLocation);
		   }
		int i = 1;
		for (i = 1; i < 102; i++) 
		{
			this.delayTime += 1;
			if (this.delayTime == delay) 
			  {
				g.drawImage(Background[i], 0, 0);
				delay = (102);
				this.delayTime = 0;
				if (i == 101)
					i = 1;
			  }
		}
		start.draw(430, 310);
		exit.draw(430, 380);
		logo.draw(200, 10);
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		Input input = gc.getInput();
		xpos = Mouse.getX();
		ypos = size.HEIGHT - Mouse.getY();
		/// Start button
		if ((xpos > 430 && xpos < 570) && (ypos > 310 && ypos < 400)) {

			if (input.isMouseButtonDown(0)) {
				gc.setTargetFrameRate(999);
				sound.play();
				sbg.enterState(1);
				
			}
		}

		/// Exit button
		if ((xpos > 430 && xpos < 550) && (ypos > 380 && ypos < 510)) {
			if ((input.isMouseButtonDown(0))) {
				exit.draw(1, 1, 1, 0.5f);
				System.exit(0);
			}
		}
	}

	/// Return menu
	public int getID() {
		return 0;
	}
}
