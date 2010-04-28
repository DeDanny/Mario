/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mario.weapons;

import java.awt.Rectangle;
import java.util.ArrayList;
import mario.Stages.Stage;
import mario.core.Collision;
import mario.core.StageObject;
import mario.core.interfaces.NoClip;

/**
 *
 * @author Onno
 */
public class Fireball extends Weapon implements NoClip{

    public Fireball(Stage game, int x, int y, int width, int height){
         super(game, x, y, width, height, "/images/mario_sprite.png");

         frames.put("fireball 0", new Rectangle(0, 1042, 11, 12));
         frames.put("fireball 1", new Rectangle(12, 1042, 12, 12));
         frames.put("fireball 2", new Rectangle(24, 1042, 12, 12));
         frames.put("fireball 3", new Rectangle(36, 1042, 12, 12));

         setAnimation(new String[]{"fireball 0", "fireball 1", "fireball 2", "fireball 3"});
    }

    @Override
    public void doLoopAction()
    {


    }

    @Override
    public void doMapCollision()
    {

    }

    @Override
    public void doCharacterCollision(ArrayList<Collision> collisions, StageObject stageObject)
    {


    }
}
