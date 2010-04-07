/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blokjes;

import java.awt.Rectangle;
import mario.GameObject;

/**
 *
 * @author Nishchal Baldew
 */
public class Stone extends GameObject {

    private boolean raak = true;
    private int goinUp = 0;

    public Stone() {
        super(148, 349, 63, 63, "/images/nsmbtileset.png");

        frames.put("stone 0", new Rectangle(558, 116, 49, 49));

        setAnimation(new String[]{"stone 0"});

    }

    @Override
    public void doLoopAction() {
        if(raak)
        {
            if(goinUp < 2)
            {
                System.out.println("HALLO" + goinUp);
                setY(getY() - 5);
                goinUp++;
            }
            else
            {
                raak = false;
                setY(getY() + 5);
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

    @Override
    public void doGravity()
    {
        
    }
}


