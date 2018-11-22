import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Hammer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hammer extends Sprite
{
    private final int IMAGES = 7, INTERVAL = 4, SPIN = 56;
    private int imgNum = 0, time = 0;
    private GreenfootImage[] images, leftImages = new GreenfootImage[IMAGES];
    private boolean held = false, launched = false;
    private Nebukar p;
    public Hammer()
    {
        cacheImages();
        setImage(images[imgNum]);
    }

    public void act() 
    {
        if (Greenfoot.isKeyDown("z")){
            launch();
            held = false;
        }
        if (launched){
            animate();
            if (getOneIntersectingObject(null) != null){
                //Greenfoot.playSound("thunk.wav")
                getWorld().removeObject(this);
            }
        }
        if (held){ 
            setLocation(p.getX(), p.getY());
        }
    }    

    /** Fly through the air */
    public void launch()
    {
        //get player's direction, facing 
        //if (p.getLeftFacing())
        //setVelocity(-2.0 + p.getVelocityX, -0.27)
        //else 
        //setVelocity(2.0 + p.getVelocityX, -0.27)
        //move();
        //p.getDirection(), setVelocity(), & move() -needed in sprite class ^^
        launched = true;
        held = false;
    }

    /**
     * gotHammer - Player picks up the hammer, 
     * its angle changes and Thor makes an announcement     
     */
    public void gotHammer(){
        setImage(images[IMAGES - 1]);
        Greenfoot.playSound("hammer.wav");
        held = true;
        p = (Nebukar) getOneIntersectingObject(Nebukar.class);
    }

    private void cacheImages(){
        GreenfootImage base = new GreenfootImage("Hammer.gif");
        for (imgNum = 0; imgNum < IMAGES; imgNum++){
            images[imgNum] = new GreenfootImage(base);
            images[imgNum].rotate(SPIN * imgNum);
            leftImages[imgNum] = images[imgNum];
            leftImages[imgNum].mirrorHorizontally();
        }
        imgNum = 0;
    }

    public void animate(){
        if (time % INTERVAL == 0){
            if (imgNum == IMAGES) {
                imgNum = 0;
            }
            if (this.getVelocityX() < 0){
                setImage(leftImages[imgNum]);
            } else {
                setImage(images[imgNum]);
            }
            imgNum++;
        }
        time++;
    }
}