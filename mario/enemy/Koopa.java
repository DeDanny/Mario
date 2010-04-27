/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mario.enemy;

import java.awt.Rectangle;
import mario.core.Collision;
import mario.core.interfaces.NoClip;
import mario.Stages.Stage;
import mario.ai.WalkAi;
import mario.core.Direction;
import mario.core.StageObject;
import mario.scenery.Tube;


/**
 *
 * @author Onno
 */
public class Koopa extends Enemy implements NoClip {

    private boolean isShell = false;
    private boolean isMoving = true;

    public Koopa(Stage game, int x, int y, int width, int height) {
        super(game, x, y, width, height, "/images/smw_enemies_sheet.png");
        init();
    }
    public Koopa(Stage game, int x, int y, int width, int height, int pushX, int pushY) {
        super(game, x, y, width, height, pushX, pushY, "/images/smw_enemies_sheet.png");
        init();
    }

    private void init()
    {
        ai = new WalkAi(this);
        frames.put("koopaStandLeft 0", new Rectangle(396, 0, 48, 81));
        frames.put("koopaWalkLeft 0", new Rectangle(276, 0, 48, 81));
        //.put("koopaWalkLeft 1", new Rectangle(156, 0, 48, 81));

        frames.put("koopaStandRight 0", new Rectangle(296, 476, 48, 81));
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
    public void doCharacterCollision(Collision collision, StageObject stageObject) {
        if (stageObject instanceof mario.Stages.StageMario) {
            switch (collision) {
                case UP:
                    if(!isShell)
                    {
                        setHeight(48);
                        //setY(stageObject.getY() - 33);
                        ai.setDirection(Direction.NONE);
                        setAnimation(new String[]{"koopaFlat 0"});
                        isShell = true;
                    }
                    else
                    {
                        setAlive(false);
                        game.getScoreBalk().killEnemy();
                    }

                    break;
                case SIDE:
                    if(isShell){
                        ai.setWALKSPEED(5);
                        isMoving = true;
                    }
                    break;
            }
        }


        if (stageObject instanceof Koopa) {
            switch (collision) {
                case SIDE:
                    Koopa koopa = (Koopa) stageObject;
                    if(koopa.isShell() && koopa.isMoving())
                    {
                        setAlive(false);
                        game.getScoreBalk().killEnemy();
                    }
                    break;
            }
        }


        if (stageObject instanceof Tube) {
            switch (collision) {
                case UP:
                    ai.toggleDirection();
                    switch (ai.getDirection()) {
                        case LEFT:
                            setAnimation(new String[]{"koopaStandLeft 0", "koopaWalkLeft 0", "koopaWalkLeft 1"});
                            break;
                        case RIGHT:
                            setAnimation(new String[]{"koopaStandRight 0", "koopaWalkRight 0", "koopaWalkRight 1"});
                            break;
                    }
                    break;
            }
        }
    }
}