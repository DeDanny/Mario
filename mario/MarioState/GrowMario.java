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
public class GrowMario extends MoveState {

      public GrowMario(Mario gameObject) {
        super(gameObject);
        this.RightAnimation     = new String[]{"bigMarioWalkRight 0", "bigMarioWalkRight 1", "bigMarioWalkRight 2"};
        this.LeftAnimation      = new String[]{"bigMarioWalkLeft 0", "bigMarioWalkLeft 1", "bigMarioWalkLeft 2"};
        this.StandLeft          = new String[]{"bigMarioStandLeft 0"};
        this.StandRight         = new String[]{"bigMarioStandRight 0"};
        this.UpRight            = new String[]{"bigMarioLookUpRight 0"};
        this.UpLeft             = new String[]{"bigMarioLookUpLeft 0"};
        this.DuckRight          = new String[]{"bigMarioDuckRight 0"};
        this.DuckLeft           = new String[]{"bigMarioDuckLeft 0"};

        this.Height = 84;
        this.tempHeight = 41;
        this.tempY = 43;

    }
}
