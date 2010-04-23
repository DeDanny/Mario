/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.mapObjects;

import mario.Stages.Stage;
import mario.*;
import mario.core.Collision;
import mario.core.StageObject;

/**
 *
 * @author Nishchal Baldew
 */
abstract public class Cube extends StageObject
{
   
    protected int goinUp = 0;

    public Cube(Stage game, int x, int y, int width, int height, String fileName)
    {
        super(game, x, y, width, height, fileName);
    }

    @Override
    public void doLoopAction()
    {

    }

    public void doHit()
    {
        if (goinUp < 4) {
            setY(getY() - 2);
        }
        else if(goinUp < 8)
        {
            setY(getY() + 2);
        }

        goinUp++;
    }

    public int getGoinUp() {
        return goinUp;
    }

    public void setGoinUp(int goinUp) {
        this.goinUp = goinUp;
    }

    public void doCharacterCollision(Collision collision, StageObject charachter)
    {


    }
}
 