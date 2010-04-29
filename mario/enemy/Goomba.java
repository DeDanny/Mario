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
import mario.core.StageObject;
import mario.scenery.Tube;
import mario.weapons.Fireball;

/**
 *
 * @author Danny
 */
public class Goomba extends Enemy implements NoClip {

    private boolean doPoints = true;

    public Goomba(Stage game, int x, int y, int width, int height) {
        super(game, x, y, width, height, "/images/smw_enemies_sheet.png");
        init();
    }

    public Goomba(Stage game, int x, int y, int width, int height, int pushX, int pushY) {
        super(game, x, y, width, height, pushX, pushY, "/images/smw_enemies_sheet.png");
        init();
    }

    private void init() {
        ai = new WalkAi(this);
        frames.put("goombaStandLeft 0", new Rectangle(27, 4161, 45, 51));
        frames.put("goombaWalkLeft 0", new Rectangle(87, 4161, 45, 51));
        frames.put("goombaWalkLeft 1", new Rectangle(150, 4161, 45, 51));
        frames.put("goombaWalkLeft 2", new Rectangle(213, 4161, 45, 51));
        frames.put("goombaWalkLeft 3", new Rectangle(276, 4161, 45, 51));
        frames.put("goombaWalkLeft 4", new Rectangle(339, 4161, 45, 51));

        frames.put("goombaStandRight 0", new Rectangle(27, 4100, 45, 51));
        frames.put("goombaWalkRight 0", new Rectangle(84, 4100, 45, 51));
        frames.put("goombaWalkRight 1", new Rectangle(147, 4100, 45, 51));
        frames.put("goombaWalkRight 2", new Rectangle(210, 4100, 45, 51));
        frames.put("goombaWalkRight 3", new Rectangle(273, 4100, 45, 51));
        frames.put("goombaWalkRight 4", new Rectangle(336, 4100, 45, 51));

        frames.put("goombaDeadRight", new Rectangle(290, 4232, 48, 54));
        frames.put("goombaDeadLeft", new Rectangle(235, 4232, 48, 54));

        frames.put("goombaFlatRight", new Rectangle(25, 4388, 45, 48));
        frames.put("goombaFlatLeft", new Rectangle(73, 4388, 45, 48));
        frameSpeed = 100;

        setAnimation(new String[]{
                    "goombaStandLeft 0", "goombaWalkLeft 4", "goombaWalkLeft 3", "goombaWalkLeft 2", "goombaWalkLeft 1", "goombaWalkLeft 0"
                });
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

    public void doCharacterCollision(ArrayList<Collision> collisions, StageObject stageObject) {
        /**
         * @todo remove tempory fix
         */
        Collision collision = collisions.get(0);
        if (stageObject instanceof mario.Stages.StageMario) {
            switch (collision) {
                case UP:
                    //////System.out.println("Goomba is dead");
                    //setAlive(false);
                    doFlat();
                    if (doPoints) {
                        stage.getScoreBalk().killEnemy();
                        doPoints = false;
                    }
                    break;
            }
        }

        if (stageObject instanceof Koopa) {
            if (collisions.contains(Collision.LEFT) || collisions.contains(Collision.RIGHT)) {
                Koopa koopa = (Koopa) stageObject;
                if (koopa.isShell() && koopa.isMoving()) {
                    //setAlive(false);
                    //stage.getScoreBalk().killEnemy();
                    doDead();
                    if (doPoints) {
                        stage.getScoreBalk().killEnemy();
                        doPoints = false;
                    }
                }
            }
        }

        if (stageObject instanceof Tube) {
            switch (collision) {
                case UP:
                    ai.toggleDirection();
                    switch (ai.getDirection()) {
                        case LEFT:
                            setAnimation(new String[]{
                                        "goombaStandLeft 0", "goombaWalkLeft 4", "goombaWalkLeft 3", "goombaWalkLeft 2", "goombaWalkLeft 1", "goombaWalkLeft 0"
                                    });
                            break;
                        case RIGHT:
                            setAnimation(new String[]{
                                        "goombaStandRight 0", "goombaWalkRight 0", "goombaWalkRight 1", "goombaWalkRight 2", "goombaWalkRight 3", "goombaWalkRight 4"
                                    });
                            break;
                    }
                    //////System.out.println("Goomba Head is bumping on Tube -- Toggle Direction");
                    break;
                case DOWN:
                    //////System.out.println("Goomba is Walking on Tube -- Doorlopen");
                    break;
            }
        }
        if (stageObject instanceof Fireball) {
            //setAlive(false);
            doDead();
             stage.getSound().playSound("/sound/deadGoomba.wav");

        }
    }

    public void doDead() {

        switch (ai.getDirection()) {
            case LEFT:
                setAnimation(new String[]{"goombaFlatLeft"});
                break;
            case RIGHT:
                setAnimation(new String[]{"goombaFlatRight"});
                break;
        }

        setDead(true);

    }

    public void doFlat() {
        switch (ai.getDirection()) {
            case LEFT:
                setAnimation(new String[]{"goombaFlatLeft"});
                break;
            case RIGHT:
                setAnimation(new String[]{"goombaFlatRight"});
                break;
        }

        setDead(true);

    }
}
