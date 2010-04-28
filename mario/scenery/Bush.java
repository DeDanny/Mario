/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.scenery;

import mario.core.interfaces.BackGround;
import java.awt.Rectangle;
import mario.Stages.Stage;
import mario.core.interfaces.NoClip;

public class Bush extends Scenery implements NoClip, BackGround
{
    public Bush(Stage game, int x, int y, int width, int height)
    {
        super(game, x, y, width, height, "/images/nsmbtileset.png");
        frames.put("bush 0", new Rectangle(424, 4134, 99, 78));
        frames.put("bush 1", new Rectangle(523, 4134, 99, 78));

        frameSpeed = 700;
        setAnimation(new String[]
                {
                    "bush 0", "bush 1"
                });
    }
}