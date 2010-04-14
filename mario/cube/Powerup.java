/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.cube;

import mario.cube.ai.Ai;
import mario.GameCharacter;
import mario.Game;

/**
 *
 * @author Danny
 */
abstract public class Powerup extends GameCharacter
{
    protected Ai ai;

    public Powerup(Game game, int x, int y, int width, int height, String fileName)
    {
        super(game, x, y, width, height, fileName);
    }

    @Override
    public final void doLoopAction()
    {
        ai();
    }

    public final void ai()
    {
        ai.doLoopAction();
    }

    public abstract void hitBy();
}
