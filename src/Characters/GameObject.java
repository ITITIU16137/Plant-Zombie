package Characters;
import java.awt.Rectangle;
//import org.newdawn.slick.*;
public class GameObject {
	
	public double xPos,yPos;
	
	public GameObject(double d,double e)
	{
		this.xPos=d;
		this.yPos=e;
	}
	public Rectangle getBounds(int width,int height)
	{
		return new Rectangle((int)xPos,(int)yPos,width,height);
	}
	
	public double getxPos() {
		return xPos;
	}
	public void setxPos(double xPos) {
		this.xPos = xPos;
	}
	public double getyPos() {
		return yPos;
	}
	public void setyPos(double yPos) {
		this.yPos = yPos;
	}
}
