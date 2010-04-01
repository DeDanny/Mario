/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario;

/**
 *
 * @author Danny
 */
public class Game
{
    private boolean pause = false;
    private Mario mario;

    public Game(Mario mario)
    {
        this.mario = mario;
    }

    public boolean isPause()
    {
        return pause;
    }

    public void setPause(boolean pause)
    {
        this.pause = pause;
    }
}
