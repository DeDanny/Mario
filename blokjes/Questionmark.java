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
        super(100, 350, 63, 63, "/images/nsmbtileset.png");

        frames.put("questionmark 0", new Rectangle(558, 66, 48, 48));
        frames.put("questionmark 1", new Rectangle(507, 66, 48, 48));

        setAnimation(new String[]{"questionmark 0"});
       
    }

    @Override
    public void doLoopAction() {
        if(raak)
        {
            if(goinUp < 2)
            {
                setY(getY() - 5);
                goinUp++;
                
            }
            else
            {
                setY(getY() + 5);
                setAnimation(new String[] {"questionmark 1"});
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
            
   
