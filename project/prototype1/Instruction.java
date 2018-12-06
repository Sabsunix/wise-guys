import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Text instructions for the player
 * 
 * @author Cole Tomaro
 * @version 12/5/18
 */
public class Instruction extends HUD
{
    private static final Color transparent = new Color(0,0,0,0);
    private GreenfootImage img;
    
    // Default constructor
    public Instruction()
    {
        this("Sample Text", 22);
    }
    
    // Constructor: specify the message and size
    public Instruction(String message, int size)
    {
        img = new GreenfootImage(message, size, Color.WHITE, transparent);
        setImage(img);
    }
    
    // Constructor: specify the message and color
    public Instruction(String message, Color color)
    {
        img = new GreenfootImage(message, 24, color, transparent);
        setImage(img);
    }
    
    // Constructor: specify the message, size, and color
    public Instruction(String message, int size, Color color)
    {
        img = new GreenfootImage(message, size, color, transparent);
        setImage(img);
    }
    
}
