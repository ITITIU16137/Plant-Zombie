package plant;
import java.util.ArrayList;
import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

//import Characters.Plants;
import characters.*;

public class Peashooter extends Plants{
	
	private ArrayList<Bullet> bullets=new ArrayList<>();
	Bullet tempBullet;
	
	public static String pngName="res/PeaShooter.png";
	public static Animation png;
	
	public Peashooter(int x, int y) throws SlickException 
	{
		super(x, y);
		init();
	}
	
	public void init() throws SlickException
	{
		png=new Animation(new SpriteSheet(pngName,125,106),20);
	}
	
	public void draw()
	{
		png.draw((float)xPos+40,(float)yPos);
	}
}
