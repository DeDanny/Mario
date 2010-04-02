/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.state;

import mario.Mario;

/**
 *
 * @author danny
 */
public class MoveState extends State
{
    private static final int WALKSPEED = 5;
    private final static String[] rightAnimation =
    {
        "smallMarioWalkRight 0", "smallMarioWalkRight 1"
    };
    private final static String[] leftAnimation =
    {
        "smallMarioWalkLeft 0", "smallMarioWalkLeft 1"
    };
    private final static String[] standLeft =
    {
        "smallMarioStandLeft 0"
    };
    private final static String[] standRight =
    {
        "smallMarioStandRight 0"
    };
    private int lastSide = 0;

    public MoveState(Mario gameObject)
    {
        super(gameObject);
        gameObject.setAnimation(standRight);
    }

    public void doAction()
    {
        if (gameObject.isLeft())
        {
            gameObject.setX(gameObject.getX() - WALKSPEED);
            if(gameObject.getAnimation() != leftAnimation)
                gameObject.setAnimation(leftAnimation);
            lastSide = 1;
        }

        if (gameObject.isRight())
        {

            gameObject.setX(gameObject.getX() + WALKSPEED);
            if(gameObject.getAnimation() != rightAnimation)
                gameObject.setAnimation(rightAnimation);
            lastSide = 0;
        }

        if (!gameObject.isRight() && !gameObject.isLeft())
        {
            switch (lastSide)
            {
                case 0:
                    gameObject.setAnimation(standRight);
                    break;
                case 1:

                    gameObject.setAnimation(standLeft);
                    break;
            }
        }
    }
}
