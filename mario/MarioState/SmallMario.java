    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.MarioState;

import mario.Stages.StageMario;

/**
 *
 * @author Onno
 */
public class SmallMario extends MoveState {

    public SmallMario(StageMario gameObject) {
        super(gameObject);
        this.RightAnimation = new String[]{"smallMarioWalkRight 0", "smallMarioWalkRight 1"};
        this.LeftAnimation = new String[]{"smallMarioWalkLeft 0", "smallMarioWalkLeft 1"};
        this.StandLeft = new String[]{"smallMarioStandLeft 0"};
        this.StandRight = new String[]{"smallMarioStandRight 0"};
        this.UpRight = new String[]{"smallMarioLookUpRight 0"};
        this.UpLeft = new String[]{"smallMarioLookUpLeft 0"};
        this.DuckRight = new String[]{"smallMarioDuckRight 0"};
        this.DuckLeft = new String[]{"smallMarioDuckLeft 0"};
        this.Height = 60;
        this.tempHeight = 41;
        this.tempY = 19;

        //gameObject.setHeight(60);
        gameObject.setAnimation(StandLeft);
    }

}
