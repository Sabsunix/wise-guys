import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A shield to protect Nebukar
 * 
 * @author Nathaniel Larsen
 * @version 11/16/18
 * 
 * img credit: 
 */
public class Shield extends Items
{
    private static final int SHIELDING = 50, IMAGES = 8, AURA = 5;
    private int integrity = SHIELDING, imgNum = 0, protection = 1;
    private GreenfootImage[] images = new GreenfootImage[IMAGES];
    private GreenfootImage[] leftImgs = new GreenfootImage[IMAGES];
    private GreenfootImage endR, endL;
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
    }

    /**
     * Act - do whatever the Shield wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (isTouching(Nebukar.class) && !p.isShielded()){
            gotShield();

        }
        if (p.isShielded() ){ 
            animate();
            
            if (isTouching(Enemy.class)){
                absorbDamage(protection);// Add your action code here.
            }
        }
    }

    public void gotShield()
    {

        p.hasShield(); //will change players image to shielded
        setLocation(p.getX(), p.getY());
    }

    public void absorbDamage(int damage)
    {
        //while (p.isShielded()){

        //if player would take damage
        //negate player's damage
        int negation = p.getHealth() + damage;
        p.setHealth(negation);
        integrity -= damage;
        // }
        if (integrity == 0){
            p.noShield();
            disintegrate();
        }
    }

    public void animate()
    {
        //aura of player shrinking around them upon pickup

        int vertical = p.getImage().getHeight() + 2;
        int horizontal = p.getImage().getWidth() + 2;
        GreenfootImage img = new GreenfootImage(horizontal, vertical);
        if(p.getLeftFacing()){
            setImage(leftImgs[imgNum]);
        }else{
            setImage(images[imgNum]);
        }

        if (imgNum > 0){
            imgNum--;
        } else {
            if (p.getLeftFacing()){
                setImage(endL);
            } else {
                setImage(endR);
            }
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
        GreenfootImage endL = new GreenfootImage("Shielded-Nebukar-Left2.png");
        GreenfootImage endR = endL;
        endR.mirrorHorizontally();
        for (imgNum = 0; imgNum < IMAGES; imgNum++){
            images[imgNum] = new GreenfootImage(baseR);
            int sizeX = 32 + AURA * imgNum;
            int sizeY = 40 + AURA * imgNum;
            images[imgNum].scale(sizeX, sizeY);
            leftImgs[imgNum] = images[imgNum];
            leftImgs[imgNum].mirrorHorizontally();
        }
        imgNum--;
    }
}