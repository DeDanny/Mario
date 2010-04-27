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
public class Stone extends Cube
{
    protected boolean hit = false;

    public Stone(Stage game, int x, int y, int width, int height)
    {
        super(game, x, y, width, height, "/images/nsmbtileset.png");

        frames.put("stone 0", new Rectangle(870, 3822, 49, 49));
        frames.put("stone 1", new Rectangle(921, 3822, 49, 49));
        frames.put("stone 2", new Rectangle(972, 3822, 49, 49));
        frames.put("stone 3", new Rectangle(1023, 3822, 49, 49));
        frameSpeed = 100;
        setAnimation(new String[]
                {
                    "stone 0", "stone 0", "stone 0", "stone 0", "stone 0", "stone 0", "stone 0", "stone 0", "stone 1", "stone 2", "stone 3"
                });

    }

    @Override
    public void doLoopAction()
    {
        if (hit)
        {
            super.doHit();
            if (getGoinUp() == 20)
            {
                hit = false;
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
