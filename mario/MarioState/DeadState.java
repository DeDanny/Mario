/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mario.MarioState;

import mario.Stages.StageMario;
import mario.core.engine.Sound;

/**
 *
 * @author Onno
 */
public class DeadState extends MarioState
{
    protected Sound sound = new Sound();
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
        sound.playSound("/sound/dead.wav");
        if (heightTeller < 20) {
            marioObject.setY(marioObject.getY() - WALKSPEED, true);
            heightTeller++;
        }
        else if (heightTeller > 130)
        {       
            marioObject.setY(marioObject.getY() + WALKSPEED, true);
            marioObject.setHeight(60);
            heightTeller++;
        }
        else
        {
            heightTeller++;
        }
        //System.out.println(heightTeller);
    }

}
