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
abstract public class MoveState extends MarioState
{
    protected static final int WALKSPEED = 5;

    protected String[] RightAnimation;
    protected String[] LeftAnimation;
    protected String[] StandLeft;
    protected String[] StandRight;
    protected String[] UpRight;
    protected String[] UpLeft;
    protected String[] DuckRight;
    protected String[] DuckLeft;


    protected static int lastSide        = 0;
    protected boolean   lookingUP       = false;
    protected boolean   duckDown        = false;
    protected int       duckHeight      = 0;
    protected int       lookupHeight    = 0;

    public MoveState(Mario gameObject)
    {
        super(gameObject);
        gameObject.setAnimation(StandRight);
    }

    @Override
    public void doAction()
    {
        // Mario does nothing - No key is pressed
        if (!gameObject.isRight() && !gameObject.isLeft() && !gameObject.isUp() && !gameObject.isDown())
        {

            // Set Mario left or right side
            switch (lastSide)
            {
                case 0:
                    gameObject.setAnimation(StandRight);
                    break;
                case 1:
                    gameObject.setAnimation(StandLeft);
                    break;
            }
            // Reset Mario's Y-as after looking up
            if (lookingUP)
            {
                lookingUP = false;
                //gameObject.setY(gameObject.getY() - lookupHeight);

            }
            // Reset Mario's Y-as after ducking down
            if (duckDown)
            {
                duckDown = false;
                gameObject.setY(gameObject.getY() - duckHeight);

            }
        }

        // Mario walks left - Arrowleft key is pressed
        if (gameObject.isLeft() && !gameObject.isPreformingSpecialMove())
        {
            gameObject.setX(gameObject.getX() - WALKSPEED);
            super.setAnimation(LeftAnimation);
            lastSide = 1;
        }
        // Mario walks right - Arrowright key is pressed
        if (gameObject.isRight() && !gameObject.isPreformingSpecialMove())
        {
            gameObject.setX(gameObject.getX() + WALKSPEED);
            super.setAnimation(RightAnimation);
            lastSide = 0;
        }

        // Mario looks up - Arrowup key is pressed
        if (gameObject.isUp() && !gameObject.isDown())
        {

            switch (lastSide)
            {
                case 0:
                    super.setAnimation(UpRight);
                    break;
                case 1:

                    super.setAnimation(UpLeft);
                    break;
            }
            if (lookingUP == false)
            {
                lookingUP = true;
                gameObject.setY(gameObject.getY() + lookupHeight);
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
                    super.setAnimation(DuckRight);
                    break;
                case 1:
                    super.setAnimation(DuckLeft);
                    break;
            }
        }
    }
}
