import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The enemy that will have the ability to bounce around
 * 
 * @author William Craig 
 * @version 11/29/18
 */
public class Enemy_bouncing extends Enemy
{
    private static final double Bounce_Speed = 12;
    private static final double GRAVITY = 0.5;
    GreenfootImage image1 = new GreenfootImage("Slime0.png");
    GreenfootImage image2 = new GreenfootImage("Slime1.png");
    private int counter=5;
    //private int sound=0;
    /**
     * Act - do whatever the Enemy_bouncing wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        testHeight();
        getCollisionGeneral(25,false);
    }    

    public void testHeight()
    {

        if(getOneObjectAtOffset(0,16,Platform.class)!=null)
        {
            setVelocityY(-1*Bounce_Speed);
            setImage(image1);
            counter=0;
            //if (sound==50){
            //    Greenfoot.playSound("Slime bounce.wav");
            //    sound=0;
            //}
            //sound++;
        }
        double velocityY = getVelocityY() + GRAVITY; 
        setVelocityY(velocityY);  
        move();
        if (counter==5){
            setImage(image2);
        }
        else{
            counter++;
        }

    }

    public void bounce()
    {
        setVelocityY(-1*Bounce_Speed);
    }
}
