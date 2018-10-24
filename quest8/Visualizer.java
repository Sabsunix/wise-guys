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
    
    }

    /**
     * Play imagery when pressing piano keys.
     *
     * @param k The key that was played.
     */
    public void visualize(Key k)
    {
        int width = k.getImage().getWidth();
        int x = k.getX();
        int drawHeight = image.getHeight() - width / 2;
        int y = Greenfoot.getRandomNumber(drawHeight) + width / 4;
        Color color = k.getColor(); // k is the Key parameter
        

        // -------------------------------------------------------------
        /*
         * From here on out, the method determines what subclass to display
           based on what key on the keyboard is pressed 
           (using the key instance variable in the Key class)
        
        * It's not that elegant, it could be more effecient, but it works.


         * Proposed Key order:
         * (leftmost to rightmost, including black keys, 4 keys per person)
         
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
            // Someone's subclass goes here
        }
        
        else if (k.key == "Y" || k.key == "H" || k.key == "U" || k.key == "J")
        {
            // Someone's subclass goes here
        }
        
        else if (k.key == "K" || k.key == "O" || k.key == "L" || k.key == "P")
        {
            // Someone's subclass goes here
        }
        
        else if (k.key == ";" || k.key == "'" || k.key == "]" || k.key == "\\")
        { //Nathaniel's Section. spawns the 10.5hz wave.
            int startHeight = image.getHeight() / 2;
            GreenfootImage img1 = new GreenfootImage("wave.png");
            Oscillioscope wave = new Oscillioscope(img1);
            getWorld().addObject(wave, getImage().getWidth() / 2, startHeight);
        }
        

    }
}
