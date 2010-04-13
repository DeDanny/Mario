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

    protected static final int WALKSPEED = 5;
    private int jumpTeller = 0;
    protected String[] JumpRight = new String[]{"smallMarioJumpRight 0"};
    protected String[] JumpLeft = new String[]{"smallMarioJumpLeft 0"};
    //protected String[] JumpRight = new String[]{"bigMarioJumpRight 0"};
    //protected String[] JumpLeft = new String[]{"bigMarioJumpLeft 0"};

    public JumpState(Mario marioObject) {
        super(marioObject);

    }

    @Override
    public void doAction() {
        if (marioObject.isLeft() && !marioObject.isRight() && !marioObject.isPreformingSpecialMove()) {
            doLeft();
        } else if (marioObject.isRight() && !marioObject.isLeft() && !marioObject.isPreformingSpecialMove()) {
            doRight();
        } else if (marioObject.getDirection() == Direction.LEFT) {
            setAnimationLeft();
        } else if (marioObject.getDirection() == Direction.RIGHT) {
            setAnimationRight();
        }

        if (jumpTeller < 15) {
            marioObject.setY(marioObject.getY() - 10);
            jumpTeller++;
            //System.out.println("teller " + jumpTeller);
        } else {
            marioObject.setJump(false);
            marioObject.setFall(true);
            //System.out.println("set jump false yippykayeay");
            jumpTeller = 0;
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

    private void setAnimationLeft()
    {
        super.setAnimation(JumpLeft);
    }

    private void setAnimationRight()
    {
        super.setAnimation(JumpRight);
    }
}
