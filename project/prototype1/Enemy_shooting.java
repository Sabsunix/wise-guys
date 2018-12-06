import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The enemy that will shoot
 * 
 * @author William Craig 
 * @version 11/29/18
 */
public class Enemy_shooting extends Enemy
{
    public static final int timer=50;
    public int timers=0;
    public int direction;
    public Enemy_shooting(int direct)
    {
        direction=direct;
    }
    /**
     * Act - do whatever the Enemy_shooting wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        timer();
        getCollisionGeneral(10,false);

    }    
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
    public void Shoot()
    {
        getWorld().addObject(new Enemy_projectile(direction), getX() , getY());
    }
}
