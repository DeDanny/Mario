/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.enemy.state;

import mario.State;
import mario.enemy.Enemy;

/**
 *
 * @author Danny
 */
abstract public class EnemyState extends State
{
    public EnemyState(Enemy gameObject)
    {
        super(gameObject);
    }
}
