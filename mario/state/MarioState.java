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
    protected Mario MarioObject;

    public MarioState(Mario gameObject)
    {
        super(gameObject);
        this.MarioObject = gameObject;
    }

    protected final void setAnimation(String[] animation)
    {
        if (MarioObject.getAnimation() != animation)
        {
            MarioObject.setAnimation(animation);
        }
    }
}
