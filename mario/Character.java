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
    public Character(int x, int y, int width, int height, String fileName)
    {
        super(x, y, width, height, fileName);
    }

    public abstract void doGravity();
}
