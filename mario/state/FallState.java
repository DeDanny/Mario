/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mario.state;

import mario.Mario;
/**
 *
 * @author Onno
 */
public class FallState extends MarioState{

    public FallState(Mario marioObject)
    {
        super(marioObject);
    }

    @Override
    public void doAction()
    {


           marioObject.setY(marioObject.getY() + 5);
           // At collision
           //marioObject.setJump(false);

    }
}
