/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.state;

import mario.GameObject;
import mario.Mario;

/**
 *
 * @author danny
 */
public abstract class State
{
    protected Mario gameObject;

    public State(Mario gameObject)
    {
        this.gameObject = gameObject;
    }
   
    public abstract void doAction();
}
