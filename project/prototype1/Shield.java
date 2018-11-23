import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A shield for the player to pickup
 * (needs reference to player to work)
 * 
 * @author Nathaniel Larsen
 * @version 11/16/18
 */
public class Shield extends Items
{
    private static final int SHIELDING = 50, IMAGES = 8, AURA = 2;
    private int integrity = SHIELDING, imgNum = 0;
    private GreenfootImage[] images = new GreenfootImage[IMAGES];
    private GreenfootImage[] leftImgs = new GreenfootImage[IMAGES];
    private Nebukar p;
    public Shield(){
        cacheImages();
    }

    @Override
    protected void addedToWorld(World world)
    {
        //int offsetX = world.getWidth();
        //int offsetY = world.getHeight();
        //p = (Nebukar) getOneObjectAtOffset(offsetX, offsetY, Nebukar.class);
        Level1 level = (Level1) getWorld();
        p = level.getPlayer();
        System.out.println(p);
    }

    /**
     * Act - do whatever the Shield wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        //absorbDamage();// Add your action code here.
    }

    public void gotShield()
    {

        
        p.hasShield(); //will change players image to shielded
        setLocation(p.getX(), p.getY());
        int vertical = p.getImage().getHeight() + 2;
        int horizontal = p.getImage().getWidth() + 2;
        imgNum = IMAGES-1;
        animate();
        GreenfootImage img = new GreenfootImage(horizontal, vertical);
        setImage(img);
        setLocation(p.getX(), p.getY());
    }

    public void absorbDamage()
    {
        //while (p.isShielded()){
            
            //if player would take damage
            //negate player's damage
            //integrity -= damage;
       // }
        if (integrity == 0){
            p.noShield();
            disintegrate();
        }
    }

    public void animate()
    {
        //aura of player shrinking around them upon pickup

        while(imgNum >= 0){
            if(p.getLeftFacing()){
                setImage(leftImgs[imgNum]);
            }else{
                setImage(images[imgNum]);
            }imgNum--;
        }

    }

    public void disintegrate()
    {
        //Greenfoot playSound("crumble.wav")
        p.noShield();
        getWorld().removeObject(this);
    }

    private void cacheImages(){
        GreenfootImage baseR = new GreenfootImage("Shield-Aura-Right.png");
        GreenfootImage baseL = new GreenfootImage("Shield-Aura-Left.png");
        for (imgNum = 0; imgNum < IMAGES; imgNum++){
            images[imgNum] = new GreenfootImage(baseR);
            leftImgs[imgNum] = new GreenfootImage(baseL);
            int sizeX = 32 + AURA * imgNum;
            int sizeY = 40 + AURA * imgNum;
            images[imgNum].scale(sizeX, sizeY);
            leftImgs[imgNum].scale(sizeX, sizeY);
        }
        imgNum = 0;
    }
}