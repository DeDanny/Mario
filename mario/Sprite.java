/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario;

import java.awt.Graphics2D;

/**
 *
 * @author Danny
 */
public class Sprite
{
    protected int x, y, height, width;
    protected String image;

    public Sprite(int x, int y, int height, int width, String image)
    {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        this.image = image;
    }

    public int getHeight()
    {
        return height;
    }

    public String getImage()
    {
        return image;
    }

    public int getWidth()
    {
        return width;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }

    public void setImage(String image)
    {
        this.image = image;
    }

    public void setWidth(int width)
    {
        this.width = width;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    
    
    public void draw(Graphics2D g2)
    {}
}
