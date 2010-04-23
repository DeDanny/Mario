/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.background;

import mario.Stages.Stage;
import java.awt.Rectangle;
import java.io.Serializable;
import mario.*;
import mario.core.Collision;
import mario.core.StageObject;
import mario.core.interfaces.ReUse;

/**
 *
 * @author Onno
 */
public class Background extends StageObject implements ReUse, Serializable
{
    public Background(Stage game, int x, int y, int width, int height)
    {
        super(game, x, y, width, height, "/images/background_gameplay.png");
        frames.put("drawBackground 0", new Rectangle(0, 0, 800, 48));
        setAnimation(new String[]
                {
                    "drawBackground 0"
                });

    }

    @Override
    public void doLoopAction()
    {
    }


    public void doCharacterCollision(Collision collision, StageObject mapObject)
    {
        
    }
}
