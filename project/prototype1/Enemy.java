import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Superclass for all Enemies
 * 
 * @author William Craig
 * @version 11/29/18
 */
public class Enemy extends Sprite
{
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void getCollisionGeneral() 
    {
        if(isTouching(Hammer.class)){
            //play death sound?
            getWorld().removeObject(this);
        }
        if(isTouching(Shield.class)){
            Actor Shield = getOneIntersectingObject(Shield.class);
            getWorld().removeObject(Shield);
            getWorld().removeObject(this);
        }
        else if(isTouching(Nebukar.class)){
            Actor Nebukar = getOneIntersectingObject(Nebukar.class);
            getWorld().removeObject(Nebukar);
        }
    }
}
