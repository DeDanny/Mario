/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.state;

import mario.Direction;
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

//    protected static final int LEFT = 0;
//    protected static final int RIGHT = 1;
//
//    protected static int direction      = RIGHT;

    //protected boolean   lookingUP       = false;
    //protected boolean   ducked          = false;
    //protected static int duckMoveY      = 19;
   // protected static int duckMoveY      = 19;
    //protected static int duckMoveYOriginal      = 60;
    //protected static int duckHeight     = 42;
    //protected static int duckHeight     = 41;



    protected  int Height;
    protected  int tempHeight;
    protected  int tempY = 0;
    private boolean ducked = false;
    private boolean noMore = true;


    public MoveState(Mario gameObject)
    {
        super(gameObject);
        //gameObject.setAnimation(StandRight);
    }

    @Override
    public void doAction()
    {

        if(marioObject.isLeft() && !marioObject.isRight() && !marioObject.isPreformingSpecialMove())
        {
            doLeft();
            ducked = false;
        }
        else if(marioObject.isRight() && !marioObject.isLeft() && !marioObject.isPreformingSpecialMove())
        {
            doRight();
            ducked = false;
        }
        else if(marioObject.isUp())
        {
            doUp();
            ducked = false;
        }
        else if(marioObject.isDown())
        {
            doDown();
            ducked = true;
        }
        else
        {
            doStand();
            ducked = false;
        }

        if(!ducked && !noMore && tempY != 0)
        {
            marioObject.setHeight(Height);
            marioObject.setY(marioObject.getY() - tempY);
            noMore = true;
        }
    }

    private void doLeft()
    {
        marioObject.setX(marioObject.getX() - WALKSPEED);
        super.setAnimation(LeftAnimation);
        marioObject.setDirection(Direction.LEFT);
    }
    private void doRight()
    {
        marioObject.setX(marioObject.getX() + WALKSPEED);
        super.setAnimation(RightAnimation);
        marioObject.setDirection(Direction.RIGHT);
    }
    private void doUp()
    {

        switch (marioObject.getDirection()) {
            case LEFT:
                super.setAnimation(UpLeft);
                break;
            case RIGHT:
                super.setAnimation(UpRight);
                break;
        }
    }
    private void doDown()
    {

        if (ducked) {
            marioObject.setHeight(tempHeight);
            marioObject.setY(marioObject.getY() + tempY);
            noMore = false;
        }

        switch (marioObject.getDirection()) {
            case LEFT:
                super.setAnimation(DuckLeft);
                break;
            case RIGHT:
                super.setAnimation(DuckRight);
                break;
        }
    }

    private void doStand()
    {
        // Set Mario left or right side
        switch (marioObject.getDirection()) {
            case LEFT:
                marioObject.setAnimation(StandLeft);
                break;            
            case RIGHT:
                marioObject.setAnimation(StandRight);
                break;
        }
    }





//    private void kansloos()
//    {
//        if(false){
//            // Reset Mario's Y-as after looking up
//            if (lookingUP) {
//                lookingUP = false;
//                marioObject.setY(marioObject.getY() - lookupHeight);
//            }
//            // Reset Mario's Y-as after ducking down
//            if (duckDown) {
//                duckDown = false;
//                marioObject.setY(marioObject.getY() - duckHeight);
//
//            }
//
//            // Mario does nothing - No key is pressed
//            if (!marioObject.isRight() && !marioObject.isLeft() && !marioObject.isUp() && !marioObject.isDown()) {
//
//                // Set Mario left or right side
//                switch (direction) {
//                    case 0:
//                        marioObject.setAnimation(StandRight);
//                        break;
//                    case 1:
//                        marioObject.setAnimation(StandLeft);
//                        break;
//                }
//
//            }
//
//            // Mario walks left - Arrowleft key is pressed
//            if (marioObject.isLeft() && !marioObject.isPreformingSpecialMove()) {
//                marioObject.setX(marioObject.getX() - WALKSPEED);
//                super.setAnimation(LeftAnimation);
//                //lastSide = 1;
//            }
//            // Mario walks right - Arrowright key is pressed
//            if (marioObject.isRight() && !marioObject.isPreformingSpecialMove()) {
//                marioObject.setX(marioObject.getX() + WALKSPEED);
//                super.setAnimation(RightAnimation);
//                //lastSide = 0;
//            }
//
//            // Mario looks up - Arrowup key is pressed
//            if (marioObject.isUp() && !marioObject.isDown()) {
//
//
//                if (lookingUP == false) {
//                    lookingUP = true;
//                    marioObject.setY(marioObject.getY() + lookupHeight);
//                    marioObject.setX(marioObject.getX() - lookupWidth);
//                }
//
//            }
//
//            // Mario ducks down - ArrowDown is pressed
//            if (marioObject.isDown() && !marioObject.isUp()) {
//                switch (direction) {
//                    case 0:
//                        super.setAnimation(DuckRight);
//                        break;
//                    case 1:
//                        super.setAnimation(DuckLeft);
//                        break;
//                }
//                if (duckDown == false) {
//                    duckDown = true;
//                    marioObject.setY(marioObject.getY() + duckHeight);
//                }
//            }
//        }
//    }
}
