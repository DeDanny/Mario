/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.mapObjects;

import mario.Stages.StageMario;
import mario.Stages.Stage;
import mario.core.Direction;
import mario.core.Collision;
import java.awt.Rectangle;
import java.util.ArrayList;

import mario.ai.WalkAi;
import mario.core.StageObject;
import mario.core.interfaces.NoClip;
import mario.scenery.Tube;

/**
 *
 * @author Onno
 */
public class Mushroom extends Powerup implements NoClip {

    private boolean hit = false;
    private boolean hadCollision = false;
    private boolean changeAni = false;

    public Mushroom(Stage game, int x, int y, int width, int height) {
        super(game, x, y, width, height, "/images/nsmbtileset.png");

        ai = new WalkAi(this);
        ai.setWALKSPEED(2);
        frames.put("mushroom nothing", new Rectangle(0, 0, 1, 1));
        frames.put("mushroom 0", new Rectangle(1225, 2327, 48, 48));

        setAnimation(new String[]{"mushroom nothing"});

    }

    @Override
    public void doLoopAction() {
        if (hit) {
            super.ai();
        }

        if (changeAni) {
            setAnimation();
            changeAni = false;
        }

    }

    public void setAnimation() {
        setAnimation(new String[]{
                    "mushroom 0"
                });
    }

    @Override
    public void hitBy() {
    }

    @Override
    public void doMapCollision() {
        switch (mapCollision) {
            case SIDE:
                ai.toggleDirection();
                break;
            case NONE:
                setFall(true);
                break;
            default:
                setFall(false);
                break;

        }
    }

    public void doMapCollision(Collision side) {
        if (side == Collision.SIDE) {
            Direction direction = ai.getDirection();
            if (direction == Direction.LEFT) {
                direction = Direction.RIGHT;
            } else {
                direction = Direction.LEFT;
            }
            ai.setDirection(direction);
        }
    }

    @Override
    public void doCharacterCollision(ArrayList<Collision> collisions, StageObject stageObject) {
        /**
         * @todo remove tempory fix
         */
        Collision collision = collisions.get(0);
        if (stageObject instanceof StageMario) {
            if (hadCollision) {
                if (!stage.getMario().isBig()) {
                    setAlive(false);
                    stage.getMario().setGrow(true);
                }
            }
        }

        if (stageObject instanceof Questionmark) {
            hadCollision = true;
            hit = true;
            changeAni = true;
        }


        if (stageObject instanceof Tube) {
            switch (collision) {
                case UP:
                    ai.toggleDirection();
                    break;
            }
        }
    }
}
