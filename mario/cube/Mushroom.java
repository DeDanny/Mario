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
public class Mushroom extends GameObject {

    private boolean raak = true;
    private int goinUp = 0;

    public Mushroom(Game game) {
        super(game,100, 350, 48, 48, "/images/nsmbtileset.png");

        frames.put("mushroom 0", new Rectangle(1225, 2327, 50, 50));

        setAnimation(new String[]{"mushroom 0"});

    }

    @Override
    public void doLoopAction() {
        if(raak)
        {
            if(goinUp < 11)
            {
                setY(getY() - 5);
                goinUp++;

            }
            else
            {

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
}

