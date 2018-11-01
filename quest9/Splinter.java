import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A wooden splinter that spins. Purely cosmetic.
 * Several of these spawn when a rocking horse hits the ground.
 * 
 * @author Cole Tomaro
 * @version 10/31/2018
 */
public class Splinter extends SmoothMover
{
    private int timer; // Timer variable that keeps track of how long the object has existed.
    public static final int TIMELIMIT = 70; // Number that determines how long the object should exist for.
    
    // Default constructor
    public Splinter()
    {
        this(new Vector(0, 3));
    }
    
    // Constructor with Vector parameter
    public Splinter(Vector v)
    {
        super(v);
        timer = 0;
    }
    
    // Act
    public void act()
    {
        addToVelocity(MyWorld.GRAVITY);
        move();
        turn(5); // Makes splinter spin
        
        // Keeps stick above ground
        if (getY() > 324) {
            setLocation(getX(), 325);
        }
        
        despawn();
    }
    
    /**
     * Despawns the splinter if it goes offscreen (horizontally)
     * or exists for too long.
     */
    private void despawn()
    {
        // Remove splinter if it goes past X boundaries
        if (getX() < 1 || getX() > 599)
        {
            getWorld().removeObject(this);
        }
        
        if (timer > TIMELIMIT) // If the timer is greater than the time limit...
        {
            getWorld().removeObject(this); // Remove the splinter
            timer = 0; // Set timer to 0
        }
        else
        {
            timer++; // Increment timer
        }
    }
}
