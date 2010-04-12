/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mario.state;

import mario.Collision;
import mario.Mario;
/**
 *
 * @author Onno
 */
public class FallState extends MarioState{


    protected String[] StandRight =new String[]{"bigMarioStandRight 0"};
    public FallState(Mario marioObject)
    {
        super(marioObject);
        gameObject.setAnimation(StandRight);
    }

    @Override
    public void doAction()
    {
        int fallsize = 32;
        while(marioObject.checkCollisionMap(marioObject.getX(), fallsize)!= Collision.NONE && fallsize != 0)
        {
           fallsize--;
        }
        marioObject.setY(marioObject.getY() + fallsize);
           // At collision
           //marioObject.setJump(false);
    }
}
