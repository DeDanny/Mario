/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.core;

import mario.core.engine.GameObject;

/**
 *
 * @author Danny
 */
abstract public class State
{
    protected GameObject gameObject;

    public State(GameObject gameObject)
    {
        this.gameObject = gameObject;
    }

    abstract public void doAction();
}
