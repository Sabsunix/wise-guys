import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The enemy that will shoot
 * 
 * @author William Craig 
 * @version 12/6/18
 */
public class Enemy_shooting extends Enemy
{
    public static final int timer=50;
    public int timers=0;
    public int direction;
    public int directi;
    /**
     * initializes the enemy with a specific direction
     */
    public Enemy_shooting()
    {
        this(0);
    }
    /**
     * initializes the enemy with a direction
     */
    public Enemy_shooting(int direct)
    {
        direction=direct;
        if (direct==1){
            GreenfootImage image = new GreenfootImage("Shootingleft.png");
            setImage(image);
        }
        else{
            GreenfootImage image = new GreenfootImage("Shooting.png");
            setImage(image);
        }
    }
    /**
     * calls the 2 methods to make the program work
     */
    public void act() 
    {
        timer();
        getCollisionGeneral(10,false);

    }    
    /**
     *times ever bullet fired by the class
     */
    public void timer()
    {
        if (timers==timer)
        {
            Shoot();
            timers=0;
        }
        else
        {
            timers++;
        }
    }
    /**
     * shoots a projectile when the timer hits the set time
     */
    public void Shoot()
    {
        
        if (direction==1)
        {
            directi=1;
        }
        if (direction==0)
        {
            directi=-1;
        }
        getWorld().addObject(new Enemy_projectile(direction), getX()-directi*17 , getY());
    }
}
