/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.enemy;

import java.awt.Rectangle;
import java.util.ArrayList;
import mario.core.Collision;
import mario.core.interfaces.NoClip;
import mario.Stages.Stage;
import mario.ai.WalkAi;
import mario.core.Direction;
import mario.core.StageObject;
import mario.scenery.Tube;
import mario.weapons.Fireball;

/**
 *
 * @author Onno
 */
public class Koopa extends Enemy implements NoClip {

    private boolean isShell = false;
    private boolean isMoving = false;
    private long godModeTimer = System.currentTimeMillis();
    private int godModeTime = 100;

    public Koopa(Stage game, int x, int y, int width, int height) {
        super(game, x, y, width, height, "/images/smw_enemies_sheet.png");
        init();
    }

    public Koopa(Stage game, int x, int y, int width, int height, int pushX, int pushY) {
        super(game, x, y, width, height, pushX, pushY, "/images/smw_enemies_sheet.png");
        init();
    }

    private void init() {
        ai = new WalkAi(this);
        frames.put("koopaStandLeft 0", new Rectangle(396, 0, 48, 81));
        frames.put("koopaWalkLeft 0", new Rectangle(276, 0, 48, 81));
        //.put("koopaWalkLeft 1", new Rectangle(156, 0, 48, 81));

        frames.put("koopaStandRight 0", new Rectangle(156, 476, 48, 81));
        frames.put("koopaWalkRight 0", new Rectangle(276, 476, 48, 81));
        //frames.put("koopaWalkRight 1", new Rectangle(156, 476, 48, 81));

        frames.put("koopaFlat 0", new Rectangle(36, 18, 48, 48));
        frames.put("koopaFlat 1", new Rectangle(36, 138, 48, 48));
        frames.put("koopaFlat 2", new Rectangle(36, 258, 48, 48));

        frameSpeed = 100;

        setAnimation(new String[]{"koopaStandLeft 0", "koopaWalkLeft 0"});
        //setAnimation(new String[]{"koopaFlat 0", "koopaFlat 1", "koopaFlat 2"});
    }

    @Override
    public void hitBy() {
    }

    @Override
    public void doMapCollision() {
        checkCollisionMap();
        if (mapCollision == Collision.NONE) {
            setFall(true);
        }
        if (mapCollision != Collision.NONE) {
            setFall(false);
        }

    }

    public boolean isShell() {
        return isShell;
    }

    public boolean isMoving() {
        return isMoving;
    }

    @Override
    public void doCharacterCollision(ArrayList<Collision> collisions, StageObject stageObject) {
        /**
         * @todo remove tempory fix
         */
        Collision collision = collisions.get(0);
        if (stageObject instanceof mario.Stages.StageMario) {
            if ((System.currentTimeMillis() - godModeTimer) > godModeTime) {
                if (collisions.contains(Collision.UP)) {
                    if (!isShell || isMoving) {
                        setHeight(48);
                        //setY(stageObject.getY() - 33);
                        ai.setDirection(Direction.LEFT);
                        setAnimation(new String[]{"koopaFlat 0"});
                        ai.setWALKSPEED(0);
                        isShell = true;
                        isMoving = false;
                    } else {
                        ai.setDirection(Direction.LEFT);
                        ai.setWALKSPEED(7);
                        setAnimation(new String[]{"koopaFlat 0", "koopaFlat 1", "koopaFlat 2"});
                        isMoving = true;
                    }
                    // System.out.println("Col Up");
                } else if (collisions.contains(Collision.LEFT)) {
                    if (isShell) {
                        ai.setDirection(Direction.RIGHT);
                        ai.setWALKSPEED(7);
                        setAnimation(new String[]{"koopaFlat 0", "koopaFlat 1", "koopaFlat 2"});
                        isMoving = true;
                    }
                    //System.out.println("Col LEFT");
                } else if (collisions.contains(Collision.RIGHT)) {
                    if (isShell) {
                        ai.setDirection(Direction.LEFT);
                        ai.setWALKSPEED(7);
                        setAnimation(new String[]{"koopaFlat 0", "koopaFlat 1", "koopaFlat 2"});
                        isMoving = true;
                    }
                    //System.out.println("Col Right");
                }
                godModeTimer = System.currentTimeMillis();
            }
        }


        if (stageObject instanceof Koopa) {
            switch (collision) {
                case SIDE:
                    Koopa koopa = (Koopa) stageObject;
                    if (koopa.isShell() && koopa.isMoving()) {
                        setAlive(false);
                        stage.getScoreBalk().killEnemy();
                    }
                    break;
            }
        }


        if (stageObject instanceof Tube) {
            if (!collisions.contains(Collision.DOWN)) {
                ai.toggleDirection();
                if (!isShell) {
                    switch (ai.getDirection()) {
                        case LEFT:
                            setAnimation(new String[]{"koopaStandLeft 0", "koopaWalkLeft 0"});
                            break;
                        case RIGHT:
                            setAnimation(new String[]{"koopaStandRight 0", "koopaWalkRight 0"});
                            break;
                    }
                }


            }
//
//            switch (collision) {
//                case UP:
//                    ai.toggleDirection();
//                    if (!isShell) {
//                        switch (ai.getDirection()) {
//                            case LEFT:
//                                setAnimation(new String[]{"koopaStandLeft 0", "koopaWalkLeft 0"});
//                                break;
//                            case RIGHT:
//                                setAnimation(new String[]{"koopaStandRight 0", "koopaWalkRight 0"});
//                                break;
//                        }
//                    }
//
//                    break;
//            }
        }

        if (stageObject instanceof Fireball) {
            setAlive(false);
            stage.getScoreBalk().killEnemy();
        }
    }
}
