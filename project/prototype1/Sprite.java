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
        setLocation(x + velocityX, y + velocityY);
    }
    /**
     * Move forward by the specified distance.
     * (Overrides the method in Actor).
     */
    @Override
    public void move(int distance)
    {
        move((double)distance);
    }
    /**
     * Move forward by the specified exact distance.
     */
    public void move(double distance)
    {
        double radians = Math.toRadians(getRotation());
        velocityX = Math.cos(radians) * distance;
        velocityY = Math.sin(radians) * distance;
        move();
    }

    /**
     * Allows precise tracking of the location and eventually calls
     * the built-in 'setLocation' method of Actor.
     *
     * @param x The x-coordinate.
     * @param y The y-coordinate.
     */
    public void setLocation(double x, double y)
    {
        this.x = x;
        this.y = y;
        super.setLocation((int) x, (int) y);
    }

    /**
     * Override the default 'setLocation' method to keep our coordinates
     * up-to-date.
     *
     * @param x The x-coordinate.
     * @param y The y-coordinate.
     */
    @Override
    public void setLocation(int x, int y)
    {
        setLocation((double) x, (double) y);
    }

    /**
     * Returns the double precision value of the x-location.
     *
     * @return The double precision value of the x-location
     */

    public double getExactX()
    {
        return x;
    }

    /**
     * Returns the double precision value of the y-location.
     *
     * @return The double precision value of the y-location
     */
    public double getExactY()
    {
        return y;
    }

    /**
     * Gets the horizontal velocity of this Sprite in
     * pixels per act() call.
     *
     * @return The x horizontal velocity of this Sprite.
     */
    public double getVelocityX()
    {
        return velocityX;
    }

    /**
     * Gets the vertical velocity of this Sprite in
     * pixels per act() call.
     *
     * @return The y velocity of this Sprite.
     */
    public double getVelocityY()
    {
        return velocityY;
    }

    /**
     * Sets the horizontal velocity of this Sprite in
     * pixels per act() call.
     *
     * @param newvelocityX The new x velocity
     */
    public void setVelocityX(double newvelocityX)
    {
        velocityX = newvelocityX;
    }

    /**
     * Sets the vertical velocity of this Sprite in
     * pixels per act() call.
     *
     * @param newVelocityY The new y velocity
     */
    public void setVelocityY(double newVelocityY)
    {
        velocityY = newVelocityY;
    }
}