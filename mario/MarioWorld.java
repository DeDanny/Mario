/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario;

/**
 *
 * @author danny
 */
public class MarioWorld
{
    private boolean running = true;
    private Game game = new Game();

    public MarioWorld()
    {
        
    }

    public Game getGame()
    {
        return game;
    }

    public boolean isRunning()
    {
        return running;
    }

    public void setRunning(boolean running)
    {
        this.running = running;
    }
}
