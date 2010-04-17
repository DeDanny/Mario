/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.background;

import mario.core.GameObject;
import java.awt.Rectangle;
import mario.*;

/**
 *
 * @author Onno
 */
public class Background extends GameObject
{
    public Background(Game game)
    {
        super(game, 0, 0, 800, 600, "/images/background_gameplay.png");
        frames.put("drawBackground 0", new Rectangle(0, 0, 800, 600));
        setAnimation(new String[]
                {
                    "drawBackground 0"
                });

    }

    @Override
    public void doLoopAction()
    {
    }
}
