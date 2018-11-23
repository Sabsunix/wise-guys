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
    private int integrity = SHIELDING, imgNum = 0, protection = 1;
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
        imgNum = IMAGES-1;
        //while(imgNum >= 0){
        int vertical = p.getImage().getHeight() + 2;
        int horizontal = p.getImage().getWidth() + 2;
        GreenfootImage img = new GreenfootImage(horizontal, vertical);
        if(p.getLeftFacing()){
            setImage(leftImgs[imgNum]);
        }else{
            setImage(images[imgNum]);
        }
        imgNum--;
        if (imgNum < 0){
            setImage(img);
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