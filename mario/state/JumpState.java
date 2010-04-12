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
    private int jumpTeller = 0;

    public JumpState(Mario marioObject)
    {
        super(marioObject);
        
    }

    @Override
    public void doAction()
    {
       if(jumpTeller < 15)
       {
           marioObject.setY(marioObject.getY() - 10);
           jumpTeller++;
           System.out.println("teller "+jumpTeller);
       }
       else
       {
            marioObject.setJump(false);
            marioObject.setFall(true);
            System.out.println("set jump false yippykayeay");
            this.jumpTeller = 0;
       }
    }


}
