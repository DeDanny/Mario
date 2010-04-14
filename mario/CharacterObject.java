/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario;

import java.awt.Rectangle;

/**
 *
 * @author danny
 */
abstract public class CharacterObject extends GameObject
{
    protected int fallSpeed = 2;
    protected CharacterObject characterObject;
    protected boolean alive = true;
    public CharacterObject(Game game, int x, int y, int width, int height, String fileName)
    {
        super(game, x, y, width, height, fileName);
    }

    public void doMapCollision(Collision side)
    {
        
    }
    
    abstract public void doCharacterCollision(Collision collision);

    public Collision checkCollisionGameCharacters()
    {
         for (CharacterObject characterObjectLoop : game.getCharactersObjects())
        {
             characterObject = characterObjectLoop;
             if(characterObject != this)
             {
                Rectangle characterObjectRectangle =  new Rectangle(characterObject.getX(), characterObject.getY(), characterObject.getWidth(), characterObject.getHeight());

                if (characterObjectRectangle.intersects(x, y-1, 1, height) ||
                     characterObjectRectangle.intersects(x+width, y-1, 1, height))
                {
                    return Collision.SIDE;
                }
                
                if (characterObjectRectangle.intersects(x, y+1, width, 1))
                {
                    return Collision.UP;
                }


                if (characterObjectRectangle.intersects(x, y+height-1, width, 4))
                {
                    return Collision.DOWN;
                }
             }
        }

        return Collision.NONE;
    }

    public boolean isAlive()
    {
        return alive;
    }

    protected void setAlive(boolean alive)
    {
        this.alive = alive;
    }
}
