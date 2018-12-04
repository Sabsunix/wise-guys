import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Image of a door for level map. will also open and close
 * IMAGE = door.png
 *
 * @author Nicholas Anderson
 * @version 1.0, November 18, 2018
 */
public class Door extends Platform
{
    private Nebukar key;
    private static GreenfootImage[] doorOpensImgs;
    private static final int DOOR_COUNT = 3;
    private int currentImage = 0;
    
    public Door()
    {
        initializeImages();
        setImage(doorOpensImgs[0]);
    }

    /**
     * animation of door opening closing?
     */
    public void act() 
    {
        checkKeyDoor();
    }
    
    public void initializeImages()
    {
        if (doorOpensImgs == null)
        {
            doorOpensImgs = new GreenfootImage[DOOR_COUNT];
            for (int i = 0; i < DOOR_COUNT; i++)
            {
                String fileName = "door" + (i + 1) + ".png";
                doorOpensImgs[i] = new GreenfootImage(fileName);
            }
        
        }
    }
    
        /**
     * method to check if player intersects door holding key = true
     * next level
     */
    public void checkKeyDoor()
    {
        key = (Nebukar) getOneIntersectingObject(Nebukar.class);
        if(key != null)
        {
            if(key.hasKey == true)
            {
                Greenfoot.playSound("unlock.wav");
                doorOpens();
            }
            else
            {
                return;
            }
        }
        
    }
    
    public void doorOpens()
    {
        if (currentImage >= DOOR_COUNT) 
        {
            getWorld().removeObject(this);
            nextLevel();
        }
        else 
        {
            setImage(doorOpensImgs[currentImage]);
            currentImage++;
        }
    }
    
        /**
     * method to change player to next level
     */
    public void nextLevel()
    {
        Level_2 world2 = new Level_2();
            Greenfoot.setWorld(world2);
    }
}
    
