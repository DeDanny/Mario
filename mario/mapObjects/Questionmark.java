/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.mapObjects;

import java.awt.Rectangle;
import mario.*;
import mario.core.Collision;
import mario.core.MapObject;

/**
 *
 * @author Nishchal Baldew
 */
public class Questionmark extends Cube {

    protected boolean hit = false;
    protected boolean done = false;

    public Questionmark(Game game, int x, int y, int width, int height) {
        super(game, x, y, width, height, "/images/nsmbtileset.png");

        frames.put("questionmark 0", new Rectangle(558, 66, 48, 48));
        frames.put("questionmark 1", new Rectangle(507, 66, 48, 48));//vast blokje

        setAnimation(new String[]{"questionmark 0"});

    }

    @Override
    public void doLoopAction() {

        if (hit && !done) {
            super.doHit();
            if (getGoinUp() == 20) {
                hit = false;
                done = true;
                setGoinUp(0);
                setAnimation(new String[]{"questionmark 1"});
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
