/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.states;

import mario.Mario;

/**
 *
 * @author Danny
 */
public class Walk implements State
{
    private Mario mario;
    private final static int SPEED = 5;

    public Walk(Mario mario)
    {
        this.mario = mario;
    }

    public void left()
    {
        mario.setX(mario.getX() - SPEED);
    }

    public void right()
    {
        mario.setX(mario.getX() + SPEED);
    }

    public void jump()
    {
    }

    public void duck()
    {
    }
}