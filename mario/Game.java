/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario;

/**
 *
 * @author danny
 */
public class Game
{
    private boolean running = false;
    private Mario mario = new Mario("smw_mario_sheet.png");

    public boolean isRunning()
    {
        return running;
    }

    public void setRunning(boolean running)
    {
        this.running = running;
    }
}
