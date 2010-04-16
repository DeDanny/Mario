/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.core;

import mario.Game;


/**
 *
 * @author danny
 */
abstract public class CharacterObject extends MapObject
{
    public CharacterObject(Game game, int x, int y, int width, int height, String fileName)
    {
        super(game, x, y, width, height, fileName);
    }
}
