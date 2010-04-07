/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.cube.state;

import java.awt.Rectangle;
import mario.GameObject;

/**
 *
 * @author Nishchal Baldew
 */
public class Questionmarkup extends GameObject {

    public Questionmarkup() {
        super(100, 345, 63, 63, "/images/nsmbtileset.png");

        frames.put("questionmark 1", new Rectangle(507, 66, 48, 48));

        setAnimation(new String[]{"questionmark 1"});

    }

    @Override
    public void doLoopAction() {
    }
}