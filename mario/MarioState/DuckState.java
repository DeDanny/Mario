/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.MarioState;

import mario.State;
import mario.Mario;

/**
 *
 * @author Danny
 */
public class DuckState extends State
{

    protected String[] DuckRight = new String[]{"smallMarioDuckRight 0"};
    protected String[] DuckLeft = new String[]{"smallMarioDuckLeft 0"};
    public DuckState(Mario marioObject)
    {
        super(marioObject);
        marioObject.setAnimation(DuckRight);
    }

    @Override
    public void doAction()
    {
        
    }
}
