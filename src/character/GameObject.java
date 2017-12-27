package characters;
import java.awt.Rectangle;

public class GameObject {
	public double xPos,yPos;

	public GameObject(double d,double e)
	{
		this.xPos=d;
		this.yPos=e;
	}
	public GameObject() {
		// TODO Auto-generated constructor stub
	}
	public Rectangle getBounds(int width,int height)
	{
		return new Rectangle((int)xPos,(int)yPos,width,height);
	}
	
	public double getxPos()          {return xPos;}
	public void setxPos(double xPos) {this.xPos = xPos;}
	public double getyPos()          {return yPos;}
	public void setyPos(double yPos) {this.yPos = yPos;}
}
