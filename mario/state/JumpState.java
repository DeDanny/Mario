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
public class JumpState extends MarioState {

    protected static final int WALKSPEED = 4;


    private int jumpTeller = 0;
    protected String[] smallJumpRight = new String[]{"smallMarioJumpRight 0"};
    protected String[] smallJumpLeft = new String[]{"smallMarioJumpLeft 0"};
    protected String[] bigJumpRight = new String[]{"bigMarioJumpRight 0"};
    protected String[] bigJumpLeft = new String[]{"bigMarioJumpLeft 0"};
    private int jumpHeight;

    public JumpState(Mario marioObject) {
        super(marioObject);

    }

    @Override
    public void doAction() {
        if (!marioObject.isPreformingSpecialMove()) {
            if (marioObject.isLeft() && !marioObject.isRight()) {
                doLeft();
                doJumping();
            } else if (marioObject.isRight() && !marioObject.isLeft()) {
                doRight();
                doJumping();
            } else if (marioObject.getDirection() == Direction.LEFT) {
                setAnimationLeft();
                doJumping();
            } else if (marioObject.getDirection() == Direction.RIGHT) {
                setAnimationRight();
                doJumping();
            }
        } else {
                marioObject.setJump(false);
            }
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
           super.setAnimation(bigJumpLeft);
        }
        else
        {
            super.setAnimation(smallJumpLeft);
        }   
    }

    private void setAnimationRight() {
        if(marioObject.getIsBig()) {
           super.setAnimation(bigJumpRight);
        }
        else
        {
            super.setAnimation(smallJumpRight);
        }
    }

    private void doJumping() {

        jumpHeight = 10;
        if (jumpTeller > 10)
        {
            jumpHeight--;
        }

        if (jumpTeller < 15) {
            marioObject.setY(marioObject.getY() - jumpHeight);
            jumpTeller++;
            //System.out.println("teller " + jumpTeller);
        } else {
            marioObject.setJump(false);
            marioObject.setFall(true);
            //System.out.println("set jump false yippykayeay");
            jumpTeller = 0;
        }
    }
}
