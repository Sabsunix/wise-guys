import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * A triangle that moves up to the top of the screen.
 * 
 * @author Cole Tomaro
 * @version 10/23/2018
 */
public class Triangle extends Actor
{
    public int width;
    public int height;
    
    public static int colorIndex = 0; // int at which the colorArray accesses
    // array of colors to cycle through
    Color[] colorArray = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, Color.MAGENTA};
    
    public int[] x1 = {0, 24, 49}; // original x coords
    public int[] y1 = {49, 0, 49}; // original y coords
    //public int[] x1 = {0, 49, 0}; // fixed x coords for -90 rotation
    //public int[] y1 = {0, 24, 49}; // fixed y coords for -90 rotation
    public int tMoveSpeed = 5; // speed at which it moves
    
    
    public Triangle()
    {
        this(50, 50);
    }
    
    public Triangle(int width, int height)
    {
        this.width = width;
        this.height = height;
        GreenfootImage image = new GreenfootImage(width, height);
        
        //setRotation(-90); // spawns facing upwards
        
        image.setColor(colorArray[colorIndex]); // sets the shape's color to the current value of colorIndex
        updateColor(); // colorIndex++
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
        List<Triangle> triangles = getWorld().getObjects(Triangle.class);
        for (Triangle triangle : triangles)
        {
            turn(4);
        }
        if (getY() > 0)
        {
             setLocation(getX(), getY() - tMoveSpeed);
        }
        else
        {
            getWorld().removeObject(this); 
        }
    }
    
    /**
     * (Increments / Assigns 0 to) the static int variable colorIndex
     */
    public void updateColor()
    {
        //System.out.println(colorIndex);
        if (colorIndex < colorArray.length - 1)
        {
            colorIndex++;
        }
        else
        {
            colorIndex = 0;
        }
    }
}
