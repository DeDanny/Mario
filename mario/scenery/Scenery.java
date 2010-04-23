/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mario.scenery;

import mario.Stages.Stage;
import mario.core.StageObject;

/**
 *
 * @author danny
 */
abstract public class Scenery extends StageObject{
     public Scenery(Stage game, int x, int y, int width, int height, String sprite)
    {
          super(game, x, y, width, height, sprite);
     }
}
