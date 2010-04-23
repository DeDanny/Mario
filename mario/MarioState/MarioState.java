/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.MarioState;

import mario.Stages.StageMario;
import mario.core.State;

/**
 *
 * @author danny
 */
public abstract class MarioState extends State
{
    protected StageMario marioObject;

    public MarioState(StageMario gameObject)
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
