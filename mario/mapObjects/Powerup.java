/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.mapObjects;

import mario.ai.Ai;
import mario.core.CharacterObject;
import mario.Game;

/**
 *
 * @author Danny
 */
abstract public class Powerup extends CharacterObject
{
    protected Ai ai;

    public Powerup(Game game, int x, int y, int width, int height, String fileName)
    {
        super(game, x, y, width, height, fileName);
    }

   
    @Override
    public void doLoopAction()
    {
        //ai();
    }

    public void ai()
    {
        ai.doLoopAction();
    }

    public abstract void hitBy();
}
