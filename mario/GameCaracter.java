/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario;

/**
 *
 * @author danny
 */
abstract public class GameCaracter extends GameObject
{
    protected int fallSpeed = 2;
    public GameCaracter(Game game, int x, int y, int width, int height, String fileName)
    {
        super(game, x, y, width, height, fileName);
    }

    public void doGravity()
    {
        setY(getY()+fallSpeed);
    }
}
