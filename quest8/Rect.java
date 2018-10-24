import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Rect here.
 * 
 * @author Nick Anderson
 * @version v1.0 10.23.18
 */

public class Rect extends Actor
{
    //private Color[] colors = {Color.RED, Color.GREEN, Color.BLUE};
    //private Color color;
         public Rect()
        {
            this(50, 25, new Color(0, 180, 0));
        }
    /**
       * Rect Constructor
         *
          * @param width  The width of the rect.
            * @param height  The height of the rect.
               * @param color  The color of the rect.
                 */
        public Rect(int width, int height, Color color)
    {
        
        GreenfootImage image = new GreenfootImage(width, height);
        image.setColor(color);
        image.fillRect(0, 0, width, height);
        setImage(image);
    }

    public void act() 
    {
        // Add your action code here.
        /**
         * create an array with colors list
         * and a for each loop that cycles through the color list
         */
        
        
    }    
}
