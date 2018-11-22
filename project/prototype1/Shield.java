import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Shield here.
 * 
 * @author Nathaniel Larsen
 * @version 11/16/18
 */
public class Shield extends Items
{
    private static final int SHIELDING = 50, IMAGES = 8, AURA = 2;
    private int integrity = SHIELDING, imgNum = 0;
    private GreenfootImage[] images = new GreenfootImage[IMAGES];
    private Nebukar p;
    public Shield(){
        //cacheImages();
        //
        //set p = ^
    }

    /**
     * Act - do whatever the Shield wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        absorbDamage();// Add your action code here.
    }

    public void gotShield()
    {
        
        int offsetX = getImage().getWidth() / 2;
        int offsetY = getImage().getHeight() / 2;
        p = (Nebukar) getOneObjectAtOffset(offsetX, offsetY, Nebukar.class); 
        p.hasShield(); //will change players image to shielded
        Color color = new Color(0,0,0,0);
        int vertical = p.getImage().getHeight() + 2;
        int horizontal = p.getImage().getWidth() + 2;
        imgNum = IMAGES-1;
        animate();
        GreenfootImage img = new GreenfootImage(horizontal, vertical);
        setImage(img);
    }

    public void absorbDamage()
    {
        while (p.isShielded()){
            setLocation(p.getX(), p.getY());
            //if player would take damage
            //negate player's damage
            //integrity -= damage;
        }
        if (integrity == 0){
            //set player has shield bool = false;
            disintegrate();
        }
    }

    public void animate()
    {
        //aura of player shrinking around them upon pickup
        setLocation(p.getX(), p.getY());
        while(imgNum >= 0){
            setImage(images[imgNum]);
            imgNum--;
        }
        //setImage(new GreenfootImage(1,1));
    }

    public void disintegrate()
    {
        //Greenfoot playSound("crumble.wav")
        p.noShield();
        getWorld().removeObject(this);
    }
    /* 
    private void cacheImages(){
        //GreenfootImage base = new GreenfootImage("wave.gif");
        for (imgNum = 0; imgNum < IMAGES; imgNum--){
            //images[imgNum] = new GreenfootImage(base);
            int sizeX = p.getImage().getWidth() + AURA * imgNum;
            int sizeY = p.getImage().getHeight() + AURA * imgNum;
            images[imgNum].scale(sizeX, sizeY);
        }
        imgNum = 0;
    }*/
}