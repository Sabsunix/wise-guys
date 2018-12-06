import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Superclass for all Enemies
 * 
 * @author William Craig
 * @version 12/6/18
 */
public abstract class Enemy extends Sprite
{
    private int death_counter=15;
    /**
     * Checks collisions for all the enemy classes so this code didn't have to be rewriten in every class
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
            if (death_counter>=15){
                if(!nebukar.isShielded()){

                    if (nebukar.getHealth() > 0)
                    {
                        nebukar.setHealth(nebukar.getHealth()-damage);
                        hb.setSize(nebukar.getHealth());
                    }
                    if (nebukar.getHealth() <= 0){
                        hb.setSize(nebukar.getHealth());
                    }
                    //else if(nebukar.getHealth() <= damage)
                    //{
                    //    nebukar.setHealth(0);
                    //}
                    //Hammer.dropped();
                    death_counter=0;
                }
                else {
                    nebukar.noShield();
                    getWorld().removeObject(this);

                }
            }
        }

        else if(
        isTouching(Hammer.class)){
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
        death_counter++;
    }
}
