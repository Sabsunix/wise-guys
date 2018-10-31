import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Mushroom cloud explosion
 * 
 * @author Nicholas Anderson 
 * @version 1.0
 * @date October 30th, 2018
 */
public class NukesEnd extends Actor
{
    private static final int NUMBER_IMAGES= 10;
    private static GreenfootImage[] images;
    private int currentImage = 0;
    
    public NukesEnd() 
    {
        initializeImages();
        setImage(images[0]);
    }
    /**
     * Act - nuclear explosion
     */
    public void act() 
    {
        grow();
    }
    
    public void initializeImages() 
        {
            if (images == null) 
            {
            GreenfootImage baseImage = new GreenfootImage("mushroom.png");
            images = new GreenfootImage[NUMBER_IMAGES];
            for (int i = 0; i < NUMBER_IMAGES; i++) 
                {
                  int size = (i+1) * ( baseImage.getWidth() / NUMBER_IMAGES );
                  images[i] = new GreenfootImage(baseImage);
                  images[i].scale(size, size);
                }
            }
        }
        
    private void grow()
    {
        if (currentImage >= NUMBER_IMAGES) 
        {
            getWorld().removeObject(this);
        }
        else 
        {
            setImage(images[currentImage]);
            currentImage++;
        }
    }
    }
