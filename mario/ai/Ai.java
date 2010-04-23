/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.ai;

import mario.core.Direction;
import mario.core.StageObject;

/**
 *
 * @author Danny
 */
abstract public class Ai
{
    protected StageObject stageObject;
    protected Direction direction;
    protected int WALKSPEED = 1;

    public Ai(StageObject stageObject)
    {
        this.stageObject = stageObject;
        direction = direction.LEFT;
    }

    public void toggleDirection()
    {
        if (getDirection() == direction.RIGHT)
        {
            setDirection(direction.LEFT);
            //System.out.println("toggleDirection Right");
        }
        else if (getDirection() == direction.LEFT)
        {
            setDirection(direction.RIGHT);
            //System.out.println("toggleDirection Left");
        }
    }

    public int getWALKSPEED()
    {
        return WALKSPEED;
    }

    public void setWALKSPEED(int WALKSPEED)
    {
        this.WALKSPEED = WALKSPEED;
    }

    public Direction getDirection()
    {
        return direction;
    }

    public void setDirection(Direction direction)
    {
        this.direction = direction;
    }

    public abstract void doLoopAction();
}


