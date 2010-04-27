/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mario.scenery;

import java.awt.Rectangle;
import mario.Stages.Stage;
import mario.core.Collision;
import mario.core.StageObject;
import mario.core.interfaces.NoClip;

/**
 *
 * @author Onno
 */
public class Ground extends StageObject{

    int yAs = 0;

    public Ground(Stage game, int x, int y, int width, int height)
    {
        super(game, x, y, width, height, "/images/groundObjects.png");
        frames.put("groundLeft", new Rectangle(0, yAs, 48, 48));
        frames.put("groundMid", new Rectangle(51, yAs, 192, 48));
        frames.put("groundRight", new Rectangle(245, yAs, 48, 48));
        setAnimation(new String[]{"cloud 0"});
    }

    @Override
    public void doCharacterCollision(Collision collision, StageObject stageObject) {

    }

    @Override
    public void doLoopAction() {

    }


}
