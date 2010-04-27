/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.scenery;

import java.awt.Rectangle;
import mario.Stages.Stage;
import mario.core.Collision;
import mario.core.StageObject;

/**
 *
 * @author Onno
 */
public class Ground extends StageObject {

    int yAs;
    // Stappen van 28 maken

    public Ground(Stage game, int x, int y, int width, int height, GroundType groundType, Theme theme) {
        super(game, x, y, width, height, "/images/groundObjects.png");
        switch (theme) {
            case NORMAL:
                    yAs = 0;
                break;
            case SNOW:
                    yAs = 48;
                break;
            case JUNGLE:
                    yAs = 96;
                break;
            case STONE:
                    yAs = 144;
                break;
            case WET:
                    yAs = 192;
                break;

        }

        frames.put("groundLeft", new Rectangle(0, yAs, 48, 48));
        frames.put("groundMid", new Rectangle(51, yAs, 192, 48));
        frames.put("groundRight", new Rectangle(245, yAs, 48, 48));

        switch (groundType) {
            case LEFT:
                setAnimation(new String[]{"groundLeft"});
                break;
            case MIDDLE:
                setAnimation(new String[]{"groundMid"});
                break;
            case RIGHT:
                setAnimation(new String[]{"groundRight"});
                break;
        }

    }

    @Override
    public void doCharacterCollision(Collision collision, StageObject stageObject) {
    }

    @Override
    public void doLoopAction() {
    }
}
