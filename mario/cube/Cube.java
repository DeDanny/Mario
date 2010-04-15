/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mario.cube;

import java.awt.Rectangle;
import mario.*;

/**
 *
 * @author Nishchal Baldew
 */
abstract public class Cube extends GameObject
{
    protected boolean raak = true;
    protected int goinUp = 0;
    protected int down = 0;

    public Cube(Game game, int x, int y, int width, int height, String fileName)
    {
            super(game, x, y, width, height, fileName);
    }


    @Override
    public void doLoopAction()
    {
      
    }

    public void doHit()
    {
           if (goinUp < 10 && raak)
            {
                setY(getY() - 1);
                goinUp++;

            }
            else if (goinUp >= 10 && down <= 10)
            {

                setY(getY() + 1);
                raak = false;
                down++;
                    
            }
        }

    }
