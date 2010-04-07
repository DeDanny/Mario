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
    protected Mario gameObject;
    public MarioState(Mario gameObject)
    {
        super(gameObject);
        this.gameObject = gameObject;
    }

    protected final void setAnimation(String[] animation)
    {
        if (gameObject.getAnimation() != animation)
        {
            gameObject.setAnimation(animation);
        }
    }
}
