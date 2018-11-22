import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Sprite class for movers
 * 
 * @author Nathaniel
 * @version Prototype
 */
public abstract class Sprite extends Actor
{
    /*
       needs variables : gravity 
             methods : move() <implemented>, applyGravity()
          why is check health in this method? 
          is it just checking the player's health?
          nebukar has a getHealth() method that returns his health int
       */
    private double x = 0;
    private double y = 0;
    private double velocityX; // in pixels per act() call
    private double velocityY; // in pixels per act() call 
    /**
     * Constructor that sets velocity of the sprite.
     *
     * @param newVelocityX The x component of the velocity.
     * @param newVelocityY The y component of the velocity.
     **/
    public Sprite ()
    {
        this(0.0, 0.0);
    }

    public Sprite(double velocityX, double velocityY)
    {
        this.velocityX = velocityX;
        this.velocityY = velocityY;
    }

    public void checkHealth()
    {

    }

    /**
     * Act - do whatever the N_Sprite wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    

    /**
     * Move based on velocity.
     */
    public void move()
    {

    }
}