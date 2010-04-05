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
    private final static String[] upRight =
    {
        "smallMarioLookUpRight 0"
    };
    private final static String[] upLeft =
    {
        "smallMarioLookUpLeft 0"
    };
    private int lastSide = 0;
    private boolean lookingUP = false;

    public MoveState(Mario gameObject)
    {
        super(gameObject);
        gameObject.setAnimation(standRight);
    }

    @Override
    public void doAction()
    {
        if (gameObject.isLeft() && !gameObject.isUp())
        {
            gameObject.setX(gameObject.getX() - WALKSPEED);

            super.setAnimation(leftAnimation);
            lastSide = 1;
        }

        if (gameObject.isRight() && !gameObject.isUp())
        {

            gameObject.setX(gameObject.getX() + WALKSPEED);
            super.setAnimation(rightAnimation);
            lastSide = 0;
        }

        if (gameObject.isUp())
        {
            if (lookingUP == false)
            {
                lookingUP = true;
                gameObject.setY(gameObject.getY() - 1);
            }
            switch (lastSide)
            {
                case 0:
                    super.setAnimation(upRight);
                    break;
                case 1:

                    super.setAnimation(upLeft);
                    break;
            }
        }

        if (!gameObject.isRight() && !gameObject.isLeft() && !gameObject.isUp())
        {
            if (lookingUP)
            {
                lookingUP = false;
                gameObject.setY(gameObject.getY() + 1);

            }
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
