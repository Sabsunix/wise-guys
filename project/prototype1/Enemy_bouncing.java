import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The enemy that will have the ability to bounce around
 * 
 * @author William Craig 
 * @version 11/29/18
 */
public class Enemy_bouncing extends Enemy
{
    private static final double Bounce_Speed = 12;
    private static final double GRAVITY = 0.5;
    /**
     * Act - do whatever the Enemy_bouncing wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        testHeight();
        getCollisionGeneral();
    }    
    public void testHeight()
    {
        if(getY()>=293)
        {
            setVelocityY(-1*Bounce_Speed);
        }
        double velocityY = getVelocityY() + GRAVITY; // add gravity
        setVelocityY(velocityY);  // save current velocity
        move();
    }
    public void bounce()
    {
        setVelocityY(-1*Bounce_Speed);
    }
}
