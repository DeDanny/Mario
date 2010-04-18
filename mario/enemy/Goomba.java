/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.enemy;

import java.awt.Rectangle;
import mario.core.CharacterObject;
import mario.core.Collision;
import mario.core.NoClip;
import mario.Game;
import mario.ai.WalkAi;
import mario.core.MapObject;
import mario.mapObjects.Tube;

/**
 *
 * @author Danny
 */
public class Goomba extends Enemy implements NoClip {

    public Goomba(Game game, int x, int y, int width, int height) {
        super(game, x, y, width, height, "/images/smw_enemies_sheet.png");
        ai = new WalkAi(this);
        frames.put("goombaStandLeft 0", new Rectangle(156, 978, 48, 48));
        frames.put("goombaWalkLeft 0", new Rectangle(35, 978, 50, 48));
        frames.put("goombaStandRight 0", new Rectangle(33, 862, 50, 48));
        frames.put("goombaWalkRight 0", new Rectangle(154, 861, 50, 48));
        frameSpeed = 100;

        setAnimation(new String[]{
                    "goombaStandLeft 0", "goombaWalkLeft 0", //"goombaStandRight 0", "goombaWalkRight 0"
                });
    }

    @Override
    public void hitBy() {
    }

    @Override
    public void doMapCollision() {
        switch (mapCollision) {
            case SIDE:
                break;
            case NONE:
                setFall(true);
                break;
            case DOWN:
                setFall(false);
                break;
            //System.out.println("123:"+mapCollision);

        }

    }

    public void doCharacterCollision(Collision collision, MapObject mapObject) {

        if (mapObject instanceof mario.Mario) {
            switch (collision) {
                case UP:
                    System.out.println("Goomba is dead");
                    setAlive(false);
                    break;
            }
        }

        if (mapObject instanceof Tube) {
            switch (collision) {
                case UP:
//                    ai.toggleDirection();
//                    switch (ai.getDirection()) {
//                        case LEFT:
//                            setAnimation(new String[]{"goombaStandLeft 0", "goombaWalkLeft 0"});
//                            break;
//                        case RIGHT:
//                            setAnimation(new String[]{"goombaStandRight 0", "goombaWalkRight 0"});
//                            break;
//                    }
                    System.out.println("Goomba Vol UP tube");
                    break;
                case DOWN:
                    System.out.println("Goomba Vol DOWN tube -- Doorlopen");
                    break;
            }

        }


    }















    //
//        if(side == Collision.SIDE)
//        {
//            Direction direction = ai.getDirection();
//            if(direction == Direction.LEFT)
//            {
//                direction = Direction.RIGHT;
//            }
//            else
//            {
//                direction = Direction.LEFT;
//            }
//            ai.setDirection(direction);
    //  }
    //
    //super.setAnimation(new String[] {"goombaStandRight 0", "goombaWalkRight"});
    //   }
//         if(side == Collision.SIDE)
//         {
//           //super.setAnimation(new String[] {"goombaStandRight 0", "goombaWalkRight"});
//         }
//            switch(side)
//            {
//                case SIDE:
//                    System.out.println("Goomba-Collision with Wall");
//                    //setAlive(false);
//                    break;
//            }
    //}
    //else if(side == Collision.
}
