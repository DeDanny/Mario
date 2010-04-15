/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.enemy.ai;

import mario.Collision;
import mario.enemy.Enemy;

/**
 *
 * @author Danny
 */
public class GoombaAi extends Ai {

    public GoombaAi(Enemy enemy) {
        super(enemy);

        // protected String[] WalkRight = new String[]{"goombaWalkRight 0"};
    }

    @Override
    public void doLoopAction() {
        // super.setAnimation("WalkRight");
        if (enemy.isFall()) {
            int fallsize = 5;
            while (enemy.checkCollisionMap(enemy.getX(), enemy.getY() + fallsize) != Collision.NONE && fallsize != 0) {
                fallsize--;
                System.out.println("fallsize = " + fallsize);
            }

            enemy.setY(enemy.getY() + fallsize);
            System.out.println("fall goombla");
        }

        enemy.setX(enemy.getX() - 1);
        // super.setAnimation(new String[] {"goombaStandRight 0", "goombaWalkRight"});
    }
}
