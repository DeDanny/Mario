/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario;

/**
 *
 * @author Danny
 */
public class MarioWorld
{
    private boolean applicationRunning = true;
    private int gameSpeed = 10;
    private Game game;
    private Mario mario= new Mario(100, 100, 16, 75, "asd");

    public MarioWorld()
    {
        
    }

    public void startGame()
    {
        game = new Game(mario);
    }

    public boolean isApplicationRunning()
    {
        return applicationRunning;
    }

    public void setApplicationRunning(boolean applicationRunning)
    {
        this.applicationRunning = applicationRunning;
    }

    public int getGameSpeed()
    {
        return gameSpeed;
    }

    public void setGameSpeed(int gameSpeed)
    {
        this.gameSpeed = gameSpeed;
    }

    public Game getGame()
    {
        return game;
    }

    public Mario getMario()
    {
        return mario;
    }

    public boolean isPaused()
    {
        if (game == null)
        {
            return false;
        }
        else
        {
            return game.isPause();
        }
    }

    public boolean isGameRunning()
    {
        if (game == null)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
}
