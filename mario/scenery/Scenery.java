/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mario.scenery;

import mario.Game;
import mario.core.MapObject;

/**
 *
 * @author danny
 */
abstract public class Scenery extends MapObject{
     public Scenery(Game game, int x, int y, int width, int height, String sprite)
    {
          super(game, x, y, width, height, sprite);
     }
}
