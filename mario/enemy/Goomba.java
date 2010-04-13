/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.enemy;

import java.awt.Rectangle;
import mario.Collision;
import mario.Game;
import mario.enemy.ai.GoombaAi;

/**
 *
 * @author Danny
 */
public class Goomba extends Enemy
{
    public Goomba(Game game, int x, int y, int width, int height)
    {
        super(game, x, y, width, height, "/images/smw_enemies_sheet.png");
        ai = new GoombaAi(this);
        frames.put("goombaStandLeft 0", new Rectangle(156, 978, 48, 48));
        frames.put("goombaWalkLeft 0", new Rectangle(35, 978, 50, 48));
        frames.put("goombaStandRight 0", new Rectangle(33,862,50,48));
        frames.put("goombaWalkRight 0", new Rectangle(154,861,50,48));
        frameSpeed = 100;
        setAnimation(new String[]
                {
                    "goombaStandLeft 0", "goombaWalkLeft 0"
                });

      

    }

    @Override
    public void hitBy()
    {


    }

   @Override
   public void doCollision(Collision side)
   {
    //   if(side == Collision.SIDE)
   
       // setAnimation(new String[]{"goombaStandRight 0", "goombaWalkRight 0"});
       //else if(side == 2)
       // setAnimation(new String[]{"goombaStandLeft 0", "goombaWalkLeft 0"});
   
   
   }
}

