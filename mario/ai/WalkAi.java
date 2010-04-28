package mario.ai;

import mario.core.Collision;
import mario.core.Direction;
import mario.core.StageObject;

public class WalkAi extends Ai {

    private int heightTeller = 0;

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

        if (stageObject.isDead()) {
            WALKSPEED = 15;
            if (heightTeller < 5) {
            } else if (heightTeller < 10) {
                stageObject.setY(stageObject.getY() - WALKSPEED, true);
            } else if (heightTeller >= 10) {
                stageObject.setY(stageObject.getY() + WALKSPEED, true);
            }
            heightTeller++;
        } else {

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
}
