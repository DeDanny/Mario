/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import mario.state.State;


/**
 *
 * @author danny
 */
public abstract class GameObject
{
    protected BufferedImage sprite;
    protected int x, y;
    protected State state;

    public GameObject(int x, int y, String fileName)
    {
        this.x = x;
        this.y = y;
        sprite = loadImage(fileName);
    }

    private BufferedImage loadImage(String fileName)
    {
        try
        {
            sprite = ImageIO.read(new File(fileName));
        } catch (IOException e)
        {
        }
        return sprite;
    }

    public BufferedImage getSprite()
    {
        return sprite;
    }

    abstract public void draw(Graphics graphics);
    abstract public void doLoopAction();

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public void setY(int y)
    {
        this.y = y;
    }
}
