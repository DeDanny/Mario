/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.enemy;

import mario.GameObject;
import mario.enemy.ai.Ai;


/**
 *
 * @author Danny
 */
abstract public class Enemy extends GameObject
{
    protected Ai ai;
    public Enemy(int x, int y, int width, int height, String fileName)
    {

       super(x, y, width, height, fileName);
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
