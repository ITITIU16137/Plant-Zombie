package Plants;
import java.util.ArrayList;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import Characters.*;

public class Peashooter extends Plants{
	
	private ArrayList<Bullet> bullets=new ArrayList<>();
	Bullet tempBullet;
	
	public static String pngName="res/PeaShooter.png";
	
	public Peashooter(int x, int y)   {super(x, y);}
	
	@Override
	public void render(Graphics g,Image png) {                // draw bullets
		for(int i=0;i<bullets.size();i++)
		{
			tempBullet=bullets.get(i);
			tempBullet.render(g,png);
		}
	}
	
	public void draw(Animation a)
	{
		a.draw((float)xPos+40,(float)yPos);
	}
}
