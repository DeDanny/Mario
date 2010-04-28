/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.ai;

import mario.core.Collision;
import mario.core.Direction;
import mario.core.StageObject;
import mario.Stages.StageMario;

/**
 *
 * @author Onno
 */
public class MarioFireballAi extends Ai {

    private boolean goingUp = false;
    private int upsize = 3;
    private int fallsize = 3;
    private int upTeller;

    public MarioFireballAi(StageObject mapObject) {
        super(mapObject);
    }

    @Override
    public void doLoopAction() {
        if (stageObject.isFall() && !goingUp) {
            goingUp = false;
            upTeller = 0;
            while (stageObject.checkCollisionMap(stageObject.getX(), stageObject.getY() + fallsize) != Collision.NONE && fallsize != 0) {
                fallsize--;
            }
            stageObject.setY(stageObject.getY() + fallsize);
        } else {
            fallsize = 5;
            goingUp = true;
            if (upTeller == 20) {
                goingUp = false;
            }
            stageObject.setY(stageObject.getY() - upsize);
            upTeller++;
        }

        switch (direction) {
            case LEFT:
                stageObject.setX(stageObject.getX() - WALKSPEED);
                break;
            case RIGHT:
                stageObject.setX(stageObject.getX() + WALKSPEED);
                break;
            case NONE:

                break;
        }

    }
}
