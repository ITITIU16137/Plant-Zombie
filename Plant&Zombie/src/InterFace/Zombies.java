
public class Zombies {
	protected int hp;
	protected int damage;
	protected int speed;
	
	public Zombies(int hp,int dam,int speed)
	{
		this.hp=hp;
		this.damage=dam;
		this.speed=speed;
	}
	
	public void move()
	{
		
	}
	
	public void attack(Plants plant)
	{
		plant.hp-=this.damage;
	}
	
	public void die()
	{
		
	}
}
