import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A bomb that goes boom
 * 
 * @author Nathaniel Larsen 
 * @version 10.28.18
 */
public class Bomb extends SmoothMover
{
     
    public Bomb()
    {
        this(new Vector(0, 3));
    }
    public Bomb(Vector burst)
    {
        super(burst);
        Greenfoot.playSound("bomb-fall.wav");
    }
    /**
     * Act - do whatever the bomb wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        addToVelocity(Flyerworld.GRAVITY);
        move();
        explode();
        
    }
    
    public void explode()
    {
        if (getOneIntersectingObject(Target.class) !=null){
                removeTouching(Target.class);
                getWorld().addObject(new Boom(), getX(), getY());
            }
        if (getY() > getWorld().getHeight() - 32) {
            getWorld().addObject(new Boom(), getX(), getY() - 2);
            getWorld().removeObject(this);
        }
    }
}
