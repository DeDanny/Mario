package mario.cube.ai;

import mario.cube.Powerup;
import mario.Collision;
import mario.Direction;

public class MushroomAi extends Ai {

    
    public MushroomAi(Powerup mushroom) {
        super(mushroom);
        direction = Direction.LEFT;
    }

    @Override
    public void doLoopAction() {

        if (direction == Direction.LEFT) {
            mushroom.setX(mushroom.getX() - 1);
        } else if (direction == Direction.RIGHT) {
            mushroom.setX(mushroom.getX() + 1);
        }

    }


}
