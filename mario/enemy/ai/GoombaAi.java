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

      // protected String[] WalkRight = new String[]{"goombaWalkRight 0"};
    }

    @Override
    public void doLoopAction()
    {
       // super.setAnimation("WalkRight");
         enemy.setX(enemy.getX() - 1);
    }
}
