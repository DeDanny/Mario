/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.core;

import mario.Game;

/**
 *
 * @author Danny
 */
abstract public class MapObject extends GameObject
{
    protected int fallSpeed = 2;
    protected boolean alive = true;
    protected boolean fall = false;
    public MapObject(Game game, int x, int y, int width, int height, String fileName)
    {
        super(game, x, y, width, height, fileName);
    }
    public boolean isAlive()
    {
        return alive;
    }

    protected void setAlive(boolean alive)
    {
        this.alive = alive;
    }
    
    public abstract void doCharacterCollision(Collision collision, MapObject mapObject);

    public boolean isFall() {
        return fall;
    }
    
    public void setFall(boolean fall) {
        this.fall = fall;
    }

    public void doMapCollision()
    {

    }
}