/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.core;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import mario.Game;
import mario.State;
import mario.Mario;

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
    protected Game game;
    private static ArrayList<GameObject> collection = new ArrayList<GameObject>();
    private int x_last, y_last, width_last, height_last;
    protected Collision mapCollision = Collision.NONE;

    public GameObject(Game game, int x, int y, int width, int height, String fileName)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        sprite = sprites.getImage(fileName);
        boolean add = collection.add(this);
        this.game = game;
    }

    public BufferedImage getSprite()
    {
        return sprite;
    }

    protected BufferedImage getImage()
    {
        //System.out.println((System.currentTimeMillis() - systemTime));
        if ((System.currentTimeMillis() - systemTime) > frameSpeed)
        {

            systemTime = System.currentTimeMillis();
            //System.out.println(animationFrame + " : " + animation.length);
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
        graphics.setColor(Color.pink);
        graphics.fillRect(x, y, width, height);
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

    public int getXLast()
    {
        return x_last;
    }

    public int getYLast()
    {
        return y_last;
    }

    public int getWidthLast()
    {
        return width_last;
    }

    public int getHeightLast()
    {
        return height_last;
    }

    public void setX(int x)
    {

        if (checkCollisionMap(x, y) == Collision.NONE)
        {
            x_last = this.x;
            this.x = x;
            if (this instanceof Mario)
            {
                if (x > ((800 / 2) + 5))
                {
                    moveAll(this.x - x_last);
                }
                if (x <= 0)
                {
                    this.x = 0;
                }
            }
        }
    }

    public void setX(int x, boolean override)
    {
        if (override)
        {
            x_last = this.x;
            this.x = x;
        }
    }

    public void setY(int y)
    {
        if (checkCollisionMap(x, y) == Collision.NONE)
        {
            y_last = this.y;
            //System.out.println(y_last + " : " + this.y + " : " + y);
            this.y = y;
            //System.out.println(y_last + " : " + this.y + " : " + y);
        }
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
        height_last = this.height;
        this.height = height;
    }

    public void setWidth(int width)
    {
        width_last = this.width;
        this.width = width;
    }

    public void setAnimation(String[] animation)
    {
        this.animation = animation;
        animationFrame = 0;
        //systemTime = System.currentTimeMillis() - frameSpeed;
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

    public Collision checkCollisionMap()
    {
        return checkCollisionMap(x, y, 2);
    }

    public Collision checkCollisionMap(int x, int y)
    {
        return checkCollisionMap(x, y, 1);
    }

    public Collision checkCollisionMap(int x, int y, int downSize)
    {
        Rectangle objectRectangle = new Rectangle(x, y, width, height + downSize);
        Rectangle mapRectangle = new Rectangle(0, 552, 800, 48);

        mapCollision = Collision.NONE;

        for (MapObject characterObjectLoop : game.getMapObjects())
        {
            if (this != characterObjectLoop)
            {
                if (!(characterObjectLoop instanceof NoClip))
                {
                    Rectangle mapObjectRectangle = new Rectangle(characterObjectLoop.getX(), characterObjectLoop.getY(), characterObjectLoop.getWidth(), characterObjectLoop.getHeight());
                    if (mapObjectRectangle.intersects(objectRectangle))
                    {
                        mapCollision = Collision.COLLISION;
                    }
                }
            }
        }
        return mapCollision;
    }

    private void moveAll(int i)
    {
        for (MapObject characterObjectLoop : game.getMapObjects())
        {
            if (!(characterObjectLoop instanceof Static))
            {
                if (characterObjectLoop instanceof Mario)
                {
                    Mario mario = (Mario) characterObjectLoop;
                    mario.setStepCounter(mario.getStepCounter() + 1);
                }
                characterObjectLoop.setX(characterObjectLoop.getX() - i, true);
            }
        }
    }
}
