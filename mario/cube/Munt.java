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
public class Munt extends GameObject {

    private boolean raak = true;
    private int goinUp = 0;

    public Munt(Game game) {
        super(game,100, 350, 63, 63, "/images/nsmbtileset.png");

        frames.put("munt 0", new Rectangle(457, 167, 45, 48));
        

        setAnimation(new String[]{"munt 0"});

    }

    @Override
    public void doLoopAction() {
        if(raak)
        {
            if(goinUp < 20)
            {
                setY(getY() - 5);
                goinUp++;

            }
            else
            {
                setAnimation(new String[] {"munt 0"});
                 if(goinUp < 4)
                 {
                raak = false;

                 }
            }
        }
        /*
        if (y > 95) {
            setY(getY() - 5);
        } else if (raak = true) {
            setY(getY() + 5);
        }
        raak = false;
         * */
    }

   // @Override
    public void doGravity()
    {

    }
}


