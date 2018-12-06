import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level_2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level_2 extends Level1
{
        private static final String[] MAP = 
    {
        "BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB           ",
        "BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB           ",
        "BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB                 BBBBBBB           ",
        "BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB                 WWWWWWW",
        "                                                    WWWWWWW",
        "                                                    WWWWWWW",
        "                                        W 1E   b  S dWWWWWWCCCCCCCCCCCCCCCCCC",
        "                                   WWWWW WWWWWWWWWWWWWWWWWWBBBBBBBBBBBBBBBBBB",
        " H                    b          WW                 WWWWWWWWWWWWWWWWWWWWWWWWW",
        "WWWWWWWWWWWWWWWWWWWWWWWWW    WWWWW                                   WWWWWWWW",
        "BBBBBBBBBBBBBBBBBBBBBBBBBW                                           BBBBBBBB",
        "BBBBBBBBBBBBBBBBBBBBBBBBBBW          b         b          b     E  PKBBBBBBBB",
        "BBBBBBBBBBBBBBBBBBBBBBBBBBBWWWWWWWWWWWWW WWWWWWWWW BBBBBBBBBBBBBBBBBBBBBBBBBB",
    };
    /**
     * Constructor for objects of class Level_2.
     * 
     */
    public Level_2()
    {
        removeObjects(getObjects(null));
        createPlatforms(MAP);
    }
}
