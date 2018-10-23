import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


/**
 * Write a description of class Visualizer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Visualizer extends Actor
{
    private GreenfootImage image;
    
    public Visualizer()
    {
        image = new GreenfootImage(800, Piano.SCREEN_HEIGHT);
        image.setColor(Color.DARK_GRAY);
        image.fill();
        setImage(image);
    }

    /**
     * Act - do whatever the Visualizer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }

    /**
     * Play imagery when pressing piano keys.
     *
     * @param k The key that was played.
     */
    public void visualize(Key k)
    {
        // Following is the visualization code
        
        int width = k.getImage().getWidth();
        int x = k.getX();
        int drawHeight = image.getHeight() - width / 2;
        int y = Greenfoot.getRandomNumber(drawHeight) + width / 4;
        //Color color = new Color(Greenfoot.getRandomNumber(256), Greenfoot.getRandomNumber(256), Greenfoot.getRandomNumber(256), 128);
        Color color = k.getColor(); // k is the Key parameter
        
        /*Oval shape = new Oval(width, width / 2, color);
        getWorld().addObject(shape, x, y);*/
        
        
        /* Proposed Key order:
         * (leftmost to rightmost, 4 keys per person):
         * 
         * Cole
         * Ben
         * Nick
         * William
         * Nathaniel
        */
       
       
        // Cole's section: spawn a triangle
        if (k.key == "A" || k.key == "W" || k.key == "S" || k.key == "E")
        {
            Triangle t = new Triangle();
            getWorld().addObject(t, x, 195);
        }
        
        else if (k.key == "D" || k.key == "F" || k.key == "T" || k.key == "G")
        {
            Oval shape = new Oval(width, width / 2, color);
            getWorld().addObject(shape, x, y);
        }
        
        else if (k.key == "Y" || k.key == "H" || k.key == "U" || k.key == "J")
        {
            Oval shape = new Oval(width, width / 2, color);
            getWorld().addObject(shape, x, y);
        }
        
        else if (k.key == "K" || k.key == "O" || k.key == "L" || k.key == "P")
        {
            Oval shape = new Oval(width, width / 2, color);
            getWorld().addObject(shape, x, y);
        }
        
        else if (k.key == ";" || k.key == "'" || k.key == "]" || k.key == "\\")
        {
            Oval shape = new Oval(width, width / 2, color);
            getWorld().addObject(shape, x, y);
        }
        

    }
}
