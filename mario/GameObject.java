/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import javax.imageio.ImageIO;

/**
 *
 * @author danny
 */
public abstract class GameObject
{
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

    public GameObject(Game game, int x, int y, int width, int height, String fileName)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        sprite = loadImage(fileName);
        collection.add(this);
        this.game = game;
    }

    private BufferedImage loadImage(String fileName)
    {
        URL imageUrl = Main.class.getResource(fileName);
        try
        {
            sprite = ImageIO.read(imageUrl);
        } catch (IOException e)
        {
            System.out.println("Error int GameObject/loadImage"
                    + "Error:");
            System.out.println(e);
        }
        return sprite;
    }

    public BufferedImage getSprite()
    {
        return sprite;
    }

    private BufferedImage getImage()
    {
        System.out.println((System.currentTimeMillis() - systemTime));
        if ((System.currentTimeMillis() - systemTime) > frameSpeed)
        {
           
            systemTime = System.currentTimeMillis();
            System.out.println(animationFrame + " : " + animation.length);
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
        preAnimation();
        graphics.setColor(Color.red);
        graphics.drawRect(x, y, width, height);
        graphics.setColor(Color.blue);
        graphics.fillRect(x, y+1, width, 1);
        graphics.setColor(Color.green);
        graphics.fillRect(x, y, 1, height);
        graphics.fillRect(x+width, y-1, 1, height);
        graphics.setColor(Color.orange);
        graphics.fillRect(x, y+height-1, width, 2);
        graphics.drawImage(getImage(), x, y, null);
        postAnimation();
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

    public void setX(int x)
    {
        if (checkCollisionMap(x, y) == Collision.NONE)
        {
            this.x = x;
        }
    }

    public void setY(int y)
    {
        if (checkCollisionMap(x, y) == Collision.NONE)
        {
            this.y = y;
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
        Polygon mapPolygon =  game.getBackground().getPolygon();
        if (mapPolygon.intersects(x, y+1, width, 1))
        {
            return Collision.UP;
        }

        if (mapPolygon.intersects(x, y-1, 1, height) ||
             mapPolygon.intersects(x+width, y-1, 1, height))
        {
            return Collision.SIDE;
        }

        if (mapPolygon.intersects(x, y+height-1, width, downSize))
        {
            return Collision.DOWN;
        }

        return Collision.NONE;
    }

    protected void preAnimation()
    {

    }

    protected void postAnimation()
    {

    }
}
