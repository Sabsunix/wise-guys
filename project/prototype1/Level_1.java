import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level_1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level_1 extends Level1
{
        private static final String[] MAP = 
    {
        "                                                                    ",
        "                                                                    ",
        "                                                                    ",
        "                                                                    ",
        "                                                                    ",
        "                                                                    ",
        "                                                              W W W W",
        "                                                              WWWWWWW",
        "                S                                             WWWWWWW",
        "             E              W   E    K W   E            E   P DWWWWWW",
        "CCCCCCCCCCCCCCCCCCR LC LCCCCCCCCCCCCCCCCCCCCCCCCR W LCCCCCCCCCCCCCCCCC",
        "BBBBBBBBBBBBBBBBBB     BBBBBBBBBBBBBBBBBBBBBBBB     BBBBBBBBBBBBBBBBB",
        "BBBBBBBBBBBBBBBBBB     BBBBBBBBBBBBBBBBBBBBBBBB     BBBBBBBBBBBBBBBBB",
    };
    

    /**
     * Constructor for objects of class Level_1.
     * 
     */
    public Level_1()
    {
        removeObjects(getObjects(null));
        createPlatforms(MAP);
    }
}
