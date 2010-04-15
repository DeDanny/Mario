/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.cube;

import java.awt.Rectangle;
import mario.*;
import mario.cube.ai.MushroomAi;

/**
 *
 * @author Nishchal Baldew
 */
public class Mushroom extends Powerup

{
   

    public Mushroom(Game game)
    {
        super(game, 100, 350, 48, 48, "/images/nsmbtileset.png");
        ai = new MushroomAi(this);

        frames.put("mushroom 0", new Rectangle(1225, 2327, 50, 50));

        setAnimation(new String[]
                {
                    "mushroom 0"
                });

    }

    @Override
    public void hitBy()
    {
    }

//    @Override
//   public void doMapCollision(Collision side)
//   {
//
//       if(side == Collision.SIDE)
//          setX(getX() + 1);
//
//   }
   

    @Override
    public void doCharacterCollision(Collision collision)
    {
    }

//    public void doLoopAction() {
//        if(raak)
//        {
//            if(goinUp < 11)
//            {
//                setY(getY() - 5);
//                goinUp++;
//
//            }
//            else
//            {
//
//                 if(goinUp < 4)
//                 {
//                raak = false;
//
//                 }
//            }
//        }
        /*
    if (y > 95) {
    setY(getY() - 5);
    } else if (raak = true) {
    setY(getY() + 5);
    }
    raak = false;
     * */

}
