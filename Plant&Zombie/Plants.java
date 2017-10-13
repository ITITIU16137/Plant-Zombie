
public class Plants {
	protected int hp;
	protected int damage;
	
	public Plants(int hp,int dam)
	{
		this.hp=hp;
		this.damage=dam;
	}
	
	public void shoot()
	{
		
	}
	
	public void shootZom(Zombies zom)
	{
		zom.hp-=this.damage;
	}
	
	public void die()
	{
		
	}
}
