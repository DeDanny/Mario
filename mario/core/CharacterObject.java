/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.core;

import mario.Stages.Stage;


/**
 *
 * @author danny
 */
abstract public class CharacterObject extends StageObject
{
    public CharacterObject(Stage game, int x, int y, int width, int height, String fileName)
    {
        super(game, x, y, width, height, fileName);
    }
}
