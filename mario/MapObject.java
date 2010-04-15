/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario;

/**
 *
 * @author Danny
 */
abstract public class MapObject extends GameObject
{
    private int score = 0;
    
    public MapObject(Game game, int x, int y, int width, int height, String fileName)
    {
        super(game, x, y, width, height, fileName);
    }


}
