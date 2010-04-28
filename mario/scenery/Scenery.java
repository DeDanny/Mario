/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.scenery;

import java.util.ArrayList;
import mario.Stages.Stage;
import mario.core.Collision;
import mario.core.StageObject;

/**
 *
 * @author danny
 */
abstract public class Scenery extends StageObject
{
    public Scenery(Stage stage, int x, int y, int width, int height, String sprite)
    {
        super(stage, x, y, width, height, sprite);
    }

    @Override
    public void doCharacterCollision(ArrayList<Collision> collisions, StageObject mapObject)
    {
    }

    @Override
    public void doLoopAction()
    {
    }
}
