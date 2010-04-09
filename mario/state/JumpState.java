/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mario.state;


import mario.Mario;

/**
 *
 * @author danny
 */
public class JumpState extends MarioState{
    private int hop = 0;

    public JumpState(Mario marioObject)
    {
        super(marioObject);
    }

    @Override
    public void doAction()
    {
       if(hop < 14)
       {
           marioObject.setY(marioObject.getY() - 5);
       }
       else
       {
            marioObject.setJump(false);
       }
    }


}
