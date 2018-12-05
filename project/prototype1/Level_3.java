import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level_3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level_3 extends Level1
{
    private static final String[] MAP=
    {
       "                                                                            ",
       "                                                                            ",
       "                                                                            ",
       "                                                                            ",
       "                                                                            ",
        "                                                                            ",
        "                                                                            ",
        "                                                        b    b      S       ",
        "              S                                         W    W    P         ",
        "            b   E    E        b   E  E              E  WWW EWWW bWWW  b     b",
        "CCCCCCCCCCCCCCCCCCCCCCCCCR  LCCCCCCCCCCCCCCCCCR  LCCCCCCCCCCCCCCCCCR  LCCCCCC",
        "BBBBBBBBBBBBBBBBBBBBBBBBB    BBBBBBBBBBBBBBBBB    BBBBBBBBBBBBBBBBB    BBBBB ",
        "BBBBBBBBBBBBBBBBBBBBBBBBB    BBBBBBBBBBBBBBBBB    BBBBBBBBBBBBBBBBB    BBBBB ",
    };
    /**
     * Constructor for objects of class Level_3.
     * 
     */
    public Level_3()
    {
        removeObjects(getObjects(null));
        createPlatforms(MAP);
    }
}
