import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A generic button for a game or other application.
 *
 * @author Ed Parrish
 * @version 1 on 11/25/2017
 */
public class Button extends HUD
{
    private static final Color TRANSPARENT = new Color(0, 0, 0, 0);
    private String text;
    private int size;
    private Color textColor;
    private Style style;
    // An identifying number for this component.
    private int id;
    public enum Style { RECTANGLE, ROUNDED, CIRCLE };
    // Button image in normal (up) state
    private GreenfootImage up;
    // Button image in pressed (down) state
    private GreenfootImage down;
    // Button image in mouseover (hover) state
    private GreenfootImage hover;

    /**
     *  Creates a button with default text and settings.
     */
    public Button() {
        this("Button");
    }

    /**
     *  Creates a button with the specified text and default settings.
     */
    public Button(String text) {
        this(text, 24);
    }

    /**
     * Constructs a button of the specified size with black text
     * on a transparent background.
     *
     * @param text The text to display on the button
     * @param textSize The size of the text in pixels.
     */
    public Button(String text, int textSize) {
        this(text, textSize, Color.BLACK);
    }

    /**
     * Constructs a button of the specified size and text color.
     *
     * @param text The text to display on the button
     * @param size The font size with which to display the text.
     * @param textColor The color to use for displaying text.
     */
    public Button(String text, int textSize, Color textColor) {
        this(text, textSize, Color.BLACK, Style.RECTANGLE);
    }

    /**
     * Constructs a button of the specified size and text color
     * on a transparent background.
     *
     * @param text The text to display on the button
     * @param size The font size with which to display the text.
     * @param textColor The color to use for displaying text.
     */
    public Button(String text, int textSize, Color textColor, Style type) {
        this.text = text;
        size = textSize;
        this.textColor = textColor;
        style = type;
        paint();
    }

    /**
     * React to the mouse including rollovers and button clicks.
     */
    public void act()
    {
        if (Greenfoot.mouseMoved(this)) {
            setImage(hover);
        }
        else if (Greenfoot.mouseMoved(null))
        {
            setImage(up);
        }
        if (Greenfoot.mousePressed(this))
        {
            setImage(down);
            resetGame();
        }
        if (Greenfoot.mouseClicked(null)
        || Greenfoot.mouseDragEnded(null))
        {
            setImage(up);
        }
        if (Greenfoot.mouseClicked(this))
        {
            setImage(hover);
            //fireActionEvent();
        }
    }

    /**
     * Returns true if this button is currently down (pressed), otherwise
     * returns false.
     *
     * @return <code>true</code> if this button is currently pressed, otherwise
     * <code>false</code>.
     */
    public boolean isPressed()
    {
        return Greenfoot.mousePressed(this);
    }

    /**
     * Return the ID number of this button.
     *
     * @return The ID number for this button.
     */
    public int getID() {
        return id;
    }


    /**
     * Set an ID number for this button.
     *
     * @param idNumber An identifier number.
     */
    public void setID(int idNumber) {
        id = idNumber;
    }

    /**
     * Returns the text for this button.
     *
     * @return The text displayed on this button.
     */
    public String getText() {
        return text;
    }

    /**
     * Set the text to be displayed.
     *
     * @param newText The new text to be displayed on this button.
     */
    public void setText(String newText)
    {
        text = newText;
        paint();
    }

    /**
     * Draws three images for each button state: up, down, hover.
     */
    public void paint()
    {
        if (style == Style.RECTANGLE)
        {
            up = new GreenfootImage("rectbtn-up.jpg");
            down = new GreenfootImage("rectbtn-down.jpg");
            hover = new GreenfootImage("rectbtn-hover.jpg");
        }
        else if (style == Style.ROUNDED)
        {
            up = new GreenfootImage("roundedbtn-up.png");
            down = new GreenfootImage("roundedbtn-down.png");
            hover = new GreenfootImage("roundedbtn-hover.png");
        }
        else if (style == Style.CIRCLE)
        {
            up = new GreenfootImage("roundbtn-up.png");
            down = new GreenfootImage("roundbtn-down.png");
            hover = new GreenfootImage("roundbtn-hover.png");
        }
        GreenfootImage img = new GreenfootImage(text, size, textColor,
                TRANSPARENT);
        int width = (int)(img.getWidth() * 1.2);
        int height = (int)(img.getHeight() * 1.2);
        if (style == Style.CIRCLE)
        {
            height = width;
        }
        up.scale(width, height);
        down.scale(width, height);
        hover.scale(width, height);
        int x = (width - img.getWidth()) / 2; // center
        int lines = countLines(text);
        int y = (height - size * lines) / 2; // center
        up.drawImage(img, x, y);
        down.drawImage(img, x + 1, y + 1);
        hover.drawImage(img, x, y);
        setImage(up);
    }

    /**
     * Sets a new background color for this button. Use a low alpha
     * value for a tint.
     *
     * @param color The new color.
     */
    public void setBackgroundColor(Color color)
    {
        up.setColor(color);
        up.fill();
        down.setColor(color);
        down.fill();
        hover.setColor(color);
        hover.fill();
    }

    /**
     * Counts the number of newlines in a string object.
     *
     * @param str The string to test.
     * @return The number of '\n' characters found.
     */
    private int countLines(String str)
    {
        if(str == null || str.isEmpty())
        {
            return 0;
        }
        int lines = 1;
        int pos = 0;
        while ((pos = str.indexOf("\n", pos) + 1) != 0)
        {
            lines++;
        }
        return lines;
    }
    
    public void resetGame()
    {
        Greenfoot.setWorld(new Level_1());
    }
}
