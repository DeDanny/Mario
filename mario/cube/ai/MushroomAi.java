
package mario.cube.ai;

import mario.cube.Powerup;
import mario.Collision;
import mario.Direction;


public class MushroomAi extends Ai
{
    private Direction direction;

    public MushroomAi(Powerup mushroom)
    {
        super(mushroom);
    }

    @Override
    public void doLoopAction()

    {
        if (direction == Direction.LEFT)
        mushroom.setX(mushroom.getX() - 1);
        else if
                (direction == Direction.RIGHT)
                mushroom.setX(mushroom.getX() + 1);
        
    }
 public void doMapCollision(Collision side)
   {

        if (side == Collision.SIDE)
        {
            if(direction == Direction.LEFT)
            {
                direction = Direction.RIGHT;
            } else if
                    (direction == Direction.RIGHT)
            {

            }


        }

   }
   public Direction getDirection()
    {
        return direction;
    }

    public void setDirection(Direction direction)
    {
        this.direction = direction;
    }

}