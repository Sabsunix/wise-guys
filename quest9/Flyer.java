import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Flyer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Flyer extends SmoothMover
{
    private int bombTime = 0, bombReset = 300;
    /**
     * Act - do whatever the Flyer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Flyer(){
        addToVelocity(new Vector(0, 5.8));
    }
    public void act() 
    {
        move();
        bombTime++;
        if (Greenfoot.isKeyDown("\\") && bombTime >= bombReset) 
        {
            dropBomb();
            bombTime = 0;
        }
        
        // Add your action code here.
    }    
    
    public void dropBomb()
    {
        Bomb bomb  = new Bomb(new Vector(30, getSpeed()));
        getWorld().addObject(bomb, getX(), getY());
    }
}
