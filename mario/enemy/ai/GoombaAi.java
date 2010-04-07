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
public class GoombaAi extends Ai
{
    public GoombaAi(Enemy enemy)
    {
        super(enemy);
    }

    @Override
    public void doLoopAction()
    {
        System.out.println("Goomba Ai Loop");
    }
}
