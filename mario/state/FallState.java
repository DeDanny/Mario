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

    //protected String[] FallRight = new String[]{"smallMarioFallRight 0"};
    //protected String[] FallLeft = new String[]{"smallMarioFallLeft 0"};
    protected String[] FallRight = new String[]{"bigMarioFallRight 0"};
    protected String[] FallLeft = new String[]{"bigMarioFallLeft 0"};
    
    public FallState(Mario marioObject)
    {
        super(marioObject);
        
    }

    @Override
    public void doAction()
    {
        gameObject.setAnimation(FallRight);
        int fallsize = 5;
//        while(marioObject.checkCollisionMap(marioObject.getX(), fallsize)!= Collision.NONE && fallsize != 0)
//        {
//           fallsize--;
//        }
        marioObject.setY(marioObject.getY() + fallsize);
           // At collision
           //marioObject.setJump(false);
    }
}
