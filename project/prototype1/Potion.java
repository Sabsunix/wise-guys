import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A potion to heal Nebukar
 * 
 * @author Nathaniel Larsen
 * @version 12.4.18
 * 
 * img credit: zeldapedia
 *  
 * sound credit: soundeffectsplus.com 
 *  
 */
public class Potion extends Items
{
    private final int HEAL = 50, MAX = 100;
    private Nebukar p;
    
    /**
     * Check for a player to heal.
     */
    public void act() 
    {
        checkPlayer();
    }    
    
    /**
     * Check if there's a player touching the potion and if there is, 
     * heal the player, play a sound, and disappear.
     *
     * needs glug.wav
     */
    public void checkPlayer()
    {
        p = (Nebukar) getOneIntersectingObject(Nebukar.class);
        if (p != null){
            Level1 w = (Level1) getWorld();
            HealthBar hb = (HealthBar) w.getHealthBar();
            if(p.getHealth() < MAX){
                p.setHealth(p.getHealth() + HEAL);
                if (p.getHealth() > MAX){
                    p.setHealth(MAX);
                }
                hb.setSize(p.getHealth());
                Greenfoot.playSound("clink.wav");
                getWorld().removeObject(this);
            }
        } 
    }
}
