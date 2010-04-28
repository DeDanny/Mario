/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.mapObjects;

import java.awt.Rectangle;
import java.util.ArrayList;
import mario.Stages.Stage;
import mario.core.Collision;
import mario.core.StageObject;
import mario.core.interfaces.NoClip;

/**
 *
 * @author Nishchal Baldew
 */
public class Coin extends StageObject implements NoClip
{
    private boolean hit = false;
    private boolean changeAni = false;
    private int goinUp;
    private boolean hadCollision = false;

    public Coin(Stage game, int x, int y, int width, int height)
    {
        super(game, x, y, width, height, "/images/nsmbtileset.png");
        frames.put("munt nothing", new Rectangle(0, 0, 1, 1));
        frames.put("munt 0", new Rectangle(457, 167, 45, 48));
        frames.put("munt 1", new Rectangle(922, 3873, 45, 48));
        frames.put("munt 2", new Rectangle(973, 3872, 45, 48));
        frames.put("munt 3", new Rectangle(1023, 3873, 45, 48));
        setAnimation(new String[]
                {
                    "munt nothing"
                });
    }

    @Override
    public void doLoopAction()
    {
        if (hit)
        {
            doHit();

        }

        if (changeAni)
        {
            setAnimation();
            changeAni = false;
        }
    }

    public void doHit()
    {

        if (goinUp < 20)
        {
            setY(getY() - 5);
        }
        else if (goinUp < 40)
        {
            setY(getY() + 5);
        }
        goinUp++;

    }

    public void setAnimation()
    {
        setAnimation(new String[]
                {
                    "munt 0", "munt 1", "munt 2", "munt 3"
                });
    }

    @Override
    public void doCharacterCollision(ArrayList<Collision> collisions, StageObject stageObject)
    {
        /**
         * @todo remove tempory fix
         */
        Collision collision = collisions.get(0);
        if (stageObject instanceof mario.Stages.StageMario)
        {
            if (hadCollision)
            {
                stage.getScoreBalk().addCoin();
                stage.getSound().playSound("/sound/coin.wav");
                setAlive(false);
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
