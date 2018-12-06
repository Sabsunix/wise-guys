import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The enemy that will have the ability to bounce around
 * 
 * @author William Craig 
 * @version 12/6/18
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
     * calls the 2 methods to get this class to work
     */
    public void act() 
    {
        testHeight();
        getCollisionGeneral(25,false);
    }    
    /**
     * tests for a platform class below the bouncing enemy
     */
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
    /**
     * causes the enemy to bounce
     */
    public void bounce()
    {
        setVelocityY(-1*Bounce_Speed);
    }
}
