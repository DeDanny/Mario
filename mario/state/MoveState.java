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
public class MoveState extends MarioState
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
    private final static String[] duckRight =
    {
        "smallMarioDuckRight 0"
    };
    private final static String[] duckLeft =
    {
        "smallMarioDuckLeft 0"
    };
    private int lastSide        = 0;
    private boolean lookingUP   = false;
    private boolean duckDown    = false;
    private int duckHeight      = 1;
    private int lookupHeight    = 1;

    public MoveState(Mario gameObject)
    {
        super(gameObject);
        gameObject.setAnimation(standRight);
    }

    @Override
    public void doAction()
    {
        // Mario does nothing - No key is pressed
        if (!gameObject.isRight() && !gameObject.isLeft() && !gameObject.isUp() && !gameObject.isDown())
        {
            // Reset Mario's Y-as after looking up
            if (lookingUP)
            {
                lookingUP = false;
                gameObject.setY(gameObject.getY() + lookupHeight);

            }
            // Reset Mario's Y-as after ducking down
            if (duckDown)
            {
                duckDown = false;
                gameObject.setY(gameObject.getY() - duckHeight);

            }
            // Set Mario left or right side
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

        // Mario walks left - Arrowleft key is pressed
        if (gameObject.isLeft() && !gameObject.isPreformingSpecialMove())
        {
            gameObject.setX(gameObject.getX() - WALKSPEED);
            super.setAnimation(leftAnimation);
            lastSide = 1;
        }
        // Mario walks right - Arrowright key is pressed
        if (gameObject.isRight() && !gameObject.isPreformingSpecialMove())
        {
            gameObject.setX(gameObject.getX() + WALKSPEED);
            super.setAnimation(rightAnimation);
            lastSide = 0;
        }

        // Mario looks up - Arrowup key is pressed
        if (gameObject.isUp() && !gameObject.isDown())
        {
            if (lookingUP == false)
            {
                lookingUP = true;
                gameObject.setY(gameObject.getY() - lookupHeight);
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

        // Mario ducks down - ArrowDown is pressed
        if (gameObject.isDown() && !gameObject.isUp())
        {
            if (duckDown == false)
            {
                duckDown = true;
                gameObject.setY(gameObject.getY() + duckHeight);
            }
            switch (lastSide)
            {
                case 0:
                    super.setAnimation(duckRight);
                    break;
                case 1:
                    super.setAnimation(duckLeft);
                    break;
            }
        }
    }
}
