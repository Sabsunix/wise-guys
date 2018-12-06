import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy_walking here.
 * 
 * @author William Craig 
 * @version 12/6/18
 */
public class Enemy_walking extends Enemy
{
    private static final double MOVE_SPEED = 1;
    private static final double GRAVITY = 0.5;
    private static final int right=0;
    private static final int left=1;
    private int direction=1;
    int placeholder=0;
    private static GreenfootImage[] moveLeftImgs;
    private static GreenfootImage[] moveRightImgs;
    private static final int MOVE_COUNT = 2;
    private int move=0;
    /**
     * This constructor calls initialize images
     */
   
    public Enemy_walking()
    {
        initializeImages();
    }
    /**
     * calls the different methods that make the program work
     */
    public void act() 
    {
        Collisions();
        moving();
        move();
        getCollisionGeneral(35,false);
    }    
    /**
     * checks collisions with walls so that the enemy can turn around instead of walking throught them
     */
    public void Collisions()
    {
        if(isTouching(Platform.class)){
            if (direction==right)
            {
                direction=left;
            }
            else
            {
                direction=right;
            }
        }
        //if(getX()<=30)
        //{
        //    direction=right;
        //}
        //int lookY=getY()+11;
        //Actor r = getOneObjectAtOffset(0, lookY, Right.class);
        //Actor l = getOneObjectAtOffset(0, lookY, Left.class);
        //if (r != null) { 
        //    direction=left;
        //}
        //if (l != null) { 
        //    direction=right;
        //}
        if(placeholder<100)
        {
            placeholder++;
        }
        else
        {
            if (direction==right)
            {
                direction=left;
                placeholder=0;
            }
            else
            {
                direction=right;
                placeholder=0;
            }
        }
    }
    /**
     * uses code to move the walking enemy
     */
    public void moving()
    {
        if (direction==right)
        {
            setVelocityX(MOVE_SPEED);
            if (move==0||move==1||move==2)
            {
                setImage(moveRightImgs[1]);
                move++;
            }
            else if (move==3||move==4)
            {
                setImage(moveRightImgs[0]);
                move++;
            }
            else if (move==5)
            {
                setImage(moveRightImgs[0]);
                move=0;
            }
        }
        if (direction==left)
        {
            setVelocityX(-1*MOVE_SPEED);
            if (move==0||move==1||move==2)
            {
                setImage(moveLeftImgs[1]);
                move++;
            }
            else if (move==3||move==4)
            {
                setImage(moveLeftImgs[0]);
                move++;
            }
            else if (move==5)
            {
                setImage(moveLeftImgs[0]);
                move=0;
            }
        }
    }
    /**
     * returns the height of the image used for the class
     */
    public int getHeight()
    {
        return getImage().getHeight();
    }
    /**
     * a modified version of the method from Platformer6 to make it work for this class
     */
    public static void initializeImages()
    {
        if (moveLeftImgs == null || moveRightImgs == null)
        {
            moveLeftImgs = new GreenfootImage[MOVE_COUNT];
            moveRightImgs = new GreenfootImage[MOVE_COUNT];
            for (int i = 0; i < moveRightImgs.length; i++)
            {
                String fileName = "Walking" + (i + 1) + ".png";
                moveLeftImgs[i] = new GreenfootImage(fileName);
                moveRightImgs[i] = new GreenfootImage(moveLeftImgs[i]);
                moveRightImgs[i].mirrorHorizontally();
            }
        }
        
    }
}
