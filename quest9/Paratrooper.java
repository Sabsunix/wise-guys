import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A veteran paratrooper looking to cause some mayhem.
 * 
 * @author (Ben) 
 * @version 10/31/18
 */
public class Paratrooper extends SmoothMover
{
    private static final int GROUND_HEIGHT = CannonWorld.GROUND_HEIGHT - 6;
    public Paratrooper()
    {
        this(new Vector(-45, 6));
    }

    public Paratrooper(Vector velocity)
    {
        super(velocity);
    }

    @Override protected void addedToWorld(World world)
    {
        setLocation(getX(), getY());
    }

    /**
     * Act - do whatever the Paratrooper wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        addToVelocity(Flyerworld.GRAVITY);
        move();
    }  
    
    private void checkHitTarget() 
    {
        Actor target = getOneIntersectingObject(Target.class);
        //getWorld().addObject(new Explosion(), target.getX(), target.getY());
        
        
        if (target != null)
        {
            Flyerworld world = (Flyerworld) getWorld();
            world.addObject(new ParatrooperEnd(), getX(), getY());
            world.removeObject(target);
            world.removeObject(this);
            return; // in case of multiple if statements
            
        }
    
    }
    
    
    
    
}
