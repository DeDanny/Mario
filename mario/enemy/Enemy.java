/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.enemy;

import mario.ai.Ai;
import mario.core.CharacterObject;
import mario.Stages.Stage;

/**
 *
 * @author Danny
 */
abstract public class Enemy extends CharacterObject {

    protected Ai ai;

    public Enemy(Stage game, int x, int y, int width, int height, String fileName) {
        super(game, x, y, width, height, fileName);
    }

    @Override
    public final void doLoopAction() {
        ai();
    }

    public final void ai() {
        ai.doLoopAction();
    }

    public abstract void hitBy();
}