/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.core.engine;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import mario.core.Collision;
import mario.core.Sprites;
import mario.core.State;

/**
 *
 * @author danny
 */
public abstract class GameObject
{
    private static Sprites sprites = new Sprites();
    protected BufferedImage sprite;
    protected BufferedImage spritePart;
    protected int x, y, width, height;
    protected HashMap<String, Rectangle> frames = new HashMap<String, Rectangle>();
    protected String[] animation;
    protected int animationFrame = 0;
    protected State state;
    protected int frameSpeed = 50;
    protected long systemTime = System.currentTimeMillis();
    //private static ArrayList<GameObject> collection = new ArrayList<GameObject>();
    protected Collision mapCollision = Collision.NONE;

    public GameObject(int x, int y, int width, int height, String fileName)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        sprite = sprites.getImage(fileName);
        //boolean add = collection.add(this);
    }

    public BufferedImage getSprite()
    {
        return sprite;
    }

    protected BufferedImage getImage()
    {
        if ((System.currentTimeMillis() - systemTime) > frameSpeed)
        {
            systemTime = System.currentTimeMillis();
            if (animationFrame == animation.length)
            {
                animationFrame = 0;
            }
            BufferedImage crop = sprite.getSubimage((int) frames.get(animation[animationFrame]).getX(),
                    (int) frames.get(animation[animationFrame]).getY(),
                    (int) frames.get(animation[animationFrame]).getWidth(),
                    (int) frames.get(animation[animationFrame]).getHeight());
            animationFrame++;
            spritePart = crop;
        }
        return spritePart;
    }

    public void draw(Graphics graphics)
    {
        graphics.drawImage(getImage(), x, y, null);
    }

    public abstract void doLoopAction();

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public int getHeight()
    {
        return height;
    }

    public int getWidth()
    {
        return width;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }

    public void setWidth(int width)
    {
        this.width = width;
    }

    public void setAnimation(String[] animation)
    {
        this.animation = animation;
        animationFrame = 0;
    }

    public String[] getAnimation()
    {
        return animation;
    }

    public int getFrameSpeed()
    {
        return frameSpeed;
    }

    public void setState(State state)
    {
        this.state = state;
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
