/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.cube.ai;

import mario.Direction;
import mario.cube.Powerup;

/**
 *
 * @author Danny
 */
abstract public class Ai
{
    protected Powerup mushroom;
    protected Direction direction;

    public Ai(Powerup mushroom)
    {
        this.mushroom = mushroom;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public abstract void doLoopAction();
}
