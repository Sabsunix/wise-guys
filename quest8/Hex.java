import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * A Hexagon.
 * 
 * @author (Ben Smith) 
 * @version 10/25/18
 */
public class Hex extends Actor
{
    int width;    
    int height;
    
    private Color keyColor = Color.CYAN;
    private Color[] colors = {Color.RED, Color.BLUE};
    GreenfootImage image = new GreenfootImage(50, 50);

    public Hex()
    {

        this(50,50,new Color(0,0,0));
        
    }

    public Hex(int width, int height, Color color)
    {
        GreenfootImage image = new GreenfootImage(width, height);
        int[] x1 = {40, 49, 40, 10, 0, 10};
        int[] y1 = {0, 25, 49, 49, 25, 0};
        image.fillPolygon(x1, y1, x1.length);
        image.setColor(color);        
        setImage(image);

    }

    /**
     * Act - do whatever the Hex wants to do
     */
    public void act() 
    {        
        int delta = getImage().getTransparency();
        if (delta > 8)
        {
            getImage().setTransparency(delta - 2);
        }
        else
        {
            getWorld().removeObject(this);
        }

    }   

    public Color getColor()
    {
        return keyColor;
    }

    public void setColor(Color newColor)
    {
        keyColor = newColor;
    }
}
