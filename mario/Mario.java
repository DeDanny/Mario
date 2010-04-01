/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mario;

import java.awt.event.*;
import mario.states.*;

/**
 *
 * @author Danny
 */
public class Mario implements KeyListener
{
    private static final int width = 16;
    private int height = 22;
    private int speed = 12;
    private State state;

    public Mario()
    {
        this.state = new Normal(this);
    }

    public void setState(State state)
    {
        this.state = state;
    }

    public void keyPressed(KeyEvent e)
    {
        if(e.getKeyChar() == KeyEvent.VK_LEFT)
        {
            state = new Left(this);
        }
    }

    public void keyReleased(KeyEvent e)
    {
        if(e.getKeyChar() == KeyEvent.VK_LEFT)
        {
            state = new Normal(this);
        }
    }
    
    public void keyTyped(KeyEvent e)
    {}
}
