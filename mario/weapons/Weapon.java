/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mario.weapons;

import java.util.ArrayList;
import mario.Stages.Stage;
import mario.core.Collision;
import mario.core.StageObject;
/**
 *
 * @author Onno
 */
abstract public class Weapon extends StageObject
{
    public Weapon(Stage stage, int x, int y, int width, int height, String sprite)
    {
        super(stage, x, y, width, height, sprite);
    }
    public Weapon(Stage stage, int x, int y, int width, int height, int pushX, int pushY, String sprite)
    {
        super(stage, x, y, width, height, pushX, pushY, sprite);
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
