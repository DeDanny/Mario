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
public class Tube extends StageObject{

    public Tube(Stage game, int x, int y, int width, int height)
    {
        super(game, x, y, width, height, "/images/nsmbtileset.png");
        frames.put("tube 0", new Rectangle(430, 4008, 96, 96));
        setAnimation(new String[]{"tube 0"});
    }


    @Override
    public void doLoopAction() {

    }

    @Override
    public void doCharacterCollision(Collision collision, StageObject mapObject) {

    }




}
