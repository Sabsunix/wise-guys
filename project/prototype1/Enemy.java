import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Superclass for all Enemies
 * 
 * @author William Craig
 * @version 11/29/18
 */
public class Enemy extends Sprite
{
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void getCollisionGeneral(int damage,boolean projectile) 
    {
        if(isTouching(Shield.class)){
            Actor shield = getOneIntersectingObject(Shield.class);
            Greenfoot.playSound("squish_placeholder.wav");
            getWorld().removeObject(shield); 
            getWorld().removeObject(this);
        } else if(isTouching(Nebukar.class)){
            
            Level1 w = (Level1) getWorld();
            Nebukar nebukar = (Nebukar) getOneIntersectingObject(Nebukar.class);
            HealthBar hb = (HealthBar) w.getHealthBar();
            
            if(!nebukar.isShielded()){
                if (nebukar.getHealth() > 0)
                {
                    nebukar.setHealth(nebukar.getHealth()-damage);
                    hb.setSize(nebukar.getHealth());
                }
                if (nebukar.getHealth() <= 0){
                    hb.setSize(nebukar.getHealth());
                    getWorld().removeObject(nebukar);
                }
                /*else if(nebukar.getHealth() <= damage)
                {
                    nebukar.setHealth(0);
                }*/
                Hammer.dropped();
                getWorld().removeObject(this);
            } else {
                nebukar.noShield();
                getWorld().removeObject(this);
            }
            
        }
        else if(isTouching(Hammer.class)){
            Greenfoot.playSound("squish_placeholder.wav");
            getWorld().removeObject(this);
        }
        else if(projectile)
        {
            Actor p = getOneIntersectingObject(Platform.class);
            if (p != null)
            {
                World world = getWorld();
                world.removeObject(this);
            }
        }
    }
}
