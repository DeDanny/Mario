/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.mapObjects;

import java.awt.Rectangle;
import mario.*;
import mario.core.Collision;
import mario.core.MapObject;
import mario.core.NoClip;

/**
 *
 * @author Nishchal Baldew
 */
public class Stone extends Cube {

    protected boolean hit = false;

    public Stone(Game game, int x, int y, int width, int height)
    {
        super(game, x, y, width, height, "/images/nsmbtileset.png");

        frames.put("stone 0", new Rectangle(558, 116, 49, 49));

        setAnimation(new String[]{"stone 0"});

    }

    @Override
    public void doLoopAction() {
        if (hit) {
            super.doHit();
            if (getGoinUp() == 20) {
                hit = false;
                setGoinUp(0);
            }
        }
    }

    @Override
    public void doCharacterCollision(Collision collision, MapObject charachter) {
        if (charachter instanceof mario.Mario) {

            switch (collision) {
                case SIDE:

                    break;
                case UP:

                    break;
                case DOWN:
                    hit = true;
                    break;
                case NONE:

                    break;
            }

        }

    }
}
