import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The projectile the shooting enemy will shoot
 * 
 * @author William Craig
 * @version 11/29/18
 */
public class Enemy_projectile extends Enemy
{
    /**
     * Act - do whatever the Enemy_projectile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Enemy_projectile(int direction)
    {
        int direct = direction;
        speed(direct);
    }
    public void act() 
    {
        move();
        getCollisionGeneral(50,true);
    }    
    public void speed(int direct)
    {
        if(direct==1)
        {
            setVelocityX(-16);
        }
        else
        {
            setVelocityX(16);
        }
    }
}
