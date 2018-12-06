import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * wins the game
 * 
 * @author William Craig
 * @version 12/6/18
 */
public class Win extends Actor
{
    /**
     * Act - do whatever the Win wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(isTouching(Nebukar.class))
        {
            getWorld().addObject(new Instruction("You Win!", 64), 200, 200);
            getWorld().addObject(new Button("Play Again?"), 200, 250);
            getWorld().removeObject(this);
        }
    }    
}
