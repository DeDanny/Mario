/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.cube.ai;

import mario.cube.Powerup;

/**
 *
 * @author Danny
 */
abstract public class Ai
{
    protected Powerup mushroom;

    public Ai(Powerup mushroom)
    {
        this.mushroom = mushroom;
    }

    public abstract void doLoopAction();
}
