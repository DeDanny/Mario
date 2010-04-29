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
public class DeadState extends MarioState
{
    protected static final int WALKSPEED = 10;
    protected String[] death = new String[]{"deathMario 0", "deathMario 1"};
    private int heightTeller = 0;

    public DeadState(StageMario gameObject) {
        super(gameObject);
        //marioObject.setHeight(72);
    }

    @Override
    public void doAction() {
        super.setAnimation(death);
        
        if (heightTeller < 20) {
            marioObject.setY(marioObject.getY() - WALKSPEED, true);
            heightTeller++;
        }
        else
        {       
            marioObject.setY(marioObject.getY() + WALKSPEED, true);
            marioObject.setHeight(60);
            heightTeller++;
        }
        //System.out.println(heightTeller);
    }

}
