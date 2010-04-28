/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.core;

import mario.core.engine.GameObject;
import mario.core.interfaces.NoClip;
import mario.core.interfaces.Static;
import java.awt.Rectangle;
import java.util.ArrayList;
import mario.Stages.Stage;
import mario.Stages.StageMario;

/**
 *
 * @author Danny
 */
abstract public class StageObject extends GameObject
{
    protected int fallSpeed = 2;
    protected boolean alive = true;
    protected boolean fall = false;
    protected int x_last, y_last, width_last, height_last, pushX = 0, pushY = 0;
    protected Stage stage;

    public StageObject(Stage stage, int x, int y, int width, int height, String fileName)
    {
        super(x, y, width, height, fileName);
        this.stage = stage;
    }

    /**
     * 
     * @param stage
     * @param x
     * @param y
     * @param width
     * @param height
     * @param pushX //Expirimental
     * @param pushY //Expirimental
     * @param fileName
     */
    public StageObject(Stage game, int x, int y, int width, int height, int pushX, int pushY, String fileName)
    {
        super(x, y, width, height, fileName);
        this.stage = game;
        this.pushX = pushX;
        this.pushY = pushY;
    }

    public boolean isAlive()
    {
        return alive;
    }

    protected void setAlive(boolean alive)
    {
        this.alive = alive;
    }

    public abstract void doCharacterCollision(ArrayList<Collision> collisions, StageObject stageObject);


    public boolean isFall()
    {
        return fall;
    }

    public void setFall(boolean fall)
    {
        this.fall = fall;
    }

    public void doMapCollision()
    {
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
        Rectangle objectRectangle = new Rectangle(x+pushX, y+pushY, width, height + downSize);

        mapCollision = Collision.NONE;

        if (mapCollision == Collision.NONE)
        {
            for (StageObject characterObjectLoop : stage.getMapObjects())
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
        }

        return mapCollision;
    }

    private void moveAll(int i)
    {
        for (StageObject characterObjectLoop : stage.getMapObjects())
        {
            if (!(characterObjectLoop instanceof Static))
            {
                if (characterObjectLoop instanceof StageMario)
                {
                    StageMario mario = (StageMario) characterObjectLoop;
                    mario.setStepCounter(mario.getStepCounter() + 1);
                }
                characterObjectLoop.setX(characterObjectLoop.getX() - i, true);
            }
        }
    }

    @Override
    public void setX(int x)
    {

        if (checkCollisionMap(x, y) == Collision.NONE)
        {
            x_last = this.x;
            this.x = x;
            if (this instanceof StageMario)
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

    @Override
    public void setY(int y)
    {
        if (checkCollisionMap(x, y) == Collision.NONE)
        {
            y_last = this.y;
            this.y = y;
        }
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


    @Override
    public void setHeight(int height)
    {
        height_last = this.height;
        super.setHeight(height);
    }

    @Override
    public void setWidth(int width)
    {
        width_last = this.width;
        super.setWidth(width);
    }
}
