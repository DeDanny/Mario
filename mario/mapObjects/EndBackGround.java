/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.mapObjects;

import java.awt.Rectangle;
import mario.Stages.Stage;
import mario.core.interfaces.BackGround;
import mario.core.interfaces.NoClip;
import mario.scenery.Scenery;

/**
 *
 * @author danny
 */
public class EndBackGround extends Scenery implements NoClip, BackGround
{
    public EndBackGround(Stage game, int x, int y, int width, int height)
    {
        super(game, x, y, width, height, "/images/finish.png");
        frames.put("pole", new Rectangle(32, 4, 24, 118));
        setAnimation(new String[]
                {
                    "pole"
                });
    }
}
