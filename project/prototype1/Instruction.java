import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Text instructions for the player
 * 
 * @author Cole Tomaro
 * @version 11/19/18
 */
public class Instruction extends HUD
{
    private static final Color transparent = new Color(0,0,0,0);
    private GreenfootImage img;
    
    public Instruction()
    {
        this("Sample Text", 22);
    }
    
    public Instruction(String message, int size)
    {
        img = new GreenfootImage(message, size, Color.BLACK, transparent);
        setImage(img);
    }
    
    /*public void setText(String x)
    {
        message = x;
    }*/
}
