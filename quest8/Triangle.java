import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Triangle here.
 * 
 * @author Cole Tomaro
 * @version 10/23/2018
 */
public class Triangle extends Actor
{
    //public int[] x1 = {0, 24, 49}; // original x coords
    //public int[] y1 = {49, 0, 49}; // original y coords
    public int[] x1 = {0, 49, 0}; // fixed x coords for -90 rotation
    public int[] y1 = {0, 24, 49}; // fixed y coords for -90 rotation
    public int tMoveSpeed = 5; // speed at which it moves
    
    public Triangle()
    {
        GreenfootImage image = new GreenfootImage(50, 50);
		
        setRotation(-90); // spawns facing upwards
        
        image.setColor(Color.RED); // make this vary for key press?
        image.fillPolygon(x1, y1, x1.length);
        
        setImage(image);
    }
    
    /**
     * Act - do whatever the Triangle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        tMove();
    }
	
    /**
     * tMove - move at tMoveSpeed until it hits the top of the world
     * in which case, remove the object.
     */
    public void tMove()
    {
        if (getY() > 0)
        {
             move(tMoveSpeed);
        }
        else
        {
            getWorld().removeObject(this); 
        }
    }
}
