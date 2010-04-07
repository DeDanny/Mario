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
public class Questionmark extends GameObject {

    private boolean raak = true;
    private int goinUp = 0;

    public Questionmark() {
        super(100, 100, 63, 63, "/images/nsmbtileset.png");

        frames.put("questionmark 0", new Rectangle(558, 66, 48, 48));

        setAnimation(new String[]{"questionmark 0"});

    }

    @Override
    public void doLoopAction() {
        if(raak)
        {
            if(goinUp < 5)
            {
                System.out.println("HALLO" + goinUp);
                setY(getY() - 5);
                goinUp++;
            }
            else
            {
                raak = false;
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
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
            
   
