/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.MarioState;

import mario.core.Direction;
import mario.Stages.StageMario;
import mario.core.Collision;

/**
 *
 * @author danny
 */
public class JumpState extends MarioState {

    protected static final int WALKSPEED = 4;
    protected String[] smallJumpRight = new String[]{"smallMarioJumpRight 0"};
    protected String[] smallJumpLeft = new String[]{"smallMarioJumpLeft 0"};
    protected String[] bigJumpRight = new String[]{"bigMarioJumpRight 0"};
    protected String[] bigJumpLeft = new String[]{"bigMarioJumpLeft 0"};
    private int jumpHeight;

    public JumpState(StageMario marioObject) {
        super(marioObject);
    }

    @Override
    public void doAction() {
        if (!marioObject.isPreformingSpecialMove()) {
            if (marioObject.isLeft() && !marioObject.isRight()) {
                doLeft();
            } else if (marioObject.isRight() && !marioObject.isLeft()) {
                doRight();
            } else if (marioObject.getDirection() == Direction.LEFT) {
                setAnimationLeft();
            } else if (marioObject.getDirection() == Direction.RIGHT) {
                setAnimationRight();
            }
            doJumping();
        } else {
            marioObject.setJump(false);
            marioObject.setJumpExtra(false);
        }
    }

    private void doLeft() {
        marioObject.setX(marioObject.getX() - WALKSPEED);
        setAnimationLeft();
        //marioObject.setDirection(Direction.LEFT);
    }

    private void doRight() {
        marioObject.setX(marioObject.getX() + WALKSPEED);
        setAnimationRight();
        //marioObject.setDirection(Direction.RIGHT);
    }

    private void setAnimationLeft() {
        if (marioObject.isBig()) {
            super.setAnimation(bigJumpLeft);
        } else {
            super.setAnimation(smallJumpLeft);
        }
    }

    private void setAnimationRight() {
        if (marioObject.isBig()) {
            super.setAnimation(bigJumpRight);
        } else {
            super.setAnimation(smallJumpRight);
        }
    }

    private void doJumping() {

        jumpHeight = 12;
        if (marioObject.getJumpTeller() < 10) {
        }else{
            //jumpHeight--;
        }

        if (marioObject.getJumpTeller() < 20) {
            while (marioObject.checkCollisionMap(marioObject.getX(), marioObject.getY() - jumpHeight) != Collision.NONE && jumpHeight != 0) {
               jumpHeight--;
                //System.out.println("jumpHeight = " + jumpHeight);
            }

            marioObject.setY(marioObject.getY() - jumpHeight);


            marioObject.setJumpTeller(marioObject.getJumpTeller() + 1);

            //System.out.println("teller " + jumpHeight + " " +marioObject.getJumpTeller());
        } else {
            marioObject.setJump(false);
            marioObject.setJumpExtra(false);
            marioObject.setFall(true);
            marioObject.setJumpTeller(0);
        }
    }
}
