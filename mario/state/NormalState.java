/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.state;

import mario.Mario;

/**
 *
 * @author danny
 */
public class NormalState extends State
{
    public NormalState(Mario gameObject)
    {
        super(gameObject);
    }
 
    @Override
    public void doAction()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
