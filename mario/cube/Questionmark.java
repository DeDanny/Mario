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
public class Questionmark extends Cube
{


    public Questionmark(Game game)
    {
        super(game, 100, 350, 47, 48, "/images/nsmbtileset.png");

        frames.put("questionmark 0", new Rectangle(558, 66, 48, 48));
        frames.put("questionmark 1", new Rectangle(507, 66, 48, 48));//vast blokje
        
        setAnimation(new String[]
                {
                    "questionmark 0"
                });

    }

    @Override
    public void doLoopAction()
    {

        doHit();
    }
    @Override
    public void doHit()
    {
        super.doHit();
        setAnimation(new String[]{"questionmark 1"});
    }
}
            
   
