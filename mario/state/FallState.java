/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.state;

import mario.Collision;
import mario.Direction;
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
        if (marioObject.isLeft() && !marioObject.isRight() && !marioObject.isPreformingSpecialMove()) {
            doLeft();
        } else if (marioObject.isRight() && !marioObject.isLeft() && !marioObject.isPreformingSpecialMove()) {
            doRight();
        } else if (marioObject.getDirection() == Direction.LEFT && !marioObject.isPreformingSpecialMove()) {
            setAnimationLeft();
        } else if (marioObject.getDirection() == Direction.RIGHT && !marioObject.isPreformingSpecialMove()) {
            setAnimationRight();
        }


        if(fallsize < 7)
        {
            fallsize++;
        }
        while (marioObject.checkCollisionMap(marioObject.getX(), marioObject.getY() + fallsize) != Collision.NONE && fallsize != 0) {
            fallsize--;
            System.out.println("fallsize = " + fallsize);
        }
        //System.out.println("CHEEEEEEEEEEECK: "+marioObject.checkCollisionMap(marioObject.getX(), fallsize));
        marioObject.setY(marioObject.getY() + fallsize);
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
}
