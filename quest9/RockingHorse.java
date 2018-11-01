import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A rocking horse that destroys targets
 * and crashes into wooden splinters when it hits the ground.
 * 
 * @author Cole Tomaro
 * @version 10/31/2018
 */
public class RockingHorse extends SmoothMover
{
    int spinSpeed;
    
    // Default constructor
    public RockingHorse()
    {
        this(new Vector(280, 3));
    }
    
    // Constructor with Vector parameter
    public RockingHorse(Vector v)
    {
        super(v);
        spinSpeed = Greenfoot.getRandomNumber(10) + 1; // Makes a unique random spin speed
        Greenfoot.playSound("horse.wav"); // Play sfx
    }
    
    // Act
    public void act() 
    {
        addToVelocity(MyWorld.GRAVITY); // Apply gravity
        move();
        turn(spinSpeed); // Spin
        collide();
    }
    
    public void collide()
    {
        // Destroys targets
        if (getOneIntersectingObject(Target.class) !=null)
        {
            removeTouching(Target.class);
        }
        
        if (getY() > 324) // When it hits the ground...
        {
            explode(5);
            getWorld().removeObject(this);
        }
    }
    
    /**
     * Creates an explosion of splinters by spawning X amount.
     * When spawned, they fly in random directions.
     */
    public void explode(int splinters)
    {
        World w = getWorld();
        for (int i = 0; i < splinters; i++)
        {
            int dx = Greenfoot.getRandomNumber(120) + 210; // Generate a random direction from 210-330 degrees
            int dy = Greenfoot.getRandomNumber(9) + 1; // Generate a random velocity (that's over 0)
            w.addObject(new Splinter(new Vector(dx, dy)), getX(), getY()); // Add splinter to world with random vector properties
        }
    }
}
