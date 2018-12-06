import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * World Map Level1.
 *  Thank You Mr. Parrish for the code examples from Platformer that inspired
 *  and helped meto create this Level1 class. 
 * @author Nicholas Anderson
 * @version V1.0
 * @Date November 15, 2018
 */
public class Level1 extends World
{
    private static final int TILE_WIDTH = 32;
    private static final int TILE_HEIGHT = 32;
    private int leftX; // leftmost x coordinate for a tile
    private int topY;  // highest y coordinate for a tile
    private Nebukar thor = new Nebukar();
    HealthBar hb = new HealthBar();
  
    /**
     * Constructor for objects of class Level1.
     * 
     */
    public Level1()
    {
        super(400, 400, 1, false);
        leftX = TILE_WIDTH / 2;
        topY = TILE_HEIGHT / 2 - getHeight() % TILE_HEIGHT; 
        setPaintOrder(HealthBar.class, Nebukar.class, Platform.class, Hammer.class, Enemy.class);
        Hammer.dropped();
    }
    
    /**
     * Method to allow scrolling background to move through level1.
     */
        public void scrollHorizontal(double dx)
    {
        List<Actor> actors = getObjects(null);
        for (Actor a : actors)
        {
            if (a != hb)
            {
                int moveX = (int) Math.round(a.getX() - dx);
                a.setLocation(moveX, a.getY());
            }
        }
        
    }
    
    
    /**
     * Add a row of tiles to the world.
     *
     * @param y The row number in the MAP grid.
     */
    private void makeMapRow(int y, String[] MAP)
    {
        int tileY = topY + TILE_HEIGHT * y;
        String row = MAP[y];
        for (int x = 0; x < row.length(); x++)
        {
            int tileX = leftX + TILE_WIDTH * x;
            char tileType = row.charAt(x);
            if (tileType == 'B')
            {
                addObject(new Base(), tileX, tileY);
            }
            else if (tileType == 'L')
            {
                addObject(new Left(), tileX, tileY);
            }
            else if (tileType == 'C')
            {
                addObject(new Center(), tileX, tileY);
            }
            else if (tileType == 'R')
            {
                addObject(new Right(), tileX, tileY);
            }
            else if (tileType == 'W')
            {
                addObject(new Wall(), tileX, tileY);
            }
            else if (tileType == 'd')
            {
                addObject(new Door(), tileX, tileY);
            }
            else if (tileType == 'K')
            {
                addObject(new Key(), tileX, tileY);
            }
            else if (tileType == 'P')
            {
                addObject(new Potion(), tileX, tileY);
            }
            else if (tileType == 'S')
            {
                addObject( new Shield(), tileX, tileY);
            }
            else if (tileType == 'E')
            {
                addObject( new Enemy_walking(), tileX, tileY);
            }
            else if (tileType == 'b')
            {
                addObject(new Enemy_bouncing(), tileX, tileY);
            }else if (tileType == 'H')
            {
                addObject(new Hammer(), tileX, tileY);
            }
            else if (tileType != ' ')
            {
                System.out.println("Wrong tile type: " + tileType);
            }
        }
    }
    
    /**
     * Create and arrange platforms in the world.
     */
    protected void createPlatforms(String[] MAP)
    {
        for (int y = 0; y < MAP.length; y++)
        {
            makeMapRow(y, MAP);
        }
        addObject(thor, getWidth()/2, getHeight()/2);
        addObject(hb, 70, 25);
        //addObject(hb, 200, 200);
    }
 
    public Nebukar getPlayer()
    {
        return thor;
    }
    
    public HealthBar getHealthBar()
    {
        return hb;
    }
}

