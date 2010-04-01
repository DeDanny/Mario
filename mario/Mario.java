/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario;

import mario.states.*;

/**
 *
 * @author Danny
 */
public class Mario extends Sprite
{
    private State state;
    private boolean left = false;
    private boolean right = false;
    private boolean down = false;
    private boolean up = false;

    Mario(int x, int y, int height, int width, String image)
    {
        super(x, y, height, width, image);
        this.state = new Normal(this);
    }

    public void setState(State state)
    {
        this.state = state;
    }

    void setLeft(boolean b)
    {
        left = b;
    }

    void setRight(boolean b)
    {
        right = b;
    }

    void setDown(boolean b)
    {
        down = b;
    }

    void setUp(boolean b)
    {
        up = b;
    }
}
