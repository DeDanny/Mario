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
import mario.*;
import mario.ai.WalkAi;
import mario.core.StageObject;
import mario.core.interfaces.NoClip;

/**
 *
 * @author Onno
 */
public class Flower extends Powerup implements NoClip
{
    private boolean hit = false;
    private boolean hadCollision = false;
    private boolean changeAni = false;

    public Flower(Stage game, int x, int y, int width, int height)
    {
        super(game, x, y, width, height, "/images/nsmbtileset.png");

        ai = new WalkAi(this);
        ai.setWALKSPEED(2);
        frames.put("flower nothing", new Rectangle(0, 0, 1, 1));
        frames.put("flower 0", new Rectangle(1230,  2379, 42, 48));
        setAnimation(new String[]{"flower nothing"});
    }

    @Override
    public void doLoopAction()
    {
        if (hit)
        {
            //super.ai();
        }

        if (changeAni)
        {
            setAnimation();
            changeAni = false;
        }

    }

    public void setAnimation()
    {
        setAnimation(new String[]{"flower 0"});
    }

    @Override
    public void hitBy()
    {
    }

    @Override
    public void doMapCollision()
    {

    }

    public void doMapCollision(Collision side)
    {
        if (side == Collision.SIDE)
        {
            Direction direction = ai.getDirection();
            if (direction == Direction.LEFT)
            {
                direction = Direction.RIGHT;
            }
            else
            {
                direction = Direction.LEFT;
            }
            ai.setDirection(direction);
        }
    }

    @Override
    public void doCharacterCollision(ArrayList<Collision> collisions, StageObject stageObject)
    {
        /**
         * @todo remove tempory fix
         */
        Collision collision = collisions.get(0);
        if (stageObject instanceof StageMario)
        {
            if (hadCollision)
            {
                if (stage.getMario().isBig())
                {
                    setAlive(false);
                    stage.getMario().setInit(true);
                    stage.getMario().setFlowerPower(true);
                }
            }
        }

        if (stageObject instanceof Questionmark)
        {
            hadCollision = true;
            hit = true;
            changeAni = true;
        }

    }
}
