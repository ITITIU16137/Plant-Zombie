package Event;
import Characters.*;

import java.util.ArrayList;

public class Physic 
{	
	public boolean Collision(Bullet b,ArrayList<Zombies> z)
	{
		for(int i=0;i<z.size();i++)
		{
			if(b.getBounds(20,20).intersects(z.get(i).getBounds(450/3,519/3)))
			{
				return true;
			}
		}
		return false;
	}

	public boolean Collision(Zombies z,ArrayList<Bullet> b)
	{
		for(int i=0;i<b.size();i++)
		{
			if(z.getBounds(450/3,519/3).intersects(b.get(i).getBounds(20,20)))
			{
				return true;
			}
		}
		return false;
	}
	
}
