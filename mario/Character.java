/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario;

/**
 *
 * @author danny
 */
abstract public class Character extends GameObject
{
    public Character(Game game, int x, int y, int width, int height, String fileName)
    {
        super(game, x, y, width, height, fileName);
    }

    public abstract void doGravity();
}
