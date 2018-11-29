import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy_walking here.
 * 
 * @author William Craig 
 * @version 11/29/18
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
    private static final int MOVE_COUNT = 0;
    public Enemy_walking()
    {
        initializeImages();
    }
    /**
     * Act - do whatever the Enemy_walking wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        Collisions();
        moving();
        move();
        getCollisionGeneral();
    }    
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
    public void moving()
    {
        if (direction==right)
        {
            setVelocityX(MOVE_SPEED);
        }
        if (direction==left)
        {
            setVelocityX(-1*MOVE_SPEED);
        }
    }
    public int getHeight()
    {
        return getImage().getHeight();
    }
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
                moveRightImgs[i] =
                new GreenfootImage(moveLeftImgs[i]);
                moveRightImgs[i].mirrorHorizontally();
            }
        }
        
    }
}
