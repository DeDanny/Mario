/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.mapObjects;

import mario.Stages.Stage;
import java.awt.Rectangle;
import java.util.ArrayList;
import mario.*;
import mario.Stages.StageMario;
import mario.core.Collision;
import mario.core.StageObject;

/**
 *
 * @author Nishchal Baldew
 */
public class Questionmark extends Cube
{
    protected boolean hit = false;
    protected boolean done = false;

    public Questionmark(Stage game, int x, int y, int width, int height)
    {
        super(game, x, y, width, height, "/images/nsmbtileset.png");

        frames.put("questionmark 0", new Rectangle(870, 3771, 48, 48));
        frames.put("questionmark 1", new Rectangle(921, 3771, 48, 48));
        frames.put("questionmark 2", new Rectangle(972, 3771, 48, 48));
        frames.put("questionmark 3", new Rectangle(1023, 3771, 48, 48));
        frames.put("questionmark end", new Rectangle(507, 66, 48, 48));//vast blokje
        frameSpeed = 100;
        setAnimation(new String[]
                {
                    "questionmark 0", "questionmark 1", "questionmark 2", "questionmark 3"
                });

    }

    @Override
    public void doLoopAction()
    {

        if (hit && !done)
        {
            setAnimation(new String[]
                    {
                        "questionmark end"
                    });
            super.doHit();
            if (getGoinUp() == 20)
            {
                hit = false;
                done = true;
                setGoinUp(0);

            }

        }
    }

    @Override
    public void doCharacterCollision(ArrayList<Collision> collisions, StageObject charachter)
    {
        /**
         * @todo remove tempory fix
         */
        Collision collision = collisions.get(0);
        if (charachter instanceof StageMario)
        {

            switch (collision)
            {
                case SIDE:

                    break;
                case UP:

                    break;
                case DOWN:
                    hit = true;
                    break;
                case NONE:

                    break;
            }

        }

    }
}
