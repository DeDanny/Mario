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
public class MoveState extends State
{

    private static final int WALKSPEED = 5;

    public MoveState(Mario gameObject)
    {
        super(gameObject);
    }
    

    public void doAction()
    {
        if(gameObject.isLeft())
        {
           gameObject.setX(gameObject.getX() - WALKSPEED);
        }

        if(gameObject.isRight())
        {

           gameObject.setX(gameObject.getX() + WALKSPEED);
        }
    }
}
