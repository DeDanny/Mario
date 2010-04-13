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

    protected static final int WALKSPEED = 5;
    protected String[] FallRight = new String[]{"smallMarioFallRight 0"};
    protected String[] FallLeft = new String[]{"smallMarioFallLeft 0"};
    //protected String[] FallRight = new String[]{"bigMarioFallRight 0"};
    //protected String[] FallLeft = new String[]{"bigMarioFallLeft 0"};

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

        int fallsize = 5;
        while (marioObject.checkCollisionMap(marioObject.getY(), fallsize) != Collision.NONE && fallsize != 0) {
            fallsize--;
            System.out.println("fallsize = " + fallsize);
        }
        System.out.println("fallsize = " + fallsize);
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
        super.setAnimation(FallLeft);
    }

    private void setAnimationRight() {
        super.setAnimation(FallRight);
    }
}