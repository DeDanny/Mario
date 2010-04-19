/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mario.scenery;

import java.awt.Rectangle;
import mario.Game;
import mario.core.Collision;
import mario.core.MapObject;
import mario.core.NoClip;

/**
 *
 * @author Mike
 */
public class Cloud extends MapObject implements NoClip{

    int teller = 0;
        public Cloud(Game game, int x, int y, int width, int height)
    {
        super(game, x, y, width, height, "/images/nsmbtileset.png");
        frames.put("cloud 0", new Rectangle(553, 4035, 96, 48));
        setAnimation(new String[]{"cloud 0"});
    }


    @Override
    public void doLoopAction() {

        if(teller > 5)
        {
    setX(getX() - 1);
        teller = 0;
        }
        else{
             teller++;
        }
    }

    @Override
    public void doCharacterCollision(Collision collision, MapObject mapObject) {

    }


}
