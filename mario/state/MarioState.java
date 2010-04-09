/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.state;

import mario.Mario;
import mario.State;

/**
 *
 * @author danny
 */
public abstract class MarioState extends State
{
    protected Mario marioObject;

    public MarioState(Mario gameObject)
    {
        super(gameObject);
        this.marioObject = gameObject;
    }

    protected final void setAnimation(String[] animation)
    {
        if (marioObject.getAnimation() != animation)
        {
            marioObject.setAnimation(animation);
        }
    }
}
