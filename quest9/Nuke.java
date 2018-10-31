import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A nuclear bromb that drops to ground towards a target.
 * 
 * @author Nicholas Anderson
 * @version 1.0
 * @date October 30th, 2018
 */
public class Nuke extends SmoothMover
{
    public Nuke()
    {
        this(new Vector(0, 1));
    }
    public Nuke(Vector velocity)
    {
        super(velocity);
    }
    /**
     * Nuke bomb falls util upon contact explodes
     */
    public void act() 
    {
        addToVelocity(MyWorld.GRAVITY);
        move();
        explode();
    } 
    
        public void explode()
    {
        if (getOneIntersectingObject(Target.class) !=null){
                removeTouching(Target.class);
                getWorld().addObject(new NukesEnd(), getX(), getY());
                getWorld().removeObject(this);
            }
        if (getY() > 324) {
            getWorld().addObject(new NukesEnd(), getX(), getY() - 2);
            getWorld().removeObject(this);
        }
    }
}
