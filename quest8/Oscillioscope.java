import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * A sound wave that moves away from the keys
 * 
 * @author Nathaniel Larsen
 * @version 10/22/2018
 */
public class Oscillioscope extends Actor
{
    private GreenfootImage img0, img1, img2, img3;

    public Oscillioscope()
    {
        this("wave.png");
    }

    public Oscillioscope(String note)
    {
        
        GreenfootImage img1 = new GreenfootImage("wave.png");
        GreenfootImage img2 = new GreenfootImage("wave2.png");
        //GreenfootImage img3 = new GreenfootImage("c1wave3.png");
        GreenfootImage img0 = new GreenfootImage("clear.png");
        setImage(img1);
    }
     public Oscillioscope(GreenfootImage note)
    {
        
        GreenfootImage img1 = new GreenfootImage("wave.png");
        GreenfootImage img2 = new GreenfootImage("wave2.png");
        //GreenfootImage img3 = new GreenfootImage("c1wave3.png");
        GreenfootImage img0 = new GreenfootImage("clear.png");
        setImage(img1);
    }


    /**
     * Act - do whatever the Oscillioscope wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        setLocation(getX(), getY() - 10);
        if (getY() == 0){
            getWorld().removeObject(this);
        }
        updateImg();
        //bashKeys();
    }    
    
    public void updateImg(){
        if (this.getImage() == img1){
            setImage(img2);
        } else if(getImage() == img2){
            setImage(img0);
        } else if(getImage() == img0){
            setImage(img1);
        }
        bashKeys();
    }
    
public void bashKeys(){
        World piano = getWorld();
        List <Oscillioscope> notes = piano.getObjects(Oscillioscope.class);
        for (Oscillioscope note: notes)
        {
            note.setImage(img1);
            //updateImg();
        }
    }

}
