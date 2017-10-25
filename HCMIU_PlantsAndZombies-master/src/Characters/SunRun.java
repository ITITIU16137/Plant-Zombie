package Characters;

import GUI.*;
import Characters.*;

import org.newdawn.slick.*;
import java.util.ArrayList;

public class SunRun {
	
	private ArrayList<Sun> sun=new ArrayList<>();
	Sun tempSun;
	Main screen;

	public void run()                        
	{
		for(int i=0;i<sun.size();i++)             //shoot all the bullets in the list
		{
			tempSun=sun.get(i);
			tempSun.flying();
			
			if(tempSun.xPos>screen.WIDTH)       // remove bullets out of screen
			{
				sun.remove(tempSun);
			}
		}
	}
	
	public void render(Graphics g,Image png)              // draw bullets
	{
		
		for(int i=0;i<sun.size();i++)
		{
			tempSun=sun.get(i);
			tempSun.draw(g,png);
		}
	}
	
	public void addSun(Sun b)
	{
		sun.add(b);
	}
	
	public void removeSun(Sun b)
	{
		sun.remove(b);
	}
	
}
