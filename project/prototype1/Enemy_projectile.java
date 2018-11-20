import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The projectile the shooting enemy will shoot
 * 
 * @author William Craig
 * @version 11/20/18
 */
public class Enemy_projectile extends Sprite
{
    /**
     * Act - do whatever the Enemy_projectile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        Actor p = getOneIntersectingObject(Platform.class);
        if (p != null)
        {
            World world = getWorld();
            world.removeObject(this);
        }
    }    
}
