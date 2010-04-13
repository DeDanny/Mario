/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario;

/**
 *
 * @author danny
 */
abstract public class GameCharacter extends GameObject
{
    protected int fallSpeed = 2;
    public GameCharacter(Game game, int x, int y, int width, int height, String fileName)
    {
        super(game, x, y, width, height, fileName);
    }

    public void doMapCollision(Collision side)
    {
        
    }
    
    abstract public void doCharacterCollision(Collision collision);

    public Collision checkCollisionGameCharacters()
    {
        return Collision.DOWN;
    }
}
