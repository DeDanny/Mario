    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.state;

import mario.Mario;

/**
 *
 * @author Onno
 */
public class SmallMario extends MoveState
{

    public SmallMario(Mario gameObject) {
        super(gameObject);
        this.RightAnimation         = new String[]{"smallMarioWalkRight 0", "smallMarioWalkRight 1"};
        this.LeftAnimation          = new String[]{"smallMarioWalkLeft 0", "smallMarioWalkLeft 1"};
        this.StandLeft              = new String[]{"smallMarioStandLeft 0"};
        this.StandRight             = new String[]{"smallMarioStandRight 0"};
        this.UpRight                = new String[]{"smallMarioLookUpRight 0"};
        this.UpLeft                 = new String[]{"smallMarioLookUpLeft 0"};
        this.DuckRight              = new String[]{"smallMarioDuckRight 0"};
        this.DuckLeft               = new String[]{"smallMarioDuckLeft 0"};

        //gameObject.setAnimation(StandRight);
    }
}
