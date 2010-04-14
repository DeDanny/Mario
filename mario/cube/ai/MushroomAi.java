
package mario.cube.ai;

import mario.cube.Powerup;


public class MushroomAi extends Ai
{
    public MushroomAi(Powerup mushroom)
    {
        super(mushroom);
    }

    @Override
    public void doLoopAction()
    {
        mushroom.setX(mushroom.getX() - 1);
    }
}
