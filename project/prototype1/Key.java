import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A Key to unlock the Door
 * 
 * @author Nathaniel Larsen 
 * @version 11.21.18
 */
public class Key extends Items
{
    private Nebukar player;
    
    /**
     * Wait to be picked up
     */
    public void act() 
    {
        checkPlayer();
    } 

    /**
     * Check if there's a player touching the key
     * if there is, set the player's hasKey boolean to true and disappear.
     */
    public void checkPlayer()
    {
        //Get a reference to the Nebukar touching the key, if one is
        player = (Nebukar) getOneIntersectingObject(Nebukar.class);
        if (player != null){
            //set that Nebukar to be holding the key
            player.hasKey = true;  
            getWorld().removeObject(this);
        }
    }
}
