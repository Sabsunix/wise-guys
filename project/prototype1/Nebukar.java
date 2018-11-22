import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The hero and main character! The player controls Nebukar to advance through the gauntlet using
 * the arrow keys and spacebar.
 * 
 * @author (Ben Smith and Ed Parrish) 
 * @version Prototype
 */
public class Nebukar extends Sprite
{
    private static final double MOVE_SPEED = 2.50;
    private static final double GRAVITY = 0.5;
    private static final int RIGHT = 0;
    private static final int LEFT = 0;
    private static boolean facingLeft;
    private boolean canJump; // Jumping is allowed when true
    private static GreenfootImage faceRight;
    private static GreenfootImage faceLeft;

    private int health;
    private boolean shielded;
    public boolean hasKey;
    /**
     * Constructor for the main character
     */
    public Nebukar()
    {
        canJump = true; 
        facingLeft = true;
        shielded  = false;
        hasKey = false;
    }

    /**
     * Move and interact
     */
    public void act() 
    {
        jump();
        attack();
        stopMoving();
    }    

    public void keyPress()    
    {
        if (Greenfoot.isKeyDown("right"))
        {
            move(2);
            facingLeft = false;
        }
        else if (Greenfoot.isKeyDown("left"))
        {
            move(-2);
            facingLeft = true;
        }
        else
        {
            stopMoving();
        }
        if (Greenfoot.isKeyDown("space"))
        {
            jump();
        }
    }

    /**
     * Propels Nebukar upwards.
     */
    public void jump()
    {

    }

    /**
     * Attacks with a mighty weapon!
     */
    public void attack()
    {

    }

    /**
     * Stops Nebukar.
     */
    public void stopMoving()
    {

    }

    /**
     * Centers camera on Nebukar.
     */
    public void checkCam() 
    {

    }

    /**
     * Animates run.
     */
    public void animate()
    {

    }

    /**
     * Method for enchantment pickup.
     */
    public void pickUp()
    {
    }

    /**
     * Checks if Nebukar has the key for unlock the door.
     */
    public void keyCheck()
    {

    }

    public boolean getLeftFacing()
    {
        return facingLeft;
    }

    public int getHealth(){
        return health;
    }

    public void setHealth(int newHealth){
        health = newHealth;
    }

    public void hasShield(){
        shielded = true;
        //set images to shielded versions
    }

    public void noShield(){
        shielded = false;
        //back to base image
    }

    public boolean isShielded(){
        return shielded;
    }
    
    /**
    * move method imported from Player class to allow player to stay centered
    * while the world and all actors scroll left & right accordingly with user
    * input movement.
    * 
    * -requires scrollHorizontal to be implemented in world class
    */
   
    public void move()
    {
        //super.move();
        //double dx = getVelocityX();
        Level1 w = (Level1) getWorld();
        //if (w == null || dx == 0)
        {
            return;
        }
        // w.scrollHorizontal(dx);
        //setLocation(w.getWidth() / 2, getY()); // stay in horizontal center
    }
}