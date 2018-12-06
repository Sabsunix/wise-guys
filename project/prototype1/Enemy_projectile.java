import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The projectile the shooting enemy will shoot
 * 
 * @author William Craig
 * @version 12/6/18
 */
public class Enemy_projectile extends Enemy
{
    /**
     * this constructer sets the direction of the projectile, and then calls the speed method
     */
    public Enemy_projectile(int direction)
    {
        int direct = direction;
        
        speed(direct);
        
    }
    /**
     * calls the different methods that make the program work
     */
    public void act() 
    {
        move();
        getCollisionGeneral(40,true);
    }    
    /**
     * sets the speed of the projectile based on the direction variable
     */
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
