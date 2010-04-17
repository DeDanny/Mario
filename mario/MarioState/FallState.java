/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.MarioState;

import mario.core.Collision;
import mario.core.Direction;
import mario.Mario;

/**
 *
 * @author Onno
 */
public class FallState extends MarioState {


    protected static final int WALKSPEED = 4;

    protected String[] smallFallRight = new String[]{"smallMarioFallRight 0"};
    protected String[] smallFallLeft = new String[]{"smallMarioFallLeft 0"};
    protected String[] bigFallRight = new String[]{"bigMarioFallRight 0"};
    protected String[] bigFallLeft = new String[]{"bigMarioFallLeft 0"};
    private int fallsize = 1;

    public FallState(Mario marioObject) {
        super(marioObject);

    }

    @Override
    public void doAction() {
       //if (!marioObject.isPreformingSpecialMove() && !marioObject.isJump()) {
            if (marioObject.isLeft() && !marioObject.isRight()) {
                doLeft();
            } else if (marioObject.isRight() && !marioObject.isLeft()) {
                doRight();
            } else if (marioObject.getDirection() == Direction.LEFT) {
                setAnimationLeft();
            } else if (marioObject.getDirection() == Direction.RIGHT) {
                setAnimationRight();
            }
            
       //}
        doFall();
    }

    private void doLeft() {
        marioObject.setX(marioObject.getX() - WALKSPEED);
        setAnimationLeft();
        marioObject.setDirection(Direction.LEFT);
    }

    private void doRight() {
        marioObject.setX(marioObject.getX() + WALKSPEED);
        setAnimationRight();
        marioObject.setDirection(Direction.RIGHT);
    }

    private void setAnimationLeft() {
        if(marioObject.getIsBig()) {
           super.setAnimation(bigFallLeft);
        }
        else
        {
            super.setAnimation(smallFallLeft);
        }
    }

    private void setAnimationRight() {
        if(marioObject.getIsBig()) {
           super.setAnimation(bigFallRight);
        }
        else
        {
            super.setAnimation(smallFallRight);
        }
    }

    private void doFall()
    {
        while(fallsize < 7)
        {
            fallsize++;
        }
        while (marioObject.checkCollisionMap(marioObject.getX(), marioObject.getY() + fallsize) != Collision.NONE && fallsize != 0) {
            fallsize--;
            System.out.println("fallsize = " + fallsize);
        }
        marioObject.setY(marioObject.getY() + fallsize);
    }
}
