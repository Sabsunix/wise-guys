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
    private static final double MOVE_SPEED = 3.75;
    private static final double GRAVITY = 0.4;
    private static final int MAX_HEALTH = 100;
    //private static final int RIGHT = 0;
    //private static final int LEFT = 1;

    private static boolean facingLeft;
    private boolean canJump; // Jumping is allowed when true

    //Array Cache    
    private int moveCount = 0; //sets animmation counter to 0
    private static final int MOVE_COUNT = 6;
    private static final int DURATION = 7;
    //private static GreenfootImage[] image;
    private static GreenfootImage[] runRightImages;
    private static GreenfootImage[] runLeftImages;
    private static GreenfootImage faceRight;
    private static GreenfootImage faceLeft;

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
        // image = new GreenfootImage[2];
        // image[0] = new GreenfootImage ("Nebukar-Right.png");
        // image[1] = new GreenfootImage ("Nebukar-Left.png");

    }

    /**
     * Move and interact
     */
    public void act() 
    {


        applyGravity();
        keyPress();        
        hamCheck();
        pShield();
        checkVertical();
        checkHorizontal();
        move();
    }    

    private static GreenfootImage[] flipImages(GreenfootImage[] imgs)
    {
        GreenfootImage[] flipped = new GreenfootImage[imgs.length];
        for (int i = 0; i < imgs.length; i++)
        {
            flipped[i] = new GreenfootImage(imgs[i]);
            flipped[i].mirrorHorizontally();
        }
        return flipped;
    }

    public static void initializeImages()
    {
        if (runRightImages == null)
        {
            // // Load the right-facing image
            faceRight = new GreenfootImage("Nebukar-Right.png");
            // // Make the left-facing image
            faceLeft = new GreenfootImage(faceRight);
            faceLeft.mirrorHorizontally();

            // Load the running images
            runRightImages = new GreenfootImage[MOVE_COUNT];
            for (int i = 0; i < MOVE_COUNT; i++)
            {
                String fileName = "test" + (i + 1) + ".png";
                runRightImages[i] = new GreenfootImage(fileName);
            }
            runLeftImages = flipImages(runRightImages);
        }
    }

    public void pShield()
    {
        if (isTouching (Shield.class))
        {

            //shielded  = true;
            //Greenfoot.playSound("sound1.wav");
        }
    }

    public void keyPress()    
    {
        if (Greenfoot.isKeyDown("right"))
        {
            setVelocityX(MOVE_SPEED);            
            moveCount++;
            if (moveCount >= runRightImages.length * DURATION)
            {
                moveCount = 0; // reset the count
            }
            setImage(runRightImages[moveCount / DURATION]);

            //setImage("Nebukar-Right.png");

            facingLeft = false;
        }
        else if (Greenfoot.isKeyDown("left"))
        {
            setVelocityX(-MOVE_SPEED);
            moveCount++;
            if (moveCount >= runLeftImages.length * DURATION)
            {
                moveCount = 0; // reset the count
            }
            setImage(runLeftImages[moveCount / DURATION]);          

            //setImage("Nebukar-Left.png");
            facingLeft = true;
        }
        else
        {
            stopMoving();
        }
        if ((Greenfoot.isKeyDown("space")|| Greenfoot.isKeyDown("up")))
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
            setVelocityY(-14);
            canJump= false;
        }

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

    /**
     * Check for a horizontal collision with a platform.
     */
    public void checkHorizontal() 
    {
        double velocityX = getVelocityX();
        if (velocityX == 0) return;
        int lookX = 0;
        if (velocityX < 0)
        {
            lookX = (int) velocityX - getWidth() / 2;
        }
        else
        {
            lookX = (int) velocityX + getWidth() / 2;
        }
        Actor a = getOneObjectAtOffset(lookX, 0, Platform.class);
        if (a != null) {
            moveToContactHorizontal(a);
            stopMoving();
        }
    }

    /**
     * Move this Actor into contact with the specified Actor in the
     * horizontal (x) direction.
     *
     * @param target The target this sprite is approaching.
     */
    public void moveToContactHorizontal(Actor target)
    {
        int w2 = (getWidth() + target.getImage().getWidth()) / 2;
        int newX = 0;
        if (target.getX() > getX())
        {
            newX = target.getX() - w2;
        }
        else
        {
            newX = target.getX() + w2;
        }
        setLocation(newX, getY());
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
     * Stops Nebukar.
     */
    public void stopMoving()
    {
        setVelocityX(0);
    }

}