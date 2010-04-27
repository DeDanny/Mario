package mario.ai;

import mario.core.Collision;
import mario.core.Direction;
import mario.core.StageObject;

public class WalkAi extends Ai {

    public WalkAi(StageObject mapObject) {
        super(mapObject);
        direction = Direction.LEFT;
    }

    @Override
    public void doLoopAction() {
        if (stageObject.isFall()) {
            int fallsize = 5;
            while (stageObject.checkCollisionMap(stageObject.getX(), stageObject.getY() + fallsize) != Collision.NONE && fallsize != 0) {
                fallsize--;
            }
            stageObject.setY(stageObject.getY() + fallsize);
            //System.out.println("fall stageObject");
        }

        switch (direction) {
            case LEFT:
                stageObject.setX(stageObject.getX() - WALKSPEED);
                break;
            case RIGHT:
                stageObject.setX(stageObject.getX() + WALKSPEED);
                break;
            case NONE:
                
                break;
        }

    }
}
