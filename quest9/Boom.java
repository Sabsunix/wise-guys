import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The boom from a bomb. punches holes in the world
 * 
 * @author Nathaniel Larsen 
 * @version 10.28.18
 */
public class Boom extends Actor
{
    private int spin;
    private boolean rev = false;
    private int imgNum = 11;
    private static GreenfootImage imgs[] = new GreenfootImage[12];
    public Boom()
    {
        this(Greenfoot.getRandomNumber(180) - 90);
    }

    public Boom(int degrees)
    {
        setFrames();
        setImage(imgs[imgNum]);
        setRotation(degrees);
        spin = degrees;
        if (degrees < 0){
            rev = true;
        }
    }

    /**
     * Act - do whatever the Boom wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        animate();

        if (imgNum < 0)
        {
            getWorld().removeObject(this);
        }
    }   

    public void setFrames() 
    {
        GreenfootImage std = new GreenfootImage("boom.png");
        for (int i = imgNum; i >= 0; i--){
            int size = (i+1) * ( std.getWidth() / 12);
            imgs[i] = new GreenfootImage(std);
            imgs[i].scale(size, size);
        } 
    }

    public void animate()
    {
        if (rev){
            turn(-spin);
        } else {
            turn(spin);
        }
        setImage(imgs[imgNum]); 
        imgNum--;
    }
}