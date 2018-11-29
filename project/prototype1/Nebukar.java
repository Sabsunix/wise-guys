import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The hero and main character! The player controls Nebukar to advance through the gauntlet using
 * the arrow keys and spacebar.
 * 
 * @author (Ben Smith and Ed Parrish) 
 * @version 1.1
 */
public class Nebukar extends Sprite
{
    private static final double MOVE_SPEED = 3.50;
    private static final double GRAVITY = 0.5;
    private static final int MAX_HEALTH = 100;
    //private static final int RIGHT = 0;
    //private static final int LEFT = 1;

    private static boolean facingLeft;
    private boolean canJump; // Jumping is allowed when true

    //Array Cache    
    private static final int MOVECOUNT = 0; //sets animmation counter to 0
    private static GreenfootImage[] image;

    private int health;
    private boolean shielded, armed;
    public boolean hasKey;

    /**
     * Constructor for the main character: Neb
     */
    public Nebukar()
    {
        canJump = true; 
        facingLeft = true;
        shielded  = false;
        hasKey = false;
        armed = false;
        health = MAX_HEALTH;

        initializeImages();

        //placeholders for images. will have potentially 6 images.
        image = new GreenfootImage[2];
        image[0] = new GreenfootImage ("Nebukar-Right.png");
        image[1] = new GreenfootImage ("Nebukar-Left.png");
        // image[2] = new GreenfootImage ("");
        // image[3] = new GreenfootImage ("");
        // image[4] = new GreenfootImage ("");
        // image[5] = new GreenfootImage ("");
    }

    /**
     * Move and interact
     */
    public void act() 
    {

        applyGravity();
        checkVertical();
        keyPress();
        move();
        hamCheck();
        pShield();

        //setImage();
        //attack();
    }    

    public void pShield()
    {
        if (isTouching (Shield.class))
        {

            //shielded  = true;
            Greenfoot.playSound("sound1.wav");
        }
    }

    public void keyPress()    
    {
        if (Greenfoot.isKeyDown("right"))
        {
            setVelocityX(MOVE_SPEED);            
            setImage("Nebukar-Right.png");

            facingLeft = false;
        }
        else if (Greenfoot.isKeyDown("left"))
        {
            setVelocityX(-MOVE_SPEED);            
            setImage("Nebukar-Left.png");

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

    public void applyGravity()
    {
        double velocityY = getVelocityY() + GRAVITY; // add gravity
        setVelocityY(velocityY);  // save current velocity
    }

    /**
     * Propels Nebukar upwards.
     */
    public void jump()
    {
        if (canJump)
        {
            setVelocityY(-16);
            canJump= false;
        }

    }

    /**
     * images 
     */
    public void initializeImages()
    {

    }

    /**
     *Centers cam on Player and handles movement.
     *move method imported from Player class to allow player to stay centered
     * while the world and all actors scroll left & right accordingly with user
     * input movement.
     * 
     * -requires scrollHorizontal to be implemented in world class
     */

    public void move()
    {
        super.move();
        double dx = getVelocityX();
        Level1 w = (Level1) getWorld();
        if (w == null || dx == 0)
        {
            return;
        }
        w.scrollHorizontal(dx);
        setLocation(w.getWidth() / 2, getY()); // stay in horizontal center
    }

    /**
     * checks for vertical collision
     */
    public void checkVertical()
    {
        // Calculate distance sprite will move vertically
        double velocityY = getVelocityY();
        int lookY = 0;
        if (velocityY > 0)
        {
            lookY = (int) (velocityY + GRAVITY + getHeight() / 2);
        }
        else
        {
            lookY = (int) (velocityY + GRAVITY - getHeight() / 2);
        }
        // Check for vertical collision this cycle
        Actor a = getOneObjectAtOffset(0, lookY, Platform.class);
        if (a == null) {
            // No collision this cycle
            applyGravity();
            canJump = false; 
        }
        else
        {
            // Collision detected
            moveToContactVertical(a);
            if (velocityY > 0)
            {
                // Player has landed
                canJump = true;
            }
            setVelocityY(0.0);
        }
    }

    /**
     * contact
     */
    public void moveToContactVertical(Actor target)
    {
        int h2 = (target.getImage().getHeight() + getImage().getHeight()) / 2;
        int newY = 0;

        if (target.getY() > getY())
        {
            newY = target.getY() - h2;
        }
        else
        {
            newY = target.getY() + h2;
        }

        setLocation(getX(), newY);

    }

    public void hamCheck()
    {
        Hammer h = (Hammer) getOneIntersectingObject(Hammer.class);
        if (h != null)  
        {
            if (armed == false)
            {
                h.gotHammer();
                armed = true;
            }

        }
    }

    /**
     * Returns the height of this Sprite's image.
     *
     * @return Height of the current image.
     */
    public int getHeight()
    {
        return getImage().getHeight();
    }

    /**
     * Returns the width of this Sprite's image.
     *
     * @return Width of the current image.
     */
    public int getWidth()
    {
        return getImage().getWidth();
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
    public void unarmed(){
        armed = false;
        //back to base image
    }

    public boolean isShielded(){
        return shielded;
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
        setVelocityX(0);
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

}