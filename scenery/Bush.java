/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package scenery;

import java.awt.Rectangle;
import mario.Game;
import mario.core.Collision;
import mario.core.MapObject;
import mario.core.NoClip;

public class Bush extends MapObject implements NoClip{

    public Bush(Game game, int x, int y, int width, int height)
    {
        super(game, x, y, width, height, "/images/bush.png");
        frames.put("bush 0", new Rectangle(0, 0, 99, 78));
        frames.put("bush 1", new Rectangle(99, 0, 99, 78));
        frameSpeed = 700;
        setAnimation(new String[]{"bush 0", "bush 1"});
    }


    @Override
    public void doLoopAction() {

    }

    @Override
    public void doCharacterCollision(Collision collision, MapObject mapObject) {

    }




}
