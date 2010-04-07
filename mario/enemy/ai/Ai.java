/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.enemy.ai;

import mario.enemy.Enemy;

/**
 *
 * @author Danny
 */
abstract public class Ai
{
    protected Enemy enemy;

    public Ai(Enemy enemy)
    {
        this.enemy = enemy;
    }

    public abstract void doLoopAction();
}
