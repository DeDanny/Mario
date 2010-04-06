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
public abstract class MarioState
{
    protected Mario gameObject;

    public MarioState(Mario gameObject)
    {
        this.gameObject = gameObject;
    }

    protected final void setAnimation(String[] animation)
    {
        if (gameObject.getAnimation() != animation)
        {
            gameObject.setAnimation(animation);
        }
    }

    public abstract void doAction();
}
