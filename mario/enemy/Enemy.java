/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.enemy;

import mario.enemy.ai.Ai;
import mario.GameCaracter;
import mario.Game;

/**
 *
 * @author Danny
 */
abstract public class Enemy extends GameCaracter
{
    protected Ai ai;

    public Enemy(Game game, int x, int y, int width, int height, String fileName)
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
