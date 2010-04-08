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
    protected int       lookupWidth     = 0;

    public MoveState(Mario gameObject)
    {
        super(gameObject);
        gameObject.setAnimation(StandRight);
    }

    @Override
    public void doAction()
    {
        // Mario does nothing - No key is pressed
        if (!MarioObject.isRight() && !MarioObject.isLeft() && !MarioObject.isUp() && !MarioObject.isDown())
        {
            // Reset Mario's Y-as after looking up
            if (lookingUP)
            {
                lookingUP = false;
               // MarioObject.setY(MarioObject.getY() - lookupHeight);
            }
            // Reset Mario's Y-as after ducking down
            if (duckDown)
            {
                duckDown = false;
                MarioObject.setY(MarioObject.getY() - duckHeight);

            }

            // Set Mario left or right side
            switch (lastSide)
            {
                case 0:
                    MarioObject.setAnimation(StandRight);
                    break;
                case 1:
                    MarioObject.setAnimation(StandLeft);
                    break;
            }

        }

        // Mario walks left - Arrowleft key is pressed
        if (MarioObject.isLeft() && !MarioObject.isPreformingSpecialMove())
        {
            MarioObject.setX(MarioObject.getX() - WALKSPEED);
            super.setAnimation(LeftAnimation);
            lastSide = 1;
        }
        // Mario walks right - Arrowright key is pressed
        if (MarioObject.isRight() && !MarioObject.isPreformingSpecialMove())
        {
            MarioObject.setX(MarioObject.getX() + WALKSPEED);
            super.setAnimation(RightAnimation);
            lastSide = 0;
        }

        // Mario looks up - Arrowup key is pressed
        if (MarioObject.isUp() && !MarioObject.isDown())
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
                MarioObject.setY(MarioObject.getY() + lookupHeight);
                MarioObject.setX(MarioObject.getX() - lookupWidth);
            }

        }

        // Mario ducks down - ArrowDown is pressed
        if (MarioObject.isDown() && !MarioObject.isUp())
        {
            switch (lastSide)
            {
                case 0:
                    super.setAnimation(DuckRight);
                    break;
                case 1:
                    super.setAnimation(DuckLeft);
                    break;
            }
            if (duckDown == false)
            {
                duckDown = true;
                MarioObject.setY(MarioObject.getY() + duckHeight);
            }
        }
    }
}
