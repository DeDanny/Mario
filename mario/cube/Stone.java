/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.cube;

import java.awt.Rectangle;
import mario.*;

/**
 *
 * @author Nishchal Baldew
 */
public class Stone extends Cube
{


    public Stone(Game game)
    {
        super(game, 148, 349, 48, 49, "/images/nsmbtileset.png");

        frames.put("stone 0", new Rectangle(558, 116, 49, 49));
        
        setAnimation(new String[]
                {
                    "stone 0"
                });

    }

    @Override
    public void doLoopAction()
    {
        doHit();
    }
}


