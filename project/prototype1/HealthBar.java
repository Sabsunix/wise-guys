import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Displays the player's health
 * 
 * @author Cole Tomaro
 * @version 11/19/18
 */
public class HealthBar extends Actor
{
    public static final int HEIGHT = 25;
    int health;
    GreenfootImage barFill = new GreenfootImage(100 + 1, HEIGHT + 1);
    Level1 w = (Level1) getWorld();
    
    public HealthBar()
    {
        barFill.setColor(Color.RED);
        barFill.fillRect(0, 0, 100, HEIGHT); //edit this
        setImage(barFill);
    }
    
    public void setSize(int number)
    {
        health = number;
        draw();
    }
    
    public void draw()
    {
        barFill.clear();
        barFill.fillRect(0, 0, health, HEIGHT);
        setImage(barFill);
    }
}
