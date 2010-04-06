/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.enemy.state;

import mario.enemy.Enemy;

/**
 *
 * @author Danny
 */
abstract public class EnemyState
{
    protected Enemy gameObject;
    public EnemyState(Enemy gameObject)
    {
        this.gameObject = gameObject;
    }
}
