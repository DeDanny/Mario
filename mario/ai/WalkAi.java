package mario.ai;

import mario.core.Collision;
import mario.core.Direction;
import mario.core.MapObject;

public class WalkAi extends Ai
{
    public WalkAi(MapObject mapObject)
    {
        super(mapObject);
        direction = Direction.LEFT;
    }

    @Override
    public void doLoopAction()
    {
        if (mapObject.isFall())
        {
            int fallsize = 5;
            while (mapObject.checkCollisionMap(mapObject.getX(), mapObject.getY() + fallsize) != Collision.NONE && fallsize != 0)
            {
                fallsize--;
                System.out.println("fallsize = " + fallsize);
            }

            mapObject.setY(mapObject.getY() + fallsize);
            System.out.println("fall mapObject");
        }
        mapObject.setX(mapObject.getX() - 1);
    }
}
