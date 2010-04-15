/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario;


/**
 *
 * @author danny
 */
abstract public class CharacterObject extends GameObject
{
    protected int fallSpeed = 2;
    protected boolean alive = true;
    public CharacterObject(Game game, int x, int y, int width, int height, String fileName)
    {
        super(game, x, y, width, height, fileName);
    }

    public void doMapCollision(Collision side)
    {
        
    }
    
    abstract public void doCharacterCollision(Collision collision, CharacterObject charachter);

    public boolean isAlive()
    {
        return alive;
    }

    protected void setAlive(boolean alive)
    {
        this.alive = alive;
    }
}
