/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.MarioState;

import mario.Mario;

/**
 *
 * @author Onno
 */
public class GrowMario extends MarioState {

    protected String[] growJumpLeft = new String[]{"smallMarioJumpLeft 0", "bigMarioJumpLeft 0"};
    protected String[] growJumpRight = new String[]{"smallMarioJumpRight 0", "bigMarioJumpRight 0"};

    protected String[] growStandLeft = new String[]{"smallMarioStandLeft 0", "bigMarioStandLeft 0"};
    protected String[] growStandRight = new String[]{"smallMarioStandRight 0", "bigMarioStandRight 0"};

    protected String[] growFallLeft = new String[]{"smallMarioFallLeft 0", "bigMarioFallLeft 0"};
    protected String[] growFallRight = new String[]{"smallMarioFallRight 0", "bigMarioFallRight 0"};
    
    private int growTeller;

    public GrowMario(Mario marioObject) {
        super(marioObject);
        //gameObject.setAnimation(StandRight);

            
    }

    @Override
    public void doAction() {
        if (growTeller < 100) {
            switch (marioObject.getDirection()) {
                case LEFT:
                    if (marioObject.isJump()) {
                        super.setAnimation(growJumpLeft);
                    } else if (marioObject.isFall()) {
                        super.setAnimation(growFallLeft);
                    } else {
                        super.setAnimation(growStandLeft);
                    }
                    break;
                case RIGHT:
                    if (marioObject.isJump()) {
                        super.setAnimation(growJumpRight);
                    } else if (marioObject.isFall()) {
                        super.setAnimation(growFallRight);
                    } else {
                        super.setAnimation(growStandRight);
                    }
                    break;
            }

            growTeller++;
        } else {
            marioObject.setBig(true);
            marioObject.setGrow(false);
        }
    }
}
