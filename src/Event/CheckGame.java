package Event;
import org.newdawn.slick.*;
import Characters.*;
public class CheckGame extends Zombies{
	Zombies tempZombie;
	public CheckGame(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	/*
	 * 	Check Gameover when reach backyard
	 */
	public boolean reachHouse(){                              
		if(tempZombie.xPos<165) return false;
		else return true;
	}
}
