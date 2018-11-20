import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Sprite
{
    private int health;
    private boolean shielded = false;
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
    
    /**
    * add this method here to compliment similar method in world that allows player to side scroll in unbound world
    * while player stays fixed in center of screen.
    */
   
    public void move()
    {
        //super.move();
        //double dx = getVelocityX();
        Level1 w = (Level1) getWorld();
        //if (w == null || dx == 0)
        {
            return;
        }
        // w.scrollHorizontal(dx);
        //setLocation(w.getWidth() / 2, getY()); // stay in horizontal center
    }
}