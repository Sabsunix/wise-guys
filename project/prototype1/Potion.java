import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Potion here.
 * 
 * @author Nathaniel Larsen
 * @version 11/16/18
 */
public class Potion extends Items
{
    private final int HEAL = 50, MAX = 100;
    /**
     * Act - do whatever the Potion wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkPlayer();
    }    
    public void checkPlayer()
    {
        Nebukar p = (Nebukar) getOneIntersectingObject(Nebukar.class);
        if (p != null){
            if(p.getHealth() < MAX){
                p.setHealth(p.getHealth() + HEAL);
                if (p.getHealth() > MAX){
                    p.setHealth(MAX);
                }
                getWorld().removeObject(this);
            }
        } 
    }
}